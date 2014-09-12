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
<title>蜕变网-资源共享</title>
<link href="base.css" rel="stylesheet" />
<link href="css/download.css" rel="stylesheet" />
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
  var timer;
	$('.news-page table tbody tr').hover(function(){
		$(this).css('background','url(images/dfsdf.png) repeat-x left top');
    var _this=this;
    $(this).bind('mousemove',func)
    timer=setTimeout(function(){
        $('#file-info h3').html($(_this).find('.filename').text());
        $('#file-info p').html($(_this).find('.miaoshu').text());
        $('#file-info').show();

    },300);
    
		},function(){
		$(this).css('background','none');
    clearTimeout(timer);
    $('#file-info').hide();
    removeEvent(this,'mousemove',func);
			});

  function func(e){
      var x= e.clientX+(document.documentElement.scrollLeftLeft||document.body.scrollLeft);
      var y= e.clientY+(document.documentElement.scrollTop||document.body.scrollTop)
        $('#file-info').css('left',x-100+'px').css('top',y+20+'px');
    }
	/*$('.xuanfyguanggao .guanbi').click(function(){
		$(this.parentNode).hide();
		})*/
	
	});
</script>
</head>

<body id="news">
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
      <div class="news-page">
      <div class="touming"></div>
        <table summary="莎莎新闻资讯列表">
          <caption>
         蜕变网资源列表
          </caption>
          <thead>
            <tr>
              <th scope="col" width="80"> 编号 </th>
              <th scope="col" width="200"> 文件名 </th>
              <th scope="col" width="300"> 文件描述 </th>
              <th scope="col" width="130"> 上传时间 </th>
              <th scope="col" width="80"></th>

            </tr>
          </thead>
          <tbody>
          <c:forEach var="num" items="${page2.list}">
            <tr>
                  <td>${num.id }</td>
                  <td class="filename"><p>${num.realname }</p></td>
                  <td class="miaoshu"><p>${num.description }</p></td>
                  <td align="center">${num.date}</td>
                  <td><a href="/translation/servlet/DownFileServlet?id=${num.id}">下载</a></td>
              </tr>
              </c:forEach>
          </tbody>
        </table>
        
        <!-- <div style="text-align:center">
  当前第[${page2.pagenum}]页
  <c:forEach var="pagenum" begin="${page2.forEachBegin }" end="${page2.forEachEnd}">
  	[<a href="/translation/shasha/backstage/file.html?pagenum=${pagenum}"><b>${pagenum}</b></a>]&nbsp;
  </c:forEach>
  &nbsp;总页数[${page2.totalpage}]&nbsp;总记录数[${page2.totalrecord}]
  </div>
         -->
        <ol class="pagination">
          	<li><a href="/translation/shasha/listallfile.html?pagenum=1" rel="first">首页</a></li>
		    <c:if test="${page2.pagenum eq 1}">
		    <li><a rel="prev">到头了</a></li>
		    </c:if>
		    <c:if test="${page2.pagenum gt 1}">
		    <li><a href="/translation/shasha/listallfile.html?pagenum=${page2.pagenum -1}" rel="prev">上一页</a></li>
		    </c:if>
		    <c:forEach begin="${page2.forEachBegin}" end="${page2.forEachEnd}" var="pagenum">
		        <li><a href="/translation/shasha/listallfile.html?pagenum=${pagenum}"  <c:if test="${page2.pagenum eq pagenum}"> class="slected"   </c:if>>${pagenum}</a></li>
		    </c:forEach>
		    <c:if test="${page2.totalpage gt page2.pagenum}">
		    <li><a href="/translation/shasha/listallfile.html?pagenum=${page2.pagenum+1}" rel="next">下一页</a></li>
		    </c:if>
		    <c:if test="${page2.totalpage eq page2.pagenum}">
		    <li><a rel="next">到尾了</a></li>
		    </c:if>
		    <li><a href="/translation/shasha/listallfile.html?pagenum=${page2.totalpage}" rel="last">尾 页</a></li>
          <strong>[共${page2.totalpage}页]</strong>
        </ol>
       
    </div>
    </div>
     <div id="footer">
      <p><a href="faq.html"><fmt:message key="faq" bundle="${bundle}"/></a> | <a href="mailto:netservice@bk.ru"><fmt:message key="feedback" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="openplatform" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="sitemap" bundle="${bundle}"/></a><br />
        <a href="#"><fmt:message key="partner" bundle="${bundle}"/></a> | <a href="javascript:alert('по вопросам работы у нас просим звонить\nна: 89141949263\nskype: rualvi')"><fmt:message key="jobopportunities" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="legalnotices" bundle="${bundle}"/></a><br />
            <fmt:message key="copyright" bundle="${bundle}"/>| <a href="#"><fmt:message key="teamprofile" bundle="${bundle}"/></a> | <a href="/translation/shasha/login.html"><fmt:message key="manage" bundle="${bundle}"/></a> </p>
    </div>
  </div>
</div>

<!--主体外布局-->
<div id="file-info">
  <h3>asfdas</h3>
  <p>asdasd</p>
</div>
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
<!--<div  class="xuanfyguanggao guanggaoleft"><a href="#"><img src="images/13667097651.jpg"/></a><img src="images/clo.jpg" class="guanbi" alt="关闭" title="关闭" /></div>
<div class="xuanfyguanggao guanggaoright"><a href="#"><img src="images/adsmall.jpg"/></a><img src="images/clo.jpg" class="guanbi" alt="关闭" title="关闭"/></div>
<div style="top:330px" class="xuanfyguanggao guanggaoleft"><a href="#"><img src="images/13667097651.jpg"/></a><img src="images/clo.jpg" class="guanbi" alt="关闭" title="关闭" /></div>
<div style="top:330px" class="xuanfyguanggao guanggaoright"><a href="#"><img src="images/adsmall.jpg"/></a><img src="images/clo.jpg" class="guanbi" alt="关闭" title="关闭"/></div>
-->
<div id="screen"></div>
<div id="back_top">返回顶部</div>
</body>
</html>