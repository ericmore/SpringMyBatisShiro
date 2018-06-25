package com.lance.shiro.service;

import java.util.Map;

public interface UMailService {
    Map<String, String> addMailBox(String username, String realname, String password) throws Exception;

    Map<String, String> delMailbox(String username) throws Exception;

    Map<String,String> sendManagerMail(String to, String subject, String body) throws Exception;

    String randomPwd();
}
