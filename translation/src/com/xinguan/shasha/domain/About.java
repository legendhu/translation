package com.xinguan.shasha.domain;

import java.sql.Date;
//关于我们
public class About {
	private int id;
	private String title;//标题
	private Date date;//日期
	private String content;//内容
	
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
