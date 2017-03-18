package cn.lfsenior.service;

import cn.lfsenior.entity.PageBean;
import cn.lfsenior.entity.Student;

/**
 * 业务逻辑接口，处理Student分页
 * @author LFSenior
 *
 *下午4:58:40
 *
 */
public interface IStudnetService {
	/**
	 * 分页查询数据
	 */
	public void findAll(PageBean<Student> pb);
	
	/**
	 * 通过用户名编号和密码登录
	 * @param student
	 * @return
	 */
	Student findByNameAndPwd(Student student);
	
	/**
	 * 删除学员根据学员编号
	 * @param student
	 */
	void deleteStudent(Student student);
	
	/**
	 * 更新学员，根据学员编号
	 * @param student
	 */
	void updataStudent(Student student);
	
	
	/**
	 * 根据id的值查找学员
	 * @param student
	 * @return 返回student对象
	 */
	Student findById(Student student);
	
	
	/**
	 * 向数据库中插入学生
	 * @param student
	 */
	void insertStudent(Student student);
}
