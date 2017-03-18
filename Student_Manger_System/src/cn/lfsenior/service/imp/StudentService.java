package cn.lfsenior.service.imp;

import javax.management.RuntimeErrorException;

import cn.lfsenior.dao.IStudentDao;
import cn.lfsenior.dao.imp.StudentDao;
import cn.lfsenior.entity.PageBean;
import cn.lfsenior.entity.Student;
import cn.lfsenior.service.IStudnetService;

public class StudentService implements IStudnetService {

	// 创建Dao实例
	private IStudentDao studentDao = new StudentDao();

	@Override
	public void findAll(PageBean<Student> pb) {
		try {
			studentDao.findAll(pb);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Student findByNameAndPwd(Student student) {
		try {
			return studentDao.findByNameAndPwd(student);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteStudent(Student student) {
		try {
			studentDao.deleteStudent(student);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updataStudent(Student student) {
		try {
			studentDao.updataStudent(student);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Student findById(Student student) {
		try {
			return studentDao.findById(student);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertStudent(Student student) {
		try {
			studentDao.insertStudent(student);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
