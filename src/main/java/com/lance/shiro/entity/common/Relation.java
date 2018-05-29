package com.lance.shiro.entity.common;


import java.util.Date;

public class Relation  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sourceType;
	
	private String destType;
	
	private Long sourceId;
	
	private Long destId;
	
	private Date beginDate;
	
	private Date endDate;
	
	private String keyword; //关系关键字
	
	private String code; //关系编码


	private String content;
	
	private Object sourceObject;
	
	private Object destObject;
	
	public Object getSourceObject() {
		return sourceObject;
	}

	public void setSourceObject(Object sourceObject) {
		this.sourceObject = sourceObject;
	}

	public Object getDestObject() {
		return destObject;
	}

	public void setDestObject(Object destObject) {
		this.destObject = destObject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private Integer level;
	
	private String varString1;
	
	private String varString2;
	
	private String varString3;
	
	private String varString4;
	
	private String varString5;

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getDestType() {
		return destType;
	}

	public void setDestType(String destType) {
		this.destType = destType;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public Long getDestId() {
		return destId;
	}

	public void setDestId(Long destId) {
		this.destId = destId;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getVarString1() {
		return varString1;
	}

	public void setVarString1(String varString1) {
		this.varString1 = varString1;
	}

	public String getVarString2() {
		return varString2;
	}

	public void setVarString2(String varString2) {
		this.varString2 = varString2;
	}

	public String getVarString3() {
		return varString3;
	}

	public void setVarString3(String varString3) {
		this.varString3 = varString3;
	}

	public String getVarString4() {
		return varString4;
	}

	public void setVarString4(String varString4) {
		this.varString4 = varString4;
	}

	public String getVarString5() {
		return varString5;
	}

	public void setVarString5(String varString5) {
		this.varString5 = varString5;
	}

}
