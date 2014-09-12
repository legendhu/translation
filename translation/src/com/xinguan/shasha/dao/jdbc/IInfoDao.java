package com.xinguan.shasha.dao.jdbc;


import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;
import com.xinguan.shasha.domain.User;

public interface IInfoDao {
	
	public boolean updateSt(Student student);//根据username更改学生信息(前台)
	
	public boolean updateTh(Teacher teacher);//根据username更改老师信息(前台)
	
	public boolean insert(Teacher teacher);//插入ads表，更新老师发布信息
	
	public boolean update(User user);//更改用户密码
	
	public boolean updateStPro(Student student);//插入学生密保
	
	public boolean updateThPro(Teacher teacher);//插入老师密保
	
	public boolean updatePrice(Teacher teacher);//更新课程价格
}
