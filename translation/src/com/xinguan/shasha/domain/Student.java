package com.xinguan.shasha.domain;
//ѧ����װ��
import java.sql.Date;

public class Student {
	//������һ����ĳ�Ա��Ҫ���Ϊ������Ա���ҪΪ���ṩget��set����
	private int id;//Id
	private String type;//����ѧ������ʦ�����ֶΣ�'0'Ϊѧ����'1'Ϊ��ʦ
	private String username;//�û���
	private String password;//����
	private String sex;//�Ա�
	private String email;//�����ʼ�
	private String tel;//�绰
	private String protection;// �ܱ�����
	private String answer;//�ܱ���
	private String photo;//ѧ��ͷ��
	private String view_photo;//ͷ��Ԥ����ַ
	private String name;//��������
	private Date register_date;//ע������

	//javabean��Ҫһ���޲εĹ��캯����������Ĭ�ϴ���
	//Getters  & Setters....
	public int getId() {//get�������Է�����
		return id;
	}
	public void setId(int id) {//�����޸���
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
