package com.xinguan.shasha.dao.jdbc;

import java.util.List;

import com.xinguan.shasha.domain.News;
import com.xinguan.shasha.domain.Page;

public interface INewsDao {
	
	public boolean insert(News news);//插入新新闻
	
	public boolean delete(News news);//根据Id删除新闻
	
	public boolean update(News news);//根据Id更改新闻
	
	public News selectInfo(int id);//根据Id查询单条新闻
	
	public int selectCount();//查询新闻总数
	
	public List<News> selectAll(Page page);//分页展示新闻数据
}
