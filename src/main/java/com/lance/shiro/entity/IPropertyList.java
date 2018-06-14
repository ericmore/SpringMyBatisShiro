package com.lance.shiro.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Table(name = "i_property_list")
public class IPropertyList {
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer id;
    @Column(name = "buildingName",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String buildingName;
    @Column(name = "buildingAddress",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String buildingAddress;
    @Column(name = "city",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String city;
    @Column(name = "state",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String state;
    @Column(name = "country",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String country;
    @Column(name = "x",type = MySqlTypeConstant.DOUBLE,length = 10,decimalLength = 2)
    private double x;
    @Column(name = "y",type = MySqlTypeConstant.DOUBLE,length = 10,decimalLength = 2)
    private double y;
    @Column(name = "buildingOverview",type = MySqlTypeConstant.TEXT)
    private String buildingOverview;
    @Column(name = "features",type = MySqlTypeConstant.TEXT)
    private String features;
    @Column(name = "date",type = MySqlTypeConstant.DATETIME,length = 80)
    private Date date;
    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 20,defaultValue = "active")
    private String status;
    @Column(name = "createTime",type = MySqlTypeConstant.DATETIME,length = 80)
    private Date createTime;
    @Column(name = "updateTime",type = MySqlTypeConstant.DATETIME,length = 80)
    private Date updateTime;

    public List lotTypeList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getBuildingOverview() {
        return buildingOverview;
    }

    public void setBuildingOverview(String buildingOverview) {
        this.buildingOverview = buildingOverview;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public List getLotTypeList() {
        return lotTypeList;
    }

    public void setLotTypeList(List lotTypeList) {
        this.lotTypeList = lotTypeList;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
