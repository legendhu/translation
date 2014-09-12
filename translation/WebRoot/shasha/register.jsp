<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/token" prefix="zhw"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蜕变网-注册</title>
<link href="base.css" rel="stylesheet" />
<link href="css/register.css" rel="stylesheet" />
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/lianzhui.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/lianzhui_drag.js"></script>
<!--[if lt IE 7]>
<script type="text/javascript" src="js/ltIE7hack.js"></script>
<![endif]-->
<script type="text/javascript" src="js/kuangjia.js"></script>
<script type="text/javascript" src="js/register.js"></script>
</head>

<body id="home">
<div id="main_box">
  <div id="main_center_box">
    <div id="header">
      <div class="logo"><img src="images/logo.png" alt="莎莎 语言培训中心" /></div>
      <div class="language_change"> 
      <em>
         <c:if test="${fn:containsIgnoreCase(param.language,'zh') or fn:containsIgnoreCase(sessionScope.language,'zh')}">
        	中文（简体）
        </c:if>
        <c:if test="${fn:containsIgnoreCase(param.language,'ru') or fn:containsIgnoreCase(sessionScope.language,'ru')}">
        	русский
        </c:if>
        <c:if test="${fn:containsIgnoreCase(param.language,'en') or fn:containsIgnoreCase(sessionScope.language,'en')}">
        	English
        </c:if>
      </em>
        <div class="language_box">
           <a href="?language=zh">中文（简体）</a>
	       <a href="?language=ru">русский</a>
	       <a href="?language=en">English</a>
	    </div>
      </div>
      <c:if test="${param.language ne null}">
     	 <fmt:setLocale value="${param.language}"/>
      </c:if>
      <c:if test="${param.language eq null}">
      	<fmt:setLocale value="${sessionScope.language}"/>
      </c:if>
      <fmt:setBundle var="bundle" basename="com.xinguan.shasha.web.i18n.i18n"/>
      <c:if test= "${sessionScope.auth ne null}">
	      <c:if test="${sessionScope.type=='0'}">
		      <div class="login_user">
		      	<a href="/translation/shasha/studentCenter.html"  style="color:#f7941f">${sessionScope.auth}</a> | 
		      	<a href="/translation/servlet/LoginOutServlet"><fmt:message key="logout" bundle="${bundle}"/></a>
		      </div>
	      </c:if>
      	  <c:if test="${sessionScope.type=='1'}">
	      	  <div class="login_user">
		      	<a href="/translation/shasha/teacherCenter.html"  style="color:#f7941f">${sessionScope.auth}</a> | 
		      	<a href="/translation/servlet/LoginOutServlet"><fmt:message key="logout" bundle="${bundle}"/></a>
		      </div>
          </c:if>
      </c:if>
      
     
      <c:if test= "${sessionScope.auth eq null}">
      <div class="login_user"><em class="login_user_denglu"><fmt:message key="login" bundle="${bundle}"/></em> | <a class="login_user_zhuce" href="register.html"><fmt:message key="register" bundle="${bundle}"/></a></div>
      </c:if>
      </div>
    <div id="nav">
      <ul class="yijilanmu">
        <li class="home"><a href="index.html"><fmt:message key="home" bundle="${bundle}"/></a></li>
        <li class="teacher_list"><a href="teacher.html"><fmt:message key="teacher" bundle="${bundle}"/></a></li>
        <li class="about_us"><a href="aboutus.html"><fmt:message key="aboutus" bundle="${bundle}"/></a></li>
        <li class="news"><a href="news.html"><fmt:message key="news" bundle="${bundle}"/></a></li>
        <li class="bbs"><a href="listallfile.html"><fmt:message key="forum" bundle="${bundle}"/></a>
        </li>
        <li class="faq"><a href="faq.html"><fmt:message key="faq" bundle="${bundle}"/></a></li>
      </ul>
    </div>
    <!--内容区域-->
