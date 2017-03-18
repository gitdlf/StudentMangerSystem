package cn.lfsenior.entity;

public class Teacher {
	private int lf_os_id;// 主键
	private String lf_os_number;// 编号
	private String lf_os_name;// 姓名
	private String lf_os_gender;// 性别
	private String lf_os_age;// 年龄
	private String lf_os_qq;// QQ
	private String lf_os_email;// 邮箱
	private String lf_os_text;// 任职格言
	private String lf_os_password;// 密码

	public Teacher() {

	}

	public String getLf_os_password() {
		return lf_os_password;
	}

	public void setLf_os_password(String lf_os_password) {
		this.lf_os_password = lf_os_password;
	}

	public int getlf_os_id() {
		return lf_os_id;
	}

	public void setlf_os_id(int lf_os_id) {
		this.lf_os_id = lf_os_id;
	}

	public String getlf_os_number() {
		return lf_os_number;
	}

	public void setlf_os_number(String lf_os_number) {
		this.lf_os_number = lf_os_number;
	}

	public String getlf_os_name() {
		return lf_os_name;
	}

	public void setlf_os_name(String lf_os_name) {
		this.lf_os_name = lf_os_name;
	}

	public String getlf_os_gender() {
		return lf_os_gender;
	}

	public void setlf_os_gender(String lf_os_gender) {
		this.lf_os_gender = lf_os_gender;
	}

	public String getlf_os_age() {
		return lf_os_age;
	}

	public void setlf_os_age(String lf_os_age) {
		this.lf_os_age = lf_os_age;
	}

	public String getlf_os_qq() {
		return lf_os_qq;
	}

	public void setlf_os_qq(String lf_os_qq) {
		this.lf_os_qq = lf_os_qq;
	}

	public String getlf_os_email() {
		return lf_os_email;
	}

	public void setlf_os_email(String lf_os_email) {
		this.lf_os_email = lf_os_email;
	}

	public String getlf_os_text() {
		return lf_os_text;
	}

	public void setlf_os_text(String lf_os_text) {
		this.lf_os_text = lf_os_text;
	}

	@Override
	public String toString() {
		return "Teacher [lf_os_id=" + lf_os_id + ", lf_os_number="
				+ lf_os_number + ", lf_os_name=" + lf_os_name
				+ ", lf_os_gender=" + lf_os_gender + ", lf_os_age=" + lf_os_age
				+ ", lf_os_qq=" + lf_os_qq + ", lf_os_email=" + lf_os_email
				+ ", lf_os_text=" + lf_os_text + "]";
	}

}
