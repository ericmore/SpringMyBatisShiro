package com.lance.shiro.service;

import com.google.common.collect.Sets;
import com.lance.shiro.entity.IProperty;
import com.lance.shiro.entity.IUser;
import com.lance.shiro.mapper.UserMapper;
import com.lance.shiro.utils.ConvertUtils;
import com.lance.shiro.utils.UserStatus;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.*;

import static com.lance.shiro.config.ConstantVariable.*;
import static com.lance.shiro.config.ConstantVariable.BELONG_TO_CATEGORY_PROPERTY_MAIN_IMAGE;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommonService commonService;


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
        return userMapper.findByAttrAndStatus(" code='"+code+"' and status = 'active'");
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
    public void deleteAllByIds(ArrayList<Integer> id) {
        userMapper.deleteAllByIds(id);
    }

    @Override
    public Map updateAttribute(int id, Map<String, String> reqMap) throws Exception {
        IUser obj  = userMapper.get(id);
        if (null != obj) {
            Field fields[] = obj.getClass().getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < fields.length; i++) {
                String keyName = fields[i].getName();
                String ketValue = reqMap.get(keyName);
                if (null != reqMap.get(keyName)) {
                    if(keyName.equals("password")){
                        ketValue = md5Password(ketValue);
                    }
                    if(keyName.equals("code") && !vaildCodeRepeatAndIncludeInActive(id,ketValue)){
                        throw new Exception("Code already exists!" + ketValue);
                    }
                    if( keyName.equals("referID") && !vaildReferID( ketValue )){
                        throw new Exception("Refer ID does not exist!" + ketValue );
                    }
                    sb.append("  ").append(keyName).append("=").append("'").append(ketValue).append("'").append("  ").append(",");
                }
            }
            if (null != sb) {
                String s = sb.toString();
                userMapper.updateAttribute(id, s.substring(0, s.length() - 1));
                obj = userMapper.get(id);
                return  setAttachment(obj);
            }
        }
        return null;
    }

    @Override
    public Map save(IUser user) throws Exception {
        if(!UserStatus.validate(user.getStatus())){
            throw new Exception("Status not valid!" + user.getStatus());
        }
        if( !vaildReferID( user.getReferID())){
            throw new Exception("Refer ID does not exist!" + user.getReferID());
        }
        if( !vaildCodeRepeatAndIncludeInActive(user.getId(),user.getCode())){
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
    public Map approve(int id, String type) throws Exception {
        IUser user = userMapper.get(id);
        user.setStatus(UserStatus.ACTIVE);
        user.setEmail( user.getFirstName()+"."+user.getLastName()+"@ipanproperty.com");
        String code = "";
        if(type.equals("internal")){
            Map map = userMapper.findMaxCode(" code <= 'i8000100' ");
            if(map!=null && map.get("code")!=null && !map.get("code").equals("") ){
                if(map.get("code").equals("i8000100")){
                    throw new Exception("Internal employee number is full!" );
                }
                code = "i" + (  Integer.parseInt(map.get("code").toString().substring(1))+1 );
            }else{
                code = "i8000001";
            }
        }else{
            Map map = userMapper.findMaxCode(" code > 'i8000100' ");
            if(map!=null &&  map.get("code")!=null  && !map.get("code").equals("") ){
                code = "i" + (  Integer.parseInt(map.get("code").toString().substring(1))+1 );
            }else{
                code = "i8000101";
            }
        }
        user.setCode(code);
        userMapper.update(user);
        return setAttachment(user);
    }
    private String md5Password(String password){
        return DigestUtils.md5DigestAsHex(password.getBytes()) ;
    }

    private boolean vaildReferID(String referId) {
        IUser user = userMapper.findByAttrAndStatus(" code is not null and code !='' and  code = '"+ referId +"'");
        if(user != null){
            return true;
        }
        return false;
    }


    private boolean vaildCodeRepeatAndIncludeInActive(int id ,String value) {
        String sql =  "code is not null and code !='' and code ='"+value+"' " ;
        if(id>0){
            sql += " and id != " + id;
        }
        IUser user = userMapper.findByAttrAndStatus(sql);
        if(user == null){
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
        String id = String.valueOf(user.getId());
        muser.put(BELONG_TO_CATEGORY_USER_PORTRAIT, commonService.findListAttachmentByBelong(id, BELONG_TO_CATEGORY_USER_PORTRAIT));
        muser.put(BELONG_TO_CATEGORY_USER_ATTACHMENTS, commonService.findListAttachmentByBelong(id, BELONG_TO_CATEGORY_USER_ATTACHMENTS));
        return muser;
    }
}