<div class="content">
<div class="primary">
<div class="welcome"><h2 class="students-choice"><fmt:message key="registerst" bundle="${bundle}"/></h2><h2 class="teacher-choice"><fmt:message key="registerth" bundle="${bundle}"/></h2></div>
<div id="register-student">
<form name="register-student" action="/translation/escape/servlet/StRegisterServlet" method="post">
<input type="hidden" name="formnum00" value=formnum/>
<!-- 防止表单重复提交标签 -->
<input type="hidden" name="sttoken" value="<zhw:token key="sttoken"/>"/>
<div>
<label for="zhuce_user"><fmt:message key="name" bundle="${bundle}"/></label><input id="zhuce_user" name="zhuce_user" type="text" />
<span class="info info_user"><fmt:message key="nameinfo" bundle="${bundle}"/></span>
<span class="error error_user"><fmt:message key="illegal" bundle="${bundle}"/></span>
<span class="succ succ_user"><fmt:message key="ok" bundle="${bundle}"/></span>
<span class="user_wait"></span>
<span class="error error_repeat"><fmt:message key="registered" bundle="${bundle}"/></span>
</div>
<div>
<label for="zhuce_mima"><fmt:message key="password" bundle="${bundle}"/></label><input id="zhuce_mima" name="zhuce_mima" type="password" />
<span class="info info_pass">
<p><fmt:message key="level" bundle="${bundle}"/><strong class="anquan anquan1">■</strong><strong class="anquan anquan2">■</strong><strong class="anquan anquan3">■</strong></strong><strong class="anquan anquan4" style="font-weight:normal;"></strong></p>
<p><strong class="quan1" style="font-weight:normal;">○</strong><fmt:message key="char" bundle="${bundle}"/></p>
<p><strong class="quan2" style="font-weight:normal;">○</strong><fmt:message key="just" bundle="${bundle}"/></p>
<p><strong class="quan3" style="font-weight:normal;">○</strong><fmt:message key="more" bundle="${bundle}"/></p>
</span>
<span class="error error_pass"><fmt:message key="illegal" bundle="${bundle}"/></span>
<span class="succ succ_pass"><fmt:message key="ok" bundle="${bundle}"/></span>
</div>
<div>
<label for="querenmima"><fmt:message key="confirmpassword" bundle="${bundle}"/></label><input id="querenmima" name="querenmima" type="password" />
<span class="info info_sure"><fmt:message key="again" bundle="${bundle}"/></span>
<span class="error error_sure"><fmt:message key="illegal" bundle="${bundle}"/></span>
<span class="succ succ_sure"><fmt:message key="ok" bundle="${bundle}"/></span>
</div>
<div>
<label for="zhuce_email"><fmt:message key="email" bundle="${bundle}"/></label><input id="zhuce_email" name="zhuce_email" type="text" autocomplete="off" />
	<ul class="all_email">
      	<li><span></span>@qq.com</li>
		<li><span></span>@163.com</li>
		<li><span></span>@sohu.com</li>
		<li><span></span>@sina.com.cn</li>
		<li><span></span>@gmail.com</li> 
            <li><span></span>@126.com</li> 
	</ul>
<span class="info info_email"><fmt:message key="enteremail" bundle="${bundle}"/></span>
<span class="error error_email"><fmt:message key="illegal" bundle="${bundle}"/></span>
<span class="succ succ_email"><fmt:message key="ok" bundle="${bundle}"/></span>
</div>
<div>
<label for="tel-num"><fmt:message key="tel" bundle="${bundle}"/></label><input id="tel-num" name="tel-num" type="tel" />
<span class="info info_tel"><fmt:message key="entertel" bundle="${bundle}"/></span>
<span class="error error_tel"><fmt:message key="illegal" bundle="${bundle}"/></span>
<span class="succ succ_tel"><fmt:message key="ok" bundle="${bundle}"/></span>
</div>
<div><input  style="background:url(images/reg.png) no-repeat left top; width:143px; height:33px; border:0; margin-left:150px; cursor:pointer;" type="button" name="sub"/></div>
</form>
</div>

