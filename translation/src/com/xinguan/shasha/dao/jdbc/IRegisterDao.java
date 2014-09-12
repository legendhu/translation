package com.xinguan.shasha.dao.jdbc;

import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public interface IRegisterDao {
	public  boolean insert(Teacher teacher);
	public boolean insert(Student student);
}
