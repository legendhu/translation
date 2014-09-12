package com.xinguan.shasha.dao.jdbc;

import java.util.List;

import com.xinguan.shasha.domain.Faq;

public interface IFaqDao {
	
	public boolean insert(Faq faq);//增加一个faq
	
	
	public boolean delete(int id);//根据Id删除一个faq
	

	public boolean update(Faq faq);//根据Id更新一个faq
	

	public Faq select(int id);//根据Id查询一个faq
	
	public List<Faq> find();//查询所有faq

}
