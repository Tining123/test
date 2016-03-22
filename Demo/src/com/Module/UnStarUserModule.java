package com.Module;

import com.DB.DBCore;

public class UnStarUserModule {
	//取关用户
	public static void UnStarBar(String user_id,String star_id){
		String sql = "delete from star_user where star_id = '" + star_id + "' and user_id = '" + user_id + "'";
		DBCore.Execute(sql);
	}
	//获得用户ID
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "user_id", "int");
		return back;
	}
}
