package cn.lfsenior.util.dao;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;




import cn.lfsenior.dao.imp.StudentDao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @author LFSenior
 *
 *下午9:34:29
 *
 *该类为数据库操作的工具类
 *
 */
public class JdbcUtil {
	private static DataSource dataSource_Student;
	private static DataSource dataSource_Teacher;
	
	static{
		dataSource_Student=new ComboPooledDataSource("LF_OS_Student_Config");
		dataSource_Teacher=new ComboPooledDataSource("LF_OS_Teacher_Config");
	}
	
	/**
	 * 使用dbutil技术
	 * @param clazz 为操作对象的实现接口的字节码文件
	 * @return
	 */
	public static QueryRunner getQuerRunner(Class clazz){
		if(clazz.equals(StudentDao.class)){
			return new QueryRunner(dataSource_Student);
		}else{
			return new QueryRunner(dataSource_Teacher);
		}
		
	}
	
	
/*	public static Connection  getConnection(Class clazz){
		Connection conn=null;
		if(clazz.equals(StudentDao.class)){
			try {
				conn=dataSource_Student.getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		if(clazz.equals(TeacherDao.class)){
			try {
				conn=dataSource_Teacher.getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		 
		return conn;
	}
	
	public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try {
			if(conn!=null){
				conn.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}*/
}
