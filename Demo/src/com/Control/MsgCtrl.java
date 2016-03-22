package com.Control;

import com.Module.MsgModule;;

public class MsgCtrl {
	String user_id;
	public MsgCtrl(String user_id){
		this.user_id = user_id;
	}
	
	//获取和我对话的人名字
	public String getUserName(){
		return MsgModule.getUserName(user_id);
	}
	
	//获取和我对话的人对我说的话
	public String getMsg(String Msg_id){
		return MsgModule.getMsg(Msg_id);
	}
	
	//获取用户id
	public String getUserId(String user_name){
		return MsgModule.getUserID(user_name);
	}
}
