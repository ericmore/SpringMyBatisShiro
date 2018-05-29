package com.lance.shiro.entity;

import java.util.Date;

/**
 * 代理用戶信息。註冊後
 * @author root
 * status:0,未邮件通知，1，邮件通知。
 
 */
public class UserAgent  {

	
	public Integer getMailStatus() {
		return mailStatus;
	}

	public void setMailStatus(Integer mailStatus) {
		this.mailStatus = mailStatus;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstname;

	private String surname;
	
	private String code;
	
	private RegAgent regAgent;
	
	
	public RegAgent getRegAgent() {
		return regAgent;
	}

	public void setRegAgent(RegAgent regAgent) {
		this.regAgent = regAgent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	private Integer grade; //等级
	
	private Integer points;//积分


	
  

	
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}


	

	

	
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	private User user;

	private Date regDate;

	private Date okDate;

	private String email;
	
	
	private Integer mailStatus; //是否已经注册邮件

	private String occupation;

	private String position;
	
	private String photo;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	private String company;
	
	private String mobile;
	
	private String experience;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String street;
	
	private String district;
	
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 0,用戶註冊，1，管理與註冊
	 */
	private Integer source;

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getCompany() {
		return company;
	}

	public String getEmail() {
		return email;
	}
	
	public String getFirstname() {
		return firstname;
	}
	

	
	public String getOccupation() {
		return occupation;
	}
	
	public Date getOkDate() {
		return okDate;
	}

	public String getPosition() {
		return position;
	}

	public Date getRegDate() {
		return regDate;
	}

	public String getSurname() {
		return surname;
	}

	public User getUser() {
		return user;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public void setOkDate(Date okDate) {
		this.okDate = okDate;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
