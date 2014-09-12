package com.xinguan.shasha.dao.jdbc.impl;
//注册Dao
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.xinguan.shasha.dao.jdbc.IRegisterDao;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;
import com.xinguan.shasha.web.util.JdbcUtil;

public class RegisterDaoImpl implements IRegisterDao{
		//老师注册
		public  boolean insert(Teacher teacher){
			Connection conn = null;
			PreparedStatement st = null;	
			ResultSet rs = null;	
			String sql01 ="insert into user(type,username,password)values(?,?,?)";
			String sql02 ="insert into teacher(type,username,password,sex,college,education,language,tel,email,birthday,introduction,register_date)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			try{
				conn = JdbcUtil.getConnection();
				conn.setAutoCommit(false);//不自动提交事务 
				//插入user表
				st = conn.prepareStatement(sql01);//预编译SQL语句
				st.setString(1,"1");
				st.setString(2,teacher.getUsername());
				st.setString(3,teacher.getPassword());
				st.executeUpdate();
				
				//插入teacher_register表
				st = conn.prepareStatement(sql02);//预编译SQL语句
				st.setString(1,"1");
				st.setString(2,teacher.getUsername());
				st.setString(3,teacher.getPassword());
				st.setString(4,teacher.getSex());
				st.setString(5,teacher.getCollege());
				st.setString(6,teacher.getEducation());
				st.setString(7,teacher.getLanguage());
				st.setString(8,teacher.getTel());
				st.setString(9,teacher.getEmail());
				st.setDate(10,teacher.getBirthday());
				st.setString(11, teacher.getIntroduction());
				st.setDate(12,new Date(System.currentTimeMillis()));//获取当前系统时间
				st.executeUpdate();
	
				conn.commit();//提交事务
	
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
		
		//学生注册
		public boolean insert(Student student){
			Connection conn = null;
			PreparedStatement st = null;	
			ResultSet rs = null;
			String	sql01 ="insert into user(type,username,password)values(?,?,?)";
			String	sql02 ="insert into student(type,username,password,tel,email,register_date)values(?,?,?,?,?,?)";
		try{
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//不自动提交事务 
			//插入user表
			st = conn.prepareStatement(sql01);//预编译SQL语句
			st.setString(1,"0");
			st.setString(2,student.getUsername());
			st.setString(3,student.getPassword());
			st.executeUpdate();
			
			//插入student_register表
			st = conn.prepareStatement(sql02);//预编译SQL语句
			st.setString(1,"0");
			st.setString(2,student.getUsername());
			st.setString(3,student.getPassword());
			st.setString(4,student.getTel());
			st.setString(5,student.getEmail());
			st.setDate(6,new Date(System.currentTimeMillis()));//获取当前系统时间
			st.executeUpdate();
			
			conn.commit();//提交事务
			
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
}


