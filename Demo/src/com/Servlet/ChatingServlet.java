package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBCore;
import com.Module.*;

/**
 * Servlet implementation class ChatingServlet
 */
@WebServlet("/ChatingServlet")
public class ChatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UserName = "";
		Cookie[] cook =request.getCookies();//��һ��Cookie����������
		if(cook != null){
			for(int j=0;j<cook.length;j++){	//ͨ��ѭ������ӡCookie  
				if(cook[j].getName().equals("name"))	//ȡcookie���� 
					UserName = cook[j].getValue();	//ȡcookie��ֵ  
			}
		}
		String bar_id = request.getParameter("bar_id") ;
		String msg = request.getParameter("msg") ;
		String sql = "insert into chat(user_id,bar_id,msg) values('" + MsgModule.getUserID(UserName) + "','" + bar_id + "','" + msg + "')";
		DBCore.Execute(sql);
		response.sendRedirect(request.getHeader("Referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
