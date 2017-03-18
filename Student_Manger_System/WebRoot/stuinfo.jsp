<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>学生信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 学生信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">
    	 <div class="label">
         	<span name="usernumber: id="idnumber">&nbsp;&nbsp;学号：${sessionScope.student_login.lf_os_number }</span></br></br>
         
     		<span name="username" id="idname">&nbsp;&nbsp;姓名：${sessionScope.student_login.lf_os_name }</span></br></br>
       	   
            <span name="userage" id="idage">&nbsp;&nbsp;年龄：${sessionScope.student_login.lf_os_age }</span></br></br>
            
            <span name="userqq" id="idqq">&nbsp;&nbsp;班级：${sessionScope.student_login.lf_os_class }</span></br></br>
            
            <span name="usergender" id="idgender" >&nbsp;&nbsp;性别：${sessionScope.student_login.lf_os_gender }</span></br></br>
            
            <span name="userqq" id="idqq">&nbsp;&nbsp;qq：${sessionScope.student_login.lf_os_qq }</span></br></br>
            
            <span name="useremail" id="idemail">&nbsp;&nbsp;E-Mail：${sessionScope.student_login.lf_os_email }</span></br></br>
            
            <span name="usertext" id="idtext">&nbsp;&nbsp;注册信息：${sessionScope.student_login.lf_os_remark }</span></br></br>
        </div>
    </form>
  </div>
</div>
</body></html>
