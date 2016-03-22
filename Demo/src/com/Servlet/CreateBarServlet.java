package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Module.CreateBarModule;

import com.Module.*;

/**
 * Servlet implementation class CreateBarServlet
 */
@WebServlet("/CreateBarServlet")
public class CreateBarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		
		String UserName = "";
		Cookie[] cook =request.getCookies();//��һ��Cookie����������
		if(cook != null){
			for(int j=0;j<cook.length;j++){	//ͨ��ѭ������ӡCookie  
				if(cook[j].getName().equals("name"))	//ȡcookie���� 
					UserName = cook[j].getValue();	//ȡcookie��ֵ  
			}
		}
		if(UserName == null || UserName.length() == 0)
			response.sendRedirect("Login.jsp");
		
		
		String id = PostModule.getUserID(UserName);
		//String id = request.getParameter("id") ;
		String name = request.getParameter("name") ;
		String topic = request.getParameter("type") ;

		//��������
		CreateBarModule.createBar(id, topic, name);
		out.println("�����ɹ�");
		response.sendRedirect("bar?page=1&name="+name);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
