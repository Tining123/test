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
	//获取对某个贴吧的签到数
	public String getSignNum(String bar_id){
		return UserModule.getSignNum(user_id, bar_id);
	}
	//获取某人id
	public String getUserId(String user_name){
		return UserModule.getUserID(user_name);
	}
	//获取关注人
	public String OutStartUser(){
		String backString = "";
		for(int i =0 ;i< StarUser.size();i ++){
			backString += MakeATips("star_id?&page=1id=1&name=" + StarUser.get(i) ,UserModule.getUserName(StarUser.get(i)));
			backString += NewLine();
		//被关注人链接
		}
		return backString;
	}
	
	//获取粉丝
	public String OutFansUser(){
		String backString = "";
		for(int i =0 ;i< FansUser.size();i ++){
			backString += MakeATips("fans?id=1&page=1&name=" + FansUser.get(i) ,UserModule.getUserName(FansUser.get(i)));
			backString += NewLine();
	       //粉丝链接
		}
		return backString;
	}
	
	//获取关注贴吧
	public String OutStarBar(){
		String backString = "";
		for(int i =0 ;i< StarBar.size();i ++){
			//out.print(StarBar.get(i));贴吧id
			backString += MakeATips("bar?id=1&page=1&name=" + StarBar.get(i) ,StarBar.get(i+1));
			backString += NewLine();
            //贴吧链接
		}
		return backString;
	}
	
	//输出发帖
	public String OutPost(){
		String backString = "";
		for(int i =0 ;i< Post.size(); i += 5){
			//发帖链接（显示帖子名）
			backString += MakeATips("post?post_id=" + Post.get(i+1) + "&page=1", Post.get(i));
			backString += NewLine();
			//发帖内容（显示帖子内容）
			backString += Post.get(i+2);
			backString += NewLine();
			//贴吧链接
			String bar_name = UserModule.getBarName(Post.get(i+3));
			backString+= MakeATips("bar?name=" + bar_name + "&page=1", bar_name);
			backString += NewLine();
			//发帖时间
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
	 * 最终输出区
	 */
	
	//获取用户名
	public String getUserName(){
		return UserModule.getUserName(user_id);
	}
	
	//获取某一用户名
	public String getUserName1(String user_id){
		return UserModule.getUserName(user_id);
	}
	
	//获取贴吧数目
	public int getBarNum(){
		return this.StarBar.size()/2;
	}
	
	//获取贴吧名字
	public String getBarName(int index){
		return this.StarBar.get(index*2+1);
	}
	
	//获取关注人数目
	public int getStarNum(){
		return this.StarUser.size();
	}
	
	//获取关注人名字
	public String getStarName(int index){
		return UserModule.getUserName(this.StarUser.get(index));
	}
	
	//获取关注人id
	public String getStarId(int index){
		return this.StarUser.get(index);
	}
	
	//获取粉丝数目
	public int getFansNum(){
		return this.FansUser.size();
	}
	
	//获取粉丝名字
	public String getFansName(int index){
		return UserModule.getUserName(this.FansUser.get(index));
	}
	
	//获取粉丝id
	public String getFansId(int index){
		return this.FansUser.get(index);
	}
	
	//获取贴子数
	public int getPostNum(){
		return this.Post.size()/5;
	}
	
	//获取贴吧id
	public String getBarId(int index){
		if(index*5+2 > this.Post.size())
			return "";
		return this.Post.get(index*5+2);
	}
	
	//获取贴吧名字
	public String getMyBarName(int index){
		return this.Post.get(index*5+3);
	}
	
	//获取帖子id
	public String getPostId(int index){
		return this.Post.get(index*5);
	}
	
	//获取帖子名
	public String getPostName(int index){
		return this.Post.get(index*5+1);
	}
	
	//获取回复数
	public String getReplyNum(String post_id){
		return UserModule.getReplyNum(post_id);
	}
	
	//获取发帖日期
	public String getPostDate(int index){
		return this.Post.get(index*5+4);
	}
	
	//获取回帖数量
	public int getReplyNum(){
		return this.Reply.size()/6;
	}
	
	//获取回帖吧id
	public String getReplyBarId(int index){
		return this.Reply.get(index*6+2);
	}
	//获取回帖吧名
	public String getReplyBarName(int index){
		return this.Reply.get(index*6+3);
	}
	//获取回帖id
	public String getReplyId(int index){
		return this.Reply.get(index*6);
	}
	//获取回帖消息
	public String getReplyMsg(int index){
		return this.Reply.get(index*6+1);
	}
	//获取回帖回帖数量
	public String getReplyReplyNum(int index){
		return UserModule.getReplyNum(this.Reply.get(index*5+5));
	}
	//获取回帖日期
	public String getReplyDate(int index){
		return this.Reply.get(index*6+4);
	}
	
	//获取消息数量
	public int getMsgNum(){
		return this.Msg.size()/6;
	}
	//获取消息id
	public String getMsgId(int index){
		return this.Msg.get(index*6);
	}
	//获取消息内容
	public String getMsgMsg(int index){
		return this.Msg.get(index*6+1);
	}
	//获取附加消息
	public String getMsgAdd(int index){
		return this.Msg.get(index*6+2);
	}
	//获取消息类型
	public String getMsgType(int index){
		return this.Msg.get(index*6+3);
	}
	//获取发信人id
	public String getMsgSenderId(int index){
		return this.Msg.get(index*6+4);
	}
	//获取发信人名
	public String getSenderName(int index){
		return UserModule.getUserInfo(this.getMsgSenderId(index));
	}
	//获取消息时间
	public String getMsgDate(int index){
		return this.Msg.get(index*6+5);
	}
	//检查是否已经关注某人
	public boolean checkStarUser(String my_id){
		try{
			if(UserModule.checkStarUser(my_id, this.user_id).equals("1"))
				return true;
			else return false;
		}catch(Exception e){
			return false;
		}
	}
	//获取某一个贴吧名字
	public String getBarName1(String bar_id){
		return BarModule.getBarName1(bar_id);
	}
}