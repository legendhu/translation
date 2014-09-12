package com.xinguan.shasha.dao.jdbc;

import com.xinguan.shasha.domain.Admin;

public interface IAdminDao {
	
	public boolean select(Admin admin);//比对管理员用户名和密码
	
	public boolean update(Admin admin);//更改管理员用户名和密码
}
