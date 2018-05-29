package com.lance.shiro.entity.common;

public class Attachment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	
	private Long size;
	
	private String ext;
	
	private String filename;
	
	private String path;
	
	private String type;//0,内部，1，链接
	
	private Integer isLink; //
	
	public Integer getIsLink() {
		return isLink;
	}

	public void setIsLink(Integer isLink) {
		this.isLink = isLink;
	}

	private String sourceType;
	
	private Long sourceId;

	private String sourceKey; //附件用途关键字

	private String keyword;
	
	private String field;
	
	private byte[] data;
	
	private String url;
	
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getExt() {
		return ext;
	}
	
	public String getFilename() {
		return filename;
	}

	

	public String getKeyword() {
		return keyword;
	}

	public String getPath() {
		return path;
	}

	public Long getSize() {
		return size;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public String getSourceType() {
		return sourceType;
	}

	public String getTitle() {
		return title;
	}



	public void setExt(String ext) {
		this.ext = ext;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getSourceKey() {
		return sourceKey;
	}

	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
