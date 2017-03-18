<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 教师信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/Modifinfo_Servlet">
      <input type="text" class="input" style="display:none" name="usernumber" value="${sessionScope.teacher_login.lf_os_number }" />
      <div class="form-group">
        <div class="label">
          <label>教师编号：</label>
        </div>
        <div class="label">
          <label>${sessionScope.teacher_login.lf_os_number }</label>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="userName" value="${sessionScope.teacher_login.lf_os_name }" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>年龄：</label>
        </div>
        <div class="field">
          <input type="text"  class="input" name="userage" value="${sessionScope.teacher_login.lf_os_age }" />
        </div>
      </div>
      <div class="form-group" style="display:none">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="usergender" value="${sessionScope.teacher_login.lf_os_gender }" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>qq：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="userqq" value="${sessionScope.teacher_login.lf_os_qq }" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>E-Mail：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="useremail" value="${sessionScope.teacher_login.lf_os_email }" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>任职格言：</label>
        </div>
        <div class="field">
          <textarea class="input" name="usertext">${sessionScope.teacher_login.lf_os_text }</textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>