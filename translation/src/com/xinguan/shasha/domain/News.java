package com.xinguan.shasha.domain;
//����
import java.sql.Date;

public class News {
	private int id;//����id
	private String title;//���ű���
	private String content;//��������
	private Date date;//��������
	private int last;//��һ������
	private int next;//��һ������
	
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
