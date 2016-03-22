package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBCore;
import com.Module.BarModule;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
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
		//获取消息列表
		String bar_id = request.getParameter("bar_id") ;
		String sql = "select user_id,msg from chat where bar_id = '" + bar_id + "' order by msg_id desc";
		ArrayList get = new ArrayList();
		get.add("user_id");
		get.add("int");
		get.add("msg");
		get.add("String");
		ArrayList back = DBCore.multiSelect(sql, get);
		for(int i = 0;i<back.size()/2;i++){
			out.print("<div style='margin:10px 0;'>");
			out.print("<a href=user?user_id=" + back.get(i*2) + ">" + BarModule.getUserName((String)back.get(i*2)) + "说：</a>&nbsp;&nbsp;<span>" + back.get(i*2+1) + "</span>");
			out.print("</div>");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
