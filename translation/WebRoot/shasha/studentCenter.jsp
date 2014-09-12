<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蜕变网-学生个人中心</title>
<link rel="shortcot icon" href="images/favicon.ico"/>
<link href="base.css" rel="stylesheet" />
<link href="css/studentCenter.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/lianzhui.js"></script>
<script type="text/javascript" src="js/lianzhui_drag.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<!--[if lt IE 7]>
<script type="text/javascript" src="js/ltIE7hack.js"></script>
<![endif]-->
<script type="text/javascript" src="js/kuangjia.js"></script>
<script type="text/javascript" src="js/studentCenter.js"></script>
</head>

<body>
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
      <div class="self-info-box">
        <div class="self-info">
          <div class="head-phto"> 
          	 <c:if test="${info.photo ne null}">
         	 <img src="../${info.photo}" alt="${info.name}" title="${info.name}"/> 
          	</c:if>
          	<c:if test="${info.photo eq null}">
          	 <img src="images/default.jpg" alt="${info.name}" title="${info.name}"/> 
          	</c:if>
          </div>
        </div>
      </div>
      <c:if test="${sessionScope.type eq '0' and sessionScope.auth ne null}">
      <div class="info-show">
        <div class="self-info-nav">
          <h2><fmt:message key="options" bundle="${bundle}"/></h2>
          <ul class="self-info-put">
            <li><fmt:message key="selfinfo" bundle="${bundle}"/></li>
            <li><fmt:message key="avatar" bundle="${bundle}"/></li>
            <li><fmt:message key="chpass" bundle="${bundle}"/></li>
            <li><fmt:message key="protection" bundle="${bundle}"/></li>
          </ul>
        </div>
        
       
        <!--个人信息-->
        <div class="gerenxinxi card">
          <h2><fmt:message key="selfinfo" bundle="${bundle}"/></h2>
          <div id="gerenxinxi-box">
            <form name="register-teacher" action="/translation/front/servlet/ChangeCenterInfoServlet" method="post">
            <div>
                <label for="truename"><fmt:message key="realname" bundle="${bundle}"/></label>
                <input id="truename" name="truename" type="text" value="${info.name}"/>
	</div>
              <div>
                <label for="tzhuce_email"><fmt:message key="email" bundle="${bundle}"/></label>
                <input id="tzhuce_email" name="zhuce_email" type="text" autocomplete="off" value="${info.email}"/>
                <ul class="all_email">
                  <li><span></span>@qq.com</li>
                  <li><span></span>@163.com</li>
                  <li><span></span>@sohu.com</li>
                  <li><span></span>@sina.com.cn</li>
                  <li><span></span>@gmail.com</li>
                  <li><span></span>@126.com</li>
                </ul>
                <span class="info info_email"><fmt:message key="enteremail" bundle="${bundle}"/></span><span class="error error_email"><fmt:message key="illegal" bundle="${bundle}"/></span> <span class="succ succ_email"><fmt:message key="ok" bundle="${bundle}"/></span> </div>
              <div>
                <label for="ttel-num"><fmt:message key="tel" bundle="${bundle}"/></label>
                <input id="ttel-num" name="tel-num" type="tel" value="${info.tel}" />
                <span class="info info_tel"><fmt:message key="entertel" bundle="${bundle}"/></span> <span class="error error_tel"><fmt:message key="illegal" bundle="${bundle}"/></span> <span class="succ succ_tel"><fmt:message key="ok" bundle="${bundle}"/></span> </div>
              <div>
                <input  style="background:url(images/anniu1.png) no-repeat left top; width:102px; height:42px; border:none; margin-left:190px; cursor:pointer; font:bold 18px/42px '微软雅黑'; color:#fff;" type="button" name="sub" value="<fmt:message key="submit" bundle="${bundle}"/>"/>
              </div>
            </form>
          </div>
        </div>
        <!--修改头像-->
       <div class="xiugaitouxiang card">
          <iframe name="iframe1" style="display:none;" frameborder="0" scrolling="no"></iframe>
          <h2><fmt:message key="avatar" bundle="${bundle}"/></h2>
          <div id="head-photo-see">
           <c:if test="${info.photo ne null}">
         	 <img  id="himage1" src="../${info.photo}" alt="${info.name}" title="${info.name}"/> 
          	</c:if>
          	<c:if test="${info.photo eq null}">
          	 <img id="himage1"  src="images/default.jpg" alt="${info.name}" title="${info.name}"/> 
          	</c:if>
          </div>
          <form class="photo-send" name="photo-send" action="/translation/front/servlet/ViewHeadServlet" target="iframe1" method="post" enctype="multipart/form-data">
            <div class="xiugai-input" style="position:relative;">
              <input name="selected-photo" id="selected-photo" type="file"/>
              <input class="" type="button" value="<fmt:message key="select" bundle="${bundle}"/>"/>
              <p><fmt:message key="avatarinfo" bundle="${bundle}"/> </p>
            </div>
            <div class="xiugai-input">
              <input type="button" id="touxiangfasong" value="<fmt:message key="submit" bundle="${bundle}"/>" />
              <input type="button" id="fasongquxiao" value="<fmt:message key="cancel" bundle="${bundle}"/>" />
            </div>
          </form>
        </div>
        <!--修改密码-->
        <div class="xiugaimima card">
          <h2><fmt:message key="chpass" bundle="${bundle}"/></h2>
          <form name="xiugaimimaform" class="xiugaimimaform" >
            <div>
              <label for="yuashimima"><fmt:message key="nowpass" bundle="${bundle}"/></label>
              <input id="yuashimima" name="yuashimima" type="password" value=""/>
            </div>
            <div>
              <label for="gaihoumima"><fmt:message key="newpass" bundle="${bundle}"/></label>
              <input id="gaihoumima" name="gaihoumima" type="password" value=""/>
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
              <label for="querengaihoumima"><fmt:message key="confirmpassword" bundle="${bundle}"/></label>
              <input id="querengaihoumima" name="querengaihoumima" type="password" value=""/>
              <span class="info info_sure"><fmt:message key="again" bundle="${bundle}"/></span> <span class="error error_sure"><fmt:message key="illegal" bundle="${bundle}"/></span> <span class="succ succ_sure"><fmt:message key="ok" bundle="${bundle}"/></span> </div>
            <div class="queren-box">
              <input type="button" name="xiugaitijiao" class="xiugaitijiao" value="<fmt:message key="submit" bundle="${bundle}"/>"/>
            </div>
          </form>
          <div class="xiugai_wait"></div>
        </div>
        <!--设置密码保护-->
        <div class="mimabaohubox card">
          <h2><fmt:message key="protection" bundle="${bundle}"/></h2>
          <div class="mibao-box">
            <p><fmt:message key="protectioninfo" bundle="${bundle}"/></p>
            <form name="mimabaohu" class="mimabaohu" action="/translation/escape/servlet/ProtectionServlet" method="post">
              <div class="que">
                <label for="que"><fmt:message key="question" bundle="${bundle}"/></label>
                <select name="que" id="que">
                  <option value="0">- - - <fmt:message key="choice" bundle="${bundle}"/>- - -</option>
                </select>
                <span></span> </div>
              <div class="daan">
                <label for="daan"><fmt:message key="answer" bundle="${bundle}"/></label>
                <input name="daan" id="daan" type="text" value="" />
                <span></span> </div>
              <div class="mibaoqueren">
              <input type="button" name="tijiaomibao"  class="tijiaomibao"
            	<c:if test="${info.protection ne null}">value="<fmt:message key="setted" bundle="${bundle}"/>"  disabled="disabled" </c:if>
            	<c:if test="${info.protection eq null}">value="<fmt:message key="submit" bundle="${bundle}"/>"</c:if>
            	/>
              </div>
            </form>
          </div>
        </div>
        </div>
         </c:if>
        <div style="clear:both"></div>
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
