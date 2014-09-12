package com.xinguan.shasha.dao.jdbc.factory;

import com.xinguan.shasha.dao.jdbc.IAuthDao;
import com.xinguan.shasha.dao.jdbc.impl.AuthDaoImpl;

public class AuthDaoFactory {
	public static IAuthDao getInstance(){
		return new AuthDaoImpl();
	}
}
