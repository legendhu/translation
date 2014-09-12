<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蜕变网-常见问题</title>
<link href="base.css" rel="stylesheet" />
<link href="css/faq.css" rel="stylesheet" />
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/lianzhui.js"></script>
<script type="text/javascript" src="js/lianzhui_drag.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<!--[if lt IE 7]>
<script type="text/javascript" src="js/ltIE7hack.js"></script>
<![endif]-->
<script type="text/javascript" src="js/kuangjia.js"></script>
<script>
addEvent(window,"load",function(){
	$('.faq-box').opacityChange({target:100,type:1,t:50,speed:20});
//position为fixed的元素offsetParent是body，而ie的offsetparent是null，所以用getPosition（）获取偏移值时有误，所以我们采用两个广告相互切换
	var box_h=getPosition($('.ding').elements[0]).top;
	fn();
	$(window).bind('resize',function(){
		setInterval(fn,100);
		})
	$(window).bind('scroll',fn)
	function fn(){
		var h=document.documentElement.scrollTop||document.body.scrollTop;
		var l=getPosition($('.ding').elements[0]).left;
		if(box_h<h){
			
			
			$('.dong').css('left',getPosition($('.ding').elements[0]).left+'px').show();
			if(h+$('.dong').elements[0].offsetHeight>document.documentElement.scrollHeight-$('#footer').elements[0].offsetHeight){
			$('.dong').hide();
			}
			
			}else{
				$('.dong').hide();
				
				}
				
}
});
</script>
</head>

<body id="faq">
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
 <!--广告-->
 <c:forEach items="${advert}" var="str" >
	<c:if test="${str.id eq 12}">
    <div class="xuanfyguanggao ding">
    <a href="${str.url} "><img <c:if test="${str.filePath ne null}">src="../${str.filePath}"</c:if>  <c:if test="${str.filePath eq null}">src="images/13667097651.jpg"</c:if> /></a></div>
    </c:if>
    <c:if test="${str.id eq 12}">
    <div class="xuanfyguanggao dong">
    <a href="${str.url} "><img <c:if test="${str.filePath ne null}">src="../${str.filePath}"</c:if>  <c:if test="${str.filePath eq null}">src="images/13667097651.jpg"</c:if> /></a></div>
    </c:if>
 </c:forEach>
    <ul class="faq-box">
    <h2 class="faqh2"><fmt:message key="faq" bundle="${bundle}"/></h2>
    <c:forEach var="str" items="${faq}">
    <li class="que-an">
    <h2 class="que">
	
	${str.title}
    </h2>
    <p class="an">
   ${str.content}
    </p>
    </li>
    </c:forEach>
    </ul>
    </div>
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
