package com.xinguan.shasha.domain;

import java.util.Date;

public class UpFile {
	private int id;
	private String name;//�ļ���uuid���������
	private String realname;//�ļ�����ʵ������
	private String filepath;//�ļ���·��
	private String description;//�ļ�������
	private Date date;//�ϴ�ʱ��
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
