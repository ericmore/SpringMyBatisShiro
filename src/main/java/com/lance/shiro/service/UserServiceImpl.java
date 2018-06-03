package com.lance.shiro.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lance.shiro.entity.IUser;
import com.lance.shiro.mapper.UserMapper;
import org.springframework.util.DigestUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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


	/**
	 * 通过role获取用户列表
	 * @param role
	 * @return
	 */
	@Override
	public ArrayList<IUser> findAllByRoles(List<String> role){
		ArrayList<IUser> list;
		if(role !=null && role.size()>0){
			String roles = "'"+ StringUtils.join(role, "','")+"'";
			list = userMapper.findAllByRoles(roles);
		}else{
			list= userMapper.findAll();
		}
		return list;
	}

	/**
	 * 删除用户
	 * @param id
	 */
	@Override
	public int deleteAllByIds(List<String> id){
		return userMapper.deleteAllByIds(id);
	}

	/**
	 * 修改用户
	 * @param user
	 */
	@Override
	public IUser update(IUser user){
		IUser oUser = userMapper.get(user.getId());
		user.setUsername(oUser.getUsername());
		user.setCreateTime(oUser.getCreateTime());
		user.setUpdateTime(new Date(Calendar.getInstance().getTimeInMillis()));
		if(user.getPassword() != null && !user.getPassword().equals("") && !user.getPassword().equals(oUser.getPassword())){
			String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
			user.setPassword( password ) ;
		}else{
			user.setPassword( oUser.getPassword()) ;
		}
		userMapper.update(user);
		return user;
	}


}