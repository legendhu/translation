package com.xinguan.shasha.dao.jdbc.factory;

import com.xinguan.shasha.dao.jdbc.IMessageDao;
import com.xinguan.shasha.dao.jdbc.impl.MessageDaoImpl;

public class MessageDaoFactory {
	public static IMessageDao getInstance(){
		return new MessageDaoImpl();
	}
}
