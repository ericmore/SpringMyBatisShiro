package com.lance.shiro.mapper;

import org.apache.ibatis.annotations.Select;

import com.lance.shiro.entity.UserInfo;

public interface UserMapper {

	@Select("select *from t_user where account=#{account}")
	UserInfo findByAccount(String account);
}
