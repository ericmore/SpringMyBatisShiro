package com.lance.shiro.entity.common;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * 数据字典Entity
 * @author lgf
 * @version 2017-01-16
 */
public class DictType  {
	
	private static final long serialVersionUID = 1L;
	private String type;		// 类型
	private String description;		// 描述
	private String lang;
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	private String alias;

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	private List<DictValue> dictValueList = Lists.newArrayList();		// 子表列表
	
	public DictType() {
		super();
	}

//	public DictType(Long id){
//		super(id);
//	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<DictValue> getDictValueList() {
		return dictValueList;
	}

	public void setDictValueList(List<DictValue> dictValueList) {
		this.dictValueList = dictValueList;
	}
}