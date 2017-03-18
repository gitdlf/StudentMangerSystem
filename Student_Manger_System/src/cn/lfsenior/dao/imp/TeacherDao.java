package cn.lfsenior.dao.imp;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.lfsenior.dao.ITeacherDao;
import cn.lfsenior.entity.Teacher;
import cn.lfsenior.util.dao.JdbcUtil;

public class TeacherDao implements ITeacherDao {

	@Override
	public Teacher findByNameAndPwd(Teacher teacher) {
		try {
			String sql = "Select * from teacher where lf_os_number=? and lf_os_password=?";
			return JdbcUtil.getQuerRunner(TeacherDao.class)//
					.query(sql, new BeanHandler<Teacher>(Teacher.class),
							teacher.getlf_os_number(),
							teacher.getLf_os_password());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updataTeacher(Teacher teacher) {
		 try {
			String sql="UPDATE teacher SET	lf_os_name=?,lf_os_gender=?,lf_os_age=?,lf_os_qq=?,lf_os_email=?,lf_os_text=? WHERE lf_os_number=?";
			JdbcUtil.getQuerRunner(TeacherDao.class)//
			.update(sql, teacher.getlf_os_name(),teacher.getlf_os_gender(),teacher.getlf_os_age(),teacher.getlf_os_qq(),teacher.getlf_os_email(),teacher.getlf_os_text(),teacher.getlf_os_number());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updataPassword(Teacher teacher) {
		try {
			String sql="UPDATE teacher set lf_os_password=? WHERE lf_os_number=?";
			JdbcUtil.getQuerRunner(TeacherDao.class)//
			.update(sql,teacher.getLf_os_password(),teacher.getlf_os_number());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
