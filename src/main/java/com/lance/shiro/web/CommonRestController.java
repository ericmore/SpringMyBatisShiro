package com.lance.shiro.web;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonRestController {


    @RequestMapping("/current-user")
    public Object login() {
        Subject subject = SecurityUtils.getSubject();
        Object user = subject.getPrincipal();
        return user;
    }
}



