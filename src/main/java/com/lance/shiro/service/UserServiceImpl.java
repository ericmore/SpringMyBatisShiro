package com.lance.shiro.service;

import com.google.common.collect.Sets;
import com.lance.shiro.entity.IUser;
import com.lance.shiro.mapper.UserMapper;
import com.lance.shiro.utils.ConvertUtils;
import com.lance.shiro.utils.UserStatus;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.*;

import static com.lance.shiro.config.ConstantVariable.BELONG_TO_CATEGORY_USER_ATTACHMENTS;
import static com.lance.shiro.config.ConstantVariable.BELONG_TO_CATEGORY_USER_PORTRAIT;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private UMailService uMailService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mail.domain}")
    private String mailDomain;

    @Value("${mail.defaultPassword}")
    private String defaultPassword;

    @Value("${mail.manager.username}")
    private String mailManager;

    @Value("${externalHttpPath}")
    private String externalHttpPath;

    @Override
    public Map get(int id) {
        IUser user = userMapper.get(id);
        return setAttachment(user);
    }

    @Override
    public Map findByCode(String code) {
        IUser user = ckeckByCode(code);
        return setAttachment(user);
    }

    @Override
    public IUser ckeckByCode(String code) {
        return userMapper.findByAttrAndStatus(" code='" + code + "' and status = 'active'");
    }

    @Override
    public Set<String> findPermissions(String code) {
        Set<String> set = Sets.newHashSet();
        IUser user = ckeckByCode(code);
        set.add(user.getRole());
        return set;
    }

    @Override
    public ArrayList<Map> findAllByRoles(List<String> role) {
        ArrayList<IUser> list;
        if (role != null && role.size() > 0) {
            String roles = "'" + StringUtils.join(role, "','") + "'";
            list = userMapper.findAllByRoles(roles);
        } else {
            list = userMapper.findAll();
        }
        ArrayList<Map> aUsers = new ArrayList<Map>();
        for (int i = 0, size = list.size(); i < size; i++) {
            Map mUser = setAttachment(list.get(i));
            aUsers.add(mUser);
        }
        return aUsers;
    }


    @Override
    public ArrayList<Map> findAllByAttr(Map<String, String> reqMap) {
        ArrayList<IUser> list;
        if (null != reqMap && reqMap.size() > 0) {
            IUser obj = new IUser();
            Field fields[] = obj.getClass().getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < fields.length; i++) {
                String keyName = fields[i].getName();
                if (null != reqMap.get(keyName)) {
                    sb.append("  ").append(keyName).append("=").append("'").append(reqMap.get(keyName)).append("'").append("  ").append("and");
                }
            }
            if (null != sb) {
                String s = sb.toString();
                list = userMapper.findAllByAttr(s.substring(0, s.length() - 3));
            } else {
                list = userMapper.findAll();
            }
        } else {
            list = userMapper.findAll();
        }
        return setAttachmentForList(list);
    }

    @Override
    public void deleteAllByIds(ArrayList<Integer> ids) {
        userMapper.deleteAllByIds(ids);
        for (int id : ids) {
            IUser user = userMapper.get(id);
            deleteMail(user);
        }
    }

    @Override
    public Map updateAttribute(int id, Map<String, String> reqMap) throws Exception {
        IUser obj = userMapper.get(id);
        if (null != obj) {
            Field fields[] = obj.getClass().getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < fields.length; i++) {
                String keyName = fields[i].getName();
                String ketValue = reqMap.get(keyName);
                if (null != reqMap.get(keyName)) {
                    if (keyName.equals("password")) {
                        if (ketValue != null && !ketValue.equals("") && !ketValue.equals(obj.getPassword())) {
                            ketValue = md5Password(ketValue);
                        } else {
                            continue;
                        }
                    }
                    if (keyName.equals("code") && !vaildCodeRepeatAndIncludeInActive(id, ketValue)) {
                        throw new Exception("Code already exists!" + ketValue);
                    }
                    if (keyName.equals("referID") && !vaildReferID(ketValue)) {
                        throw new Exception("Refer ID does not exist!" + ketValue);
                    }
                    sb.append("  ").append(keyName).append("=").append("'").append(ketValue).append("'").append("  ").append(",");
                }
            }
            if (null != sb) {
                String s = sb.toString();
                userMapper.updateAttribute(id, s.substring(0, s.length() - 1));
                obj = userMapper.get(id);
                return setAttachment(obj);
            }
        }
        return null;
    }

    @Override
    public Map save(IUser user) throws Exception {
        if (!UserStatus.validate(user.getStatus())) {
            throw new Exception("Status not valid!" + user.getStatus());
        }
        if (!vaildReferID(user.getReferID())) {
            throw new Exception("Refer ID does not exist!" + user.getReferID());
        }
        if (!vaildCodeRepeatAndIncludeInActive(user.getId(), user.getCode())) {
            throw new Exception("Code already exists!" + user.getCode());
        }
        if (user.getId() == 0) {
            userMapper.add(user);
        } else {
            IUser oUser = userMapper.get(user.getId());
            user.setUsername(oUser.getUsername());
            user.setCreateTime(oUser.getCreateTime());
            user.setUpdateTime(new Date(Calendar.getInstance().getTimeInMillis()));
            if (user.getPassword() != null && !user.getPassword().equals("") && !user.getPassword().equals(oUser.getPassword())) {
                String password = md5Password(user.getPassword());
                user.setPassword(password);
            } else {
                user.setPassword(oUser.getPassword());
            }
            userMapper.update(user);
        }
        return setAttachment(user);
    }

    @Override
    public Map apply(int id) throws Exception {
        IUser user = userMapper.get(id);
        if (!user.getStatus().equals(UserStatus.DRAFT)) {
            throw new Exception("Not " + UserStatus.DRAFT + " status cannot be applied!");
        }
        user.setStatus(UserStatus.PENDING);
        userMapper.update(user);
        sendApplyMail(user);
        return setAttachment(user);
    }


    @Override
    public Map approve(int id, String type) throws Exception {
        IUser user = userMapper.get(id);
        if (!user.getStatus().equals(UserStatus.PENDING)) {
            throw new Exception("Not " + UserStatus.PENDING + " status cannot be Approval!");
        }
        user.setStatus(UserStatus.ACTIVE);

        String code = "";
        if (type.equals("internal")) {
            Map map = userMapper.findMaxCode(" code <= 'i8000100' ");
            if (map != null && map.get("code") != null && !map.get("code").equals("")) {
                if (map.get("code").equals("i8000100")) {
                    throw new Exception("Internal employee number is full!");
                }
                code = "i" + (Integer.parseInt(map.get("code").toString().substring(1)) + 1);
            } else {
                code = "i8000001";
            }
        } else {
            Map map = userMapper.findMaxCode(" code > 'i8000100' ");
            if (map != null && map.get("code") != null && !map.get("code").equals("")) {
                code = "i" + (Integer.parseInt(map.get("code").toString().substring(1)) + 1);
            } else {
                code = "i8000101";
            }
        }
        user.setCode(code);

        String password = uMailService.randomPwd();
        user.setPassword(  md5Password(password) );

        String email = createMail(user,password);
        user.setEmail(email);
        userMapper.update(user);
        return setAttachment(user);
    }

    private String md5Password(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

    private boolean vaildReferID(String referId) {
        IUser user = userMapper.findByAttrAndStatus(" code is not null and code !='' and  code = '" + referId + "'");
        if (user != null) {
            return true;
        }
        return false;
    }


    private boolean vaildCodeRepeatAndIncludeInActive(int id, String value) {
        String sql = "code is not null and code !='' and code ='" + value + "' ";
        if (id > 0) {
            sql += " and id != " + id;
        }
        IUser user = userMapper.findByAttrAndStatus(sql);
        if (user == null) {
            return true;
        }
        return false;
    }

    private ArrayList<Map> setAttachmentForList(ArrayList<IUser> list) {
        ArrayList<Map> aObjs = new ArrayList<Map>();
        for (int i = 0, size = list.size(); i < size; i++) {
            Map mapObj = setAttachment(list.get(i));
            aObjs.add(mapObj);
        }
        return aObjs;
    }

    private Map setAttachment(IUser user) {
        Map muser = ConvertUtils.beanToMap(user);
        if (user != null) {
            String id = String.valueOf(user.getId());
            muser.put(BELONG_TO_CATEGORY_USER_PORTRAIT, commonService.findListAttachmentByBelong(id, BELONG_TO_CATEGORY_USER_PORTRAIT));
            muser.put(BELONG_TO_CATEGORY_USER_ATTACHMENTS, commonService.findListAttachmentByBelong(id, BELONG_TO_CATEGORY_USER_ATTACHMENTS));
        }
        return muser;
    }


    private void deleteMail(IUser user) {
        try {
            if (!StringUtils.isBlank(user.getEmail())) {
                Map<String, String> ret = uMailService.delMailbox(user.getEmail().replaceAll("@" + mailDomain, ""));
            }
        } catch (Exception ex) {
        }
    }

    private String createMail(IUser user,String password) throws Exception {
        String email = (user.getFirstName() + "." + user.getLastName()).replaceAll(" ", "");
        int cMap = userMapper.findCountByAttr("  email regexp '^" + email + "([0-9]*)@" + mailDomain + "$'  ");
        if (cMap > 0) {
            email += cMap;
        }
        Map<String, String> ret = uMailService.addMailBox(email, user.getFirstName() + " " + user.getLastName(), password);
        email += "@" + mailDomain;
        user.setEmail(email);

        sendApproveMail(user,password);

        return email;
    }

    private void sendApplyMail(IUser user) {
        try {
            String subject = "Dear " + user.getFirstName() + " " + user.getLastName() + ", Welcome To the iPAN!";
            String body = "<div>Welcome to the international Property Agent network(iPAN)</div>";
            body += "<div>Please confirm your detail below</div>";
            body += "<div>Mobile Number: " + (user.getMobile() == null ? "none" : user.getMobile()) + "</div>";
            body += "<div>Country/Region: " + user.getCountry() + "</div>";
            body += "<div>State/Province: " + (user.getState() == null ? "none" : user.getState()) + "</div>";
            body += "<div>City: " + (user.getCity() == null ? "none" : user.getCity()) + "</div>";
            body += "<div>Street: " + (user.getStreet() == null ? "none" : user.getStreet()) + "</div>";
            body += "<div>Please contact " + mailManager + " if detail need to be corrected.</div>";
            body += "<div><br><br>    iPAN Admin Team </div>";
            Map<String, String> ret = uMailService.sendManagerMail(user.getPrivateEmail(), subject, body);
        } catch (Exception ex) {
        }
    }

    private void sendApproveMail(IUser user,String password) {
        try {
            String subject = "Dear " + user.getFirstName() + " " + user.getLastName() + ", Your iPAN membership Property Sale has been approved!";
            String body = "<div>Congratulations, your membership has been approved by the International Property Agent network(iPAN)\n</div>";
            body += "<div>Your member ID: " + user.getCode() + "</div>";
            body += "<div>Your iPan Portal password: " + password + "</div>";
            body += "<div>Your iPan Mailbox: " + user.getEmail() + "</div>";
            body += "<div>Initial Mailbox password is: " + password + "</div>";
            body += "<div>To access your mailbox via web, please log into <a href=\"http://mail.ipanproperty.com\" target='_blank'>http://mail.ipanproperty.com</a> with your password provided above.</div>";
            body += "<div>Please contact " + mailManager + " if there's any question.</div>";
            body += "<div>Enjoy!</div>";
            body += "<div><br><br>    iPAN Admin Team </div>";
            Map<String, String> ret = uMailService.sendManagerMail(user.getPrivateEmail(), subject, body);
        } catch (Exception ex) {
        }
    }


    @Override
    public IUser findExternalByCode(String code) {
        //test api http://localhost:8080/rest/user/external?code=i8000101
        String url = externalHttpPath+ "?code=" + code;
        JSONObject jsonObject = restTemplate.getForObject(url , JSONObject.class);
        IUser user = new IUser();
        if(jsonObject!=null && jsonObject.size()>0) {
            user.setLastName(jsonObject.getString("surname") );
            user.setFirstName(jsonObject.getString("firstname") );
            user.setPrivateEmail(jsonObject.getString("email"));
            user.setMobile(jsonObject.getString("mobile"));
            user.setStreet(jsonObject.getString("street"));
            user.setPosition(jsonObject.getString("position") );
            user.setCompany(jsonObject.getString("company"));
            user.setCountry(jsonObject.getString("country"));
            user.setState(jsonObject.getString("state"));
            user.setCity(jsonObject.getString("city"));
        }
        return user;
    }
}