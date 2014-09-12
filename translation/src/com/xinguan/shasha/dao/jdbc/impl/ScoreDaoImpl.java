package com.xinguan.shasha.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.xinguan.shasha.dao.jdbc.IScoreDao;
import com.xinguan.shasha.domain.Score;
import com.xinguan.shasha.domain.Teacher;
import com.xinguan.shasha.web.util.JdbcUtil;

public class ScoreDaoImpl implements IScoreDao {
	
	public int select(Teacher teacher) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from teacher where username=?";
			st = conn.prepareStatement(sql);//预编译SQL语句
			st.setString(1, teacher.getUsername());
			rs = st.executeQuery();
		while(rs.next()) { 			//逐行查询
			int score= rs.getInt("score");
			return score;
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		JdbcUtil.release(conn, st, rs);
	}
	return 0;
}

	public boolean select(Score score) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		boolean bl = true;
		try {
			
			conn = JdbcUtil.getConnection();
			String sql = "select studentusername from score where teacherusername=?"; 
			st = conn.prepareStatement(sql);
			st.setString(1, score.getTeacherusername());
			rs = st.executeQuery();
			while(rs.next()){
				//一样不能点赞  
				//没查到可以点赞
				//查到了可以点赞
			  	bl = !score.getStudentusername().equals(rs.getString("studentusername"));
			  	if(bl==false){
			  		return bl;//false不能点赞
			  	}
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;//false不能点赞
		}finally{
			JdbcUtil.release(conn, st, rs);
		}
		return bl;//true 可以点赞
	}

	public boolean updateUser(Teacher teacher, Score score) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		String sql00 = "update teacher set score=? where username=?";
		String sql01 = "insert into score(teacherusername,studentusername) values(?,?)";
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(sql00);
			st.setInt(1, teacher.getScore());
			st.setString(2, teacher.getUsername());
			st.executeUpdate();
			
			st = conn.prepareStatement(sql01);
			st.setString(1, score.getTeacherusername());
			st.setString(2, score.getStudentusername());
			st.executeUpdate();
			
			conn.commit();
			
		}catch(SQLException e){
			try {
				conn.rollback();
				conn.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		}
		return true;
	}

	public boolean updateAdmin(Teacher teacher) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "update teacher set score=? where username=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, teacher.getScore());
			st.setString(2, teacher.getUsername());
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