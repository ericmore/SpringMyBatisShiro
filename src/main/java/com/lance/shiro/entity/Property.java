package com.lance.shiro.entity;

/**
 * 具体房子信息，
 * 通过status 0，空闲，1预定，2交易中，3交易完成/被购买来状态
 * @author root
 *
 */
public class Property  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	
	private Double price; //挂牌价
	
	

	private BuildingType buildingType; //房型

	private Integer floor; //楼层

	private String roomNo;//房间号

	private String code;//房产证号，类似
	

	

	private Integer rentFlag; //出租状态
	
	
	
	public BuildingType getBuildingType() {
		return buildingType;
	}
	
	public String getCode() {
		return code;
	}
	
	
	private String picture;


	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getFloor() {
		return floor;
	}



	public String getName() {
		return name;
	}

	public Integer getRentFlag() {
		return rentFlag;
	}

	public String getRoomNo() {
		return roomNo;
	}

	





	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public void setRentFlag(Integer rentFlag) {
		this.rentFlag = rentFlag;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}



	


	
	
	

}
