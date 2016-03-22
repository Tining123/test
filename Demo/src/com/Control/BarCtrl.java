package com.Control;

import java.util.ArrayList;

import com.Module.BarModule;
import com.Module.SearchModule;

public class BarCtrl extends Ctrl{
	
	String page;
	String name;
	ArrayList<String> BarInfo = new ArrayList<String>();		//������Ϣ��
	ArrayList<String> TeacherInfo = new ArrayList<String>();	//��ʦ��Ϣ��
	ArrayList<String> PostList = new ArrayList<String>();		//�����б�
//////////////////////////
//��̬�����	
//////////////////////////
	//��ȡ�û�ID
	public String getUserID1(String name){
		return SearchModule.getUserID(name);
	}
	
	public BarCtrl(String name,String page){
		this.page = page;
		this.name = name;
		BarInfo = BarModule.getBarInfo(name);		//��ȡ������Ϣ
		TeacherInfo = BarModule.getTeacherInfo(BarInfo.get(0));	//��ȡ��ʦ��Ϣ
		
		int pageNum = Integer.parseInt(page);
		PostList = BarModule.getPostList(BarInfo.get(0), 
				((pageNum-1)*10+1) + "", ((pageNum-1)*10+10) + "");//��ȡ�����б�
	}
	//������
	public boolean CheckBarName(){
		return BarModule.checkBar(name) != 1;
	}

	
/////////////////////////
//���������
/////////////////////////
	//��ȡ����id
	public String getBarOwnerId(){
		return BarInfo.get(1);
	}
	//��ȡ��������
	public String getBarOwnerName(){
		return getUserName(BarInfo.get(1));
	}
	//�������id
	public String getBarId(){
		return this.BarInfo.get(0);
	}
	//���������
	public String getBarName(){
		return BarInfo.get(3);
	}
	
	//�����������
	public String getBarType(){
		return BarInfo.get(2);
	}
	
	//�����������
	public int getPostNum(){
		return PostList.size()/7;
	}
	
	//�������id
	public String getPostId(int index){
		return PostList.get(index*7);
	}
	
	//���¥��id
	public String getPosterId(int index){
		return PostList.get(index*7+1);
	}
	
	//���������
	public String getPostName(int index){
		return PostList.get(index*7+2);
	}
	
	//�����������
	public String getPostMsg(int index){
		return PostList.get(index*7+3);
	}
	
	//��ȡ����ʱ��
	public String getPostDate(int index){
		return PostList.get(index*7+4);
	}
	
	//��ȡ���ظ�ʱ��
	public String getLastDate(int index){
		return PostList.get(index*7+5);
	}
	
	//��ȡ��󷢲���id
	public String getLastId(int index){
		return PostList.get(index*7+6);
	}
	
	//���ĳ������
	public String getUserName(String user_Id){
		return BarModule.getUserName(user_Id);
	}
	
	//��ȡ�û�ID
	public String getUserID(String name){
		return SearchModule.getUserID(name);
	}
	
	//���ĳ���û��Ƿ��ע������
	public boolean checkStarBar(String user_id){
		try{
			if(BarModule.checkStarBar(user_id, getBarId()).equals("1"))
				return true;
			else return false;
		}catch(Exception e) {return false;}
	}
	//����Ƿ��Ѿ�ǩ��
	public boolean checkSign(String user_id){
		try{
			if(BarModule.CheckSign(getBarId(),user_id).equals("1"))
				return true;
			else return false;
		}catch(Exception e) {return false;}
	}
	
	//���ĳ���Ƿ�����ʦ
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
	//��ȡ��ʦ����
	public int getTeacherNum(){
		return TeacherInfo.size()/2;
	}
	//��ȡ��ʦid
	public String getTeacherId(int index){
		return TeacherInfo.get(index*2);
	}
	//��ȡ��ʦ����
	public String getTeacherName(int index){
		return TeacherInfo.get(index*2+1);
	}
	//��ȡĳһ����������
	public String getBarName1(String bar_id){
		return BarModule.getBarName1(bar_id);
	}
	//���ĳ�����Ƿ���һ���ɵİ���
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
	//��ȡĳ��������id
	public String getReplyer(String reply_id){
		return BarModule.getReplyer(reply_id);
	}
}










