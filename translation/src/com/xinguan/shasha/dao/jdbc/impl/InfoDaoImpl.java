package com.xinguan.shasha.dao.jdbc.impl;
//�������Ĺ������
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.xinguan.shasha.dao.jdbc.IInfoDao;
import com.xinguan.shasha.domain.Student;
import com.xinguan.shasha.domain.Teacher;
import com.xinguan.shasha.domain.User;
import com.xinguan.shasha.web.util.JdbcUtil;

public class InfoDaoImpl implements IInfoDao {
	//����username����ѧ����Ϣ(ǰ̨)
	public boolean updateSt(Student student){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "update student set name=?,email=?,tel=? where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, student.getName());
			st.setString(2, student.getEmail());
			st.setString(3, student.getTel());
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
	//����username������ʦ��Ϣ(ǰ̨)
	public boolean updateTh(Teacher teacher){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "update teacher set name=?,tel=?,bank=?,banknum=?,education=?,language=?,college=?,email=?,introduction=? where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, teacher.getName());
			st.setString(2, teacher.getTel());
			st.setString(3, teacher.getBank());
			st.setString(4, teacher.getBanknum());
			st.setString(5, teacher.getEducation());
			st.setString(6, teacher.getLanguage());
			st.setString(7, teacher.getCollege());
			st.setString(8, teacher.getEmail());
			st.setString(9, teacher.getIntroduction());
			st.setInt(10, teacher.getId());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		}	
		return true;
	}
	//����ads����ʦ������Ϣ
	public boolean insert(Teacher teacher){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		String sql = "insert into ads(thusername,content,ads_date) values(?,?,?)";
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, teacher.getUsername());
			st.setString(2, teacher.getContent());
			st.setDate(3, new Date(System.currentTimeMillis()));
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();	
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
	   }
		return true;
	}
	//�����û�����
	public boolean update(User user) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		String sql01 = "Update user Set password=? Where username=?";
		String sql02 = "Update teacher Set password=? Where username=?";
		String sql03 = "Update student Set password=? Where username=?";
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//���Զ��ύ���� 
			if("1".equals(user.getType())){
				//����user��
				st = conn.prepareStatement(sql01);
				st.setString(1, user.getPassword());
				st.setString(2, user.getUsername());
				st.executeUpdate();
				
				//����teacher��
				st = conn.prepareStatement(sql02);
				st.setString(1, user.getPassword());
				st.setString(2, user.getUsername());
				st.executeUpdate();	
			}
			if("0".equals(user.getType())){
				//����user��
				st = conn.prepareStatement(sql01);
				st.setString(1, user.getPassword());
				st.setString(2, user.getUsername());
				st.executeUpdate();	
				
				//����student��
				st = conn.prepareStatement(sql03);
				st.setString(1, user.getPassword());
				st.setString(2, user.getUsername());
				st.executeUpdate();
			}
			conn.commit();//�ύ����
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
	
	//����ѧ���ܱ�
	public boolean updateStPro(Student student){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		String sql =  "update student set protection=?,answer=? where username=?";
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, student.getProtection());
			st.setString(2, student.getAnswer());
			st.setString(3, student.getUsername());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();	
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
	   }
		return true;
	}
	//������ʦ�ܱ�
	public boolean updateThPro(Teacher teacher){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		String sql =  "update teacher set protection=?,answer=? where username=?";
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, teacher.getProtection());
			st.setString(2, teacher.getAnswer());
			st.setString(3, teacher.getUsername());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();	
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
	   }
		return true;
	}
	//���¿γ̼۸�
	public boolean updatePrice(Teacher teacher){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		String sql =  "update teacher set price=? where username=?";
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, teacher.getPrice());
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