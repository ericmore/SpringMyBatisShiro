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
            return success("Operation success!", user);
        } else {
            // 注册失败
            return error("Username already exists!");
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
            return success("Operation success!",user);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return error("Your account or password was entered incorrectly!");
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
        return success("Operation success!");
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
            return success("Operation success!", user);
        }else{
            return success("No login information！");
        }

    }


    /**
     *list
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity list(@RequestParam ArrayList<String> role) {
        ArrayList<IUser> list = userService.findAllByRoles(role);
        return success("Operation success!", list);
    }


    /**
     *delete
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam ArrayList<String> id) {
        userService.deleteAllByIds(id);
        return success("Operation success!");
    }

    /**
     *update
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody  IUser user) {
        user = userService.update(user);
        return success("Operation success!",user);
    }

}
