package com.lance.shiro.web;

import com.lance.shiro.entity.IProperty;
import com.lance.shiro.entity.IUser;
import com.lance.shiro.service.UserService;
import com.lance.shiro.utils.UserStatus;
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
import java.util.HashMap;
import java.util.Map;

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
            UsernamePasswordToken token = new UsernamePasswordToken(user.getCode(), user.getPassword(), rememberMe);
            subject.login(token); // 登录
            Map muser = userService.findByCode(user.getCode());
            return success("Operation success!",muser);
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
            String code =  SecurityUtils.getSubject().getPrincipal().toString();
            Map user = userService.findByCode(code);
            return success("Operation success!", user);
        }else{
            return error("No login information！");
        }
    }

    /**
     * delete
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam ArrayList<Integer> id) {
        userService.deleteAllByIds(id);
        return success("Operation success!");
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") int id) {
        Map obj = userService.get(id);
        return success("Operation success!", obj);
    }
    /**
     *Register
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody IUser user) throws Exception {
        Map muser = userService.save(user);
        return success("Operation success!", muser);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody IUser user) throws Exception {
        Map obj = userService.save(user);
        return success("Operation success!", obj);
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity edit(@RequestBody IUser user) throws Exception {
        Map obj = userService.save(user);
        return success("Operation success!", obj);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity put(@PathVariable("id") int id, @RequestParam Map<String, String> reqMap)  throws Exception {
        if (null != reqMap) {
            Map obj = userService.updateAttribute(id, reqMap);
            return success("Operation success!", obj);
        } else {
            return success("Operation success!", null);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public ResponseEntity patch(@PathVariable("id") int id, @RequestBody Map<String, String> reqMap)  throws Exception {
        if (null != reqMap) {
            Map obj = userService.updateAttribute(id, reqMap);
            return success("Operation success!", obj);
        } else {
            return success("Operation success!", null);
        }
    }

    @RequestMapping(value = "apply/{id}", method = RequestMethod.PUT)
    public ResponseEntity apply(@PathVariable("id") int id)  throws Exception{
        Map obj = userService.apply(id);
        return success("Operation success!", obj);
    }

    @RequestMapping(value = "approve/{id}", method = RequestMethod.PUT)
    public ResponseEntity approve(@PathVariable("id") int id, @RequestParam String type)  throws Exception{
        Map obj = userService.approve(id,type);
        return success("Operation success!", obj);
    }

    @RequestMapping(value = "subuser/{referID}", method = RequestMethod.GET)
    public ResponseEntity subuser(@PathVariable("referID") String referID) {
        HashMap<String, String> reqMap = new HashMap<String, String>();
        reqMap.put("referID",referID);
        reqMap.put("status","active");
        ArrayList<Map> list = userService.findAllByAttr(reqMap);
        return success("Operation success!", list);

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity findAll(@RequestParam Map<String, String> reqMap) {
        ArrayList<Map> list = userService.findAllByAttr(reqMap);
        return success("Operation success!", list);
    }
    /**
     *roles
     * @return
     */
    @RequestMapping(value = "role", method = RequestMethod.GET)
    public ResponseEntity findByRole(@RequestParam(name="role",required=false) ArrayList<String> role) {
        ArrayList<Map> list = userService.findAllByRoles(role);
        return success("Operation success!", list);
    }

    @RequestMapping(value = "external", method = RequestMethod.GET)
    public ResponseEntity findExternal(@RequestParam(name="code") String code) {
        IUser user = userService.findExternalByCode(code);
        return success("Operation success!", user);
    }

}
