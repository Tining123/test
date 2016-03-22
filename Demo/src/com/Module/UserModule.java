package com.Module;

import java.util.ArrayList;




import com.DB.DBCore;

public class UserModule {
	//获取个人资料
	public static String getUserInfo(String user_id){
		String sql = "select pic_id from user where user_id = " + user_id ;	
		return DBCore.singleSelect(sql,"pic_id","int");
	}
	//获得用户ID
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "user_id", "int");
		return back;
	}
	//获取所有关注人
	public static ArrayList<String> getStarUser(String user_id){
		String sql = "select star_id from star_user where user_id = " + user_id;
		ArrayList<String> get = new ArrayList<String>();
		get.add("star_id");
		get.add("int");
		return DBCore.multiSelect(sql, get);
	}
	
	//获取粉丝ID
	public static ArrayList<String> getFansUser(String user_id){
		String sql = "select user_id from star_user where star_id = " + user_id;
		ArrayList<String> get = new ArrayList<String>();
		get.add("user_id");
		get.add("int");
		return DBCore.multiSelect(sql, get);
	}

	//获取所有关注贴吧
	public static ArrayList<String> getStarBar(String user_id){
		String sql = "select star_bar.bar_id,bar_name from star_bar "
				+ "left join bar on star_bar.bar_id = bar.bar_id where star_bar.user_id = " + user_id+"";
		ArrayList<String> get = new ArrayList<String>();
		get.add("bar_id");
		get.add("int");
		get.add("bar_name");
		get.add("String");
		return DBCore.multiSelect(sql, get);
		
	}
	
	//获取所有发帖
	public static ArrayList<String> getPost(String user_id){
		String sql = "select post_id,post_name,post.bar_id,bar_name,post_date from " 
				+"post left join bar on post.bar_id = bar.bar_id "
				+"where post.user_id = '" + user_id + "'";
		ArrayList<String> get = new ArrayList<String>();
		get.add("post_id");
		get.add("int");
		get.add("post_name");
		get.add("String");
		get.add("bar_id");
		get.add("int");
		get.add("bar_name");
		get.add("String");
		get.add("post_date");
		get.add("date");
		return DBCore.multiSelect(sql, get);
	}
	
	//获取用户名
	public static String getUserName(String user_id){
		String sql = "Select user_name from user"
				+ " where user_id = "+user_id ;
		return DBCore.singleSelect(sql,"user_name","String");
	}
	
	//获取贴吧名
	public static String getBarName(String bar_id){
		String sql = "Select bar_name from bar"
				+ " where bar_id = "+bar_id ;
		return DBCore.singleSelect(sql,"bar_name","String");
	}
	
	//获取某贴回复数
	public static String getReplyNum(String post_id){
		String sql = "select count(reply_id) from reply where post_id = '" + post_id + "'";
		return DBCore.singleSelect(sql,"count(reply_id)","int");
	}
	
	//获取回帖信息
	public static ArrayList getReply(String user_id){
		String sql = "SELECT reply_id,reply_msg,reply.bar_id,bar_name,reply_date,post_id "
		+"from reply left join bar on reply.bar_id  = bar.bar_id "
		+"where reply.user_id = '" + user_id + "' ";
		ArrayList<String> get = new ArrayList<String>();
		get.add("reply_id");
		get.add("int");
		get.add("reply_msg");
		get.add("String");
		get.add("bar_id");
		get.add("int");
		get.add("bar_name");
		get.add("String");
		get.add("reply_date");
		get.add("date");
		get.add("post_id");
		get.add("String");
		return DBCore.multiSelect(sql, get);
	}
	
	//获取消息信息
	public static ArrayList getMsg(String user_id){
		String sql = "select msg_id,msg,add_msg,type,sender_id,msg_date from msg where reader_id = '" + user_id + "' order by msg_id DESC";
		ArrayList<String> get = new ArrayList<String>();
		get.add("msg_id");
		get.add("int");
		get.add("msg");
		get.add("String");
		get.add("add_msg");
		get.add("String");
		get.add("type");
		get.add("String");
		get.add("sender_id");
		get.add("int");
		get.add("msg_date");																																																																																																							
		get.add("date");
		return DBCore.multiSelect(sql, get);
	}
	
	//获取对一个贴吧的签到数
	public static String getSignNum(String user_id,String bar_id){
		String sql = "select sign_num from star_bar where user_id = '" + user_id + "' and bar_id = '" + bar_id + "'";
		return DBCore.singleSelect(sql, "sign_num", "int");
	}
	
	//查看某人是否已经关注某人
	//，user_id为你,star_id为他人
	public static String checkStarUser(String user_id,String star_id){
		String sql = "select exist from star_user where user_id = '" + user_id + "' and star_id = '" + star_id + "'";
		return DBCore.singleSelect(sql, "exist", "int");
	}
	
	//获取某个贴吧名字
	public static String getBarName1(String bar_id){
		String sql = "select bar_name from bar where bar_id = '" + bar_id + "'";
		return DBCore.singleSelect(sql, "bar_name", "String");
	}
}
