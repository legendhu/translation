package com.xinguan.shasha.domain;

import java.sql.Date;
//��������
public class About {
	private int id;
	private String title;//����
	private Date date;//����
	private String content;//����
	
	//Getters  and Setters...
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
