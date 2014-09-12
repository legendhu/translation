package com.xinguan.shasha.dao.jdbc;

import java.util.List;

import com.xinguan.shasha.domain.Faq;

public interface IFaqDao {
	
	public boolean insert(Faq faq);//����һ��faq
	
	
	public boolean delete(int id);//����Idɾ��һ��faq
	

	public boolean update(Faq faq);//����Id����һ��faq
	

	public Faq select(int id);//����Id��ѯһ��faq
	
	public List<Faq> find();//��ѯ����faq

}
