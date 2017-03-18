<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<form method="post" action="">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 学员列表</strong>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">ID</th>
					<th>学号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>班级</th>
					<th>qq</th>
					<th>电话</th>
					<th>邮箱</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
				<c:choose>
					<c:when test="${not empty requestScope.pageBean.pageData}">
						<c:forEach var="emp" items="${requestScope.pageBean.pageData }"
							varStatus="vs">
							<tr>
								<td><input type="checkbox" name="id[]" value="1" />${emp.lf_os_id}</td>
								<td>${emp.lf_os_number}</td>
								<td>${emp.lf_os_name}</td>
								<td>${emp.lf_os_gender}</td>
								<td>${emp.lf_os_age}</td>
								<td>${emp.lf_os_class}</td>
								<td>${emp.lf_os_qq}</td>
								<td>${emp.lf_os_tel}</td>
								<td>${emp.lf_os_email}</td>
								<td>${emp.lf_os_remark}</td>
								<td><div class="button-group">
										<a class="button border-main" href="${pageContext.request.contextPath}/Add_Deal_Servlet?userid=${emp.lf_os_id}"><span
											class="icon-edit"></span> 修改</a> <a class="button border-red"
											href="${pageContext.request.contextPath}/StuDelete_Servlet?usernumber=${emp.lf_os_number}"><span
											class="icon-trash-o"></span> 删除</a>
									</div></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="11">对不起，没有找到数据</td>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<td colspan="8">
					<div class="pagelist">
							<a href="${pageContext.request.contextPath }/Student_Servlet?currPage=1">首页</a> 
							<a href="${pageContext.request.contextPath }/Student_Servlet?currPage=${requestScope.pageBean.currentPage-1}">上一页</a>
							 当前<span class="current">${requestScope.pageBean.currentPage}</span>/ ${requestScope.pageBean.totalPage}
								<a href="${pageContext.request.contextPath }/Student_Servlet?currPage=${requestScope.pageBean.currentPage+1}">下一页</a>
								<a href="${pageContext.request.contextPath }/Student_Servlet?currPage=${requestScope.pageBean.totalPage}">尾页</a>
						</div>
						</td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {

			}
		}

		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>
