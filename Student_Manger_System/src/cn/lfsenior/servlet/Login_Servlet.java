package cn.lfsenior.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lfsenior.entity.Student;
import cn.lfsenior.entity.Teacher;
import cn.lfsenior.service.imp.StudentService;
import cn.lfsenior.service.imp.TeacherService;

public class Login_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String identy = request.getParameter("identy");
		String uri = "";// 最终跳转界面
		if ("老师登录".equals(identy)) {
			// 表示老师登录
			Teacher teacher = new Teacher();
			teacher.setlf_os_number(name);
			teacher.setLf_os_password(password);
			Teacher loginInfo = new TeacherService().findByNameAndPwd(teacher);
			if (loginInfo == null) {
				// 表示登录失败
				uri = "/login.jsp";
			} else {
				// 登录成功
				request.getSession().setAttribute("teacher_login", loginInfo);
				request.getSession().setMaxInactiveInterval(60 * 60 * 1000);// session保存1小时
				Teacher tea=(Teacher) request.getSession().getAttribute("teacher_login");
				uri = "/index.jsp";
			}

		} else if ("学生登录".equals(identy)) {
			// 表示学生登录
			Student student = new Student();
			student.setlf_os_number(name);
			student.setLf_os_password(password);
			Student loginInfo = new StudentService().findByNameAndPwd(student);
			if (loginInfo == null) {
				// 登录失败
				uri = "/login.jsp";
			} else {
				// 登录成功
				request.getSession().setAttribute("student_login", loginInfo);
				request.getSession().setMaxInactiveInterval(60 * 60 * 1000);// session保存1小时
				uri = "/student_index.jsp";
			}
		} else {
			// 没有选择标签，返回登录页面，并给出提示
			uri = "/login.jsp";
		}

		request.getRequestDispatcher(uri).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
