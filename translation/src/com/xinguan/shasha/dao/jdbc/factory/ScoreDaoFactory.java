package com.xinguan.shasha.dao.jdbc.factory;

import com.xinguan.shasha.dao.jdbc.IScoreDao;
import com.xinguan.shasha.dao.jdbc.impl.ScoreDaoImpl;

public class ScoreDaoFactory {
	public static IScoreDao getInstance(){
		return new ScoreDaoImpl();
	}
}
