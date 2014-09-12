<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    <title>文件上传</title>
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
	<h1>老师信息</h1>
    <form action="/translation/admin/servlet/UploadServlet" enctype="multipart/form-data" method="post">
  	<table>
  		<tr>
  			<td colspan="2"><input type="file" name="filename"></td>  	
  		</tr>
  		
  		<tr>
  		    <td>请输入文件的描述：</td>
  		    <td><textarea name="description"></textarea></td>
  		</tr>
  	
  		
  		<tr>
  			<td colspan="2"><input type="submit" value="上传"></td>
  		</tr>
  	</table>
   </form>
  </body>
</html>
