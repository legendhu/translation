package com.xinguan.shasha.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xinguan.shasha.dao.jdbc.IFaqDao;
import com.xinguan.shasha.domain.Faq;
import com.xinguan.shasha.web.util.JdbcUtil;

public class FaqDaoImpl implements IFaqDao {
	//����һ��faq
	public boolean insert(Faq faq){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "insert into faq(question,answer) values(?,?)";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, faq.getTitle());
			st.setString(2, faq.getContent());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
			}
		
		return true;
	}
	
	//����Idɾ��һ��faq
	public boolean delete(int id){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "delete from faq where id=?";
		
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
			}
		return true;
	}
	
	//����Id����һ��faq
	public boolean update(Faq faq){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "update faq set question=?,answer=? where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, faq.getTitle());
			st.setString(2, faq.getContent());
			st.setInt(3, faq.getId());
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
			}
		return true;
	}
	
	//����Id��ѯһ��faq
	public Faq select(int id){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		Faq faq = null;
		String sql = "select * from faq where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1,id);
			rs = st.executeQuery();
			while(rs.next()){
				faq = new Faq();
				faq.setId(id);
				faq.setTitle(rs.getString("question"));
				faq.setContent(rs.getString("answer"));
			}
		}catch(SQLException e){
			e.printStackTrace();
			return faq;
		}finally{
			JdbcUtil.release(conn, st, rs);
			}
		return faq;
	}
	//��ѯ����faq
	public List<Faq> find(){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		List<Faq> list = null;
		try{
			conn = JdbcUtil.getConnection();
			list = new ArrayList<Faq>();
			String sql= "select * from faq "; 
			st = conn.prepareStatement(sql);//Ԥ����SQL���
			rs = st.executeQuery();
			while(rs.next()) { 			//���в�ѯ
				int id = rs.getInt("id");
				String question= rs.getString("question");
				String answer= rs.getString("answer");
				
			
				Faq faq0 = new Faq();
				faq0.setId(id);
				faq0.setTitle(question);
				faq0.setContent(answer);
				list.add(faq0);
			}
			}catch(SQLException e){
				e.printStackTrace();
				return list;
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		return list;
	}
	

}
