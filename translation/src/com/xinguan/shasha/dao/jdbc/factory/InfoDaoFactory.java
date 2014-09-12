package com.xinguan.shasha.dao.jdbc.factory;

import com.xinguan.shasha.dao.jdbc.IInfoDao;
import com.xinguan.shasha.dao.jdbc.impl.InfoDaoImpl;

public class InfoDaoFactory {
	public static IInfoDao getInstance(){
		return new InfoDaoImpl();
	}
}
