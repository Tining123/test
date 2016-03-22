package com.Module;

import java.util.ArrayList;

import com.DB.DBCore;

public class PostingModule {
	//登记帖子
	public static void posting(String bar_id,String user_id,String post_name,String post_msg){
		
		String sql = "insert into post(last_date,bar_id,user_id,post_name,post_msg,post_date) "
				+ "values(now()," + bar_id + ","+user_id+",'"+post_name+"','"+post_msg+"',now())";
		DBCore.Execute(sql);		
		return;
	}
	
	//检测用户id是否合法
	public static int checkID(String user_id){
		String sql = "select exist from user where user_id = '" + user_id + "'";
		String back = DBCore.singleSelect(sql, "exist", "int");
		if(back == null)
			return 0;
		else return Integer.parseInt(back);
	}
	
	//检测贴吧id是否合法
	public static int checkBar(String bar_id){
		String sql = "select exist from bar where bar_id = '" + bar_id + "'";
		String back = DBCore.singleSelect(sql, "exist", "int");
		if(back == null)
			return 0;
		else return Integer.parseInt(back);
	}
	
	//获得用户ID
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "user_id", "int");
		return back;
	}
}
