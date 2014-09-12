<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>莎莎后台管理系统登录页面</title>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<style>
#login{
	width:960px;
	height:auto;
	margin:0 auto;
	position:relative;
	}
#login form{
	position:absolute;
	left:300px;
	top:210px;
	
	}
#login form div{
	height:25px;
	margin-bottom:20px;}
#login form label{
	float:left;
	width:100px;
	padding-right:10px;
	font:16px/25px '微软雅黑';
	color:#fff;
	text-align:right;
	
	}
#login form input{
	height:24px;
	width:150px;
	padding-left:26px;
	border:none;
	font:14px/24px '微软雅黑';
	}
#login form #username{
	background:url(images/1_130221084903_1_03.jpg) no-repeat left top;}
#login form #password{
	background:url(images/1_130221084903_1_06.jpg) no-repeat left top;
	}
#login form #captcha{
 	float:left;
	width:80px;
	padding:0;
}
#yanzheng{
	width:80px;
	height:24px;
	float:left;
	padding-left:10px;
}
#login form .tijiao{
	width:68px;
	height:26px;
	float:left;
	margin-left:110px;
	background:url(images/1_130221084903_1_09.jpg) no-repeat left top;
	cursor:pointer;
	}
#login form .chongzhi{
	width:68px;
	height:26px;
	float:left;
	margin-left:20px;
	background:url(images/1_130221084903_1_11.jpg) no-repeat left top;
	cursor:pointer;
	}
</style>
<script>
window.onload=function(){
	var username=document.getElementById("username");
	var password=document.getElementById("password");
	var captcha=document.getElementById("captcha");
	document.forms.login.onsubmit=function(){
		if(username.value==""){
			alert("用户名不能为空");
			return false;
			}else if(password.value==""){
			alert("密码不能为空");
			return false;
			}else if(captcha.value==""){
			alert("验证码不能为空");
			return false;
			
			}else{
			return true;		
					}
		}
	}
</script>
</head>

<body>

<div id="login">
<form name="login" action="/translation/servlet/AdminServlet" method="post">
<div>
<label for="username">用户名:</label><input id="username" name="username" type="text"/>
</div>
<div>
<label for="password">密　码:</label><input id="password" name="password" type="password" />
</div>
<div class="yanzheng">
<label for="captcha">验证码:</label><input id="captcha" name="captcha" type="text" />
<img id="yanzheng" alt="看不清换一张" src="/translation/shasha/backstage/captcha.jsp" onclick="this.src='/translation/shasha/backstage/captcha.jsp?d='+Math.random();">
</div>
<div>
<input type="submit" class="tijiao"  value=""/>
<input type="reset" class="chongzhi" value=""/>
</div>
</form>

</div>
</body>
</html>
