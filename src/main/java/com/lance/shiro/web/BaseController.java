package com.lance.shiro.web;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by bingyun on 2018-06-02.
 */
@RestController
@RequestMapping("/rest/user/")
public class BaseController {
    public Logger log = LogManager.getLogger(getClass());

    public static ResponseEntity success(String msg){
        return success(msg,null);
    }

    public static ResponseEntity success(String msg ,Object data){
        return result(true,msg,data);
    }

    public static ResponseEntity error(String msg){
        return  error(msg, null);
    }
    public static ResponseEntity error(String msg ,Object data){
        return result(false, msg, data);
    }
    public static ResponseEntity result(Boolean success , String msg ,Object data){
        HashMap<String,Object> re = new HashMap<String,Object>();
        re.put("success",success);
        re.put("msg",msg);
        re.put("data",data);
        return ResponseEntity.ok(re);
    }
}
