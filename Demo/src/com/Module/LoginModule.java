package com.Module;

import com.DB.DBCore;

public class LoginModule {
	public static int login(String name,String pass){
		String sql = "select exist from user where user_name = '" + name + "' and password = '" + pass + "'";
		String back = DBCore.singleSelect(sql, "exist", "int");
		if(back == null)
			return 0;
		else return Integer.parseInt(back);
	}
}
