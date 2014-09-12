package com.xinguan.shasha.web.util;
//���ݿ����ӳ�
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtil {
	//����һ��datasource����Դ
	private static DataSource datasource = null ;
	//staticģ�����౻���ù�����ִֻ��һ��
	static{							
		try {
			//�������������ȡ.properties�������ļ�,�ļ�����Ҫ��classpath��ָ�����Ŀ¼��
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties p = new Properties();
			p.load(in); 			
			BasicDataSourceFactory factory = new BasicDataSourceFactory();						
			datasource = factory.createDataSource(p);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
	}
}
	//�����ӳ����ȡһ������
	public static Connection getConnection()throws SQLException {
	
			Connection  conn = datasource.getConnection();	
			return conn;    
}
	//�ͷ����ӡ����塢����ķ���
	public static  void release(Connection conn,PreparedStatement st ,ResultSet rs){ 				
			try {
				if (conn!=null)//���Ӳ�Ϊ��		
				conn.close();		//close()�����ͷ����ӻ����ӳ�
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

