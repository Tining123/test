package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Module.BarTeacherModule;

/**
 * Servlet implementation class BarTeacherServlet
 */
@WebServlet("/BarTeacherServlet")
public class BarTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BarTeacherServlet() {
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
		String ask = request.getParameter("ask") ;
		//�����������������
		if(ask==null){
			String yes = request.getParameter("yes") ;
			//���
			if(yes != null){
				//������ʦ
				String user_id = request.getParameter("user_id") ;
				BarTeacherModule.SetTeacher(bar_id, user_id);
				String msg_id = request.getParameter("msg_id") ;
				BarTeacherModule.DeleteAskTeacher(msg_id);
				response.sendRedirect(request.getHeader("Referer"));
			}else{
				String msg_id = request.getParameter("msg_id") ;
				BarTeacherModule.DeleteAskTeacher(msg_id);
				response.sendRedirect(request.getHeader("Referer"));
			}
		}
		//�����������������������ź�
		else{
			//������������Ϣ
			BarTeacherModule.AskTeacher(bar_id, BarTeacherModule.getUserID(UserName));
			response.sendRedirect(request.getHeader("Referer"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
