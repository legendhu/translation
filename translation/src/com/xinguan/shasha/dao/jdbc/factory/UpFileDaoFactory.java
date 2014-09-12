package com.xinguan.shasha.dao.jdbc.factory;

import java.io.InputStream;
import java.util.Properties;

import com.xinguan.shasha.dao.jdbc.IUpFileDao;


public class UpFileDaoFactory {
	//产生dao工厂
	
		private final static UpFileDaoFactory instance = new UpFileDaoFactory();
		
		private UpFileDaoFactory(){
			
		}
		public static UpFileDaoFactory getInstance(){
			
			return instance;
		}
		
		private static IUpFileDao upfiledao = null;
		static{
			
			try {
				InputStream in = UpFileDaoFactory.class
						.getClassLoader()
						.getResourceAsStream("com/xinguan/shasha/dao/jdbc/factory/dao.properties");
				Properties prop = new Properties();
				prop.load(in);
				String classname = prop.getProperty("daoClassName");
				
				Class clazz = Class.forName(classname);
				upfiledao = (IUpFileDao) clazz.newInstance();
				
			} catch (Exception e) {
				throw new ExceptionInInitializerError(e);
			}
		}
		
		public IUpFileDao getIUpFileDao(){
			return upfiledao;
		}

}
