package com.Module;
import com.DB.DBCore;;

public class RegisterModule {
	public static void register(String name,String pass,String mail,String pic){
		String sql = "insert into user(user_name,password,mail,register_date,pic_id) "
				+ "values('" + name + "','" + pass + "','" + mail + "',SYSDATE()," + pic + ")";
		DBCore.Execute(sql);
	}
	
	public static int checkRegister(String name){
		String sql = "select exist from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "exist", "int");
		if(back == null)
			return 0;
		else return Integer.parseInt(back);
	}
}
