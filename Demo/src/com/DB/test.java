package com.DB;

import java.util.Properties;

import junit.framework.Test;

public class test {

	static DBHelper instance = null;
	
	public static void main(String[] args) {
		if(instance == null){
			System.out.println("asd");
			instance = new DBHelper();
			Properties p = new Properties();
			try{
				p.load(Test.class.getClassLoader().getResourceAsStream("config.properties"));
				System.out.println("asd");
				String driver = (String) p.get("driver");
				Class.forName(driver);
				System.out.println("asd");
			}catch(Exception e){
				e.printStackTrace(); 
			} 
		}
		
		DBHelper dbh = new DBHelper();
		
		while(true){
			
		}
	}
}
