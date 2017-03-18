package cn.lfsenior.dao;

import cn.lfsenior.entity.PageBean;
import cn.lfsenior.entity.Student;

public interface IStudentDao {
	/**
	 * 分页查询数据
	 */
	public void findAll(PageBean<Student> pb);
	
	/**
	 * 查询总记录数
	 */
	
	public int getTotalCount();
	
	/**
	 * 该方法通过student对象进行查询
	 * @param student student对象
	 * @return student对象
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
	 * 根据id查找学员信息
	 * @param student
	 * @return 返回Student对象
	 */
	Student findById(Student student);
	
	/**
	 * 向数据库中插入学生
	 * @param student
	 */
	void insertStudent(Student student);
}
