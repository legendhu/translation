package com.xinguan.shasha.domain;
//老师、学生中间表封装类
public class User {
	
	//定义了一个类的成员，要想成为类的属性必须要为其提供get或set方法
	private int id;
	private String type;
	private String username;
	private String password;
	
	//javabean需要一个无参的构造函数，该类中默认存在
	//Getters  & Setters....
	public int getId() {//get方法属性访问器
		return id;
	}
	public void setId(int id) {//属性修改器
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
	
	