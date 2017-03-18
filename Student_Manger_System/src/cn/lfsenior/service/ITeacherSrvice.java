package cn.lfsenior.service;

import cn.lfsenior.entity.Teacher;

public interface ITeacherSrvice {
	/**
	 * 通过用户名编号和密码登录
	 * @param teacher
	 * @return
	 */
	Teacher findByNameAndPwd(Teacher teacher);
	
	/**
	 * 更新用户信息，根据编号
	 * @param teacher
	 */
	void updataTeacherInfo(Teacher teacher);
	
	/**
	 * 更改用户的密码，根据编号
	 * @param teacher
	 */
	void updataPassword(Teacher teacher);
	
}
