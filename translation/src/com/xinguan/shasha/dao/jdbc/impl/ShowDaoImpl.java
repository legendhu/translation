package com.xinguan.shasha.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xinguan.shasha.dao.jdbc.IShowDao;
import com.xinguan.shasha.domain.Page;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;
import com.xinguan.shasha.web.util.JdbcUtil;

public class ShowDaoImpl implements IShowDao {
	//��ѯһ��������ߵ���ʦ
	public Teacher selectThFirst(){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		Teacher teacher = null;
		String sql = "select * from teacher order by score desc limit 0,1"; 
		try{
			teacher = new Teacher();
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) { 		
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				teacher.setSex(rs.getString("sex"));
				teacher.setTel(rs.getString("tel"));
				teacher.setScore(rs.getInt("score"));
				teacher.setBank(rs.getString("bank"));
				teacher.setPhoto(rs.getString("photo"));
				teacher.setAnswer(rs.getString("answer"));
				teacher.setEmail(rs.getString("email"));
				teacher.setBanknum(rs.getString("banknum"));
				teacher.setLanguage(rs.getString("language"));
				teacher.setBirthday(rs.getDate("birthday"));
				teacher.setCollege(rs.getString("college"));
				teacher.setUsername(rs.getString("username"));
				teacher.setView_photo(rs.getString("view_photo"));
				teacher.setPrice(rs.getString("price"));
				teacher.setEducation(rs.getString("education"));
				teacher.setProtection(rs.getString("protection"));
				teacher.setIntroduction(rs.getString("introduction"));
			}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		return teacher;
	}
	
	//��ѯע����ʦ����
	public int selectThCount() {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		int count = 0;
		String sql= "select count(*) as rowCount  from teacher";
		try{
			conn = JdbcUtil.getConnection();	
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
				while(rs.next()){
					count = rs.getInt("rowCount");
				}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		return count;
	}
	
	//����usernameɾ��һ����ʦ
	public boolean deleteTh(String username){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql01 = "delete from teacher where username=?";
		String sql02 = "delete from user where username=?";
		try{
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//���Զ��ύ���� 
			st = conn.prepareStatement(sql01);
			st.setString(1, username);
			st.executeUpdate();
			
			st = conn.prepareStatement(sql02);
			st.setString(1, username);
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
	
	//����һ����ʦ����(��̨)
	public boolean updateTh(Teacher teacher){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "update teacher set name=?,tel=?,bank=?,banknum=?,score=?,introduction=? where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, teacher.getName());
			st.setString(2, teacher.getTel());
			st.setString(3, teacher.getBank());
			st.setString(4, teacher.getBanknum());
			st.setInt(5, teacher.getScore());
			st.setString(6, teacher.getIntroduction());
			st.setInt(7, teacher.getId());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		}	
		return true;
	}
	
	//����username��ѯĳ����ʦ��Ϣ
	public Teacher selectTh(String username) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		Teacher teacher = null;
		String sql = "select * from teacher where username=? "; 
		try{
			teacher = new Teacher();
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			while(rs.next()) { 	
				if(username.equals(rs.getString("username"))){
					teacher.setId(rs.getInt("id"));
					teacher.setName(rs.getString("name"));
					teacher.setSex(rs.getString("sex"));
					teacher.setTel(rs.getString("tel"));
					teacher.setScore(rs.getInt("score"));
					teacher.setBank(rs.getString("bank"));
					teacher.setPhoto(rs.getString("photo"));
					teacher.setAnswer(rs.getString("answer"));
					teacher.setEmail(rs.getString("email"));
					teacher.setBanknum(rs.getString("banknum"));
					teacher.setLanguage(rs.getString("language"));
					teacher.setBirthday(rs.getDate("birthday"));
					teacher.setCollege(rs.getString("college"));
					teacher.setUsername(rs.getString("username"));
					teacher.setView_photo(rs.getString("view_photo"));
					teacher.setPrice(rs.getString("price"));
					teacher.setEducation(rs.getString("education"));
					teacher.setProtection(rs.getString("protection"));
					teacher.setIntroduction(rs.getString("introduction"));
				}
			}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		return teacher;
	}
	//��ҳչʾ��ʦ��Ϣ
	public List<Teacher> selectAllTh(Page page) {
			Connection conn = null;
			PreparedStatement st = null;	
			ResultSet rs = null;
			List<Teacher> list = null;
			String sql= "select * from teacher order by score desc limit ?,?"; 
			try{
				conn = JdbcUtil.getConnection();
				list = new ArrayList<Teacher>();
				st = conn.prepareStatement(sql);//Ԥ����SQL���
				st.setInt(1,page.getStart());
				st.setInt(2,page.getShowCount());
				rs = st.executeQuery();
				
				while(rs.next()) { 			//���в�ѯ	
					Teacher teacher = new Teacher();
					teacher.setId(rs.getInt("id"));teacher.setName(rs.getString("name"));teacher.setPhoto(rs.getString("photo"));
					teacher.setCollege(rs.getString("college"));teacher.setUsername(rs.getString("username"));teacher.setSex(rs.getString("sex"));
					teacher.setLanguage(rs.getString("language"));teacher.setEducation(rs.getString("education"));
					teacher.setEmail(rs.getString("email"));teacher.setTel(rs.getString("tel"));teacher.setScore(rs.getInt("score"));
					teacher.setBank(rs.getString("bank"));teacher.setBanknum(rs.getString("banknum"));
					list.add(teacher);
				}
				}catch(SQLException e){
					e.printStackTrace();		
				}finally{
					JdbcUtil.release(conn, st, rs);
					}
			return list;
	}
	
	//����username��ѯĳ����ʦ��������Ϣ
	public List<Teacher> selectAds(Teacher teacher){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		List<Teacher> list = null;
		String sql = "select * from ads where thusername=? order by ads_date desc limit 0,4";
		try{
			list = new ArrayList<Teacher>();
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, teacher.getUsername());
			rs = st.executeQuery();
			while(rs.next()) { 	
				Teacher _teacher = new Teacher();
				_teacher.setUsername(teacher.getUsername());
			    _teacher.setContent(rs.getString("content"));
				_teacher.setAds_date(rs.getDate("ads_date"));
				list.add(_teacher);
			}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		return list;
	}
	//��ѯ����״̬����
	public int selectAdsCount(){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		int count = 0;
		String sql= "select count(*) as rowCount from ads";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				count = rs.getInt("rowCount");
				}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		return count;
	}
	
	//��ҳ��ѯ����״̬
	public List<Teacher> selectAllAds(Page page) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		List<Teacher> list = null;
		String sql ="select * from ads order by ads_date desc limit ?,?";
		try{
			conn = JdbcUtil.getConnection();
			list = new ArrayList<Teacher>();
			st = conn.prepareStatement(sql);
			st.setInt(1, page.getStart());
			st.setInt(2, page.getShowCount());
			rs = st.executeQuery();
			while(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setUsername(rs.getString("thusername"));
				teacher.setContent(rs.getString("content"));
				teacher.setAds_date(Date.valueOf(rs.getString("ads_date")));
				list.add(teacher);
			}
		}catch(SQLException e){
			e.printStackTrace();		
		}finally{
			JdbcUtil.release(conn, st, rs);
			}
		return list;
	}
	//ɾ��һ��״̬
	public boolean deleteAds(int id) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "delete from ads where id=?";
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

