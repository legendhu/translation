package com.xinguan.shasha.dao.jdbc;

import java.util.List;

import com.xinguan.shasha.domain.Advert;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public interface IImageDao {
	
	public List<Advert> selectAll();//�������й����Ϣ
	
	public String select(int id);//����Id���Ҷ�Ӧ���ļ�·��
	
	public boolean updateAd(Advert advert);//�ϴ����	
	
	public boolean updateStView(Student student);//ѧ��ͷ��Ԥ��
	
	public boolean updateSt(Student student);//ѧ��ͷ���ϴ�
	
	public boolean updateThView(Teacher teacher);//��ʦͷ��Ԥ��
	
	public boolean updateTh(Teacher teacher);//����teacher���洢��ʦͷ����Ƭ���·��
}
