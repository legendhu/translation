package com.xinguan.shasha.dao.jdbc.factory;

import com.xinguan.shasha.dao.jdbc.INewsDao;
import com.xinguan.shasha.dao.jdbc.impl.NewsDaoImpl;

public class NewsDaoFactory {
	public static INewsDao getInstance(){
		return new NewsDaoImpl();
	}
}
