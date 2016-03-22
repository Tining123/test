package com.Control;

import java.util.ArrayList;

import com.Module.PostModule;

public class PostCtrl extends Ctrl{
	String post_id;
	String page;
	String bar_id;	//贴吧id
	ArrayList<String> BarInfo;//贴吧信息表
	ArrayList<String> FirstFloor;//一楼信息
	ArrayList<String> FloorInfo;//回帖表
	public PostCtrl(String post_id,String page,String poster,String teacher){
		this.page = page;
		this.post_id = post_id;
		bar_id = PostModule.getBarID(post_id);
		BarInfo = PostModule.getBarInfo(bar_id);//获取贴吧信息
		
		//获取一楼
		FirstFloor = PostModule.getFirstInfo(post_id);
		//获取10层楼
		int pageNum = Integer.parseInt(page);
		FloorInfo = PostModule.getFloorInfo(post_id,((pageNum-1)*10) + "",((pageNum-1)*10+9)+ "");
		
		//若楼主设置不空，取楼主
		if(poster != null){
			FloorInfo = PostModule.getPoster(post_id,((pageNum-1)*10) + "",((pageNum-1)*10+9)+ "", this.getFirstUserId());
		}
		//若楼主设置为空且老师设置不为空
		else if(teacher != null){
			FloorInfo = PostModule.getTeacher(post_id,((pageNum-1)*10) + "",((pageNum-1)*10+9)+ "");
		}
	}
	//获取用户ID
	public String getUserID1(String name){
		return PostModule.getUserID(name);
	}
	//获得帖子id
	public String getPostId(){
		return this.post_id;
	}
	//获得贴吧表表内相关信息
	public String OutBarInfo(){
			String postString = "";
			
			postString += BarInfo.get(1);//贴吧名字
			postString += BarInfo.get(2);//贴吧创建时间
			postString += BarInfo.get(3);//贴吧头像
			
			return postString;
	}
	
	//获取10层楼信息
	public String OutFloorInfo(){
		String postString = "";
		for(int i = 0 ;i < FloorInfo.size(); i += 4){
			postString += (Integer.parseInt(page)-1)*10+1;
			postString += NewLine();
			postString += FloorInfo.get(i+1);
			postString += NewLine();
			postString += FloorInfo.get(i+2);
			postString += NewLine();
			postString += MakeATips("user?id=1&page=1&user_id="+ FloorInfo.get(i+3)
					, PostModule.getUserName(FloorInfo.get(i+3)));
		}
		return postString;
	}
	
/////////////////////////
//最终输出区
/////////////////////////
	//获取帖子所在贴吧名字
	public String getBarname(){
		return BarInfo.get(1);
	}
	
	//获取帖子所在贴吧id
	public String getBarId(){
		return bar_id;
	}
	
	//获取帖子一楼内容
	public String getFirstFloorMsg(){
		return FirstFloor.get(2);
	}
	
	//获取获取帖子名字
	public String getFirstName(){
		return this.FirstFloor.get(1);
	}
	
	//获取贴吧日期
	public String getFirstDate(){
		return this.FirstFloor.get(3);
	}
	
	//获取楼主id
	public String getFirstUserId(){
		return this.FirstFloor.get(0);
	}
	
	//获取楼主名
	public String getFirstUserName(){
		return PostModule.getUserName(getFirstUserId());
	}
	//获取层主数
	public int getFloorNum(){
		return this.FloorInfo.size()/4;
	}
	//获取层主id
	public String getFloorUserId(int index){
		return this.FloorInfo.get(index*4+3);
	}
	//获取层主名
	public String getFloorUserName(int index){
		return PostModule.getUserName(this.getFloorUserId(index));
	}
	//获取层内容
	public String getFloorMsg(int index){
		return this.FloorInfo.get(index*4+2);
	}
	//获取层日期
	public String getFloorDate(int index){
		return this.FloorInfo.get(index*4+1);
	}
	//查询某人是不是老师
	public boolean checkTeacher(String user_id){
		String get = PostModule.checkTeacher(user_id);
		try{
			if( get == null || !get.equals("1"))
				return false;
			else return true;
		}catch(Exception e){
			return false;
		}
	}
}
