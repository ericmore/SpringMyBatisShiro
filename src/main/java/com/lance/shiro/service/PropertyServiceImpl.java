package com.lance.shiro.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.lance.shiro.config.ConstantVariable;
import com.lance.shiro.entity.IAttachment;
import com.lance.shiro.entity.IContent;
import com.lance.shiro.entity.IProperty;
import com.lance.shiro.mapper.ContentMapper;
import com.lance.shiro.mapper.PropertyMapper;
import com.lance.shiro.mapper.UserMapper;
import com.lance.shiro.utils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.sql.Date;
import java.util.*;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	private PropertyMapper propertyMapper;

	@Autowired
	private CommonService commonService;


	@Override
	public Map get(int id) {
		return null;
	}
}