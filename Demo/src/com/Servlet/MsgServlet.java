package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Module.MsgModule;

/**
 * Servlet implementation class MsgServlet
 */
@WebServlet("/MsgServlet")
public class MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		String msg_id = request.getParameter("msg_id");
		String msg = request.getParameter("msg");
		//如果有消息穿过来
		if(msg!=null&&msg.length()!=0){
			String UserName = "";
			Cookie[] cook =request.getCookies();//用一个Cookie数组来接收
			if(cook != null){
				for(int j=0;j<cook.length;j++){	//通过循环来打印Cookie  
					if(cook[j].getName().equals("name"))	//取cookie的名 
						UserName = cook[j].getValue();	//取cookie的值  
				}
			}
			//插入一条普通消息
			MsgModule.Msg(msg, "1", MsgModule.getUserID(UserName), user_id);
			//如果是回复，转到那个人的页面，如果不是回复，则转到自己的页面
			if(msg_id == null){
				response.sendRedirect("user?user_id="+user_id);
				return;
			}else{
				System.out.println("?");
				response.sendRedirect("user?user_id="+MsgModule.getUserID(UserName));
				return;
			}
		}
		request.setAttribute( "user_id", user_id);
		request.setAttribute( "msg_id", msg_id);
		request.getRequestDispatcher("Msg.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
