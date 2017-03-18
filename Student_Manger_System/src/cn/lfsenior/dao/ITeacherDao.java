package cn.lfsenior.dao;

import cn.lfsenior.entity.Teacher;

public interface ITeacherDao {
	/**
	 * 该方法通过teacher进行登录验证
	 * @param teacher 登录的对象
	 * @return 返回登录成功的对象
	 */
	Teacher findByNameAndPwd(Teacher teacher);
	
	/**
	 * 该方法为实现对用户的修改,根据编号
	 * @param teacher
	 */
	void updataTeacher(Teacher teacher);
	
	/**
	 * 该方法为实现对密码的修改，根据编号
	 * @param teacher
	 */
	void updataPassword(Teacher teacher);
}
