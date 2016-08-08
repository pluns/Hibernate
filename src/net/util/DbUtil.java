package net.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class DbUtil {
	public static ComboPooledDataSource dataSource;
	static {
		try{
			String jdbcUrl 		= "jdbc:mysql://localhost:3306/ecshop";
			String user 		= "root";
			String password 	= "";
			String driverClass 	= "com.mysql.jdbc.Driver";
			dataSource 			= new ComboPooledDataSource();
			dataSource.setJdbcUrl(jdbcUrl);
			dataSource.setUser(user);
			dataSource.setPassword(password);
			dataSource.setDriverClass(driverClass);
			dataSource.setInitialPoolSize(10);
			dataSource.setMinPoolSize(5);
			dataSource.setMaxPoolSize(50);
			dataSource.setMaxStatements(100);
			dataSource.setMaxIdleTime(60);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getPoolConnection(){
		Connection conn = null;
		if(dataSource != null){
			try{
				conn = dataSource.getConnection();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			String className = "com.mysql.jdbc.Driver";
			String url 		 = "jdbc:mysql://localhost:3306/ecshop";
			String user 	 = "root";
			String password  = "";
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
