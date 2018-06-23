package com.lance.shiro.web;

import com.lance.shiro.service.UMailService;
import com.lance.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by bingyun on 2018-06-10.
 */
@RestController
@RequestMapping("/rest/mail")
public class MailController extends BaseController {

    @Autowired
    private UMailService uMailService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity mail() throws Exception {
//        uMailService.addMailBox("test123","test123","iPanPassw0rd");
        uMailService.delMailbox("test123");
//        uMailService.sendManagerMail("578210452@qq.com","test1","test123");
        return success("ok");
    }

}
