package com.xinguan.shasha.dao.jdbc;

import java.util.List;

import com.xinguan.shasha.domain.UpFile;

public interface IUpFileDao {
	public void save(UpFile upfile);//�ϴ��ļ�
	
	public int selectCount();//��ѯ�����ļ�������
	
	@SuppressWarnings("rawtypes")
	public List findAll();//��ѯ�����ļ�
	
	public UpFile find(int id);//������ֲ�ѯĳ���ļ�
	
	public void delete(int id);//ɾ��ĳ���ļ�
	
	public int getTotalRecord();//����ܼ�¼��
	
	@SuppressWarnings("rawtypes")
	public List getPageUpFile(int startindex,int pagesize);	//��ҳչʾ
}
