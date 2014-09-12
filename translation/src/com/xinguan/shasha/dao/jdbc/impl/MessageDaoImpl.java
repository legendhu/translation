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
	//����idɾ��һ��ѧ��������Ϣ
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
	//�洢ѧ��������Ϣ
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
				st.setString(1, "��");
				st.setString(4, "��");
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
	
	//��ҳ����ѯ����������Ϣ
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
	//��ѯѧ��������Ϣ����
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
