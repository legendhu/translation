<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<style>
body{
	background:#f3f3f3;
	border-top:#40d7c2 solid 1px;}
h1{
	height:30px;
	background:url(images/sadasdf.jpg) repeat-x left top;
	font: bold 16px/30px '微软雅黑';
	color:#666;
	text-align:center;
	border-top:1px solid #999;}
form{
	margin:20px;}
form input{
	border:#ddd solid 1px;
	padding:3px;
	color:#666;}
body table{
	margin:20px;
	}
td{
	border:#ddd solid 1px;
	background:#fff;
	padding:3px;
	color:#666;}
a:hover{
	text-decoration:underline;}

</style>
</head>

<body>
	<h1>学生信息</h1>
   <form action="/translation/admin/servlet/ChangeStudentServlet?type=update&id=${info.id}" method="post">
   	<table>
   		<tr><td>用户名：</td>
   			<td>${info.username}</td>
   		</tr>
   		<tr>
   			<td>真实姓名：</td>
   			<td><input type="text" value="${info.name}" name="name"/></td>
   		</tr>
   		<tr>
   			<td>联系电话：</td>
   			<td><input type="text" value="${info.tel}" name="tel"/></td>
   		</tr>
   		<tr>
   			<td>联系邮箱：</td>
   			<td><input type="text" value="${info.email}" name="email"/></td>
   		</tr>
  		<tr>
 			<td></td>
   			<td>
   				<input type="submit" value="提交" />
   				<input type="button" value="取消" onclick="window.location.href='/translation/shasha/backstage/student.html'" />
   			</td>
   	
   		</tr>
   	</table>
   </form>
  </body>
</html>
