package com.xinguan.shasha.dao.jdbc;

import com.xinguan.shasha.domain.About;

public interface IAboutDao {
	
	public About select();//��ѯ�������ǵ���Ϣ
	
	public boolean update(About about);//���¹������ǵ���Ϣ
	

}
