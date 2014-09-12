package com.xinguan.shasha.dao.jdbc.impl;
//图片上传相关dao
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xinguan.shasha.dao.jdbc.IImageDao;
import com.xinguan.shasha.domain.Advert;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;
import com.xinguan.shasha.web.util.JdbcUtil;

public class ImageDaoImpl implements IImageDao{
	//查找所有广告信息
	public List<Advert> selectAll(){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String	sql = "select * from advert";
		List<Advert> list = null;
		try{
			list = new ArrayList<Advert>();
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				Advert advert = new Advert();
				advert.setId(rs.getInt("id"));
				advert.setFileName(rs.getString("filename"));
				advert.setFilePath(rs.getString("filepath"));
				advert.setUrl(rs.getString("url"));
				list.add(advert);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(conn, st, rs);
		   }
		return list;
	}
	
	//根据Id查找对应的文件路径
	public String select(int id){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String	sql = "select * from advert where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()){
				String filePath = rs.getString("filepath");
				return filePath;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(conn, st, rs);
		   }
		return null;
	}
	//上传广告
	public boolean updateAd(Advert advert){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String	sql = "Update advert Set filepath=?,filename=?,url=? Where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, advert.getFilePath());
			st.setString(2,advert.getFileName());
			st.setString(3,advert.getUrl());
			st.setInt(4, advert.getId());
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		   }
		return true;
	}
	//学生头像预览
	public boolean updateStView(Student student){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String	sql =  "Update Student Set view_photo=? Where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, student.getView_photo());
			st.setInt(2,student.getId());
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		   }
		return true;
	}
	//学生头像上传
	public boolean updateSt(Student student){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String	sql =  "Update Student Set photo=? Where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, student.getPhoto());
			st.setInt(2,student.getId());
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		   }
		return true;
	}
	//老师头像预览
	public boolean updateThView(Teacher teacher){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String	sql = "Update teacher Set view_photo=? Where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, teacher.getView_photo());
			st.setInt(2,teacher.getId());
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		   }
		return true;
	}

	//老师头像上传
	public boolean updateTh(Teacher teacher){
			Connection conn = null;
			PreparedStatement st = null;	
			ResultSet rs = null;
			String	sql = "Update teacher Set photo=? Where id=?";
			try{
				conn = JdbcUtil.getConnection();
				st = conn.prepareStatement(sql);
				st.setString(1, teacher.getPhoto());
				st.setInt(2,teacher.getId());
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
