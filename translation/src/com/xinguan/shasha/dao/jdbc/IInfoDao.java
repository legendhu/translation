package com.xinguan.shasha.dao.jdbc;


import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;
import com.xinguan.shasha.domain.User;

public interface IInfoDao {
	
	public boolean updateSt(Student student);//����username����ѧ����Ϣ(ǰ̨)
	
	public boolean updateTh(Teacher teacher);//����username������ʦ��Ϣ(ǰ̨)
	
	public boolean insert(Teacher teacher);//����ads��������ʦ������Ϣ
	
	public boolean update(User user);//�����û�����
	
	public boolean updateStPro(Student student);//����ѧ���ܱ�
	
	public boolean updateThPro(Teacher teacher);//������ʦ�ܱ�
	
	public boolean updatePrice(Teacher teacher);//���¿γ̼۸�
}
