package com.lance.shiro.web;

import javax.servlet.http.HttpServletRequest;

import com.lance.shiro.entity.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
	private Logger log = LogManager.getLogger(getClass());
	@RequestMapping(value="echo", method=RequestMethod.GET)
	public String echo() {
		return "echo";
	}
	/**
	 * Go login.jsp
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		return "login.html";
	}
	
	/**
	 * Go login
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ResponseEntity login(@RequestBody UserInfo user, HttpServletRequest request, RedirectAttributes rediect) {
        String ret = "";
	    String account = user.getAccount();
		String password = user.getPassword();
		
		UsernamePasswordToken upt = new UsernamePasswordToken(account, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(upt);
			log.debug(user.getAccount()+" login success!");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
			ret = "fail";
		}
		ret = "pass";
		return ResponseEntity.ok(ret);

	}
	
	/**
	 * Exit
	 * @return
	 */
	@RequestMapping("logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/index";
	}
}
