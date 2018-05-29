package com.lance.shiro.entity.common;


import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 验证码系列
 * 
 * @author root
 *
 */

public class ValidateCode  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static  Integer ValidateCode_EMAIL=1;
	
	public static Integer ValidateCode_MOBILE=0;

	private String random; //随即扰乱字符
	
	private Integer randomPosition; //存放位置
	
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	private String code;

	private String sourceType;

	private Long sourceId;

	private Integer byType;

	private String sendTo; // 接受对象

	private Date validTime; // 毫秒iao

	private Date sendTime;

	private Date checkTime; // 验证时间

	private String content;

	private String host;
	
	private String subject;
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	private Integer number; //尝试激活次数

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	private String userAgent;
	
	public ValidateCode()
	{
		
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
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

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getByType() {
		return byType;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public void setByType(Integer byType) {
		this.byType = byType;
	}

	public Date getValidTime() {
		return validTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	
	public String getCorrectCode(String code)
	{
		
		
		if(StringUtils.isBlank(this.random))
		{
			return code;
		}
		int a=code.indexOf(this.random);
		if(a==-1)
		{
			return null;
		}
		//扰乱码要一致
		if(a!=this.randomPosition)
		{
			return null;
		}
		int b=a+code.length();
		
		String newCode=code.substring(0, a)+code.substring(b+1);
		
		
		return newCode;
	}

	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public Integer getRandomPosition() {
		return randomPosition;
	}

	public void setRandomPosition(Integer randomPosition) {
		this.randomPosition = randomPosition;
	}

}
