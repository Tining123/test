package com.Control;

import java.util.ArrayList;

import com.Module.BarModule;
import com.Module.SearchModule;

public class BarCtrl extends Ctrl{
	
	String page;
	String name;
	ArrayList<String> BarInfo = new ArrayList<String>();		//贴吧信息表
	ArrayList<String> TeacherInfo = new ArrayList<String>();	//老师信息表
	ArrayList<String> PostList = new ArrayList<String>();		//帖子列表
//////////////////////////
//动态输出区	
//////////////////////////
	//获取用户ID
	public String getUserID1(String name){
		return SearchModule.getUserID(name);
	}
	
	public BarCtrl(String name,String page){
		this.page = page;
		this.name = name;
		BarInfo = BarModule.getBarInfo(name);		//获取贴吧信息
		TeacherInfo = BarModule.getTeacherInfo(BarInfo.get(0));	//获取教师信息
		
		int pageNum = Integer.parseInt(page);
		PostList = BarModule.getPostList(BarInfo.get(0), 
				((pageNum-1)*10+1) + "", ((pageNum-1)*10+10) + "");//获取帖子列表
	}
	//检查吧名
	public boolean CheckBarName(){
		return BarModule.checkBar(name) != 1;
	}

	
/////////////////////////
//最终输出区
/////////////////////////
	//获取吧主id
	public String getBarOwnerId(){
		return BarInfo.get(1);
	}
	//获取吧主名字
	public String getBarOwnerName(){
		return getUserName(BarInfo.get(1));
	}
	//输出贴吧id
	public String getBarId(){
		return this.BarInfo.get(0);
	}
	//输出贴吧名
	public String getBarName(){
		return BarInfo.get(3);
	}
	
	//输出贴吧类型
	public String getBarType(){
		return BarInfo.get(2);
	}
	
	//输出帖子数量
	public int getPostNum(){
		return PostList.size()/7;
	}
	
	//输出帖子id
	public String getPostId(int index){
		return PostList.get(index*7);
	}
	
	//输出楼主id
	public String getPosterId(int index){
		return PostList.get(index*7+1);
	}
	
	//输出帖子名
	public String getPostName(int index){
		return PostList.get(index*7+2);
	}
	
	//输出帖子内容
	public String getPostMsg(int index){
		return PostList.get(index*7+3);
	}
	
	//获取发布时间
	public String getPostDate(int index){
		return PostList.get(index*7+4);
	}
	
	//获取最后回复时间
	public String getLastDate(int index){
		return PostList.get(index*7+5);
	}
	
	//获取最后发布人id
	public String getLastId(int index){
		return PostList.get(index*7+6);
	}
	
	//获得某人人名
	public String getUserName(String user_Id){
		return BarModule.getUserName(user_Id);
	}
	
	//获取用户ID
	public String getUserID(String name){
		return SearchModule.getUserID(name);
	}
	
	//检查某个用户是否关注该贴吧
	public boolean checkStarBar(String user_id){
		try{
			if(BarModule.checkStarBar(user_id, getBarId()).equals("1"))
				return true;
			else return false;
		}catch(Exception e) {return false;}
	}
	//检测是否已经签到
	public boolean checkSign(String user_id){
		try{
			if(BarModule.CheckSign(getBarId(),user_id).equals("1"))
				return true;
			else return false;
		}catch(Exception e) {return false;}
	}
	
	//检测某人是否是老师
	public boolean checkTeacher(String userName){
		try{
			String get = BarModule.checkTeacher(this.getUserID(userName));
			if(get.equals("1")){
				return true;
			}
			else return false;
		}catch(Exception e){
			return false;
		}
	}
	//获取老师数量
	public int getTeacherNum(){
		return TeacherInfo.size()/2;
	}
	//获取老师id
	public String getTeacherId(int index){
		return TeacherInfo.get(index*2);
	}
	//获取老师名字
	public String getTeacherName(int index){
		return TeacherInfo.get(index*2+1);
	}
	//获取某一个贴吧名字
	public String getBarName1(String bar_id){
		return BarModule.getBarName1(bar_id);
	}
	//检查某个人是否是一个吧的吧主
	public boolean checkBarTeacher(String bar_id,String user_id){
		try{
			if(BarModule.checkBarTeacher(user_id, bar_id).equals("1")){
				return true;
			}
			else return false;
		}catch(Exception e) {
			return false;
		}
	}
	//获取某个回帖人id
	public String getReplyer(String reply_id){
		return BarModule.getReplyer(reply_id);
	}
}










