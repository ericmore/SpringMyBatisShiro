package com.lance.shiro.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.lance.shiro.config.ConstantVariable;
import com.lance.shiro.entity.*;
import com.lance.shiro.mapper.ContentMapper;
import com.lance.shiro.mapper.LotTypeMapper;
import com.lance.shiro.mapper.PropertyListMapper;
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
public class PropertyListServiceImpl implements PropertyListService {
	@Autowired
	private PropertyListMapper propertyListMapper;
	@Autowired
	private LotTypeMapper lotTypeMapper;

	@Autowired
	private CommonService commonService;


	@Override
	public Map get(int id) {
		IPropertyList propertyList = propertyListMapper.get(id);
		Map mpropertyList = setAttachment(propertyList);
		return mpropertyList;
	}

	@Override
	public Map save(IPropertyList propertyList) {
		if(propertyList.getId() == 0){
			propertyListMapper.add(propertyList);
		}else{
			propertyListMapper.update(propertyList);
		}
		int pid = propertyList.getId();
		List<ILotType> lotTypeList = propertyList.getLotTypeList();

		List<ILotType> oldLotTypeList = lotTypeMapper.findAllLotTypeByPropertyList(pid);
		for (int i = 0,size = oldLotTypeList.size(); i < size; i++) {
			boolean isDelete = true;
			int oldId = oldLotTypeList.get(i).getId();
			for(ILotType lotType : lotTypeList){
				 if(oldId == lotType.getId()){
					isDelete=false;
				 }
			}
			if(isDelete){
				lotTypeMapper.delete(oldId);
			}
		}

		for(ILotType lotType : lotTypeList){
			if(lotType.getId()==0) {
				lotType.setPropertyListId(pid);
				lotTypeMapper.add(lotType);
			}else{
				lotType.setPropertyListId(pid);
				lotTypeMapper.update(lotType);
			}
		}

		Map mpropertyList = setAttachment(propertyList);
		return mpropertyList;
	}

	/**
	 * 删除用户
	 * @param ids
	 */
	@Override
	public void deleteAllByIds(ArrayList<Integer> ids){
		int size = ids.size() ;
		for (int i = 0; i < size; i++) {
			delete(ids.get(i));
		}
	}
	@Override
	public void delete(Integer id) {
		propertyListMapper.delete(id);
		lotTypeMapper.deleteByPropertyList(id);
		String sid = String.valueOf(id);
		commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_LIST_LOGO);
		commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_LIST_MULTI_PICTURES);
		commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_LIST_BROCHURE);
	}

	@Override
	public ArrayList<Map> findAllByCitys(List<String> city) {
		ArrayList<IPropertyList> list;
		if(city !=null && city.size()>0){
			String roles = "'"+ StringUtils.join(city, "','")+"'";
			list = propertyListMapper.findAllByCitys(roles);
		}else{
			list= propertyListMapper.findAll();
		}
		ArrayList<Map> aPropertyLists = new ArrayList<Map>();
		for (int i = 0,size = list.size(); i < size; i++) {
			Map maPropertyList = setAttachment(list.get(i));
			aPropertyLists.add(maPropertyList);
		}
		return aPropertyLists;
	}


	private Map setAttachment(IPropertyList propertyList){
		Map mpropertyList = ConvertUtils.beanToMap(propertyList);
		String id = String.valueOf(propertyList.getId());
		mpropertyList.put(BELONG_TO_CATEGORY_PROPERTY_LIST_LOGO,commonService.findListAttachmentByBelong( id , BELONG_TO_CATEGORY_PROPERTY_LIST_LOGO));
		mpropertyList.put(BELONG_TO_CATEGORY_PROPERTY_LIST_MULTI_PICTURES,commonService.findListAttachmentByBelong(id , BELONG_TO_CATEGORY_PROPERTY_LIST_MULTI_PICTURES));
		mpropertyList.put(BELONG_TO_CATEGORY_PROPERTY_LIST_BROCHURE,commonService.findListAttachmentByBelong(id , BELONG_TO_CATEGORY_PROPERTY_LIST_BROCHURE));
		return mpropertyList;
	}
}