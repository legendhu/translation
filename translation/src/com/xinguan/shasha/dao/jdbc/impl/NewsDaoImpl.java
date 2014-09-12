package com.xinguan.shasha.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xinguan.shasha.dao.jdbc.INewsDao;
import com.xinguan.shasha.domain.News;
import com.xinguan.shasha.domain.Page;
import com.xinguan.shasha.web.util.JdbcUtil;

public class NewsDaoImpl implements INewsDao {
	
	//插入新新闻
	public boolean insert(News news){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "insert into news(title,date,content) values(?,?,?)";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, news.getTitle());
			st.setDate(2, news.getDate());
			st.setString(3, news.getContent());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		}	
		return true;
	}
	//根据Id删除新闻
	public boolean delete(News news){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "delete from news where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, news.getId());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		}	
		return true;
	}
	
	//根据Id更改新闻
	public boolean update(News news){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		String sql = "update news set title=?,content=?,date=? where id=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, news.getTitle());
			st.setString(2, news.getContent());
			st.setDate(3, news.getDate());
			st.setInt(4, news.getId());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.release(conn, st, rs);
		}	
		return true;
	}
	
	//根据Id查询单条新闻相关信息
	public News selectInfo(int id){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		News news = null;
		String sql = "select * from news where id=?";
		String sqlnext = "select * from news where id>? order by date asc limit 0,1";
		String sqllast = "select * from news where id<? order by date desc limit 0,1";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1,id);
			rs = st.executeQuery();
			news = new News();
			while(rs.next()){
				news.setId(id);
				news.setTitle(rs.getString("title"));
				news.setDate(rs.getDate("date"));
				news.setContent(rs.getString("content"));
			}
			
			st = conn.prepareStatement(sqlnext);
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()){
				news.setNext(rs.getInt("id"));
			}
			
			st = conn.prepareStatement(sqllast);
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()){
				news.setLast(rs.getInt("id"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			return news;
		}finally{
			JdbcUtil.release(conn, st, rs);
		}	
		return news;
	}
	//查询新闻总数
	public int selectCount(){
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		int total = 0;
		String sql = "select count(*) from news ";
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
	
	//分页展示新闻数据
	public List<News> selectAll(Page page) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		List<News> list = null;
		String sql= "select * from news order by date desc limit ?,?";
		try{
			conn = JdbcUtil.getConnection();
			list = new ArrayList<News>();
			st = conn.prepareStatement(sql);//预编译SQL语句
			st.setInt(1, page.getStart());
			st.setInt(2, page.getShowCount());
			rs = st.executeQuery();
			while(rs.next()) { 		
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date date = rs.getDate("date");
				News news = new News();
				news.setId(id);
				news.setTitle(title);
				news.setContent(content);
				news.setDate(date);
				list.add(news);
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
