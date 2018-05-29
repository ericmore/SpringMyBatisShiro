package com.lance.shiro.entity;


/**
 * 房型
 * 
 * @author root 房型图片
 */
public class BuildingType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String code;

	private Building building;
	
	private String picture;

	private float area; // 室内面积

	private Integer bedroomNum; // 卧室

	private Integer bathroomNum;// 盥洗室

	private Integer carportNum;// 车库

	private Integer parkingNum;// 车库

	private float space;// 占地面积

	private Integer basement;// 是否有地下室

	private Integer storey; // 楼层数

	private Double priceLow;

	private Double priceHigh;

	private Integer number;

	private Integer fixed;
	
	private Integer saled;
	
	private Integer free;
	
	public float getArea() {
		return area;
	}
	
	

	


	public Integer getBasement() {
		return basement;
	}

	public Integer getBathroomNum() {
		return bathroomNum;
	}

	public Integer getBedroomNum() {
		return bedroomNum;
	}

	public Building getBuilding() {
		return building;
	}

	public Integer getCarportNum() {
		return carportNum;
	}

	public String getCode() {
		return code;
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

	public Integer getParkingNum() {
		return parkingNum;
	}

	public String getPicture() {
		return picture;
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

	public float getSpace() {
		return space;
	}

	public Integer getStorey() {
		return storey;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public void setBasement(Integer basement) {
		this.basement = basement;
	}

	public void setBathroomNum(Integer bathroomNum) {
		this.bathroomNum = bathroomNum;
	}

	public void setBedroomNum(Integer bedroomNum) {
		this.bedroomNum = bedroomNum;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public void setCarportNum(Integer carportNum) {
		this.carportNum = carportNum;
	}

	public void setCode(String code) {
		this.code = code;
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

	public void setParkingNum(Integer parkingNum) {
		this.parkingNum = parkingNum;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public void setSpace(float space) {
		this.space = space;
	}

	public void setStorey(Integer storey) {
		this.storey = storey;
	}

}
