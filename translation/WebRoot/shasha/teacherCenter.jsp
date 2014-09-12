<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蜕变网-导师个人中心</title>
<link rel="shortcot icon" href="images/favicon.ico"/>
<link href="base.css" rel="stylesheet" />
<link href="css/teacherCenter.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/lianzhui.js"></script>
<script type="text/javascript" src="js/lianzhui_drag.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<!--[if lt IE 7]>
<script type="text/javascript" src="js/ltIE7hack.js"></script>
<![endif]-->
<script type="text/javascript" src="js/kuangjia.js"></script>
<c:if test="${sessionScope.type eq '1'}">
<c:if test="${sessionScope.auth eq param.username or  param.username eq null}">
<script type="text/javascript" src="js/teacherCenter.js"></script>
</c:if>
</c:if>

<c:if test="${sessionScope.auth eq null and sessionScope.type eq null}">
	<script>window.suerlogin="nolog"</script>
</c:if>

<script>
var education_in='${info.education}';
var language_in='${info.language}';
addEvent(window,"load",function(){
		var self_info_input =$(".self-info-input div");
	self_info_input.hover(function(){
		$(this).css('opacity',.7).css('filter','alpha(opacity=70)');
		},function(){
			$(this).css('opacity',1).css('filter','alpha(opacity=100)');
			});

	//点赞
	$('.nice-teacher').click(function(){
		var _this=this;		
		ajax({
			method:"post",
			async:true,
			url:"/translation/servlet/ScoreServlet?value=1&username=${param.username}&",
			success:function(req){
				if(req=='nolog'){
					$(".login_box").css("display","block").center(350,400);
					$("#screen").lock().css("display","block").opacityChange({target:30,type:1});
				}else if(req=='nostu'){
					alert('只有学生可以点赞。');
				}else if(req=='ok'){
					$(_this).find('strong').html('('+(parseInt($(_this).find('strong').html().substring(1))+1)+'个赞)');
				}else if(req=='ever'){
					alert('无法再赞该用户。');	
				}
			}
		});
	});
//点击踩
	$('.bad-teacher').click(function(){	
		ajax({
			method:"post",
			async:true,
			url:"/translation/servlet/ScoreServlet?value=0&username=${param.username}&",
			success:function(req){
				if(req=='nolog'){
					$(".login_box").css("display","block").center(350,400);
					$("#screen").lock().css("display","block").opacityChange({target:30,type:1});
				}else if(req=='nostu'){
					alert('只有学生可以点赞。');
				}else if(req=='ok'){
					$('.nice-teacher strong').html('('+(parseInt($('.nice-teacher strong').html().substring(1))-1)+'个赞)');
				}else if(req=='nocai'){
					alert('无法再踩该用户。');	
				}else if(req=='ever'){
					alert('无法再踩该用户。');
				}
			}
		});	
	});	
	//留言系统		
$(".set-message").click(function(){
	if(typeof window.suerlogin!="undefined"){
			$(".login_box").css("display","block").center(350,400);
			$("#screen").lock().css("display","block").opacityChange({target:30,type:1});
		
	}else{
	$(".liuyan-box").css("display","block").center(350,500);
	$("#screen").lock().css("display","block").opacityChange({target:30,type:1});
	}
	})	
$(".liuyan-box h1 img").click(function(){
	$(".liuyan-box").css("display","none");
	$("#screen").opacityChange({target:0,type:1,fn:function(){$("#screen").css("display","none")}});
	})	

$(window).bind("resize",function(){
	if($(".liuyan-box").css("display")=="block"){
	$(".liuyan-box").keepPosition();
	$("#screen").lock()}});
//字数
	var liuex=parseInt($(".liuyan .word_count span").html());
	$(".liuyan").form("liuyanneirong").bind("keyup",check_wordliu)
		//清空多余字
	$(".liuyan .word_over span").getElement(1).click(function(){
		$(".liuyan").form("liuyanneirong").value($(".liuyan").form("liuyanneirong").value().substring(0,liuex));
		check_wordliu();
		})
	$(".liuyan").form("liuyanneirong").bind("paste",function(){
		setTimeout(check_wordliu,50)
		});
	function check_wordliu(){
		var num=$(".liuyan").form("liuyanneirong").value().length;
		if(num<=liuex){
			$(".liuyan .word_over").css("display","none");
			$(".liuyan .word_count").css("display","block");
			$(".liuyan .word_count span").html(liuex-num);
			return true;
		}else{
			$(".liuyan .word_over").css("display","block");
			$(".liuyan .word_count").css("display","none");
			$(".liuyan .word_over span").getElement(0).html(Math.abs(liuex-num));//取绝对数
			return false;
			}
		}
	$('.liuyan .fasong').click(function(){
			if($(".liuyan").form("choisetea").value()==""){
				alert('所选老师不能为空！')
				return false;
				}
			if($(".liuyan").form("banknum").value()==""){
				alert('付款账号不能为空！')
				return false;
				}
			if($(".liuyan").form("liuyanneirong").value()==""){
				alert('留言内容不能为空！')
				return false;
				}
			if(!check_wordliu()){
				alert('超出字数限制，请清理后发出！')
				return false;
				}
			$(".liuyan").elements[0].submit();
		})
		
		$(".liuyan-box").move("liutuodong");
})
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
          <div class="self-info-input">
             <div class="nice-teacher"><strong  title="点击赞">(${info.score}<fmt:message key="like" bundle="${bundle}"/>)</strong></div>
             <div class="bad-teacher"><strong  title="点击踩">(<fmt:message key="dislike" bundle="${bundle}"/>)</strong></div>
             <div class="pay" onclick="alert('<fmt:message key="paytip" bundle="${bundle}"/>');window.open('https://money.yandex.ru/embed/shop.xml?account=41001769379130&quickpay=shop&writer=seller&targets=%D0%BF%D0%BB%D0%B0%D1%82%D0%B0+%D0%B7%D0%B0+%D0%BE%D0%B1%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5&targets-hint=&default-sum=&button-text=01','支付','width=450 height=163 resizable=no toolbar=no location=no scrollbars=no status=no menubar=no top=100 left=100')"><strong><fmt:message key="pay" bundle="${bundle}"/></strong></div>
         	 <div class="set-message"><strong><fmt:message key="message to manager" bundle="${bundle}"/></strong></div>
          </div>
        </div>
      </div>
   <c:if test="${sessionScope.type eq '1'}">
   <c:if test="${sessionScope.auth eq param.username or  param.username eq null}">
      <div class="info-show">
        <div class="self-info-nav">
          <h2>个人选项</h2>
          <ul class="self-info-put">
            <li>发布信息</li>
            <li>个人信息</li>
            <li>修改头像</li>
            <li>修改密码</li>
            <li>设置密码保护</li>
            <li>修改课程价格</li>
          </ul>
        </div>
        
        <!--发布信息-->
        <div class="fabuxinxi card"> 
        <h2>发布信息</h2>
          <c:forEach var="str" items="${ads}">
		  <div class="open-info"> 
	        <p class="teacher-username">
	        	<c:if test="${info.name eq null}">
	        		${info.username}：
	        	</c:if>
	        	<c:if test="${info.name ne null}">
	        		${info.name}：
	        	</c:if>
	        </p>
	        <p class="info">${str.content}</p>
	        <p class="date">${str.ads_date}</p>
        </div>
        </c:forEach>
        <form name="form1" class="form form1"  action="/translation/front/servlet/AdsServlet" method="post">
              <textarea name="zhuangtai" class="zhuangtai" rows="3" cols="50"></textarea>
            <p class="word_count">还可以输入<span>200</span>字</p>
            <p class="word_over" style="display:none;">超出字数限制<span style="color:red;font-weight:bold;"></span>字 <span style="color:blue; cursor:pointer;">清理</span></p>
            <input class="fabiao" type="button" name="fabu" value="发表" />
          </form>
        </div>
        
         
        <!--个人信息-->
        <div class="gerenxinxi card">
          <h2>个人信息</h2>
          <div id="gerenxinxi-box">
          <p class="tishi">提示：因为管理员需要通过您提供的真实姓名和银行卡号，向您汇入完成给学生上课后的学费，而且只有完善了个人信息并经过管理员的审核通过后才有机会被列入老师显示列表中，所以请尽快完善您的个人信息。</p>
            <form name="register-teacher" action="/translation/front/servlet/ChangeCenterInfoServlet" method="post">
            <div>
                <label for="truename">真实姓名：</label>
                <input id="truename" name="truename" type="text" value="${info.name}"/>
                <p style="text-align:left; color:red; float:left; text-indent:120px;">请务必填写银行卡绑定的姓名</p>
                </div>
                <div>
                <label for="bank">银行账号：</label>
                <input id="banknum" name="banknum" type="text" value="${info.banknum}" />
               
                </div>
                <div>
                <label for="bank">开户银行：</label>
                <input id="bank" name="bank" type="text" value="${info.bank}"/>
                </div>
              <div>
                <label for="teducation_bg">学　　历：</label>
                <select id="teducation_bg" name="education_bg" >
                 	<option value="0">- - - - 请选择 - - - -</option>
					<option value="三个月">- - - - 三个月 - - - -</option>
					<option value="六个月">- - - - 六个月 - - - -</option>
					<option value="一年">- - - - 一　年 - - - -</option>
					<option value="两年">- - - - 两　年 - - - -</option>
					<option value="三年">- - - - 三　年 - - - -</option>
					<option value="三年以上">- - - - 三年以上  - - -</option>
			  </select>
                <span class="error error_bg">请选择学历！</span> </div>
              <div>
                <label for="teach-which">教授语言：</label>
                <select id="teach-which" name="teach-which" >
                  <option value="0">- - - - 请选择 - - - -</option>
                  <option value="俄语">- - - - 俄语 - - - -</option>
                  <option value="китайский">- - - - 中文 - - - -</option>
                </select>
                <span class="error error_tw">请选择教授语言！</span> </div>
              <div>
                <label for="tgraduate">毕业院校：</label>
                <input id="tgraduate" name="graduate" type="text" value="${info.college}" />
                <span class="info info_ans">请输入毕业院校，2~32 位！</span> <span class="error error_ans">输入不合法，请重新输入！</span> <span class="succ succ_ans">可用</span> </div>
              <div>
                <label for="tzhuce_email">电子邮件：</label>
                <input id="tzhuce_email" name="zhuce_email" type="text" autocomplete="off" value="${info.email}"/>
                <ul class="all_email">
                  <li><span></span>@qq.com</li>
                  <li><span></span>@163.com</li>
                  <li><span></span>@sohu.com</li>
                  <li><span></span>@sina.com.cn</li>
                  <li><span></span>@gmail.com</li>
                  <li><span></span>@126.com</li>
                </ul>
                <span class="info info_email">请输入电子邮件！</span> <span class="error error_email">邮件不合法，请重新输入！</span> <span class="succ succ_email">可用</span> </div>
              <div>
                <label for="ttel-num">手机号码：</label>
                <input id="ttel-num" name="tel-num" type="tel" value="${info.tel}"/>
                <span class="info info_tel">请输入手机号码！</span> <span class="error error_tel">号码不合法，请重新输入！</span> <span class="succ succ_tel">可用</span> </div>
              <div style="margin-bottom:0;">
                <label style="vertical-align:65px;" for="tbeizhu">个人简介：</label>
                <textarea style="width:360px; height:80px;border:1px solid #ccc; resize:none;" id="tbeizhu" name="beizhu">${info.introduction}</textarea>
              </div>
              <p class="word_count" style="margin:10px 0;">还能输入<span style="color:black; font-weight:bold; font-size:16px;">200</span>字</p>
              <p class="word_over" style="display:none;margin:10px 0;">已超出<span style="color:red;font-weight:bold; font-size:16px;"></span>字　<span style="color:blue; cursor:pointer;">清理</span></p>
              <div>
                <input  style="background:url(images/anniu1.png) no-repeat left top; width:102px; height:42px; border:none; margin-left:190px; cursor:pointer; font:bold 18px/42px '微软雅黑'; color:#fff;" type="button" name="sub" value="确认修改"/>
              </div>
            </form>
          </div>
        </div>
        <!--修改头像-->
  <div class="xiugaitouxiang card">
          <iframe name="iframe1" style="display:none;" frameborder="0" scrolling="no"></iframe>
          <h2>修改头像</h2>
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
              <input class="" type="button" value="选择头像"/>
              <p> 请尽量选择比例为1:1的图片，图片大小不能超过500k。 </p>
            </div>
            <div class="xiugai-input">
              <input type="button" id="touxiangfasong" value="保存" />
              <input type="button" id="fasongquxiao" value="取消" />
            </div>
          </form>
        </div>
        <!--修改密码-->
        <div class="xiugaimima card">
          <h2>修改密码</h2>
          <form name="xiugaimimaform" class="xiugaimimaform" >
            <div>
              <label for="yuashimima">当前密码：</label>
              <input id="yuashimima" type="password" value=""/>
            </div>
            <div>
              <label for="gaihoumima">新密码：</label>
              <input id="gaihoumima" name="gaihoumima" type="password" value=""/>
              <span class="info info_pass">
              <p>安全级别：<strong class="anquan anquan1">■</strong><strong class="anquan anquan2">■</strong><strong class="anquan anquan3">■</strong></strong><strong class="anquan anquan4" style="font-weight:normal;"></strong></p>
              <p><strong class="quan1" style="font-weight:normal;">○</strong> 6-20 个字符</p>
              <p><strong class="quan2" style="font-weight:normal;">○</strong> 只能包含大小写字母、数字和非空格字符</p>
              <p><strong class="quan3" style="font-weight:normal;">○</strong> 大、小写字母、数字、非空字符，2种以上</p>
              </span> <span class="error error_pass">输入不合法，请重新输入！</span> <span class="succ succ_pass">可用</span> </div>
            <div>
              <label for="querengaihoumima">确认新密码：</label>
              <input id="querengaihoumima" name="querengaihoumima" type="password" value=""/>
              <span class="info info_sure">请再一次输入密码！</span>
