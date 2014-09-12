package com.xinguan.shasha.dao.jdbc.factory;

import com.xinguan.shasha.dao.jdbc.IImageDao;
import com.xinguan.shasha.dao.jdbc.impl.ImageDaoImpl;

public class ImageDaoFactory {
	public static IImageDao getInstance(){
		return new ImageDaoImpl();
	}
}
