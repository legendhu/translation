package com.xinguan.shasha.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.xinguan.shasha.dao.jdbc.IUpFileDao;
import com.xinguan.shasha.domain.UpFile;
import com.xinguan.shasha.web.util.JdbcUtil;
import com.xinguan.shasha.domain.Page;

public class UpFileDaoImpl implements IUpFileDao {

	
	public void save(UpFile upfile) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String	sql = "insert into file(name,realname,filepath,description,date) values (?,?,?,?,?)";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, upfile.getName());
			st.setString(2,upfile.getRealname());
			st.setString(3,upfile.getFilepath());
			st.setString(4, upfile.getDescription());
			st.setDate(5,new java.sql.Date(upfile.getDate().getTime()));
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(conn, st, rs);
		   }	
	}
	
	public int selectCount() {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		int total = 0;
		String sql = "select count(*) from file ";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				total = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return total;
		}finally{
			JdbcUtil.release(conn, st, rs);
		}	
		return total;
	}


	//��ѯ�����ļ�
	public List findAll() {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		List list = null;
		String sql= "select * from file order by date desc";
		try{
			conn = JdbcUtil.getConnection();
			list = new ArrayList();
			st = conn.prepareStatement(sql);//Ԥ����SQL���
			rs = st.executeQuery();
			while(rs.next()) { 		
				int id = rs.getInt("id");
				String realname = rs.getString("realname");
				String filepath = rs.getString("filepath");
				Date date = rs.getDate("date");
				String description  = rs.getString("description");
				UpFile upfile = new UpFile();
				upfile.setId(id);
				upfile.setRealname(realname);
				upfile.setFilepath(filepath);
				upfile.setDate(date);
				upfile.setDescription(description);
				list.add(upfile);
			}
			}catch(SQLException e){
				e.printStackTrace();
				return list;
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		return list;
	}

	
	public UpFile find(int id) {
		Connection conn=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			conn = JdbcUtil.getConnection();
			String sql = "select * from file where id="+id;
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				UpFile upfile = new UpFile();
				upfile.setId(id);
				upfile.setName(rs.getString("name"));
				upfile.setRealname(rs.getString("realname"));
				upfile.setFilepath(rs.getString("filepath"));
				upfile.setDate(rs.getDate("date"));
				upfile.setDescription(rs.getString("description"));	
				return upfile;
			}
			
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(conn, st, rs);
		}
		
		return null;
	}


	public void delete(int id) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "delete from file where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			JdbcUtil.release(conn, st, rs);
		}	
		
	}

	
	public int getTotalRecord() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try{
			conn  = JdbcUtil.getConnection();
			String sql = "select count(*) from file";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				return rs.getInt(1);//�����1ָ����count(*)����ֶ�
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(conn, st, rs);
		}
		return 0;
	}

	
	public List getPageUpFile(int startindex, int pagesize) {
		Connection conn=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		
		try{
			conn = JdbcUtil.getConnection();
			String sql = "select * from file order by date desc limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1,startindex);
			st.setInt(2,pagesize);
			rs = st.executeQuery();
			while(rs.next()){
				UpFile upfile = new UpFile();
				upfile.setId(rs.getInt("id"));
				upfile.setRealname(rs.getString("realname"));
				upfile.setFilepath(rs.getString("filepath"));
				upfile.setDate(rs.getDate("date"));
				upfile.setDescription(rs.getString("description"));	
				list.add(upfile);
			}
			
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(conn, st, rs);
		}
		return list;
		
	}

	
	

	
}
