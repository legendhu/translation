package com.xinguan.shasha.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xinguan.shasha.dao.jdbc.IMessageDao;
import com.xinguan.shasha.domain.Message;
import com.xinguan.shasha.domain.Page;
import com.xinguan.shasha.web.util.JdbcUtil;

public class MessageDaoImpl implements IMessageDao {
	//根据id删除一条学生留言信息
	public boolean deleteMessage(int id) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		String sql="delete from message where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1,id);
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
			}
		return true;
	}
	//存储学生留言信息
	public boolean insertMessage(Message message) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql="insert into message(stusername,thusername,thname,banknum,content,date) values(?,?,?,?,?,?)";
		try{ 
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			if(message.getStusername()!=null&&message.getBanknum()!=null){
				st.setString(1, message.getStusername());
				st.setString(4, message.getBanknum());
			}else{
				st.setString(1, "无");
				st.setString(4, "无");
			}
			st.setString(2, message.getThusername());
			st.setString(3, message.getThname());
			st.setString(5, message.getContent());
			st.setDate(6, new Date(System.currentTimeMillis()));
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
			}
		return true;
	}
	
	//分页：查询所有留言信息
	public List<Message> selectAll(Page page) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		List<Message> list = null;
		String sql= "select * from message order by date desc limit ?,?";
		try{
			list = new ArrayList<Message>();
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, page.getStart());
			st.setInt(2, page.getShowCount());
			rs = st.executeQuery();
			while(rs.next()) { 	
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setThusername(rs.getString("thusername"));
				message.setStusername(rs.getString("stusername"));
				message.setBanknum(rs.getString("banknum"));
				message.setThname(rs.getString("thname"));
				message.setContent(rs.getString("content"));
				list.add(message);
			}
		}catch(SQLException e){
			e.printStackTrace();	
			return list;
		}finally{
			JdbcUtil.release(conn, st, rs);
			}
		return list;
	}
	//查询学生留言信息总数
	public int selectCount() {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		int total = 0;
		String sql="select count(*) as count from message";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				 total = rs.getInt("count");
			}
		}catch(SQLException e){
			e.printStackTrace();		
		}finally{
			JdbcUtil.release(conn, st, rs);
			}
		return total;
	}

}
