package com.xinguan.shasha.dao.jdbc;

import java.util.List;
import com.xinguan.shasha.domain.Message;
import com.xinguan.shasha.domain.Page;

public interface IMessageDao {
	
	public int selectCount();//��ѯѧ��������Ϣ����
	
	public boolean insertMessage(Message message);//�洢ѧ��������Ϣ
	
	public List<Message> selectAll(Page page);//��ҳ����ѯ����������Ϣ
	
	public boolean deleteMessage(int id);//����idɾ��һ��ѧ��������Ϣ
	
}
