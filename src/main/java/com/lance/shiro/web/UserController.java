package com.lance.shiro.web;

import com.lance.shiro.entity.IUser;
import com.lance.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bingyun on 2018-06-02.
 */
@RestController
@RequestMapping("/rest/user/")
public class UserController extends BaseController {

    //注入userService
    @Autowired
    private UserService userService;

    /**
     * Go login.jsp
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody IUser user) {
        String username = user.getUsername();
        // 如果数据库中没有该用户，可以注册，否则跳转页面
        if (userService.findByUserName(username) == null) {
            // 添加用户
            userService.register(user);
            return success("保存成功！", user);
        } else {
            // 注册失败
            return error("用户名已存在!");
        }


    }

    /**
     * Go login
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody IUser user, HttpServletRequest request, RedirectAttributes rediect) {
        try {
            Subject subject = SecurityUtils.getSubject();
            boolean rememberMe = ServletRequestUtils.getBooleanParameter(request, "rememberMe", false);
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword(), rememberMe);
            subject.login(token); // 登录
            return success("登录成功!");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return error("您的账号或密码输入错误!");
        }

    }

    /**
     * Exit
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ResponseEntity logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return success("登出成功！");
    }

    /**
     * Exit
     *
     * @return
     */
    @RequestMapping(value = "current ", method = RequestMethod.GET)
    public ResponseEntity current() {
        IUser user = (IUser) SecurityUtils.getSubject().getPrincipal();
        return success("获取成功！", user);
    }
}
