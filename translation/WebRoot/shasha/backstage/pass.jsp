<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
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
    <form action="/translation/admin/servlet/ChangeAdminServlet" method="post">
    	<table>
    	<tr><td>用户名：</td>
   			<td><input name="username" type="text"/></td>
   		</tr>
	    <tr><td>密      码：</td>
   			<td><input name="password" type="password"/></td>
   		</tr>
	    <tr>
 			<td></td>
   			<td>
   				<input type="submit" value="提交" />
   				<input type="button" value="取消" onclick="window.location.href='/translation/shasha/backstage/body.html'" />
   			</td>
   		</tr>
    	</table>
    </form>
  </body>
</html>
