/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.lance.shiro.entity.common;



/**
 * 数据字典Entity
 * @author lgf
 * @version 2017-01-16
 */
public class DictValue  {
	
	private static final long serialVersionUID = 1L;
	private String label;		// 标签名
	private String value;		// 键值
	private String sort;		// 排序
	private DictType dictType;		// 外键 父类


	

	public DictValue() {
		super();
	}

//	public DictValue(Long id){
//		super(id);
//	}

	public DictValue(DictType dictType){
		this.dictType = dictType;
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public DictType getDictType() {
		return dictType;
	}

	public void setDictType(DictType dictType) {
		this.dictType = dictType;
	}
	
}