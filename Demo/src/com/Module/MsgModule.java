package com.Module;

import com.DB.DBCore;

public class MsgModule {
	//插入消息
	public static void Msg(String msg,String type,String sender_id,String reader_id){
		String sql = "INSERT into msg(msg,type,sender_id,reader_id,msg_date) "
				+ "VALUE('" + msg + "','" + type + "','" + sender_id + "','" + reader_id + "',SYSDATE());";
		DBCore.Execute(sql);
	}
	
	//获取用户名
	public static String getUserName(String user_id){
		String sql = "Select user_name from user"
				+ " where user_id = "+user_id ;
		return DBCore.singleSelect(sql,"user_name","String");
	}
	
	//获取用户Id
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		return DBCore.singleSelect(sql, "user_id", "int");
	}
	
	//获取某条对话内容
	public static String getMsg(String Msg_id){
		String sql = "select msg from msg where msg_id = '" + Msg_id + "'";
		return DBCore.singleSelect(sql, "msg", "String");
	}
}
