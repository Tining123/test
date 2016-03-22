package com.Module;

import java.util.ArrayList;

import com.DB.DBCore;

public class PostModule {
	
	//���������������id
	public static String getBarID(String post_id){
		String sql = "select bar_id from post where post_id = " + post_id;
		return DBCore.singleSelect(sql, "bar_id", "int");
	}
	
	//������ɱ���������Ϣ
	public static ArrayList<String> getBarInfo(String bar_id){
		String sql = "select user_id,topic,bar_name,create_time,bar_head from bar where bar_id = '" + bar_id + "'";
		ArrayList<String> get = new ArrayList<String>();
		get.add("user_id");
		get.add("int");
		get.add("bar_name");
		get.add("String");
		get.add("create_time");
		get.add("date");
		get.add("bar_head");
		get.add("int");
		return DBCore.multiSelect(sql, get);
	}
	
	//��ȡ10��¥��Ϣ
	public static ArrayList<String> getFloorInfo(String post_id,String begin,String end){
		//��װ
		begin = "0";
		end = "100000";
		
		String sql = "select reply_id,reply_date,reply_msg,user_id from reply where post_id = '" + post_id + "' LIMIT " + begin + "," + end;
		ArrayList<String> get = new ArrayList<String>();
		get.add("reply_id");
		get.add("int");
		get.add("reply_date");
		get.add("date");
		get.add("reply_msg");
		get.add("String");
		get.add("user_id");
		get.add("int");
		return DBCore.multiSelect(sql, get);
	}
	
	//��ȡ�û���
		public static String getUserName(String user_id){
			String sql = "Select user_name from user"
					+ " where user_id = "+user_id ;
			return DBCore.singleSelect(sql,"user_name","String");
		}
		
	//��ȡ����һ¥��Ϣ
	public static ArrayList<String> getFirstInfo(String post_id){
		String sql = "select user_id,post_name,post_msg,post_date from post where post_id = '" + post_id + "'";
		ArrayList<String> get = new ArrayList<String>();
		get.add("user_id");
		get.add("int");
		get.add("post_name");
		get.add("String");
		get.add("post_msg");
		get.add("String");
		get.add("post_date");
		get.add("String");
		return DBCore.multiSelect(sql, get);	
	}
	//����û�ID
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "user_id", "int");
		return back;
	}
	//����Ƿ�����ʦ
	public static String checkTeacher(String user_id){
		String sql = "select exist from user where user_id = '" + user_id + "' and is_teacher = 1";
		return DBCore.singleSelect(sql, "exist", "int");
	}
	
	//��ȡֻ��¥������Ϣ
	public static ArrayList<String> getPoster(String post_id,String begin,String end,String poster_id){
		String sql = "select reply_id,reply_date,reply_msg,user_id from reply where post_id = '" + post_id + "' and user_id = '" + poster_id + "' LIMIT " + begin + "," + end;
		ArrayList<String> get = new ArrayList<String>();
		get.add("reply_id");
		get.add("int");
		get.add("reply_date");
		get.add("date");
		get.add("reply_msg");
		get.add("String");
		get.add("user_id");
		get.add("int");
		return DBCore.multiSelect(sql, get);
	}
	//��ȡ��ʦ�Ļ�����Ϣ
	public static ArrayList<String> getTeacher(String post_id,String begin,String end){
		String sql = "select reply_id,reply_date,reply_msg,reply.user_id from "
				+ "reply LEFT JOIN `user` on `user`.user_id = reply.user_id where is_teacher = 1 and post_id = '" + post_id + "' LIMIT " + begin + "," + end;
		ArrayList<String> get = new ArrayList<String>();
		get.add("reply_id");
		get.add("int");
		get.add("reply_date");
		get.add("date");
		get.add("reply_msg");
		get.add("String");
		get.add("user_id");
		get.add("int");
		return DBCore.multiSelect(sql, get);
	}
}
