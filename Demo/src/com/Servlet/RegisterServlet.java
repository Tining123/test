package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Module.RegisterModule;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		String name = request.getParameter("name") ;
		
		if(RegisterModule.checkRegister(name) != 0){
			out.println("用户已存在");
			response.sendRedirect("Search.jsp");
			return;
		}
		
		String mail = request.getParameter("mail") ;
		String pass = request.getParameter("pass") ;
		String pic = request.getParameter("pic") ;
		RegisterModule.register(name, pass, mail, pic);	
		out.println("注册成功");
		out.print("<script language='javascript'>alert('注册成功');<script>");
		response.sendRedirect("Search.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
