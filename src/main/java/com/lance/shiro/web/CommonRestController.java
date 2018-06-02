package com.lance.shiro.web;


import com.lance.shiro.entity.IUser;
import com.lance.shiro.service.UserServiceImpl;
import org.apache.commons.lang.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonRestController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/current-user")
    public Object login() {
        Subject subject = SecurityUtils.getSubject();
        String user = ObjectUtils.toString(subject.getPrincipal());
        IUser realUser = userService.findByUserName(user);
        return realUser;
    }
}



