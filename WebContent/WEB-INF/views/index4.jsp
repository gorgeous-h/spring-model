<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	table.userTable {
		width: 400px;		
		border-collapse: collapse;
	}
	table.userTable,
	table.userTable td {
		border: 1px solid black;
	}
	table.userTable td {
		text-align: left;
		padding: 15px;
	}
	table.userTable td:first-child {
		width: 100px;
	}
</style>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<title>ModelAttribute Demo</title>
</head>
<body>
<!-- 	<table class="userTable"> -->
<!-- 		<tr> -->
<!-- 			<td>ID</td> -->
<%-- 			<td id="td_id">${requestScope.myUser.id}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>姓名</td> -->
<%-- 			<td id="td_name">${requestScope.myUser.name}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>性别</td> -->
<%-- 			<td id="td_gender">${requestScope.myUser.gender eq 0 ? "男" : "女"}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>年龄</td> -->
<%-- 			<td id="td_age">${requestScope.myUser.age}</td> --%>
<!-- 		</tr> -->
<!-- 	</table> -->
	<table class="userTable">
		<tr>
			<td>ID</td>
			<td id="td_id"></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td id="td_name"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td id="td_gender"></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td id="td_age"></td>
		</tr>
	</table>
	<div>
		<form method="post" action="${pageContext.request.contextPath}/helloModelAttribute/saveUser">
			<input type="hidden" name="id" id="id" />
			<div>
				<p><label for="name">姓名</label><input type="text" name="name" id="name" required /></p>
				<p>性别&nbsp;&nbsp;<input type="radio" name="gender" id="male" value="0" /><label for="male">男</label> <input type="radio" name="gender" id="female" value="1" /><label for="female">女</label></p>
				<p><label for="age">年龄</label><input type="text" name="age" id="age" /></p>
			</div>
			<input type="submit" value="保存" />
		</form>
	</div>
	<script>
		var contextPath = '${pageContext.request.contextPath}';
		
		$(function(){
			$.post(contextPath+'/helloModelAttribute/getUserById', {id: 1}, function(data){
				var user = JSON.parse(data);
				var {id, name, gender, age} = user;
				$("#td_id").text(id);
				$("#td_name").text(name);
				$("#td_gender").text(gender==0?"男":"女 "); 
				$("#td_age").text(age);
				
				$("#id").val(id);
				$("#name").val(name);
				$("input[name='gender'][value='"+gender+"']").attr("checked",true); 
				$("#gender").val(gender);
				$("#age").val(age);
			});
		});
	</script>
</body>
</html>