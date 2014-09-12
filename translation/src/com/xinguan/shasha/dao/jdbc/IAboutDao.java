package com.xinguan.shasha.dao.jdbc;

import com.xinguan.shasha.domain.About;

public interface IAboutDao {
	
	public About select();//查询关于我们的信息
	
	public boolean update(About about);//更新关于我们的信息
	

}
