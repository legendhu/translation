package com.xinguan.shasha.dao.jdbc;

import com.xinguan.shasha.domain.Admin;

public interface IAdminDao {
	
	public boolean select(Admin admin);//�ȶԹ���Ա�û���������
	
	public boolean update(Admin admin);//���Ĺ���Ա�û���������
}
