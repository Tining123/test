package com.Module;

import com.DB.DBCore;

public class StarUserModule {
	//关注贴吧
	public static void StarUser(String user_id,String star_id){
		String sql = "insert into star_user(user_id,star_id) VALUES('" + user_id + "','" + star_id + "')";
		DBCore.Execute(sql);
	}
	//获得用户ID
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "user_id", "int");
		return back;
	}
}
