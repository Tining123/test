package com.Module;

import com.DB.DBCore;

public class ReplyModule {
	//����ظ���Ϣ
	public static void Reply(String bar_id,String post_id,String reply_msg,String user_id){
		String sql = "insert into reply(bar_id,post_id,reply_date,reply_msg,user_id)" 
				+ "VALUES('" + bar_id + "','" + post_id + "',now(),'" + reply_msg + "','" + user_id + "')";
		DBCore.Execute(sql);
		
		//��û���id
		sql = "select reply_id from reply where "
				+ "bar_id = '" + bar_id + "' and post_id = '" + post_id + "' and reply_msg = '" + reply_msg + "' and user_id = '" + user_id + "'";
		String reply_id = DBCore.singleSelect(sql, "reply_id", "int");
		
		//�޸����ظ�
		sql = "update post set last_reply = '" + reply_id + "' where post_id = '" + post_id + "'";
		DBCore.Execute(sql);
		
		//�޸����ظ�ʱ��
		sql = "update post set last_date = now() where post_id = '" + post_id + "'";
		DBCore.Execute(sql);
	}
	//����û�ID
	public static String getUserID(String name){
		String sql = "select user_id from user where user_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "user_id", "int");
		return back;
	}
}