<span class="error error_sure">密码不一致，请重新输入！</span>
<span class="succ succ_sure">可用</span>
            </div>
            <div class="queren-box">
              <input type="button" name="xiugaitijiao" class="xiugaitijiao" value="确认修改"/>
            </div>
          </form>
          <div class="xiugai_wait"></div>
        </div>
         <!--设置密码保护-->
        <div class="mimabaohubox card">
          <h2>设置密码保护</h2>
          <div class="mibao-box">
          <p>设置密码保护可以用于找回密码，密保只能设置一次，请牢记所填问题和答案。</p>
          <form name="mimabaohu" class="mimabaohu" action="/translation/escape/servlet/ProtectionServlet" method="post">
          <div class="que">
          <label for="que">密保问题：</label><select name="que" id="que">	 
          <option value="0">- - 请选择问题 - -</option>        
          </select><span></span>
          </div>
          <div class="daan"> 
          <label for="daan">密保答案：</label><input name="daan" id="daan" type="text" value="" /><span></span>
          </div>
          <div class="mibaoqueren">
            <input type="button" name="tijiaomibao"  class="tijiaomibao"
            	<c:if test="${info.protection ne null}">value="您已设置"  disabled="disabled" </c:if>
            	<c:if test="${info.protection eq null}">value="提交密保"</c:if>
            />
          </div>
          </form>
          </div>
        </div>
       <!--修改课程价格-->
        <div class="xiugaijiage card">
          <h2>修改课程价格</h2>
          <div class="kechengjiage">
          <p>说明：设置价格为每小时收费价格,每小时不能低于30元。</p>
          <form name="kechengjiage" action="/translation/front/servlet/UpdatePriceServlet" method="post">
          <p class="yuanjiage">
         	当前价格：<span>${info.price}/8h</span>
          </p>
          <div class="xiugaihou">
          <label for="xiugaikechengjiage">修改价格：</label><input id="xiugaikechengjiage"
          name="kechengjiage" type="text" value="" />&nbsp;&nbsp;
                <select style="color:#666;" class="danwei" name="danwei">
                  <option value="元">元</option>
                </select>
          </div>
          <div class="kechengtijiao">
          <input type="button" name="tijiao" value="提交" />
          </div>
          </form>
          </div>
        </div>
        <div style="clear:both"></div>
      </div>
      </c:if>
  </c:if>
      
    <c:if test="${ param.username ne null and sessionScope.auth ne param.username}">
      <!--他人访问信息展示-->
      <div class="visit-info">
      <div class="gerenjiajie">
      <h2><fmt:message key="selfinfo" bundle="${bundle}"/></h2>
      		<p><fmt:message key="realname" bundle="${bundle}"/>：${info.name} </p>
            <p><fmt:message key="sex" bundle="${bundle}"/>：${info.sex} </p>
            <p><fmt:message key="birthday" bundle="${bundle}"/>： ${info.birthday}</p>
            <p><fmt:message key="price" bundle="${bundle}"/>：${info.price}/8h</p>
            <p><fmt:message key="canspeak" bundle="${bundle}"/>：${info.language}</p>
            <p><fmt:message key="experience" bundle="${bundle}"/>： ${info.education}</p>
            <p><fmt:message key="graduate" bundle="${bundle}"/>： ${info.college}</p>
            <p><fmt:message key="introduction" bundle="${bundle}"/>： ${info.introduction}</p>
            
      </div>
      <div class="fabuxinxi card">
          <h2><fmt:message key="announce" bundle="${bundle}"/></h2>
          <c:forEach var="str" items="${ads}">
          <div class="open-info">
            <p class="teacher-username">
            	<c:if test="${info.name eq null}">
	        		${info.username}：
	        	</c:if>
	        	<c:if test="${info.name ne null}">
	        		${info.name}：
	        	</c:if>
            </p>
	        <p class="info">${str.content}</p>
	        <p class="date">${str.ads_date}</p>
        </div>
        </c:forEach>
      </div>
    </div>
     </c:if>
    </div>
    
    
    
    <div id="footer">
      <p><a href="faq.html"><fmt:message key="faq" bundle="${bundle}"/></a> | <a href="mailto:netservice@bk.ru"><fmt:message key="feedback" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="openplatform" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="sitemap" bundle="${bundle}"/></a><br />
        <a href="#"><fmt:message key="partner" bundle="${bundle}"/></a> | <a href="javascript:alert('по вопросам работы у нас просим звонить\nна: 89141949263\nskype: rualvi')"><fmt:message key="jobopportunities" bundle="${bundle}"/></a> | <a href="#"><fmt:message key="legalnotices" bundle="${bundle}"/></a><br />
            <fmt:message key="copyright" bundle="${bundle}"/>| <a href="#"><fmt:message key="teamprofile" bundle="${bundle}"/></a> | <a href="/translation/shasha/login.html"><fmt:message key="manage" bundle="${bundle}"/></a> </p>
    </div>
  </div>
</div>
<!--主体外布局-->
<div class="liuyan-box">
  <h1 id="liutuodong">用户留言<img src="images/close.png" alt="关闭" title="关闭" width="14" height="14" /></h1>
  <form name="liuyan" class="liuyan" action="/translation/front/servlet/UserMessageServlet?thusername=${param.username}" method="post">
	  <p class="from_"><span>老师：</span>
	     <input class="choisetea" name="choisetea" type="text" value="<c:if test="${info.name ne null}">${info.name}</c:if>"/>
	  </p>
	    
	  <p class="to_"><span>付款账号：</span>
	  	 <input class="banknum" name="banknum" type="text" value="<c:if test="${sessionScope.type eq '1'}">无</c:if>"/>
	  </p>
    <textarea name="liuyanneirong" class="liuyanneirong" rows="3" cols="50"></textarea>
    <p class="word_count">还可以输入<span>150</span>字</p>
    <p class="word_over" style="display:none;">超出字数限制<span style="color:red;font-weight:bold;"></span>字 <span style="color:blue; cursor:pointer;">清理</span></p>
    <input class="fasong" type="button" name="fasong" value="发送" />
  </form>
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
<div id="screen"></div>
<div id="back_top">返回顶部</div>
</body>
</html>
