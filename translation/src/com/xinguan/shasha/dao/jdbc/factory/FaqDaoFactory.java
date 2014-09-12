package com.xinguan.shasha.dao.jdbc.factory;

import com.xinguan.shasha.dao.jdbc.IFaqDao;
import com.xinguan.shasha.dao.jdbc.impl.FaqDaoImpl;

public class FaqDaoFactory {
	public static IFaqDao getInstance(){
		return new FaqDaoImpl();
	}

}
