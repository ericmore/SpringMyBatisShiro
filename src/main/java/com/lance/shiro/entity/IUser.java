package com.lance.shiro.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import java.sql.Date;
@Table(name = "i_user")
public class IUser {

    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "personalID",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String personalID;
    @Column(name = "username",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String username;
    @Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String password;
    @Column(name = "firstName",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String firstName;
    @Column(name = "middleName",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String middleName;
    @Column(name = "lastName",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String lastName;
    @Column(name = "role",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String role;
    @Column(name = "code",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String code;
    @Column(name = "referID",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String referID;
    @Column(name = "email",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String email;
    @Column(name = "sex",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String sex;
    @Column(name = "age",type = MySqlTypeConstant.INT)
    private int age;
    @Column(name = "mobile",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String mobile;
    @Column(name = "country",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String country;
    @Column(name = "state",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String state;
    @Column(name = "city",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String city;
    @Column(name = "street",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String street;
    @Column(name = "position",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String position;
    @Column(name = "company",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String company;
    @Column(name = "experience",type = MySqlTypeConstant.DOUBLE,length = 80)
    private double experience;
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

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReferID() {
        return referID;
    }

    public void setReferID(String referID) {
        this.referID = referID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
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
