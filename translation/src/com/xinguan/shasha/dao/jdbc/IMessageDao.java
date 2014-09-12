package com.xinguan.shasha.dao.jdbc;

import java.util.List;
import com.xinguan.shasha.domain.Message;
import com.xinguan.shasha.domain.Page;

public interface IMessageDao {
	
	public int selectCount();//查询学生留言信息总数
	
	public boolean insertMessage(Message message);//存储学生留言信息
	
	public List<Message> selectAll(Page page);//分页：查询所有留言信息
	
	public boolean deleteMessage(int id);//根据id删除一条学生留言信息
	
}
