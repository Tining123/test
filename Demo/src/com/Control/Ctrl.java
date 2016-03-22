package com.Control;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Ctrl {
	
	//个人中心包装函数
	public String MakeUserTips(String id,String name){
		return MakeATips("user?id="+id, name);
	}
	//超链接包装函数
	public String MakeATips(String address,String value){
		return MakeSimpleTips("a", "href", address, value);
	}
	
	//单属性包装函数
	public String MakeSimpleTips(String name,String attibute,String params,String value){
		ArrayList<String> get = new ArrayList<String>();
		get.add(attibute);
		get.add(params);
		return MakeTips(name, get, value);
	}
	
	//元包装函数
	public String MakeTips(String name,ArrayList<String> attribute,String value){
		String back = "";
		back += "<" + name;
		for(int i = 0; i < attribute.size(); i += 2){
			back += " ";
			back += attribute.get(i);
			back += "=";
			back += attribute.get(i+1);
		}
		back += ">";
		back += value;
		back += "</" + name + ">";
		return back;
	}
	
	//换行
	public String NewLine(){
		return "<br/>";
	}

}
