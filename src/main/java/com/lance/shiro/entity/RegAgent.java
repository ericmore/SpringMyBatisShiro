package com.lance.shiro.entity;

import com.lance.shiro.entity.common.Region;
import com.lance.shiro.entity.common.ValidateCode;

import javax.validation.constraints.NotNull;


public class RegAgent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
	private String surname;
	
	private String firstname;
	
	private String position;
	
	private String company;
	
	private String experience;
	
	private String referralId;
	
	private String remoteIp;
	
	private String userAgent;//設備類型
	
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	private String country;
	
	private String state;
	
	private String city;
	
	private String street;
	
	private String district;
	
	private Region countryObject;
	
	private Region stateObject;
	
	
	
	public Region getStateObject() {
		return stateObject;
	}

	public void setStateObject(Region stateObject) {
		this.stateObject = stateObject;
	}



	private Region cityObject;
	
	private ValidateCode validateCode;
	
	public ValidateCode getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(ValidateCode validateCode) {
		this.validateCode = validateCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Region getCityObject() {
		return cityObject;
	}

	public void setCityObject(Region cityObject) {
		this.cityObject = cityObject;
	}

	public Region getCountryObject() {
		return countryObject;
	}

	public void setCountryObject(Region countryObject) {
		this.countryObject = countryObject;
	}

	
	
	private String photo;
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

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

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	private String mobile;
	
	private String occupation;
	
	private String email;


	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getReferralId() {
		return referralId;
	}

	public void setReferralId(String referralId) {
		this.referralId = referralId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@NotNull(message="Email can't be null")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
