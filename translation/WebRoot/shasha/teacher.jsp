<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蜕变网-导师目录</title>
<link rel="shortcot icon" href="images/favicon.ico"/>
<link href="base.css" rel="stylesheet" />
<link href="css/training.css" rel="stylesheet" />
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/lianzhui.js"></script>
<script type="text/javascript" src="js/lianzhui_drag.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<!--[if lt IE 7]>
<script type="text/javascript" src="js/ltIE7hack.js"></script>
<![endif]-->
<script type="text/javascript" src="js/kuangjia.js"></script>
<script type="text/javascript" src="js/training.js"></script>
</head>

<body id="teacher_list">
<div id="main_box">
  <div id="main_center_box">
    <div id="header">
      <div class="logo"><img src="images/logo.png" alt="梦翔网" /></div>
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
    <div class="secondary">
    <h2><fmt:message key="niceteacher" bundle="${bundle}"/></h2>
    
    <div class="study-dir">
     <div class="besttea">
    <a href="/translation/shasha/teacherCenter.html?id=${first.id}&username=${first.username}" alt="优秀老师">
    <c:if test="${first.photo ne null}">
      		<img class="touxiang" src="../${first.photo}"  width="200" height="200"/> 
       	</c:if>
       	<c:if test="${first.photo eq null}">
       	 	<img class="touxiang" src="images/default.jpg" /> 
       	</c:if>
    <img class="huangguan" src="images/niceteacher.png" /></a>
    </div>
    </div>
    </div>
    <div class="primary">
    <div class="ad">
    <ul>
    <c:forEach items="${advert}" var="str" >
		<c:if test="${str.id eq 1}">
			<li><a href="${str.url} "><img <c:if test="${str.filePath ne null}">src="../${str.filePath}"</c:if>  <c:if test="${str.filePath eq null}">src="images/ad1.jpg"</c:if> alt="广告1" width="670" height="300" title="广告1"/></a></li>
		</c:if>
		<c:if test="${str.id eq 2}">
			<li><a href="${str.url} "><img <c:if test="${str.filePath ne null}">src="../${str.filePath}"</c:if>  <c:if test="${str.filePath eq null}">src="images/ad2.jpg"</c:if> alt="广告2" width="670" height="300" title="广告2"/></a></li>
		</c:if>
		<c:if test="${str.id eq 3}">
			<li><a href="${str.url} "><img <c:if test="${str.filePath ne null}">src="../${str.filePath}"</c:if>  <c:if test="${str.filePath eq null}">src="images/ad3.jpg"</c:if> alt="广告3" width="670" height="300" title="广告3"/></a></li>
		</c:if>
		<c:if test="${str.id eq 4}">
			<li><a href="${str.url} "><img <c:if test="${str.filePath ne null}">src="../${str.filePath}"</c:if>  <c:if test="${str.filePath eq null}">src="images/ad4.jpg"</c:if> alt="广告4" width="670" height="300" title="广告4"/></a></li>
		</c:if>
		<c:if test="${str.id eq 5}">
			<li><a href="${str.url} "><img <c:if test="${str.filePath ne null}">src="../${str.filePath}"</c:if>  <c:if test="${str.filePath eq null}">src="images/ad5.jpg"</c:if> alt="广告5" width="670" height="300" title="广告5"/></a></li>
		</c:if>
	</c:forEach>
    </ul>
    <strong class="lt">&lt;</strong>
    <strong class="gt">&gt;</strong>
    </div>
    </div>
    <div class="list">
    <h2 class="list-h2"><fmt:message key="teacherlist" bundle="${bundle}"/></h2>
    <c:forEach var="str" items="${page.list}">
    <div class="list-box">
    <dl>
    <dt>
    <a href="/translation/shasha/teacherCenter.html?id=${str.id}&username=${str.username}" title="${str.name}">
     	<c:if test="${str.photo ne null}">
      		<img src="../${str.photo}" alt="${str.name}" title="${str.name}"/> 
       	</c:if>
       	<c:if test="${str.photo eq null}">
       	 	<img src="images/default.jpg" alt="${str.name}" title="${str.name}"/> 
       	</c:if>
    </a>
    </dt>
    <dd>
    <p><fmt:message key="teachername" bundle="${bundle}"/>：${str.name}</p>
    <p><fmt:message key="graduate" bundle="${bundle}"/>： ${str.college}</p>
    <p><fmt:message key="canspeak" bundle="${bundle}"/>：${str.language}</p>
    <p><fmt:message key="experience" bundle="${bundle}"/>：${str.education}</p>
    </dd>
    </dl>
    </div>
     </c:forEach>
    <ol class="pagination">
	    <li><a href="/translation/shasha/teacher.html?num=1" rel="first">首 页</a></li>
	    <c:if test="${page.num eq 1}">
	    <li><a rel="prev"><fmt:message key="theend" bundle="${bundle}"/></a></li>
	    </c:if>
	    <c:if test="${page.num gt 1}">
	    <li><a href="/translation/shasha/teacher.html?num=${page.num -1}" rel="prev"><fmt:message key="prv" bundle="${bundle}"/></a></li>
	    </c:if>
	    <c:forEach begin="${page.begin}" end="${page.end}" var="str">
	        <li><a href="/translation/shasha/teacher.html?num=${str}"  <c:if test="${page.num eq str}"> class="slected"   </c:if>>${str}</a></li>
	    </c:forEach>
	    <c:if test="${page.pageCount gt page.num}">
	    <li><a href="/translation/shasha/teacher.html?num=${page.num+1}" rel="next"><fmt:message key="next" bundle="${bundle}"/></a></li>
	    </c:if>
	    <c:if test="${page.pageCount eq page.num}">
	    <li><a rel="next"><fmt:message key="theend" bundle="${bundle}"/></a></li>
	    </c:if>
	    <li><a href="/translation/shasha/teacher.html?num=${page.pageCount}" rel="last">尾 页</a></li>
	    <strong>[共${page.pageCount}页]</strong>
    </ol>
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
 <c:forEach items="${advert}" var="str" >
		<c:if test="${str.id eq 6}">
		<div id="guanggaoleft" class="xuanfyguanggao">
			<a href="${str.url} "><img <c:if test="${str.filePath ne null}">src="../${str.filePath}"</c:if>  <c:if test="${str.filePath eq null}">src="images/13667097651.jpg"</c:if> /></a>
			<img src="images/clo.jpg" class="guanbi" alt="关闭" title="关闭" />
			</div>
		</c:if>
		<c:if test="${str.id eq 7}">
			<div id="guanggaoright" class="xuanfyguanggao">
			<a href="${str.url} "><img <c:if test="${str.filePath ne null}">src="../${str.filePath}"</c:if>  <c:if test="${str.filePath eq null}">src="images/adsmall.jpg"</c:if> /></a>
			<img src="images/clo.jpg" class="guanbi" alt="关闭" title="关闭" />
			</div>
		</c:if>
</c:forEach>
<div id="screen"></div>
<div id="back_top">返回顶部</div>
</body>
</html>
