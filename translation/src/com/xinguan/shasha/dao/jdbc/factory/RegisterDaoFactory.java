package com.xinguan.shasha.dao.jdbc.factory;

import com.xinguan.shasha.dao.jdbc.IRegisterDao;
import com.xinguan.shasha.dao.jdbc.impl.RegisterDaoImpl;


public class RegisterDaoFactory {
	public static IRegisterDao getInstance(){
		return new RegisterDaoImpl();
	}
}
