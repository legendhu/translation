package com.xinguan.shasha.dao.jdbc;

import java.util.List;
import com.xinguan.shasha.domain.Page;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public interface IShowDao {
	
	public Teacher selectThFirst();//查询一个分数最高的老师
	
	public int selectThCount();//查询注册老师人数
	
	public boolean deleteTh(String username);//根据id删除一个老师
	
	public boolean updateTh(Teacher teacher);//更新一个老师数据
	
	public Teacher selectTh(String username);//根据username查询某个老师信息
	
	public List<Teacher> selectAllTh(Page page);//分页查询所有老师信息
	
	public List<Teacher> selectAds(Teacher teacher);//根据username查询某个老师发布的信息
	
	public List<Teacher> selectAllAds(Page page);//查询所有老师发布的所有信息，以时间排序
	
	public int selectAdsCount();//查询所有状态总数
	
	public boolean deleteAds(int id);//删除某条发布的信息 
	
	
	
	
	public int selectStCount();//查询注册学生人数
	
	public boolean deleteSt(String username);//根据id删除一个学生
	
	public Student selectSt(String username);//查询一个学生的所有信息
	
	public boolean updateSt(Student student);//更新一个学生的所有信息
	
	public List<Student> selectAllSt(Page page);//查询所有学生信息 ,以注册时间为顺序
	
}
