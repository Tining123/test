package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import junit.framework.Test;

public class DBHelper implements IDBHelper{
	
	static DBHelper instance = null;
	
	static{
		//加载驱动，读取properties文件
		if(instance == null){
			instance = new DBHelper();
			Properties p = new Properties();
			try{
				p.load(test.class.getClassLoader().getResourceAsStream("config.properties"));
				String driver = (String) p.get("driver");
				Class.forName(driver);
			}catch(Exception e){
				e.printStackTrace(); 
			} 
		}
		
	}
	
	@Override
	public Connection getConnection(){
		Connection conn = null;
		Properties p = new Properties();
		try{
			p.load(test.class.getClassLoader().getResourceAsStream("config.properties"));
			String url = p.getProperty("url").trim();
			String password = p.getProperty("password").trim();
			String username = p.getProperty("username").trim();
			conn = DriverManager.getConnection(url,username,password);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return conn;
	}
	
	@Override
	public void closeConnection(Connection on){
		try {
			on.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
