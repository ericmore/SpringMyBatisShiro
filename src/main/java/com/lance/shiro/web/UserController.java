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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by bingyun on 2018-06-02.
 */
@RestController
@RequestMapping("/rest/user")
public class UserController extends BaseController {

    //注入userService
    @Autowired
    private UserService userService;

    /**
     *Register
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
     * login
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
            user = userService.findByUserName(user.getUsername());
            return success("登录成功!",user);
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
     * Current
     *
     * @return
     */
    @RequestMapping(value = "current-user", method = RequestMethod.GET)
    public ResponseEntity current() {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            String username =  SecurityUtils.getSubject().getPrincipal().toString();
            IUser user = userService.findByUserName(username);
            return success("获取成功！", user);
        }else{
            return success("没有登录信息！");
        }

    }


    /**
     *list
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity list(@RequestParam ArrayList<String> role) {
        ArrayList<IUser> list = userService.findAllByRoles(role);
        return success("操作成功！", list);
    }


    /**
     *delete
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam ArrayList<String> id) {
        userService.deleteAllByIds(id);
        return success("操作成功！");
    }

    /**
     *update
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody  IUser user) {
        user = userService.update(user);
        return success("操作成功！",user);
    }

}
