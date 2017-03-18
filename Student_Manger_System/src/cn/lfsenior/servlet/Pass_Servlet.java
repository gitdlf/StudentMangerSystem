package cn.lfsenior.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lfsenior.entity.Teacher;
import cn.lfsenior.service.imp.TeacherService;

public class Pass_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "";// 跳转链接
		try {
			Teacher teacher = new Teacher();
			teacher.setlf_os_number(request.getParameter("usernumber"));
			teacher.setLf_os_password(request.getParameter("newpass"));
			new TeacherService().updataPassword(teacher);
			uri = "/info.jsp";
		} catch (Exception e) {
			uri = "/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
