package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Module.UnStarBarModule;

/**
 * Servlet implementation class UnStarBarServlet
 */
@WebServlet("/UnStarBarServlet")
public class UnStarBarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnStarBarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UserName = "";
		Cookie[] cook =request.getCookies();//用一个Cookie数组来接收
		if(cook != null){
			for(int j=0;j<cook.length;j++){	//通过循环来打印Cookie  
				if(cook[j].getName().equals("name"))	//取cookie的名 
					UserName = cook[j].getValue();	//取cookie的值  
			}
		}
		String bar_id = request.getParameter("bar_id") ;
		UnStarBarModule.UnStarBar(bar_id,UnStarBarModule.getUserID(UserName));
		response.sendRedirect(request.getHeader("Referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
