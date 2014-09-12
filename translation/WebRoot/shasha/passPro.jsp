<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>找回密码</title>
<link href="base.css" rel="stylesheet" />
<link href="css/passPro.css" rel="stylesheet" />
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
	//修改密码
	$('.xiugaimimaform .xiugaitijiao').hover(function(){
			$(this).css('background','url(images/anniu2.png) no-repeat left top');
		},function(){
			$(this).css('background','url(images/anniu1.png) no-repeat left top');
		});		
		
	//密码验证

	$("form").getForm('xiugaimimaform').form("gaihoumima").bind("focus",function(){
		$(".xiugaimimaform .info_pass").show();
		$(".xiugaimimaform .succ_pass").hide();
		$(".xiugaimimaform .error_pass").hide();
	}).bind("blur",function(){
		if($("form").getForm('xiugaimimaform').form("gaihoumima").value()==""){
			$(".xiugaimimaform .info_pass").hide();
			$(".xiugaimimaform .succ_pass").hide();
			$(".xiugaimimaform .error_pass").hide();
		}else if(checkUp()){
			$(".xiugaimimaform .info_pass").hide();
			$(".xiugaimimaform .succ_pass").show();
			$(".xiugaimimaform .error_pass").hide();
		}else{
			$(".xiugaimimaform .info_pass").hide();
			$(".xiugaimimaform .succ_pass").hide();
			$(".xiugaimimaform .error_pass").show();
			}
		
			
				});
				
	function checkUp(){
		var value=$("form").getForm('xiugaimimaform').form("gaihoumima").value();
		var length=value.length;
		var code_length=0;
		//6-20 个字符
		if(length>=6&&length<=20){
			$(".xiugaimimaform .quan1").html("●").css("color","green")
		}else{
			$(".xiugaimimaform .quan1").html("○").css("color","#666")
		}
		//只能包含大小写字母、数字和非空格字符
		if(length>0&&!/\s/.test(value)){
			$(".xiugaimimaform .quan2").html("●").css("color","green")
		}else{
			$(".xiugaimimaform .quan2").html("○").css("color","#666")	
				}
		// 大、小写字母、数字、非空字符，2种以上
		if(/[\d]/.test(value)){
			code_length++
			}	
		if(/[a-z]/.test(value)){
			code_length++
			}
		if(/[A-Z]/.test(value)){
			code_length++
			}
		if(/[^0-9a-zA-Z]/.test(value)){
			code_length++
			}
		if(code_length>=2){
			$(".xiugaimimaform .quan3").html("●").css("color","green")
		}else{
			$(".xiugaimimaform .quan3").html("○").css("color","#666")	
				}	
		//安全级别
		if(code_length>=3&&length>=10){
			$(".xiugaimimaform .anquan1").css("color","green");
			$(".xiugaimimaform .anquan2").css("color","green");
			$(".xiugaimimaform .anquan3").css("color","green");
			$(".xiugaimimaform .anquan4").html("高").css("color","green");
		}else if(code_length>=2&&length>=8){
			$(".xiugaimimaform .anquan1").css("color","#f60");
			$(".xiugaimimaform .anquan2").css("color","#f60");
			$(".xiugaimimaform .anquan3").css("color","#ccc");
			$(".xiugaimimaform .anquan4").html("中").css("color","#f60");
		}else if(length>=1){
			$(".xiugaimimaform .anquan1").css("color","maroon");
			$(".xiugaimimaform .anquan2").css("color","#ccc");
			$(".xiugaimimaform .anquan3").css("color","#ccc");
			$(".xiugaimimaform .anquan4").html("低").css("color","maroon");
		}else{
			$(".xiugaimimaform .anquan1").css("color","#ccc");
			$(".xiugaimimaform .anquan2").css("color","#ccc");
			$(".xiugaimimaform .anquan3").css("color","#ccc");
			$(".xiugaimimaform .anquan4").html("").css("color","#ccc");		
			}
			if(length>=6&&length<=20&&!/\s/.test(value)&&code_length>=2){
			return true;
			}
			return false;
		}
	$("form").getForm('xiugaimimaform').form("gaihoumima").bind("keyup",checkUp);	
			
	//确认密码
	
	$("form").getForm('xiugaimimaform').form("querengaihoumima").bind("focus",function(){
		$(".xiugaimimaform .info_sure").show();
		$(".xiugaimimaform .succ_sure").hide();
		$(".xiugaimimaform .error_sure").hide();
		}).bind("blur",function(){
			if($("form").getForm('xiugaimimaform').form("querengaihoumima").value()==""){
				$(".xiugaimimaform .info_sure").hide();
				}else if($("form").getForm('xiugaimimaform').form("querengaihoumima").value()==$("form").getForm('xiugaimimaform').form("gaihoumima").value()){
				$(".xiugaimimaform .info_sure").hide();
				$(".xiugaimimaform .succ_sure").show();
				$(".xiugaimimaform .error_sure").hide();
			}else{
				$(".xiugaimimaform .info_sure").hide();
				$(".xiugaimimaform .succ_sure").hide();
				$(".xiugaimimaform .error_sure").show();
				}
			});		
	//确认修改
	$(".xiugaimimaform .xiugaitijiao").click(function(){
		var flag=true;
		if(!checkUp()){
			flag=false;
			$(".xiugaimimaform .error_pass").show()
			}
		if($("form").getForm('xiugaimimaform').form("querengaihoumima").value()!=$("form").getForm('xiugaimimaform').form("gaihoumima").value()){
			flag=false;
			$(".xiugaimimaform .error_sure").show();
			}
		if(flag){
			document.forms.xiugaimimaform.submit();
			removeEvent(this,'click',arguments.callee)
		}
		
		});	
	});
