package com.lance.shiro.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.lance.shiro.config.ConstantVariable;
import com.lance.shiro.entity.IAttachment;
import com.lance.shiro.entity.IContent;
import com.lance.shiro.mapper.ContentMapper;
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
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentMapper contentMapper;

	@Autowired
	private CommonService commonService;

	@Override
	public ArrayList<Map> save(ArrayList<IContent> contents) {
		ArrayList<Map> acontents = new ArrayList<Map>();
		for (int i = 0,size = contents.size(); i < size; i++) {
			IContent content = contents.get(i);
			Map mcontent = save(content);
			acontents.add(mcontent);
		}
		return acontents;
	}

	@Override
	public Map save(IContent content) {
			String module = content.getModule();
			IContent oContent = checkByModule(module);
			if (oContent == null) {
				// 添加
				contentMapper.add(content);
			} else {
				content.setId(oContent.getId());
				contentMapper.update(content);
			}
			Map mcontent = setAttachment(content);
			return mcontent;
	}

	@Override
	public ArrayList<Map> findByModule(ArrayList<String> modules) {
		ArrayList<Map> contents = new ArrayList<Map>();
		for (int i = 0,size = modules.size(); i < size; i++) {
			String module = modules.get(i);
			Map ret = findByModule(module);
			if(ret != null){
				contents.add(ret);
			}
		}
		return contents;
	}

	@Override
	public Map findByModule(String module) {
		IContent content = contentMapper.findByModule(module);
		if(null == content)
			return null;
		else{
			Map mcontent = setAttachment(content);
			return mcontent;
		}

	}

	private IContent checkByModule(String module) {
		IContent content = contentMapper.findByModule(module);
		return content;
	}

	private Map setAttachment(IContent content){
		Map mcontent = ConvertUtils.beanToMap(content);
		String id = String.valueOf(content.getId());
		mcontent.put(ConstantVariable.BELONG_TO_CATEGORY_CONTENT_ATTACHMENTS,commonService.findListAttachmentByBelong( id , ConstantVariable.BELONG_TO_CATEGORY_CONTENT_ATTACHMENTS));
		return mcontent;
	}


}