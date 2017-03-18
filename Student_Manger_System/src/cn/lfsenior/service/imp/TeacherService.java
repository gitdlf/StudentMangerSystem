package cn.lfsenior.service.imp;

import cn.lfsenior.dao.ITeacherDao;
import cn.lfsenior.dao.imp.TeacherDao;
import cn.lfsenior.entity.Teacher;
import cn.lfsenior.service.ITeacherSrvice;

public class TeacherService implements ITeacherSrvice {

	private ITeacherDao teacherDao=new TeacherDao();
	@Override
	public Teacher findByNameAndPwd(Teacher teacher) {
		try {
			return teacherDao.findByNameAndPwd(teacher);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void updataTeacherInfo(Teacher teacher) {
		try {
			teacherDao.updataTeacher(teacher);
		} catch (Exception e) {
			throw new RuntimeException(e);		}
	}
	@Override
	public void updataPassword(Teacher teacher) {
		try {
			teacherDao.updataPassword(teacher);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
