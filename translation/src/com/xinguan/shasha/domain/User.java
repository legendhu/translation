package com.xinguan.shasha.domain;
//��ʦ��ѧ���м���װ��
public class User {
	
	//������һ����ĳ�Ա��Ҫ���Ϊ������Ա���ҪΪ���ṩget��set����
	private int id;
	private String type;
	private String username;
	private String password;
	
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
}
	
	