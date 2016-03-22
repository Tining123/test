package com.Module;

import com.DB.DBCore;

public class SignModule {
	//签到
	public static void Sign(String bar_id,String user_id){
		String sql = "update star_bar set sign_num = sign_num+1"
				+ " where bar_id = '" + bar_id + "' and user_id = '" + user_id + "'";
		DBCore.Execute(sql);
		sql = "update star_bar set sign_date = SYSDATE() "
				+ " where bar_id = '" + bar_id + "' and user_id = '" + user_id + "'";
		DBCore.Execute(sql);
	}
	//获得用户ID
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "user_id", "int");
		return back;
	}
}
