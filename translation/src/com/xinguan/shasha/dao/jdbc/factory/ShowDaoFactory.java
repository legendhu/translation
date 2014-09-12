package com.xinguan.shasha.dao.jdbc.factory;


import com.xinguan.shasha.dao.jdbc.IShowDao;
import com.xinguan.shasha.dao.jdbc.impl.ShowDaoImpl;

public class ShowDaoFactory {
	public static IShowDao getInstance(){
		return new ShowDaoImpl();
	}
}
