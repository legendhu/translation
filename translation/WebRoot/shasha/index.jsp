<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蜕变网-首页</title>
<link href="base.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet"/>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/lianzhui.js"></script>
<script type="text/javascript" src="js/lianzhui_drag.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<!--[if lt IE 7]>
<script type="text/javascript" src="js/ltIE7hack.js"></script>
<![endif]-->
<script type="text/javascript" src="js/kuangjia.js"></script>
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
  <div class="banner">
    <div class="user-number">
          <dl>
            <dt><a href="#" title="<fmt:message key="stregister" bundle="${bundle}"/>" style="background-position:0 0;"></a><strong>${countst}</strong></dt>
            <dd><fmt:message key="stregister" bundle="${bundle}"/></dd>
          </dl>
          <dl>
            <dt><dt><a href="#" title="<fmt:message key="thregister" bundle="${bundle}"/>"></a><strong>${countth}</strong></dt></dt>
            <dd><fmt:message key="thregister" bundle="${bundle}"/></dd>
          </dl>
        </div>
      <!--  <div class="banner_anniu1"> <a href="teacher.html"><fmt:message key="tolearn" bundle="${bundle}"/></a> </div>
      <div class="banner_anniu2"> <a href="register.html"><fmt:message key="toteach" bundle="${bundle}"/></a> </div>
    -->
    </div>
    <!--内容-->
    
    <div id="footer">
    
      <p><a href="faq.html"><fmt:message key="faq" bundle="${bundle}"/></a> | <a href="mailto:netservice@bk.ru"><fmt:message key="feedback" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="openplatform" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="sitemap" bundle="${bundle}"/></a><br />
        <a href="#"><fmt:message key="partner" bundle="${bundle}"/></a> | <a href="javascript:alert('по вопросам работы у нас просим звонить\nна: 89141949263\nskype: rualvi')"><fmt:message key="jobopportunities" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="legalnotices" bundle="${bundle}"/></a><br />
            <fmt:message key="copyright" bundle="${bundle}"/>| <a href="#"><fmt:message key="teamprofile" bundle="${bundle}"/></a> | <a href="login.html"><fmt:message key="manage" bundle="${bundle}"/></a> </p>
			
    </div>
  </div>
</div>
<!--主体外布局-->
<div class="login_box">
  <h1 id="tuodong"><fmt:message key="userlogin" bundle="${bundle}"/><img src="images/close.png" alt="关闭" title="关闭" width="14" height="14" /></h1>
  <form name="login" action="escape/servlet/AuthServlet" method="post">
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

<!-- 分享 -->
<!-- Baidu Button BEGIN -->
<script type="text/javascript" id="bdshare_js" data="type=slide&amp;img=2&amp;pos=left&amp;uid=6826255" ></script>
<script type="text/javascript" id="bdshell_js"></script>
<script type="text/javascript">
var bds_config={"bdTop":163};
document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000);
</script>
<!-- Baidu Button END -->


<!-- BEGIN JIVOSITE CODE {literal} -->
 <script type='text/javascript'>
 (function(){ var widget_id = '107446';
 var s = document.createElement('script'); s.type = 'text/javascript'; s.async = true; s.src = '//code.jivosite.com/script/widget/'+widget_id; var ss = document.getElementsByTagName('script')[0]; ss.parentNode.insertBefore(s, ss);})();</script>
 <!-- {teral} END JIVOSITE CODE -->

</body>
</html>
