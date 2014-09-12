package com.xinguan.shasha.web.util;
//数据库连接池
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtil {
	//定义一个datasource数据源
	private static DataSource datasource = null ;
	//static模块在类被调用过程中只执行一次
	static{							
		try {
			//类加载器方法读取.properties的配置文件,文件必须要在classpath所指向的类目录下
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties p = new Properties();
			p.load(in); 			
			BasicDataSourceFactory factory = new BasicDataSourceFactory();						
			datasource = factory.createDataSource(p);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
	}
}
	//从连接池里获取一个连接
	public static Connection getConnection()throws SQLException {
	
			Connection  conn = datasource.getConnection();	
			return conn;    
}
	//释放链接、定义、结果的方法
	public static  void release(Connection conn,PreparedStatement st ,ResultSet rs){ 				
			try {
				if (conn!=null)//链接不为空		
				conn.close();		//close()方法释放链接回连接池
			} catch (SQLException e) {
				e.printStackTrace();
				conn = null;
			}
		
			
			try {
				if (st!=null)
				st.close();		
				} catch (SQLException e) {
					e.printStackTrace();
					st = null;
				}
		
					
			try {
				if (rs!=null)
				rs.close();		
				} catch (SQLException e) {
				e.printStackTrace();
					rs = null;
				}
	}		
}

