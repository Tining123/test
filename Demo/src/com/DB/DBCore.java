package com.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBCore {
	//执行插入或删除
	public static boolean Execute(String sql) {
		DBHelper dbh = new DBHelper();
		Connection conn = dbh.getConnection();
		boolean rs = false;
		try{
			Statement stmt = conn.createStatement();
			rs = stmt.execute(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace(); 
		}
		dbh.closeConnection(conn);
		return rs;
	}
	
	//执行插入或删除并返回修改id
		public static int Execute(String sql,int protect) {
			DBHelper dbh = new DBHelper();
			Connection conn = dbh.getConnection();
			int rs = protect;
			try{
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
				rs = stmt.executeQuery("Select LASTE_INSERT_ID").getInt(0);
				stmt.close();
			}catch(Exception e){
				e.printStackTrace(); 
			}
			dbh.closeConnection(conn);
			return rs;
		} 
	
	//执行复杂简单查询
		public static ArrayList<String> multiSelect(String sql,ArrayList<String> get){
			DBHelper dbh = new DBHelper();
			Connection conn = dbh.getConnection();
			ResultSet rs  = null;
			Statement stmt = null;
			
			ArrayList<String> back = new ArrayList<String>();
			try{
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					for(int i =0 ;i <= get.size()-2;i += 2){
						if(get.get(i+1) == "String"){
							back.add(rs.getString(get.get(i)));
						}else if(get.get(i+1) == "date"){
							back.add(rs.getDate(get.get(i)).toString());
						}else if(get.get(i+1) == "int"){
							back.add(rs.getInt(get.get(i)) + "");
						}
					}
				}
				
			}catch(Exception e){
				e.printStackTrace(); 
			}
			
			dbh.closeConnection(conn);
			return back;
		}
	
	//执行简单查询s
	public static String singleSelect(String sql,String element,String type){
		DBHelper dbh = new DBHelper();
		Connection conn = dbh.getConnection();
		ResultSet rs  = null;
		String result = null;
		try{
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				if(rs.getRow() == 0)
					result = null;
				if(type == "String"){
					result = rs.getString(element);
				}else if(type == "date"){
					result = rs.getDate(element).toString();
				}else if(type == "int"){
					result = rs.getInt(element) + "";
				}
			}
			stmt.close();
		}catch(Exception e){
			e.printStackTrace(); 
		}
		dbh.closeConnection(conn);
		return result;
	}
	
	//执行更改
	public static int Update(String sql){
		DBHelper dbh = new DBHelper();
		Connection conn = dbh.getConnection();
		int rs = 0;
		try{
			Statement stmt = conn.createStatement();
			rs = stmt.executeUpdate(sql);
			stmt.close();
		}catch(Exception e){
			e.printStackTrace(); 
		}
		dbh.closeConnection(conn);
		return rs;
	}
}
