package cn.lfsenior.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lfsenior.entity.PageBean;
import cn.lfsenior.entity.Student;
import cn.lfsenior.service.IStudnetService;
import cn.lfsenior.service.imp.StudentService;

/**
 * 控制层开发
 * 
 * @author LFSenior
 * 
 *         下午5:03:37
 * 
 */
public class Student_Servlet extends HttpServlet {

	private IStudnetService studentService = new StudentService();
	private String uri;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 获取当前页对象，第一次访问
			String currPage = request.getParameter("currPage");
			// 判断
			if (currPage == null || "".equals(currPage.trim())) {
				currPage = "1";
			}
			// 转换
			int currentPage = Integer.parseInt(currPage);

			// 创建pageBean对象，设置当前页参数，传入service方法
			PageBean<Student> pageBean = new PageBean<Student>();
			pageBean.setCurrentPage(currentPage);

			// 3调用service
			studentService.findAll(pageBean);

			// 保存pagebean对象，到request域中
			request.setAttribute("pageBean", pageBean);
			// 跳转
			uri = "/student.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 出现错误跳转到错误页面
			uri = "/student.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
