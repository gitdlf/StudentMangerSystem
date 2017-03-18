package cn.lfsenior.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lfsenior.entity.Teacher;
import cn.lfsenior.service.imp.TeacherService;

public class Modifinfo_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//将信息封装成Teacher对象
		String uri="";//跳转uri
		try {
			Teacher teacher=new Teacher();
			teacher.setlf_os_age(request.getParameter("userage"));
			teacher.setlf_os_name(request.getParameter("userName"));
			teacher.setlf_os_number(request.getParameter("usernumber"));
			teacher.setlf_os_text(request.getParameter("usertext"));
			teacher.setlf_os_qq(request.getParameter("userqq"));
			teacher.setlf_os_email(request.getParameter("useremail"));
			teacher.setlf_os_gender(request.getParameter("usergender"));
			teacher.setLf_os_password(((Teacher)(request.getSession().getAttribute("teacher_login"))).getLf_os_password());
			new TeacherService().updataTeacherInfo(teacher);
			request.getSession().setAttribute("teacher_login", teacher);
			uri="/info.jsp";
		} catch (Exception e) {
			//出错
			uri="/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