<div id="register-teacher">
<form name="register-teacher" action="/translation/escape/servlet/ThRegisterServlet" method="post">
<input type="hidden" name="formnum01" value=formnum>
<!-- 防止表单重复提交标签 -->
<input type="hidden" name="thtoken" value="<zhw:token key="thtoken"/>"/>
<div>
<label for="tzhuce_user">用 户 名：</label><input id="tzhuce_user" name="zhuce_user" type="text" />
<span class="info info_user">请输入用户名，4~20 位，由字母、数字和下划线组成！</span>
<span class="error error_user">输入不合法，请重新输入！</span>
<span class="succ succ_user">可用</span>
<span class="user_wait"></span>
<span class="error error_repeat">此用户名已被注册！</span>
</div>
<div>
<label for="tzhuce_mima">密　　码：</label><input id="tzhuce_mima" name="zhuce_mima" type="password" />
<span class="info info_pass">
<p>安全级别：<strong class="anquan anquan1">■</strong><strong class="anquan anquan2">■</strong><strong class="anquan anquan3">■</strong></strong><strong class="anquan anquan4" style="font-weight:normal;"></strong></p>
<p><strong class="quan1" style="font-weight:normal;">○</strong> 6-20 个字符</p>
<p><strong class="quan2" style="font-weight:normal;">○</strong> 只能包含大小写字母、数字和非空格字符</p>
<p><strong class="quan3" style="font-weight:normal;">○</strong>  大、小写字母、数字、非空字符，2种以上</p>
</span>
<span class="error error_pass">输入不合法，请重新输入！</span>
<span class="succ succ_pass">可用</span>
</div>
<div>
<label for="tquerenmima">确认密码：</label><input id="tquerenmima" name="querenmima" type="password" />
<span class="info info_sure">请再一次输入密码！</span>
<span class="error error_sure">密码不一致，请重新输入！</span>
<span class="succ succ_sure">可用</span>
</div>
<div>
<label>性　　别：</label><label class="sex" for="men">男</label><input name="sex" id="men" type="radio" checked="checked" value="男" /><label class="sex" for="female">女</label><input name="sex" id="female" type="radio" value="女" />
</div>
<div>
<label for="teducation_bg">从教经验：</label><select id="teducation_bg" name="education_bg">
<option value="0">- - - - 请选择 - - - -</option>
<option value="三个月">- - - - 三个月 - - - -</option>
<option value="六个月">- - - - 六个月 - - - -</option>
<option value="一年">- - - - 一　年 - - - -</option>
<option value="两年">- - - - 两　年 - - - -</option>
<option value="三年">- - - - 三　年 - - - -</option>
<option value="三年以上">- - - - 三年以上  - - -</option>
</select>
<span class="error error_bg">请选择学历！</span>
</div>
<div>
<label for="teach-which">教授语言：</label><select id="teach-which" name="teach-which" >
<option value="0">- - - - 请选择 - - - -</option>
<option value="俄语">- - - - 俄　语 - - - -</option>
<option value="китайский">- - - - 中　文 - - - -</option>
</select>
<span class="error error_tw">请选择教授语言！</span>
</div>
<div>
<label for="tgraduate">毕业院校：</label><input id="tgraduate" name="graduate" type="text" />
<span class="info info_ans">请输入毕业院校，2~32 位！</span>
<span class="error error_ans">输入不合法，请重新输入！</span>
<span class="succ succ_ans">可用</span>
</div>
<div>
<label for="tzhuce_email">电子邮件：</label><input id="tzhuce_email" name="zhuce_email" type="text" autocomplete="off" />
	<ul class="all_email">
      	<li><span></span>@qq.com</li>
		<li><span></span>@163.com</li>
		<li><span></span>@sohu.com</li>
		<li><span></span>@sina.com.cn</li>
		<li><span></span>@gmail.com</li> 
            <li><span></span>@126.com</li> 
	</ul>
