package com.Module;

import com.DB.DBCore;;

public class SearchModule {
	
	//检测贴吧是否存在
	public static int checkBar(String name){
		String sql = "select exist from bar where bar_name = '" + name + "'";
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
