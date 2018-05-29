package com.lance.shiro.entity;


import com.lance.shiro.entity.common.Position;

public class Building  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	private String name;

	private String picture;// 主图片

	private Integer type;

	private Integer number;

	private Integer fixed; // 预订

	private Integer saled; // 销售

	private Integer free; // 剩余

	private Position position;

	private String tag;

	private Double priceLow;

	private Double priceHigh;
	
	private String developer; //开发商
	
	private Integer propertyRight; //产权方式
	
	private Integer decoration; //装修情况
	
	private String displayAddress; //展示中心

	public String getDisplayAddress() {
		return displayAddress;
	}

	public void setDisplayAddress(String displayAddress) {
		this.displayAddress = displayAddress;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public Integer getPropertyRight() {
		return propertyRight;
	}

	public void setPropertyRight(Integer propertyRight) {
		this.propertyRight = propertyRight;
	}

	public Integer getDecoration() {
		return decoration;
	}

	public void setDecoration(Integer decoration) {
		this.decoration = decoration;
	}

	private Integer areaLow;

	private Integer areaHigh;

	private Integer spaceLow;

	private Integer spaceHigh;

	private Integer startYear;

	private Integer finishYear;

	private Integer completed;

	private Integer age;

	





	public Building() {

	}

//	public Building(Long id) {
//		super(id);
//	}

	public Integer getAge() {
		return age;
	}

	public Integer getAreaHigh() {
		return areaHigh;
	}

	public Integer getAreaLow() {
		return areaLow;
	}

	public String getCode() {
		return code;
	}

	public Integer getCompleted() {
		return completed;
	}

	public Integer getFinishYear() {
		return finishYear;
	}

	public Integer getFixed() {
		return fixed;
	}

	public Integer getFree() {
		return free;
	}

	public String getName() {
		return name;
	}

	public Integer getNumber() {
		return number;
	}

	public String getPicture() {
		return picture;
	}

	public Position getPosition() {
		return position;
	}

	public Double getPriceHigh() {
		return priceHigh;
	}

	public Double getPriceLow() {
		return priceLow;
	}

	public Integer getSaled() {
		return saled;
	}

	public Integer getSpaceHigh() {
		return spaceHigh;
	}

	public Integer getSpaceLow() {
		return spaceLow;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public String getTag() {
		return tag;
	}

	public Integer getType() {
		return type;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setAreaHigh(Integer areaHigh) {
		this.areaHigh = areaHigh;
	}

	public void setAreaLow(Integer areaLow) {
		this.areaLow = areaLow;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCompleted(Integer completed) {
		this.completed = completed;
	}

	public void setFinishYear(Integer finishYear) {
		this.finishYear = finishYear;
	}

	public void setFixed(Integer fixed) {
		this.fixed = fixed;
	}

	public void setFree(Integer free) {
		this.free = free;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setPriceHigh(Double priceHigh) {
		this.priceHigh = priceHigh;
	}

	public void setPriceLow(Double priceLow) {
		this.priceLow = priceLow;
	}

	public void setSaled(Integer saled) {
		this.saled = saled;
	}

	public void setSpaceHigh(Integer spaceHigh) {
		this.spaceHigh = spaceHigh;
	}

	public void setSpaceLow(Integer spaceLow) {
		this.spaceLow = spaceLow;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
