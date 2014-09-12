<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/referer" prefix="zhw"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = basePath+"shasha/login.html";
String index = basePath+"shasha/index.html";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>后台管理系统首页</title>
  </head>
 
 
  <frameset  rows="18%,*" frameborder="no" >
  		 <frame frameborder="0" scrolling="no" src="head.html" name="head"/>
  	<frameset  cols="18%,*" frameborder="no">
  		<frame frameborder="0" src="contents.html"/>
  		<frame frameborder="0" src="body.html"  name="body"/>
  	</frameset>
    </frameset>
</html>
