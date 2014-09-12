package com.xinguan.shasha.dao.jdbc;

import java.util.List;
import com.xinguan.shasha.domain.Page;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;

public interface IShowDao {
	
	public Teacher selectThFirst();//��ѯһ��������ߵ���ʦ
	
	public int selectThCount();//��ѯע����ʦ����
	
	public boolean deleteTh(String username);//����idɾ��һ����ʦ
	
	public boolean updateTh(Teacher teacher);//����һ����ʦ����
	
	public Teacher selectTh(String username);//����username��ѯĳ����ʦ��Ϣ
	
	public List<Teacher> selectAllTh(Page page);//��ҳ��ѯ������ʦ��Ϣ
	
	public List<Teacher> selectAds(Teacher teacher);//����username��ѯĳ����ʦ��������Ϣ
	
	public List<Teacher> selectAllAds(Page page);//��ѯ������ʦ������������Ϣ����ʱ������
	
	public int selectAdsCount();//��ѯ����״̬����
	
	public boolean deleteAds(int id);//ɾ��ĳ����������Ϣ 
	
	
	
	
	public int selectStCount();//��ѯע��ѧ������
	
	public boolean deleteSt(String username);//����idɾ��һ��ѧ��
	
	public Student selectSt(String username);//��ѯһ��ѧ����������Ϣ
	
	public boolean updateSt(Student student);//����һ��ѧ����������Ϣ
	
	public List<Student> selectAllSt(Page page);//��ѯ����ѧ����Ϣ ,��ע��ʱ��Ϊ˳��
	
}
