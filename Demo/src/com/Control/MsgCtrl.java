package com.Control;

import com.Module.MsgModule;;

public class MsgCtrl {
	String user_id;
	public MsgCtrl(String user_id){
		this.user_id = user_id;
	}
	
	//��ȡ���ҶԻ���������
	public String getUserName(){
		return MsgModule.getUserName(user_id);
	}
	
	//��ȡ���ҶԻ����˶���˵�Ļ�
	public String getMsg(String Msg_id){
		return MsgModule.getMsg(Msg_id);
	}
	
	//��ȡ�û�id
	public String getUserId(String user_name){
		return MsgModule.getUserID(user_name);
	}
}
