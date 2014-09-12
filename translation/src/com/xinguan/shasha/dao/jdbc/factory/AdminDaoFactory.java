package com.xinguan.shasha.dao.jdbc.factory;

import com.xinguan.shasha.dao.jdbc.IAdminDao;
import com.xinguan.shasha.dao.jdbc.impl.AdminDaoImpl;

public class AdminDaoFactory {
	
	public static IAdminDao getInstance(){
		return new AdminDaoImpl();
	}
}
