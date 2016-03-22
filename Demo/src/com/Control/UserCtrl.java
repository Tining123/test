package com.Control;

import java.util.ArrayList;

import com.Module.BarModule;
import com.Module.UserModule;

public class UserCtrl extends Ctrl{
	String id;
	String user_id;
	String UserInfo;
	ArrayList<String> StarUser;
	ArrayList<String> FansUser;
	ArrayList<String> StarBar;
	ArrayList<String> Post;
	ArrayList<String> Reply;
	ArrayList<String> Msg;
	
	
	public UserCtrl(String user_name,String user_id){
		this.id = UserModule.getUserID(user_name);
		this.user_id = user_id;
		UserInfo = UserModule.getUserInfo(user_id);
	    StarUser = UserModule.getStarUser(user_id);
	    FansUser = UserModule.getFansUser(user_id);
	    StarBar = UserModule.getStarBar(user_id);
	    Post = UserModule.getPost(user_id);
	    Reply = UserModule.getReply(user_id);
	    Msg = UserModule.getMsg(user_id);
	    System.out.println(StarBar);
	}
	//��ȡ��ĳ�����ɵ�ǩ����
	public String getSignNum(String bar_id){
		return UserModule.getSignNum(user_id, bar_id);
	}
	//��ȡĳ��id
	public String getUserId(String user_name){
		return UserModule.getUserID(user_name);
	}
	//��ȡ��ע��
	public String OutStartUser(){
		String backString = "";
		for(int i =0 ;i< StarUser.size();i ++){
			backString += MakeATips("star_id?&page=1id=1&name=" + StarUser.get(i) ,UserModule.getUserName(StarUser.get(i)));
			backString += NewLine();
		//����ע������
		}
		return backString;
	}
	
	//��ȡ��˿
	public String OutFansUser(){
		String backString = "";
		for(int i =0 ;i< FansUser.size();i ++){
			backString += MakeATips("fans?id=1&page=1&name=" + FansUser.get(i) ,UserModule.getUserName(FansUser.get(i)));
			backString += NewLine();
	       //��˿����
		}
		return backString;
	}
	
	//��ȡ��ע����
	public String OutStarBar(){
		String backString = "";
		for(int i =0 ;i< StarBar.size();i ++){
			//out.print(StarBar.get(i));����id
			backString += MakeATips("bar?id=1&page=1&name=" + StarBar.get(i) ,StarBar.get(i+1));
			backString += NewLine();
            //��������
		}
		return backString;
	}
	
	//�������
	public String OutPost(){
		String backString = "";
		for(int i =0 ;i< Post.size(); i += 5){
			//�������ӣ���ʾ��������
			backString += MakeATips("post?post_id=" + Post.get(i+1) + "&page=1", Post.get(i));
			backString += NewLine();
			//�������ݣ���ʾ�������ݣ�
			backString += Post.get(i+2);
			backString += NewLine();
			//��������
			String bar_name = UserModule.getBarName(Post.get(i+3));
			backString+= MakeATips("bar?name=" + bar_name + "&page=1", bar_name);
			backString += NewLine();
			//����ʱ��
			backString+=Post.get(i+4);
			backString += NewLine();
			backString += NewLine();
		}
		return backString;
	}	
	public String NewLine(){
		return "<br/>";
	}
	
	/*******************************
	 * ���������
	 */
	
	//��ȡ�û���
	public String getUserName(){
		return UserModule.getUserName(user_id);
	}
	
	//��ȡĳһ�û���
	public String getUserName1(String user_id){
		return UserModule.getUserName(user_id);
	}
	
	//��ȡ������Ŀ
	public int getBarNum(){
		return this.StarBar.size()/2;
	}
	
	//��ȡ��������
	public String getBarName(int index){
		return this.StarBar.get(index*2+1);
	}
	
	//��ȡ��ע����Ŀ
	public int getStarNum(){
		return this.StarUser.size();
	}
	
	//��ȡ��ע������
	public String getStarName(int index){
		return UserModule.getUserName(this.StarUser.get(index));
	}
	
	//��ȡ��ע��id
	public String getStarId(int index){
		return this.StarUser.get(index);
	}
	
	//��ȡ��˿��Ŀ
	public int getFansNum(){
		return this.FansUser.size();
	}
	
	//��ȡ��˿����
	public String getFansName(int index){
		return UserModule.getUserName(this.FansUser.get(index));
	}
	
	//��ȡ��˿id
	public String getFansId(int index){
		return this.FansUser.get(index);
	}
	
	//��ȡ������
	public int getPostNum(){
		return this.Post.size()/5;
	}
	
	//��ȡ����id
	public String getBarId(int index){
		if(index*5+2 > this.Post.size())
			return "";
		return this.Post.get(index*5+2);
	}
	
	//��ȡ��������
	public String getMyBarName(int index){
		return this.Post.get(index*5+3);
	}
	
	//��ȡ����id
	public String getPostId(int index){
		return this.Post.get(index*5);
	}
	
	//��ȡ������
	public String getPostName(int index){
		return this.Post.get(index*5+1);
	}
	
	//��ȡ�ظ���
	public String getReplyNum(String post_id){
		return UserModule.getReplyNum(post_id);
	}
	
	//��ȡ��������
	public String getPostDate(int index){
		return this.Post.get(index*5+4);
	}
	
	//��ȡ��������
	public int getReplyNum(){
		return this.Reply.size()/6;
	}
	
	//��ȡ������id
	public String getReplyBarId(int index){
		return this.Reply.get(index*6+2);
	}
	//��ȡ��������
	public String getReplyBarName(int index){
		return this.Reply.get(index*6+3);
	}
	//��ȡ����id
	public String getReplyId(int index){
		return this.Reply.get(index*6);
	}
	//��ȡ������Ϣ
	public String getReplyMsg(int index){
		return this.Reply.get(index*6+1);
	}
	//��ȡ������������
	public String getReplyReplyNum(int index){
		return UserModule.getReplyNum(this.Reply.get(index*5+5));
	}
	//��ȡ��������
	public String getReplyDate(int index){
		return this.Reply.get(index*6+4);
	}
	
	//��ȡ��Ϣ����
	public int getMsgNum(){
		return this.Msg.size()/6;
	}
	//��ȡ��Ϣid
	public String getMsgId(int index){
		return this.Msg.get(index*6);
	}
	//��ȡ��Ϣ����
	public String getMsgMsg(int index){
		return this.Msg.get(index*6+1);
	}
	//��ȡ������Ϣ
	public String getMsgAdd(int index){
		return this.Msg.get(index*6+2);
	}
	//��ȡ��Ϣ����
	public String getMsgType(int index){
		return this.Msg.get(index*6+3);
	}
	//��ȡ������id
	public String getMsgSenderId(int index){
		return this.Msg.get(index*6+4);
	}
	//��ȡ��������
	public String getSenderName(int index){
		return UserModule.getUserInfo(this.getMsgSenderId(index));
	}
	//��ȡ��Ϣʱ��
	public String getMsgDate(int index){
		return this.Msg.get(index*6+5);
	}
	//����Ƿ��Ѿ���עĳ��
	public boolean checkStarUser(String my_id){
		try{
			if(UserModule.checkStarUser(my_id, this.user_id).equals("1"))
				return true;
			else return false;
		}catch(Exception e){
			return false;
		}
	}
	//��ȡĳһ����������
	public String getBarName1(String bar_id){
		return BarModule.getBarName1(bar_id);
	}
}