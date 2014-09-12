package com.xinguan.shasha.domain;

public class Advert {
	private int id;//广告id
	private String fileName;//广告名
	private String filePath;//广告图片路径
	private String url;//图片链接地址
	
	
	//Getters and Setters....
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
