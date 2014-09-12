package com.xinguan.shasha.dao.jdbc.impl;
//登陆信息与数据库信息比对
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.xinguan.shasha.dao.jdbc.IAuthDao;
import com.xinguan.shasha.domain.User;
import com.xinguan.shasha.web.util.JdbcUtil;

public class AuthDaoImpl implements IAuthDao {
		
		//根据username查询type类型
		public String selectType(String username){
			Connection conn = null;
			PreparedStatement st = null;	
			ResultSet rs = null;	
			String type = null;
			String sql = "select * from user where username=?";
			try{
				conn = JdbcUtil.getConnection();
				st = conn.prepareStatement(sql);
				st.setString(1, username);
				rs = st.executeQuery();
				while(rs.next()) { 	
					if(username.equals(rs.getString("username"))){
						type = rs.getString("type");
					}
				}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.release(conn, st, rs);
				}
			return type;
		}
		//用户名比对
		public boolean judge(String username){
			Connection conn = null;
			PreparedStatement st = null;	
			ResultSet rs = null;
			String sql = "select * from user ";
				try {
					conn = JdbcUtil.getConnection();
					st = conn.prepareStatement(sql);
					rs = st.executeQuery();
					while(rs.next()) { 			
						if(username.equals(rs.getString("username"))){
							return false;
						}
					}
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
					JdbcUtil.release(conn, st, rs);
					}
				return true;
		}
		//用户名密码比对
		public int select(User user){
			Connection conn = null;
			PreparedStatement st = null;	
			ResultSet rs = null;	
			String sql= "select * from user "; 
			try{
				conn = JdbcUtil.getConnection();
				st = conn.prepareStatement(sql);//预编译SQL语句
				rs = st.executeQuery();
				
				while(rs.next()) { 			//逐行查询
					String type= rs.getString("type");
					String username = rs.getString("username");
					String pass= rs.getString("password");
					if(user.getUsername().equals(username)){
						if(user.getPassword().equals(pass)){
							if(type.equals("1")){
								int code=3;
								return code;
							}else{
								int code=4;
								return code;
							}
						}else{
							int code=2;
							return code;	
						}
					}
				}
				}catch(SQLException e){
					e.printStackTrace();		
				}finally{
					JdbcUtil.release(conn, st, rs);
					}
					int code=1;
					return code;
			}
			}
