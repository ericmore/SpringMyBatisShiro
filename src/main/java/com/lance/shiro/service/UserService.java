package com.lance.shiro.service;

import java.util.List;
import java.util.Set;

import com.lance.shiro.entity.IUser;

public interface UserService {
	// 通过用户名及密码核查用户登录
	IUser login(String username, String password);
	//增加用户
	int register(IUser user);
	//根据用户名查询
	IUser findByUserName(String user);

	/**
	 * 获取资源集合
	 * @param account
	 * @return
	 */
	Set<String> findPermissions(String account);

}
