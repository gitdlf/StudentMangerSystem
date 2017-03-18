package cn.lfsenior.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 上传
		upload(request, response);
		//同时将信息保存到xml文件中
		request.getRequestDispatcher("/stu_upload.jsp");
	}

	/**
	 * 1. 上传
	 */
	private void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1. 创建工厂对象
			FileItemFactory factory = new DiskFileItemFactory();
			// 2. 文件上传核心工具类
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置大小限制参数
			upload.setFileSizeMax(10 * 1024 * 1024); // 单个文件大小限制
			upload.setSizeMax(50 * 1024 * 1024); // 总文件大小限制
			upload.setHeaderEncoding("UTF-8"); // 对中文文件编码处理

			// 判断
			if (upload.isMultipartContent(request)) {
				// 3. 把请求数据转换为list集合
				List<FileItem> list = upload.parseRequest(request);
				// 遍历
				for (FileItem item : list) {
					// 判断：普通文本数据
					if (item.isFormField()) {
						// 获取名称
						String name = item.getFieldName();
						// 获取值
						String value = item.getString();
						System.out.println(value);
					}
					// 文件表单项
					else {
						/******** 文件上传 ***********/
						// a. 获取文件名称
						String name = item.getName();
						name=name.substring(name.lastIndexOf("/")+1, name.length());

						// b. 得到上传目录
						String basePath = getServletContext().getRealPath(
								"/upload");
						// c. 创建要上传的文件对象
						File file = new File(basePath, name);
						File fileM=new File(basePath);
						if(!fileM.exists()){
							fileM.mkdirs();//如果文件夹不存在就创建
						}
						// d. 上传
						item.write(file);
						item.delete(); // 删除组件运行时产生的临时文件
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
