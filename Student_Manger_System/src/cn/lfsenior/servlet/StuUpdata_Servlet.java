package cn.lfsenior.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lfsenior.entity.Student;
import cn.lfsenior.service.imp.StudentService;

public class StuUpdata_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Student student=new Student();
			student.setlf_os_number(request.getParameter("usernumber"));
			student.setlf_os_name(request.getParameter("username"));
			student.setlf_os_gender(request.getParameter("usergender"));
			student.setlf_os_class(request.getParameter("userclass"));
			student.setlf_os_age(Integer.parseInt(request.getParameter("userage")));
			student.setlf_os_qq(request.getParameter("userqq"));
			student.setLf_os_tel(request.getParameter("usertel"));
			student.setlf_os_email(request.getParameter("useremail"));
			student.setlf_os_remark(request.getParameter("userremark"));
			new StudentService().updataStudent(student);
			request.getRequestDispatcher("/Student_Servlet").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
