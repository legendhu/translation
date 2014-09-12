<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>常见问题</title>
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
a{
	display:block;
	text-align:center;}
a:hover{
	text-decoration:underline;}
body table{
	margin:20px auto;
	}
td{
	border:#ddd solid 1px;
	background:#fff;
	padding:3px;
	color:#666;}
	
</style>
</head>

<body>
	<h1>常见问题</h1>
  <table><a style="margin:20px;" href="/translation/shasha/backstage/form.html?flag=faq">添加Faq</a>
      <c:forEach var="str" items="${faq}">
      <tr>
      	<td>${str.title}&nbsp</td>
      	<td><a href="/translation/shasha/backstage/form.html?id=${str.id}&type=faq">&nbsp修&nbsp改&nbsp</a></td>
      	<td><a href="/translation/admin/servlet/ChangeFaqServlet?id=${str.id}&type=0">&nbsp删&nbsp除&nbsp</a></td>
      </tr>
      </c:forEach>
  </table>
  </body>
</html>
