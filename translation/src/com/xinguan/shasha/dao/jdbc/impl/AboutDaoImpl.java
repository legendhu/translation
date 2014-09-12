package com.xinguan.shasha.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.xinguan.shasha.dao.jdbc.IAboutDao;
import com.xinguan.shasha.domain.About;
import com.xinguan.shasha.web.util.JdbcUtil;

public class AboutDaoImpl implements IAboutDao{
	
	//��ѯ�������ǵ���Ϣ
	public About select(){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		About as = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql= "select * from about"; 
			st = conn.prepareStatement(sql);//Ԥ����SQL���
			
			rs = st.executeQuery();
			
			while(rs.next()) { 			//���в�ѯ
				int id = rs.getInt("id");
				String title= rs.getString("title");
				Date date = rs.getDate("date");
				String content = rs.getString("content");
				as = new About();
				as.setId(id);
				as.setTitle(title);
				as.setDate(date);
				as.setContent(content);
			}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		
		return as;
	}
	//���¹������ǵ���Ϣ
	public boolean update(About about) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "update about set title=?,content=?,date=? where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, about.getTitle());
			st.setString(2, about.getContent());
			st.setDate(3, about.getDate());
			st.setInt(4, about.getId());
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
