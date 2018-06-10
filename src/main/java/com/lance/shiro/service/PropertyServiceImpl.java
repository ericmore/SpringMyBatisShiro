package com.lance.shiro.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.lance.shiro.config.ConstantVariable;
import com.lance.shiro.entity.IAttachment;
import com.lance.shiro.entity.IContent;
import com.lance.shiro.entity.IProperty;
import com.lance.shiro.entity.IPropertyList;
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

import static com.lance.shiro.config.ConstantVariable.*;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	private PropertyMapper propertyMapper;

	@Autowired
	private CommonService commonService;


	@Override
	public Map get(int id) {
		IProperty property = propertyMapper.get(id);
		return setAttachment(property);
	}

	@Override
	public Map save(IProperty property) {
		if(property.getId() == 0){
			propertyMapper.add(property);
		}else{
			propertyMapper.update(property);
		}
		return setAttachment(property);
	}

	@Override
	public void deleteAllByIds(ArrayList<Integer> ids) {
		int size = ids.size() ;
		for (int i = 0; i < size; i++) {
			delete(ids.get(i));
		}
	}


	@Override
	public ArrayList<Map> findAllByPropertyLists(ArrayList<Integer> propertyListId) {
		ArrayList<IProperty> list;
		if(propertyListId !=null && propertyListId.size()>0){
			String propertyListIds = "'"+ StringUtils.join(propertyListId, "','")+"'";
			list = propertyMapper.findAllByPropertyList(propertyListIds);
		}else{
			list= propertyMapper.findAll();
		}
		return setAttachmentForList(list);
	}

	@Override
	public ArrayList<Map> findAllByAgents(ArrayList<Integer> agentId) {
		ArrayList<IProperty> list;
		if(agentId !=null && agentId.size()>0){
			String agentIds = "'"+ StringUtils.join(agentId, "','")+"'";
			list = propertyMapper.findAllByAgent(agentIds);
		}else{
			list= propertyMapper.findAll();
		}
		return setAttachmentForList(list);
	}

	@Override
	public ArrayList<Map> findAllByOwners(ArrayList<Integer> ownerId) {
		ArrayList<IProperty> list;
		if(ownerId !=null && ownerId.size()>0){
			String ownerIds = "'"+ StringUtils.join(ownerId, "','")+"'";
			list = propertyMapper.findAllByOwner(ownerIds);
		}else{
			list= propertyMapper.findAll();
		}
		return setAttachmentForList(list);
	}

	@Override
	public void delete(Integer id) {
		propertyMapper.delete(id);
		String sid = String.valueOf(id);
		commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_COS_DOCUMENT);
		commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_DEPOSIT_FORM_DOCUMENT);
		commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_BILL_CHARGES);
		commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_MANAGEMENT_AGREEMENT_DUCOMENT);
		commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_OTHERS);
		commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_MAIN_IMAGE);
	}

	private ArrayList<Map> setAttachmentForList(ArrayList<IProperty> list){
		ArrayList<Map> aPropertys = new ArrayList<Map>();
		for (int i = 0,size = list.size(); i < size; i++) {
			Map maProperty = setAttachment(list.get(i));
			aPropertys.add(maProperty);
		}
		return aPropertys;
	}

	private Map setAttachment(IProperty property){
		Map mproperty = ConvertUtils.beanToMap(property);
		String id = String.valueOf(property.getId());
		mproperty.put(BELONG_TO_CATEGORY_PROPERTY_COS_DOCUMENT,commonService.findListAttachmentByBelong( id , BELONG_TO_CATEGORY_PROPERTY_COS_DOCUMENT));
		mproperty.put(BELONG_TO_CATEGORY_PROPERTY_DEPOSIT_FORM_DOCUMENT,commonService.findListAttachmentByBelong(id , BELONG_TO_CATEGORY_PROPERTY_DEPOSIT_FORM_DOCUMENT));
		mproperty.put(BELONG_TO_CATEGORY_PROPERTY_BILL_CHARGES,commonService.findListAttachmentByBelong(id , BELONG_TO_CATEGORY_PROPERTY_BILL_CHARGES));
		mproperty.put(BELONG_TO_CATEGORY_PROPERTY_MANAGEMENT_AGREEMENT_DUCOMENT,commonService.findListAttachmentByBelong( id , BELONG_TO_CATEGORY_PROPERTY_MANAGEMENT_AGREEMENT_DUCOMENT));
		mproperty.put(BELONG_TO_CATEGORY_PROPERTY_OTHERS,commonService.findListAttachmentByBelong(id , BELONG_TO_CATEGORY_PROPERTY_OTHERS));
		mproperty.put(BELONG_TO_CATEGORY_PROPERTY_MAIN_IMAGE,commonService.findListAttachmentByBelong(id , BELONG_TO_CATEGORY_PROPERTY_MAIN_IMAGE));
		return mproperty;
	}
}