	//----------------------ѧ������-------------------------
	//��ѯע��ѧ������
	public int selectStCount() {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		int count = 0;
		String sql= "select count(*) as rowCount from student";
		try{
			conn = JdbcUtil.getConnection();
			
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				count = rs.getInt("rowCount");
				}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		return count;
	}
	//����usernameɾ��һ��ѧ��
	public boolean deleteSt(String username) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql01 = "delete from student where username=?";
		String sql02 = "delete from user where username=?";
		try{
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//���Զ��ύ���� 
			st = conn.prepareStatement(sql01);
			st.setString(1, username);
			st.executeUpdate();
			
			st = conn.prepareStatement(sql02);
			st.setString(1, username);
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
	
	//��ѯһ��ѧ����������Ϣ
	public Student selectSt(String username) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		Student student = null;
		String sql = "select * from student where username=? "; 
		try{
			student = new Student();
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			while(rs.next()) { 		
				if(username.equals(rs.getString("username"))){
					student.setId(rs.getInt("id"));
					student.setUsername(rs.getString("username"));
					student.setEmail(rs.getString("email"));
					student.setName(rs.getString("name"));
					student.setPhoto(rs.getString("photo"));
					student.setAnswer(rs.getString("answer"));
					student.setProtection(rs.getString("protection"));
					student.setTel(rs.getString("tel"));
					student.setView_photo(rs.getString("view_photo"));
				}
			}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		return student;
	}
	//����һ��ѧ����������Ϣ
	public boolean updateSt(Student student) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "update student set name=?,tel=?,email=? where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, student.getName());
			st.setString(2, student.getTel());
			st.setString(3, student.getEmail());
			st.setInt(4, student.getId());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		}	
		return true;
	}
	//��ѯ����ѧ����Ϣ ,��ע��ʱ��Ϊ˳��
	public List<Student> selectAllSt(Page page) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		List<Student> list = null;
		String sql= "select * from student order by register_date desc limit ?,?"; 
		try{
			conn = JdbcUtil.getConnection();
			list = new ArrayList<Student>();
			st = conn.prepareStatement(sql);//Ԥ����SQL���
			st.setInt(1,page.getStart());
			st.setInt(2,page.getShowCount());
			rs = st.executeQuery();
			
			while(rs.next()) { 			//���в�ѯ	
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setUsername(rs.getString("username"));
				student.setSex(rs.getString("sex"));
				student.setEmail(rs.getString("email"));
				student.setTel(rs.getString("tel"));
				student.setName(rs.getString("name"));
				student.setRegister_date(rs.getDate("register_date"));
				list.add(student);
			}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
		return list;
	}


}
