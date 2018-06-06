package com.lance.shiro.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.lance.shiro.entity.IAttachment;
import com.lance.shiro.entity.IContent;
import com.lance.shiro.utils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lance.shiro.entity.IUser;
import com.lance.shiro.mapper.UserMapper;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.sql.Date;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CommonService commonService;

	/**
	 * 登录
	 * 根据用户名和密码进行查询
	 */
	@Override
	public Map login(String username, String password) {
		IUser user = userMapper.findByUserNameAndPassword(username, password);
		Map mUser = setAttachment(user);
		return mUser;
	}
	/**
	 * 注册
	 * 增加用户
	 */
	@Override
	public Map register(IUser user) {
		userMapper.addUser(user);
		Map mUser = setAttachment(user);
		return mUser;
	}
	/**
	 * 根据用户名查询
	 */
	@Override
	public Map findByUserName(String username) {
		Map mUser = setAttachment( ckeckByUserName(username));
		return mUser;
	}

	@Override
	public IUser ckeckByUserName(String username) {
		IUser mUser = userMapper.findByUserName(username);
		return mUser;
	}

	/**
	 * 获取资源集合
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username) {
		Set<String> set = Sets.newHashSet();
		IUser user = ckeckByUserName(username);
		set.add(user.getRole());
		return set;
	}


	/**
	 * 通过role获取用户列表
	 * @param role
	 * @return
	 */
	@Override
	public ArrayList<Map> findAllByRoles(List<String> role){
		ArrayList<IUser> list;
		if(role !=null && role.size()>0){
			String roles = "'"+ StringUtils.join(role, "','")+"'";
			list = userMapper.findAllByRoles(roles);
		}else{
			list= userMapper.findAll();
		}
		ArrayList<Map> aUsers = new ArrayList<Map>();
		for (int i = 0,size = list.size(); i < size; i++) {
			Map mUser = setAttachment(list.get(i));
			aUsers.add(mUser);
		}
		return aUsers;
	}

	/**
	 * 删除用户
	 * @param ids
	 */
	@Override
	public int deleteAllByIds(ArrayList<String> ids){
		int count = userMapper.deleteAllByIds(ids);
		for (String id : ids) {
			commonService.deleteListAttachmentByBelong(id, "user_portrait");
			commonService.deleteListAttachmentByBelong(id, "user_attachments");
		}
		return count;
	}

	/**
	 * 修改用户
	 * @param user
	 */
	@Override
	public Map update(IUser user){
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
		Map mUser = setAttachment(user);
		return mUser;
	}

	private Map setAttachment(IUser user){
		Map muser = ConvertUtils.beanToMap(user);
		String id = String.valueOf(user.getId());
		muser.put("user_portrait",commonService.findListAttachmentByBelong( id , "user_portrait"));
		muser.put("user_attachments",commonService.findListAttachmentByBelong(id , "user_attachments"));
		return muser;
	}

}