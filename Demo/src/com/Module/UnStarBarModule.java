package com.Module;

import com.DB.DBCore;

public class UnStarBarModule {
	//取关贴吧
	public static void UnStarBar(String bar_id,String user_id){
		String sql = "delete from star_bar where bar_id = '" + bar_id + "' and user_id = '" + user_id + "'";
		DBCore.Execute(sql);
	}
	//获得用户ID
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "user_id", "int");
		return back;
	}
}
