package com.xinguan.shasha.dao.jdbc.factory;

import com.xinguan.shasha.dao.jdbc.IAboutDao;
import com.xinguan.shasha.dao.jdbc.impl.AboutDaoImpl;

public class AboutDaoFactory {
	public static IAboutDao getInstance(){
		return new AboutDaoImpl();
	}

}
