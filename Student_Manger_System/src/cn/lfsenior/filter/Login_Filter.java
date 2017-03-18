package cn.lfsenior.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录限制，如果没有登录禁止操作其他事物
 * @author LFSenior
 *
 *上午11:50:56
 *
 */
public class Login_Filter implements Filter {
	
	private String uri;//转发

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain) throws IOException, ServletException {
		//逻辑处理
		
		//转换
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		//获取所有请求页,截取
		String uri=request.getRequestURI();
		//截取
		String requestPath=uri.substring(uri.lastIndexOf("/")+1, uri.length()); 
		
		
		//判断，先放行一些资源login.jsp||Login_Servlet
		if("Login_Servlet".equals(requestPath)||"login.jsp".equals(requestPath)){
			filterChain.doFilter(req, res);
		}else{
			//对其他资源进行拦截
			/**
			 * 先获取session中的登录用户
			 * 获取的用户为空，就说明没有登录，跳转到登录
			 * 如果获取的内容不为空，说明已经登录放行
			 * 
			 */
			HttpSession session=request.getSession(false);
			if(session!=null){
				Object obj=session.getAttribute("teacher_login");
				Object obj_stu=session.getAttribute("student_login");
				if(obj_stu!=null){
					if("student_index.jsp".equals(requestPath)||"stuinfo.jsp".equals(requestPath)||
							"stu_upload.jsp".equals(requestPath)){
						filterChain.doFilter(req, res);
						return;
					}
				}
				if(obj!=null){
					//如果不等于空说明已登录放行
					filterChain.doFilter(request, response);
				}else{
					//如果获取的内容为空说明没有登录
					uri="/login.jsp";
					request.getRequestDispatcher(uri).forward(request, response);
				}
			}else{
				//因为没有session所以肯定没有登录
				uri="/login.jsp";
				request.getRequestDispatcher(uri).forward(request, response);
			}
		}
		
		
	
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}














































