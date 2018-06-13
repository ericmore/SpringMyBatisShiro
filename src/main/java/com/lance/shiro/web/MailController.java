package com.lance.shiro.web;

import com.lance.shiro.entity.IUser;
import com.lance.shiro.service.UserService;
import com.lance.shiro.utils.UserStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;



/**
 * Created by bingyun on 2018-06-10.
 */
@RestController
@RequestMapping("/rest/mail")
public class MailController extends BaseController {

    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity mail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo("578210452@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);

        return success("ok");
    }



}