</script>
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
      <div class="xiugaimima">
          <h2>修改密码</h2>
          <form name="xiugaimimaform" class="xiugaimimaform" action="/translation/front/servlet/ProPassServlet" method="post">
            <div>
              <label for="gaihoumima"><fmt:message key="newpass" bundle="${bundle}"/></label>
              <input id="gaihoumima" name="gaihoumima" type="password" value=""/>
              <span class="info info_pass">
              <p><fmt:message key="level" bundle="${bundle}"/><strong class="anquan anquan1">■</strong><strong class="anquan anquan2">■</strong><strong class="anquan anquan3">■</strong></strong><strong class="anquan anquan4" style="font-weight:normal;"></strong></p>
              <p><strong class="quan1" style="font-weight:normal;">○</strong> <fmt:message key="char" bundle="${bundle}"/></p>
              <p><strong class="quan2" style="font-weight:normal;">○</strong> <fmt:message key="just" bundle="${bundle}"/></p>
              <p><strong class="quan3" style="font-weight:normal;">○</strong> <fmt:message key="more" bundle="${bundle}"/></p>
              </span> <span class="error error_pass"><fmt:message key="illegal" bundle="${bundle}"/></span> <span class="succ succ_pass"><fmt:message key="ok" bundle="${bundle}"/></span> </div>
            <div>
              <label for="querengaihoumima"><fmt:message key="confirmpassword" bundle="${bundle}"/></label>
              <input id="querengaihoumima" name="querengaihoumima" type="password" value=""/>
              <span class="info info_sure"><fmt:message key="again" bundle="${bundle}"/></span>
<span class="error error_sure"><fmt:message key="again" bundle="${bundle}"/></span>
<span class="succ succ_sure"><fmt:message key="ok" bundle="${bundle}"/></span>
            </div>
            <div class="queren-box">
              <input type="button" name="xiugaitijiao" class="xiugaitijiao" value="<fmt:message key="submit" bundle="${bundle}"/>"/>
            </div>
          </form>
          <div class="xiugai_wait"></div>
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
