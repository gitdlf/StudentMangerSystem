package cn.lfsenior.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lfsenior.entity.Student;
import cn.lfsenior.service.imp.StudentService;

/**
 * 删除学员
 * @author LFSenior
 *
 *下午12:48:44
 *
 */
public class StuDelete_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String usernumber=request.getParameter("usernumber");
			Student student=new Student();
			student.setlf_os_number(usernumber);
			new StudentService().deleteStudent(student);
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
