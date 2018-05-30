package com.lance.shiro.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/**
	 * Go Index
	 * @return
	 */
	@RequestMapping(value={"", "/", "index","login-required","login-success","unauthorized"})
	public String index() {
		return "index.html";
	}



//	/**
//	 * unauthor
//	 * @return
//	 */
//	@RequestMapping("unauthorized")
//	public String unauthor() {
//		return "index.html";
//	}
	
	/**
	 * reports
	 * @return
	 */
	@RequestMapping("reports")
	public String reports() {
		return "reports.jsp";
	}
}
