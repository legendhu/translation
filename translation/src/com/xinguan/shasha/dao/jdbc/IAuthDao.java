package com.xinguan.shasha.dao.jdbc;

import com.xinguan.shasha.domain.User;

public interface IAuthDao {
	
	public String selectType(String username);//����username��ѯtype����
	
	public boolean judge(String username);//�û����ȶ�
	
	public int select(User user);//�û�������ȶ�
}