<span class="info info_email">请输入电子邮件！</span>
<span class="error error_email">邮件不合法，请重新输入！</span>
<span class="succ succ_email">可用</span>
</div>
<div>
<label for="ttel-num">手机号码：</label><input id="ttel-num" name="tel-num" type="tel" />
<span class="info info_tel">请输入手机号码！</span>
<span class="error error_tel">号码不合法，请重新输入！</span>
<span class="succ succ_tel">可用</span>
</div>
<div>
<label for="tbirthday">生　　日：</label><select style="width:80px;" id="tbirthday" name="year">
<option value="0">- 年-</option>
</select> -
<select style="width:80px;" name="month">
<option value="0">- 月-</option>
</select> -
<select style="width:80px;"  name="day">
<option value="0">- 日-</option>
</select>
<span class="error error_birth">请填写出生日期入！</span>
</div>
<div style="margin-bottom:0;">
<label style="vertical-align:65px;" for="tbeizhu">个人简介：</label><textarea style="width:360px; height:80px;border:1px solid #ccc; resize:none;" id="tbeizhu" name="beizhu"></textarea>
</div>
<p class="word_count" style="margin:10px 0;">还能输入<span style="color:black; font-weight:bold; font-size:16px;">200</span>字</p>
<p class="word_over" style="display:none;margin:10px 0;">已超出<span style="color:red;font-weight:bold; font-size:16px;"></span>字　<span style="color:blue; cursor:pointer;">清理</span></p>
<div><input  style="background:url(images/reg.png) no-repeat left top; width:143px; height:33px; border:0; margin-left:150px; cursor:pointer;" type="button" name="sub"/></div>
</form>
</div>
</div>
<div style="clear:both;"></div>
    <div id="footer">
      <p><a href="faq.html"><fmt:message key="faq" bundle="${bundle}"/></a> | <a href="mailto:netservice@bk.ru"><fmt:message key="feedback" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="openplatform" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="sitemap" bundle="${bundle}"/></a><br />
        <a href="#"><fmt:message key="partner" bundle="${bundle}"/></a> | <a href="javascript:alert('по вопросам работы у нас просим звонить\nна: 89141949263\nskype: rualvi')"><fmt:message key="jobopportunities" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="legalnotices" bundle="${bundle}"/></a><br />
            <fmt:message key="copyright" bundle="${bundle}"/>| <a href="#"><fmt:message key="teamprofile" bundle="${bundle}"/></a> | <a href="/translation/shasha/login.html"><fmt:message key="manage" bundle="${bundle}"/></a> </p>
    </div>
  </div>
</div>
<!--主体外布局-->
<div class="login_box">
  <h1 id="tuodong"><fmt:message key="userlogin" bundle="${bundle}"/><img src="images/close.png" alt="关闭" title="关闭" width="14" height="14" /></h1>
  <form name="login" action="/russian/servlet/AuthServlet" method="post">
    <div>
      <label for="login_user"><fmt:message key="name" bundle="${bundle}"/></label>
      <input class="login_text" id="login_user" name="login_user" type="text" />
    </div>
    <div>
      <label for="login_pass"><fmt:message key="password" bundle="${bundle}"/></label>
      <input class="login_text" id="login_pass" name="login_pass" type="password" />
    </div>
    <div>
      <input class="login_butt" name="sub" type="button" />
      <p><a href="getque.html"><fmt:message key="forgotpassword" bundle="${bundle}"/></a> | <a href="register.html"><fmt:message key="signupfree" bundle="${bundle}"/></a></p>
    </div>
    <div class="login_wait"></div>
  </form>
</div>
<div id="screen"></div>
<div id="back_top">返回顶部</div>
</body>
</html>
