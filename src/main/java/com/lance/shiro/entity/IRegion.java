package com.lance.shiro.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Table(name = "i_region")
public class IRegion {

    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private String id;
    @Column(name = "code",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String code;
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;
    @Column(name = "parentCode",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String parentCode;
    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 4)
    private String status;
    @Column(name = "createDate",type = MySqlTypeConstant.VARCHAR,length = 32)
    private String createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
