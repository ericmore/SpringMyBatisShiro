package com.lance.shiro.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import java.sql.Date;
@Table(name = "i_content")
public class IContent {

    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "module",type = MySqlTypeConstant.VARCHAR,length = 80)
    private String module;  
    @Column(name = "title",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String title;
    @Column(name = "content1",type = MySqlTypeConstant.TEXT)
    private String content1;
    @Column(name = "content2",type = MySqlTypeConstant.TEXT)
    private String content2;
    @Column(name = "content3",type = MySqlTypeConstant.TEXT)
    private String content3; 
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

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
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
