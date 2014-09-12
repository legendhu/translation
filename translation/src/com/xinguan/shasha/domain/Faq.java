package com.xinguan.shasha.domain;
//常见问题封装类
public class Faq {
	private int id;
	private String title;//标题
	private String Content;//内容
	
	//Getters and Setters...
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
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
}
