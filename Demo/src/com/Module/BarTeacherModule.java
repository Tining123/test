package com.Module;

import com.DB.DBCore;

public class BarTeacherModule {
	//������ʦ
	public static void SetTeacher(String bar_id,String user_id){
		String sql = "insert into teacher(bar_id,user_id) VALUES('" + bar_id + "','" + user_id + "')";
		DBCore.Execute(sql);
	}
	
	//������ʦ
	public static void AskTeacher(String bar_id,String user_id){
		//��ȡ����id
		String sql = "select user_id from bar where bar_id = '" + bar_id + "'";
		String barer = DBCore.singleSelect(sql, "user_id", "int");
		
		sql = "insert into msg(msg,type,sender_id,reader_id,msg_date)"
			+ "VALUES('" + bar_id + "','2','" + user_id + "','" + barer + "',SYSDATE())";
		DBCore.Execute(sql);
	}
	
	//����û�ID
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "user_id", "int");
		return back;
	}
	
	//ɾ��������ʦ����Ϣ
	public static void DeleteAskTeacher(String msg_id){
		String sql = "delete from msg where msg_id = '" + msg_id + "'";
		DBCore.Execute(sql);
	}
}
