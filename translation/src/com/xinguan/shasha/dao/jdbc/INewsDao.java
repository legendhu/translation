package com.xinguan.shasha.dao.jdbc;

import java.util.List;

import com.xinguan.shasha.domain.News;
import com.xinguan.shasha.domain.Page;

public interface INewsDao {
	
	public boolean insert(News news);//����������
	
	public boolean delete(News news);//����Idɾ������
	
	public boolean update(News news);//����Id��������
	
	public News selectInfo(int id);//����Id��ѯ��������
	
	public int selectCount();//��ѯ��������
	
	public List<News> selectAll(Page page);//��ҳչʾ��������
}
