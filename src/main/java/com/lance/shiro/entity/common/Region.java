package com.lance.shiro.entity.common;


import org.hibernate.validator.constraints.Length;

/**
 * 区域Entity
 * 
 * @author jeeplus
 * @version 2016-05-15
 */
public class Region  {

	private static final long serialVersionUID = 1L;
	// private Area parent; // 父级编号
	// private String parentIds; // 所有父级编号
	private String code; // 区域编码
	private int sort;
	private String longCode;
	private Region parent;

	public String getLongCode() {
		return longCode;
	}

	public void setLongCode(String longCode) {
		this.longCode = longCode;
	}

	private String phoneCode;
	


	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	private String ename;

	private String flag;
	
	private String pinyin;
	
	

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Region() {
		super();
		this.sort = 30;
	}

//	public Region(Long id) {
//		super(id);
//	}

	// @JsonBackReference
	// @NotNull
//	public Region getParent() {
//		return parent;
//	}

	public void setParent(Region parent) {
		this.parent = parent;
	}

	@Length(min = 0, max = 100)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

//	public Long getParentId() {
//		return parent != null && parent.getId() != null ? parent.getId() : new Long(0);
//	}

	//
	// public String getParentId() {
	// return parent != null && parent.getId() != null ? parent.getId() : "0";
	// }

	@Override
	public String toString() {
		return "";
	}
	

	
}