package com.xinguan.shasha.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.xinguan.shasha.dao.jdbc.IAdminDao;
import com.xinguan.shasha.domain.Admin;
import com.xinguan.shasha.web.util.JdbcUtil;

public class AdminDaoImpl implements IAdminDao {

	public boolean select(Admin admin) {//比对管理员用户名和密码
			Connection conn = null;
			PreparedStatement st = null;	
			ResultSet rs = null;	
			String sql= "select * from admin "; 
			try{
				conn = JdbcUtil.getConnection();
				st = conn.prepareStatement(sql);
				rs = st.executeQuery();
				
				while(rs.next()) {
					String username = rs.getString("username");
					String pass= rs.getString("password");
					if(admin.getUsername().equals(username)){
						if(admin.getPassword().equals(pass)){
							return true;
						}
					}
				}
				}catch(SQLException e){
					e.printStackTrace();	
					return false;
				}finally{
					JdbcUtil.release(conn, st, rs);
				}
		return false;
	}

	
	public boolean update(Admin admin) {//更改管理员用户名和密码
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		String sql= "update admin set username=?,password=? where id=1";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, admin.getUsername());
			st.setString(2, admin.getPassword());
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();	
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		}
		return true;
	}

}
