package cn.lfsenior.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mysql.jdbc.JDBC4CallableStatement;

import cn.lfsenior.dao.IStudentDao;
import cn.lfsenior.entity.PageBean;
import cn.lfsenior.entity.Student;
import cn.lfsenior.entity.Teacher;
import cn.lfsenior.util.dao.JdbcUtil;

public class StudentDao implements IStudentDao {

	@Override
	public void findAll(PageBean<Student> pb) {
		//查询总记录数，设置到pb对象中
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		
		//判段如果当前页《0置为1如果》max置为max
		if(pb.getCurrentPage()<=0){
			pb.setCurrentPage(1);
		}else if(pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		
		//获取当前页，计算查询的起始行，返回的行数
		int currentPage=pb.getCurrentPage();
		int index=(currentPage-1)*pb.getPageCount();
		int count=pb.getPageCount();
		//分页查询数据，将数据设置到pb中
		String sql="select * from student limit ?,?";
		try {
			//得到QueryRunner对象
			QueryRunner qr=JdbcUtil.getQuerRunner(StudentDao.class);
			//根据当前页查询当前页数据
			List<Student> pageData=qr.query(sql, new BeanListHandler<Student>(Student.class), index,count);
			//设置到pb对象中
			pb.setPageData(pageData);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalCount() {
		String sql="select count(*) from student";
		try {
			//创建QueryRunner对象
			QueryRunner qr=JdbcUtil.getQuerRunner(StudentDao.class);
			//执行查询，返回结果的第一行的第一列
			Long count=qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public Student findByNameAndPwd(Student student) {
		try {
			String sql = "Select * from student where lf_os_number=? and lf_os_password=?";
			return JdbcUtil.getQuerRunner(StudentDao.class)//
					.query(sql, new BeanHandler<Student>(Student.class),
							student.getlf_os_number(),
							student.getLf_os_password());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteStudent(Student student) {
		try {
			String sql="DELETE FROM student WHERE lf_os_number=?";
			JdbcUtil.getQuerRunner(TeacherDao.class)//
			.update(sql,student.getlf_os_number());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updataStudent(Student student) {
		try {
			String sql="UPDATE student SET lf_os_name=?,lf_os_gender=?,lf_os_age=?,lf_os_class=?,lf_os_qq=?,lf_os_tel=?,lf_os_email=?,lf_os_remark=? WHERE lf_os_number=?";
			JdbcUtil.getQuerRunner(StudentDao.class)//
			.update(sql, student.getlf_os_name(),student.getlf_os_gender(),student.getlf_os_age(),student.getlf_os_class(),student.getlf_os_qq(),student.getLf_os_tel(),student.getlf_os_email(),student.getlf_os_remark(),student.getlf_os_number());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Student findById(Student student) {
		try {
			String sql="select * from student where lf_os_id=?";
			return JdbcUtil.getQuerRunner(StudentDao.class)//
			.query(sql, new BeanHandler<Student>(Student.class), student.getlf_os_id());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertStudent(Student student) {
		try {
			String sql="INSERT INTO student (lf_os_number,lf_os_name,lf_os_gender,lf_os_age,lf_os_class,lf_os_qq,lf_os_tel,lf_os_email,lf_os_remark,lf_os_password) VALUES (?,?,?,?,?,?,?,?,?,?)";
			JdbcUtil.getQuerRunner(TeacherDao.class)//
			.update(sql, student.getlf_os_number(),student.getlf_os_name(),student.getlf_os_gender(),student.getlf_os_age(),student.getlf_os_class(),student.getlf_os_qq(),student.getLf_os_tel(),student.getlf_os_email(),student.getlf_os_remark(),student.getLf_os_password());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}












