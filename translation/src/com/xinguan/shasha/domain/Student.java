package com.xinguan.shasha.domain;
//学生封装类
import java.sql.Date;

public class Student {
	//定义了一个类的成员，要想成为类的属性必须要为其提供get或set方法
	private int id;//Id
	private String type;//区分学生、老师属性字段：'0'为学生，'1'为老师
	private String username;//用户名
	private String password;//密码
	private String sex;//性别
	private String email;//电子邮件
	private String tel;//电话
	private String protection;// 密保问题
	private String answer;//密保答案
	private String photo;//学生头像
	private String view_photo;//头像预览地址
	private String name;//真事姓名
	private Date register_date;//注册日期

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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getProtection() {
		return protection;
	}
	public void setProtection(String protection) {
		this.protection = protection;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date registerDate) {
		register_date = registerDate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getView_photo() {
		return view_photo;
	}
	public void setView_photo(String viewPhoto) {
		view_photo = viewPhoto;
	}
}
