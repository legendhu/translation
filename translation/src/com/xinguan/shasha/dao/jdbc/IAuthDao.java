package com.xinguan.shasha.dao.jdbc;

import com.xinguan.shasha.domain.User;

public interface IAuthDao {
	
	public String selectType(String username);//根据username查询type类型
	
	public boolean judge(String username);//用户名比对
	
	public int select(User user);//用户名密码比对
}
