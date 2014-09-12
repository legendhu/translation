<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%session.getAttribute("type");%>
<%session.getAttribute("auth");%>
<title>注册成功</title>
<style>
body{
	font-family:"微软雅黑";}
div{
	margin:0 auto;
	width:900px;
	height:200px;
	background:url(images/sdsad.jpg) no-repeat left top;
	text-align:center;
}
h1{
	padding-top:40px;
	margin-bottom:20px;
	color:#0C0;
	font-weight:normal;}
p{
	color:#666;}

</style>
<script>
window.onload=function(){
	var In=document.getElementById("in");
	var time=5;
	var type=document.getElementById('ty').getAttribute('type');
	setInterval(function(){
		time-=1;
		In.innerHTML=time;
		if(time==0){
			if(type==0){
			window.location.pathname="translation/shasha/studentCenter.html"
			}
			if(type==1){
			window.location.pathname="translation/shasha/teacherCenter.html"
			}
		}
		},1000);
	}
</script>
</head>

<body>
<strong id='ty' type='${sessionScope.type}'></strong>
<div>
<h1>${sessionScope.auth} 恭喜您注册成功</h1>
<p>还有<span id="in" style="font-size:150%; color:#03F">5</span>秒钟跳转到个人中心</p>
</div>
</body>
</html>
