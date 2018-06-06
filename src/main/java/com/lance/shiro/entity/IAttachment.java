package com.lance.shiro.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Table(name = "i_attachment")
public class IAttachment {
    @Column(name = "id", type = MySqlTypeConstant.INT, length = 11, isKey = true, isAutoIncrement = true)
    private int id;
    @Column(name = "filePath", type = MySqlTypeConstant.VARCHAR, length = 128)
    private String filePath;
    @Column(name = "fileName", type = MySqlTypeConstant.VARCHAR, length = 128)
    private String fileName;
    @Column(name = "extension", type = MySqlTypeConstant.VARCHAR, length = 128)
    private String extension;
    @Column(name = "fileSize", type = MySqlTypeConstant.VARCHAR, length = 128)
    private String fileSize;
    @Column(name = "belongToID", type = MySqlTypeConstant.INT, length = 32)
    private String belongToID;
    @Column(name = "belongToCategory", type = MySqlTypeConstant.VARCHAR, length = 128)
    private String belongToCategory;
    @Column(name = "description", type = MySqlTypeConstant.VARCHAR, length = 128)
    private String description;
    @Column(name = "contentType", type = MySqlTypeConstant.VARCHAR, length = 128)
    private String contentType;
    @Column(name = "createUser", type = MySqlTypeConstant.VARCHAR, length = 32)
    private String createUser;
    @Column(name = "createTime", type = MySqlTypeConstant.DATETIME, length = 32)
    private String createTime;
    @Column(name = "module", type = MySqlTypeConstant.VARCHAR, length = 128)
    private String module;
    @Column(name = "realPath", type = MySqlTypeConstant.VARCHAR, length = 128)
    private String realPath;
    @Column(name = "status", type = MySqlTypeConstant.VARCHAR, length = 4)
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getBelongToID() {
        return belongToID;
    }

    public void setBelongToID(String belongToID) {
        this.belongToID = belongToID;
    }

    public String getBelongToCategory() {
        return belongToCategory;
    }

    public void setBelongToCategory(String belongToCategory) {
        this.belongToCategory = belongToCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getRealPath() {
        return realPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
