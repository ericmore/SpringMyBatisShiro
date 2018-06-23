package com.lance.shiro.service;

import com.lance.shiro.utils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.dom4j.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UMailService{
    private static Logger logger = LogManager.getLogger();

    @Value("${mail.domain}")
    private String mailDomain;

    @Value("${mail.server}")
    private String mailServer;

    @Value("${mail.api}")
    private String mailApi;

    @Value("${mail.admin.username}")
    private String mailAdmin;

    @Value("${mail.admin.password}")
    private String adminPassword;

    @Value("${mail.manager.username}")
    private String mailManager;

    @Value("${mail.manager.password}")
    private String managerPassword;

    @Value("${mail.manager.nickname}")
    private String managerNick;

    @Value("${mail.defaultPassword}")
    private String defaultPassword;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * <pre>
     * username：	域管理员的账号（非空）
     password：	域管理员的密码，MD5加密（非空）
     domain:		域管理员所在域名，默认值是主域
     account：		添加该域名下的邮箱账号，如abc（非空）
     pwd：		该邮箱账号的密码，明文（非空）
     realname：	该邮箱账号的真实姓名，如abc（非空）
     mbsize：		该邮箱账号的邮件空间大小，数字型，单位M，如100
     ndsize：		该邮箱账号的网络硬盘大小，数字型，单位M，如100
     disabled：	该邮箱账号是否被禁用，选项型，1是禁用，-1是非禁用
     limit_send：	该邮箱发信功能是否被限制，选项型，1是限制，-1是正常
     limit_recv:	该邮箱收信功能是否被限制，选项型，1是限制，-1是正常
     recvsms：		该邮箱短信通知是否被限制，选项型，1是限制，-1是正常
     limit_ip：		该邮箱的限制登录的IP（段）地址
     eenumber：	该邮箱用户的工号
     tel_mobile：	该邮箱用户的手机号码
     tel_home：	该邮箱用户的住宅电话
     tel_qq：		该邮箱用户的qq
     tel_msn：		该邮箱用户的msn
     tel_work：	该邮箱用户的公司电话

     adminpass： 超级管理员密码MD5，如cd2c3a3529b259d42718a6a606c63f0a（password不知道为空时非空）
     adminname：	超级管理员用户名如：admin（password不知道为空时非空）

     * </pre>
     *
     */
    public Map<String, String> addMailBox(String username, String realname, String password) throws Exception {
        String url =mailApi+"?do=addMailbox";

        Map<String, String> ret = new HashMap<String, String>();


        if (StringUtils.isBlank(username)) {
            ret.put("status", "-1");
            ret.put("data", "account  cant be null");
            return ret;
        }


        if (StringUtils.isBlank(realname)) {
            ret.put("status", "-1");
            ret.put("data", "realname cant be null");
            return ret;
        }
        if (StringUtils.isBlank(password)) {
            password = defaultPassword;
        }
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("account", username);
        map.add("pwd", password);
        map.add("username", mailAdmin);
        map.add("password", adminPassword);
        map.add("domain", mailDomain);
        map.add("realname", realname);
        logger.debug(url);
        logger.debug(map);
        String responseText = restTemplate.postForObject(url, map, String.class);
        logger.debug(responseText);
        ret = parseSimpleResult(responseText);
        if(ret!=null && ret.containsKey("status") && ret.get("status").equals("0")){
            return ret;
        }else{
            throw new Exception("Create email error!");
        }
    }

    /**
     * 删除
     * @param username
     * @return
     */
    public Map<String, String> delMailbox(String username) throws Exception {
        String url =mailApi+"?do=delMailbox";

        Map<String, String> ret = new HashMap<String, String>();


        if (StringUtils.isBlank(username)) {
            ret.put("status", "-1");
            ret.put("data", "account  cant be null");
            return ret;
        }

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("account", username);
        map.add("username", mailAdmin);
        map.add("password", adminPassword);
        map.add("domain", mailDomain);
        logger.debug(url);
        logger.debug(map);
        String responseText = restTemplate.postForObject(url, map, String.class);
        logger.debug(responseText);
        ret = parseSimpleResult(responseText);
        if(ret!=null && ret.containsKey("status") && ret.get("status").equals("0")){
            return ret;
        }else{
            throw new Exception("Delete email error!");
        }
    }

    /**
     * 通过管理员帐号对外发送邮件
     * @param subject
     * @param body
     */
    public Map<String,String> sendManagerMail(String to,String subject,String body) throws Exception {
        Map<String, String> ret = new HashMap<String, String>();
        if(StringUtils.isBlank(to))
        {
            ret.put("status", "-1");
            ret.put("data", "receiver cant be empty");
            return ret;
        }

        if(StringUtils.isBlank(subject))
        {
            subject="no subject";
        }
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("email", mailManager);
        map.add("password", managerPassword);
        map.add("to", to);
        map.add("subject", subject);

        body+="<div><br><br><br></div>";
        map.add("body", body);
        String url=mailApi+"?do=sendMail";
        System.out.println(map);
        System.out.println(url);
        logger.debug(url);
        logger.debug(map);
        String responseText = restTemplate.postForObject(url, map, String.class);
        logger.debug(responseText);
        ret = parseSimpleResult(responseText);
        if(ret!=null && ret.containsKey("status") && ret.get("status").equals("0")){
            return ret;
        }else{
            throw new Exception("Send email error!");
        }
    }

    private Map<String, String> parseSimpleResult(String text) {
        Document doc = null;
        Map<String, String> ret = new HashMap<String, String>();
        try {
            doc = DocumentHelper.parseText(text);
            ret = (Map<String, String>) ConvertUtils.xml2map(doc.getRootElement());
        } catch (DocumentException e) {
            // TODO Auto-generated catch block 
            logger.error(e);
            e.printStackTrace();
            return null;
        }
        return ret;

    }
}
