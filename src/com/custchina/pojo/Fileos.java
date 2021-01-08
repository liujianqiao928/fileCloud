package com.custchina.pojo;

import java.util.Date;

public class Fileos {
	 private Integer fileId;

	    private String fileName;

	    private String fileType;

	    private Integer fileSize;

	    private String fileUptime;
	    private String imgs;

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public Integer getFileId() {
	        return fileId;
	    }

	    public void setFileId(Integer fileId) {
	        this.fileId = fileId;
	    }

	    public String getFileName() {
	        return fileName;
	    }

	    public void setFileName(String fileName) {
	        this.fileName = fileName == null ? null : fileName.trim();
	    }

	    public String getFileType() {
	        return fileType;
	    }

	    public void setFileType(String fileType) {
	        this.fileType = fileType == null ? null : fileType.trim();
	    }

	    public Integer getFileSize() {
	        return fileSize;
	    }

	    public void setFileSize(Integer fileSize) {
	        this.fileSize = fileSize;
	    }

	    public String getFileUptime() {
	        return fileUptime;
	    }

	    public void setFileUptime(String fileUptime) {
	        this.fileUptime = fileUptime;
	    }
}
