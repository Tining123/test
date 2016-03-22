package com.Control;

import java.util.ArrayList;

import com.Module.PostModule;

public class PostCtrl extends Ctrl{
	String post_id;
	String page;
	String bar_id;	//����id
	ArrayList<String> BarInfo;//������Ϣ��
	ArrayList<String> FirstFloor;//һ¥��Ϣ
	ArrayList<String> FloorInfo;//������
	public PostCtrl(String post_id,String page,String poster,String teacher){
		this.page = page;
		this.post_id = post_id;
		bar_id = PostModule.getBarID(post_id);
		BarInfo = PostModule.getBarInfo(bar_id);//��ȡ������Ϣ
		
		//��ȡһ¥
		FirstFloor = PostModule.getFirstInfo(post_id);
		//��ȡ10��¥
		int pageNum = Integer.parseInt(page);
		FloorInfo = PostModule.getFloorInfo(post_id,((pageNum-1)*10) + "",((pageNum-1)*10+9)+ "");
		
		//��¥�����ò��գ�ȡ¥��
		if(poster != null){
			FloorInfo = PostModule.getPoster(post_id,((pageNum-1)*10) + "",((pageNum-1)*10+9)+ "", this.getFirstUserId());
		}
		//��¥������Ϊ������ʦ���ò�Ϊ��
		else if(teacher != null){
			FloorInfo = PostModule.getTeacher(post_id,((pageNum-1)*10) + "",((pageNum-1)*10+9)+ "");
		}
	}
	//��ȡ�û�ID
	public String getUserID1(String name){
		return PostModule.getUserID(name);
	}
	//�������id
	public String getPostId(){
		return this.post_id;
	}
	//������ɱ���������Ϣ
	public String OutBarInfo(){
			String postString = "";
			
			postString += BarInfo.get(1);//��������
			postString += BarInfo.get(2);//���ɴ���ʱ��
			postString += BarInfo.get(3);//����ͷ��
			
			return postString;
	}
	
	//��ȡ10��¥��Ϣ
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
//���������
/////////////////////////
	//��ȡ����������������
	public String getBarname(){
		return BarInfo.get(1);
	}
	
	//��ȡ������������id
	public String getBarId(){
		return bar_id;
	}
	
	//��ȡ����һ¥����
	public String getFirstFloorMsg(){
		return FirstFloor.get(2);
	}
	
	//��ȡ��ȡ��������
	public String getFirstName(){
		return this.FirstFloor.get(1);
	}
	
	//��ȡ��������
	public String getFirstDate(){
		return this.FirstFloor.get(3);
	}
	
	//��ȡ¥��id
	public String getFirstUserId(){
		return this.FirstFloor.get(0);
	}
	
	//��ȡ¥����
	public String getFirstUserName(){
		return PostModule.getUserName(getFirstUserId());
	}
	//��ȡ������
	public int getFloorNum(){
		return this.FloorInfo.size()/4;
	}
	//��ȡ����id
	public String getFloorUserId(int index){
		return this.FloorInfo.get(index*4+3);
	}
	//��ȡ������
	public String getFloorUserName(int index){
		return PostModule.getUserName(this.getFloorUserId(index));
	}
	//��ȡ������
	public String getFloorMsg(int index){
		return this.FloorInfo.get(index*4+2);
	}
	//��ȡ������
	public String getFloorDate(int index){
		return this.FloorInfo.get(index*4+1);
	}
	//��ѯĳ���ǲ�����ʦ
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
