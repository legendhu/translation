<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻管理</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<style>
body{
	background:#f3f3f3;
	border-top:#40d7c2 solid 1px;}
h1{
	height:30px;
	background:url(images/sadasdf.jpg) repeat-x left top;
	font: bold 16px/30px '微软雅黑';
	color:#666;
	text-align:center;
	border-top:1px solid #999;}
a{
	display:block;
	text-align:center;}
a:hover{
	text-decoration:underline;}
form input{
	border:#ddd solid 1px;
	padding:3px;
	color:#666;}
body table{
	margin:20px auto;
	}
td{
	border:#ddd solid 1px;
	background:#fff;
	padding:3px;
	color:#666;}
.pagination{
	margin:0 auto 20px auto;
	overflow:hidden;
	clear:both;
	}
.pagination li{
	float:left;
	margin-left:15px;
	}
.pagination li a{
	display:block;
	width:28px;
	height:28px;
	border:1px solid #30b5a3;
	font:bold 14px/28px '微软雅黑';
	text-align:center;
	background:#fff;
	color:#30b5a3;
	}
.pagination li a:hover,.pagination li .slected{
	background:#57d5cb;
	color:#fff;
	border:1px solid #30b5a3;
	}
.pagination li a[rel=prev],.pagination li a[rel=next],.pagination li a[rel=first],.pagination li a[rel=last]{
	padding:0 5px;
	width:auto;
}
.pagination strong{
	margin-left:15px;
	font:bold 14px/30px '微软雅黑';
	color:#30b5a3;
	}
	
</style>
</head>

<body>
	<h1>新闻管理</h1><a href="/translation/shasha/backstage/form.html?flag=news" style="margin:20px;">添加新闻</a>
    <table>
    	<c:forEach var="str" items="${page.list}">
    		<tr>
    			<td>${str.title}&nbsp</td>
    			<td>${str.date}&nbsp</td>
    			<td><a href="/translation/shasha/backstage/form.html?id=${str.id}&type=news">&nbsp修&nbsp改&nbsp</a></td>
    			<td><a href="/translation/admin/servlet/ChangeNewsServlet?id=${str.id}&type=0">&nbsp删&nbsp除&nbsp</a></td>
    		</tr>
    	 </c:forEach>
 	</table> 
    <table style="margin:0 auto">
   		<tr>
   			<td style="background:#f3f3f3; border:none;">
    		<ol class="pagination">
    		<li><a href="/translation/shasha/backstage/news.html?num=1" rel="first">首 页</a></li>
		    <c:if test="${page.num eq 1}">
		    <li><a rel="prev">到头了</a></li>
		    </c:if>
		    <c:if test="${page.num gt 1}">
		     <li><a href="/translation/shasha/backstage/news.html?num=${page.num -1}" rel="prev">上一页</a> </li>
		    </c:if>
		    <c:forEach begin="${page.begin}" end="${page.end}" var="str">
		         <li><a href="/translation/shasha/backstage/news.html?num=${str}"  <c:if test="${page.num eq str}"> class="slected"   </c:if>>${str}</a></li>
		    </c:forEach>
		    <c:if test="${page.pageCount gt page.num}">
		     <li><a href="/translation/shasha/backstage/news.html?num=${page.num+1}" rel="next">下一页</a></li>
		    </c:if>
		    <c:if test="${page.pageCount eq page.num}">
		     <li><a rel="next">到头了</a></li>
		    </c:if>
		     <li><a href="/translation/shasha/backstage/news.html?num=${page.pageCount}" rel="last">尾 页</a></li>
        <strong> [共${page.pageCount}页]</strong>
     	</ol>
    	</td>
    	</tr>
    </table>
  </body>
</html>
