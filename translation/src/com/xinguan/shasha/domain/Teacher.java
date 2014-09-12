package com.xinguan.shasha.domain;
//存在于teacher表里的数据
import java.sql.Date;

public class Teacher {
	
	private int id;//id
	private String type;//区分学生、老师属性字段：'0'为学生，'1'为老师
	private String username;//用户名
	private String password;//密码
	private String sex;//性别
	private String education;//从教经验
	private String language;//教授语言
	private String college;//毕业学校
	private String email;//邮箱
	private String tel;//电话
	private Date birthday;//生日
	private String photo;//头像
	private String view_photo;//头像预览地址
	private String qq;//qq/skype
	private String price;//一小时课程价格
	private String bank;//开户银行
	private String banknum;//银行账号
	private String protection;//密保问题
	private String answer;//密保答案
	private String name;//真实姓名
	private int score;//点赞分数
	private String introduction;//个人介绍
	private Date register_date;//注册日期
	
	//存在于ads表中的数据
	private String content;
	private Date ads_date;
	
	
	/*javabean需要一个无参的构造函数，该类中默认存在
	 *Getters  & Setters....
	 */
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
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBanknum() {
		return banknum;
	}
	public void setBanknum(String banknum) {
		this.banknum = banknum;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date registerDate) {
		register_date = registerDate;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAds_date() {
		return ads_date;
	}
	public void setAds_date(Date adsDate) {
		ads_date = adsDate;
	}
}