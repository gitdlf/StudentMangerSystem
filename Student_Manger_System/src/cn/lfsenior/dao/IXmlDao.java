package cn.lfsenior.dao;

import java.util.List;

import cn.lfsenior.entity.Student;

public interface IXmlDao {
	/**
	 * 根据path路径
	 * @param path
	 */
	void createDocument(String path,String fileName);
	
	/**
	 *根据student对象正价Element子节点
	 * @param student Student 对象
	 * @param path Path路径
	 * @param address 访问的ip地址
	 * @param workName 作业编号
	 * @return 返回对应码，1创建成功，0表示已经存在
	 */
	int addElement(Student student,String path,String address,String workName);
	
	/**
	 * 删除标签
	 * @param student
	 */
	void delElement(Student student,String path);
	
	
	/**
	 * 根据路径查找所有信息
	 * @param path
	 * @return 返回一个list集合
	 */
	List<Student> findAll(String path);
	

	
}
