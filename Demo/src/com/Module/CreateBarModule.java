package com.Module;

import com.DB.DBCore;;

public class CreateBarModule {
	//������������Ƿ��Ѿ�����
	public static int checkBar(String name){
		String sql = "select exist from bar where bar_name = '" + name + "'";
		String back = DBCore.singleSelect(sql, "exist", "int");
		if(back == null)
			return 0;
		else return Integer.parseInt(back);
	}
	
	//���id�Ƿ����
	public static int checkID(String id){
		String sql = "select exist from user where user_id = '" + id + "'";
		String back = DBCore.singleSelect(sql, "exist", "int");
		if(back == null)
			return 0;
		else return Integer.parseInt(back);
	}
	
	public static void createBar(String id,String topic,String name){
		String sql = "insert into bar(user_id,topic,bar_name,create_time) "
				+ "values('" + id + "','" + topic + "','" + name + "',SYSDATE())";
		DBCore.Execute(sql);
	}
}
