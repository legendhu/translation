package com.xinguan.shasha.domain;
//������teacher���������
import java.sql.Date;

public class Teacher {
	
	private int id;//id
	private String type;//����ѧ������ʦ�����ֶΣ�'0'Ϊѧ����'1'Ϊ��ʦ
	private String username;//�û���
	private String password;//����
	private String sex;//�Ա�
	private String education;//�ӽ̾���
	private String language;//��������
	private String college;//��ҵѧУ
	private String email;//����
	private String tel;//�绰
	private Date birthday;//����
	private String photo;//ͷ��
	private String view_photo;//ͷ��Ԥ����ַ
	private String qq;//qq/skype
	private String price;//һСʱ�γ̼۸�
	private String bank;//��������
	private String banknum;//�����˺�
	private String protection;//�ܱ�����
	private String answer;//�ܱ���
	private String name;//��ʵ����
	private int score;//���޷���
	private String introduction;//���˽���
	private Date register_date;//ע������
	
	//������ads���е�����
	private String content;
	private Date ads_date;
	
	
	/*javabean��Ҫһ���޲εĹ��캯����������Ĭ�ϴ���
	 *Getters  & Setters....
	 */
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