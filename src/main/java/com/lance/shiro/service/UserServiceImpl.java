package com.lance.shiro.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lance.shiro.entity.IUser;
import com.lance.shiro.mapper.UserMapper;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	/**
	 * 登录
	 * 根据用户名和密码进行查询
	 */
	@Override
	public IUser login(String username, String password) {
		return userMapper.findByUserNameAndPassword(username, password);
	}
	/**
	 * 注册
	 * 增加用户
	 */
	@Override
	public int register(IUser user) {
		return userMapper.addUser(user);
	}
	/**
	 * 根据用户名查询
	 */
	@Override
	public IUser findByUserName(String username) {
		return userMapper.findByUserName(username);
	}

	/**
	 * 获取资源集合
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username) {
		Set<String> set = Sets.newHashSet();
		IUser user = findByUserName(username);
		set.add(user.getRole());
		return set;
	}


}