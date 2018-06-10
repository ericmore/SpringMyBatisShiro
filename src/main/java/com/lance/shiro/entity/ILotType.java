package com.lance.shiro.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import java.sql.Date;
@Table(name = "i_lot_type")
public class ILotType {

    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "bedroomCount",type = MySqlTypeConstant.INT,length = 11)
    private int bedroomCount;
    @Column(name = "bathRoomCount",type = MySqlTypeConstant.INT,length = 11)
    private int bathRoomCount;
    @Column(name = "parkingCount",type = MySqlTypeConstant.INT,length = 11)
    private int parkingCount;
    @Column(name = "price",type = MySqlTypeConstant.DOUBLE,length = 10,decimalLength = 2)
    private double price;
    @Column(name = "qty",type = MySqlTypeConstant.INT,length = 11)
    private int qty;
    @Column(name = "notes",type = MySqlTypeConstant.VARCHAR,length = 500)
    private String notes;
    @Column(name = "propertyListId",type = MySqlTypeConstant.INT,length = 11)
    private int propertyListId;
    private IPropertyList propertyList;

    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 20,defaultValue = "active")
    private String status;
    @Column(name = "createTime",type = MySqlTypeConstant.DATETIME,length = 80)
    private Date createTime;
    @Column(name = "updateTime",type = MySqlTypeConstant.DATETIME,length = 80)
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IPropertyList getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(IPropertyList propertyList) {
        this.propertyList = propertyList;
    }

    public int getBedroomCount() {
        return bedroomCount;
    }

    public void setBedroomCount(int bedroomCount) {
        this.bedroomCount = bedroomCount;
    }

    public int getBathRoomCount() {
        return bathRoomCount;
    }

    public void setBathRoomCount(int bathRoomCount) {
        this.bathRoomCount = bathRoomCount;
    }

    public int getParkingCount() {
        return parkingCount;
    }

    public void setParkingCount(int parkingCount) {
        this.parkingCount = parkingCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getPropertyListId() {
        return propertyListId;
    }

    public void setPropertyListId(int propertyListId) {
        this.propertyListId = propertyListId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
