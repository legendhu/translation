package com.xinguan.shasha.domain;
//ÿ�����񣬴���ѧ��ѡ����ʦjavabean
public class Message {
	private int id;
	private String stusername;//ѧ���û���
	private String thusername;//��ѡ��ʦ�û���
	private String thname;//��ѡ��ʦ��ʵ����
	private String banknum;//����˺�
	private String content;//��������
	
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
