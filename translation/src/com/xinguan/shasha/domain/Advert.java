package com.xinguan.shasha.domain;

public class Advert {
	private int id;//���id
	private String fileName;//�����
	private String filePath;//���ͼƬ·��
	private String url;//ͼƬ���ӵ�ַ
	
	
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
