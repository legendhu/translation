package com.xinguan.shasha.domain;
//新闻
import java.sql.Date;

public class News {
	private int id;//新闻id
	private String title;//新闻标题
	private String content;//新闻内容
	private Date date;//新闻日期
	private int last;//上一条新闻
	private int next;//下一条新闻
	
	//Getters  and  Setters....
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
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
}
