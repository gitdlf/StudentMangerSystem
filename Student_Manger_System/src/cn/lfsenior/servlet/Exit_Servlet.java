package cn.lfsenior.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出登录
 * @author LFSenior
 *
 *上午11:47:40
 *
 */
public class Exit_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri="";//跳转uri
		request.getSession().removeAttribute("teacher_login");
		request.getSession().removeAttribute("student_login");
		uri="/login.jsp";
		request.getRequestDispatcher(uri).forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
