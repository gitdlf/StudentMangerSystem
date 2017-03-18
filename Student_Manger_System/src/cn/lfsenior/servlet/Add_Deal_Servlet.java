package cn.lfsenior.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lfsenior.entity.Student;
import cn.lfsenior.service.imp.StudentService;

public class Add_Deal_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int userid=Integer.parseInt(request.getParameter("userid"));
			Student student=new Student();
			student.setlf_os_id(userid);
			student=new StudentService().findById(student);
			request.setAttribute("student_info", student);
			request.getRequestDispatcher("/add.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
