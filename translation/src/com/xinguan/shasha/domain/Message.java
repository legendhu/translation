package com.xinguan.shasha.domain;
//每日事务，处理学生选择老师javabean
public class Message {
	private int id;
	private String stusername;//学生用户名
	private String thusername;//所选老师用户名
	private String thname;//所选老师真实姓名
	private String banknum;//打款账号
	private String content;//留言内容
	
	//Getters and Setters....
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStusername() {
		return stusername;
	}
	public void setStusername(String stusername) {
		this.stusername = stusername;
	}
	public String getThusername() {
		return thusername;
	}
	public void setThusername(String thusername) {
		this.thusername = thusername;
	}
	public String getThname() {
		return thname;
	}
	public void setThname(String thname) {
		this.thname = thname;
	}
	public String getBanknum() {
		return banknum;
	}
	public void setBanknum(String banknum) {
		this.banknum = banknum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
