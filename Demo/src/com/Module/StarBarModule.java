package com.Module;

import com.DB.DBCore;

public class StarBarModule {
	//关注贴吧
	public static void StarBar(String user_id,String bar_id){
		String sql = "insert into star_bar(user_id,bar_id) VALUES('" + user_id + "','" + bar_id + "')";
		DBCore.Execute(sql);
	}
	//获得用户ID
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "user_id", "int");
		return back;
	}
}
