package com.lance.shiro.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.lance.shiro.entity.IContent;
import com.lance.shiro.mapper.ContentMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.DigestUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentMapper contentMapper;

	/**
	 * 保存
	 */
	@Override
	public IContent save(IContent content) {
		String module = content.getModule();
		IContent oContent = findByModule(module);
		if (oContent == null) {
			// 添加用户
			contentMapper.add(content);
		} else {
			content.setId(oContent.getId());
			contentMapper.update(content);
		}
		return content;
	}
	/**
	 * 查询
	 */
	@Override
	public IContent findByModule(String module) {
		return contentMapper.findByModule(module);
	}



}