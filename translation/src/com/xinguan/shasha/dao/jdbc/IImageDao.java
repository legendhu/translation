package com.xinguan.shasha.dao.jdbc;

import java.util.List;

import com.xinguan.shasha.domain.Advert;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public interface IImageDao {
	
	public List<Advert> selectAll();//查找所有广告信息
	
	public String select(int id);//根据Id查找对应的文件路径
	
	public boolean updateAd(Advert advert);//上传广告	
	
	public boolean updateStView(Student student);//学生头像预览
	
	public boolean updateSt(Student student);//学生头像上传
	
	public boolean updateThView(Teacher teacher);//老师头像预览
	
	public boolean updateTh(Teacher teacher);//插入teacher表，存储老师头像照片相对路径
}
