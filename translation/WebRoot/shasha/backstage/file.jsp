
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    <title>文件管理</title>
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
form{
	margin:20px;}
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
a:hover{
	text-decoration:underline;}
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
  <h1>文件管理</h1>
    <table width="100%">
    	<tr>
    		<td>文件编号</td>
    		<td>文件名</td>
    		<td>上传时间</td>
    		<td>文件描述</td>
    		<td>删除</td>
    	</tr>
    	<c:forEach var="num" items="${page2.list}">
    	<tr>
    		<td width="80">${num.id }</td>
    		<td width="220">${num.realname }</td>
    		<td  width="120">${num.date}</td>
    		<td>${num.description }</td>
    		<td width="50"><a href="/translation/admin/servlet/DelFileServlet?id=${num.id}">删除</a></td>
    	</tr>
        </c:forEach>
        <tr>
    	
    </table>
    <a style="display:block; font:bold 16px/25px '微软雅黑'; color:#333; text-align:right;padding-right:100px;" href="/translation/shasha/backstage/upload.jsp" >文件上传</a>
    
    <br/><br/>
   <!--   <div style="text-align:center">
  当前第[${page2.pagenum}]页
  <c:forEach var="pagenum" begin="${page2.forEachBegin }" end="${page2.forEachEnd}">
  	[<a href="/translation/shasha/backstage/file.html?pagenum=${pagenum}"><b>${pagenum}</b></a>]&nbsp;
  </c:forEach>
  &nbsp;总页数[${page2.totalpage}]&nbsp;总记录数[${page2.totalrecord}]
  </div>
  -->
  <table style="margin:0 auto">
   <tr>
   <td style="background:#f3f3f3; border:none;">
  <ol class="pagination">
          	<li><a href="/translation/shasha/backstage/file.html?pagenum=1" rel="first">首页</a></li>
		    <c:if test="${page2.pagenum eq 1}">
		    <li><a rel="prev">到头了</a></li>
		    </c:if>
		    <c:if test="${page2.pagenum gt 1}">
		    <li><a href="/translation/shasha/backstage/file.html?pagenum=${page2.pagenum -1}" rel="prev">上一页</a></li>
		    </c:if>
		    <c:forEach begin="${page2.forEachBegin}" end="${page2.forEachEnd}" var="pagenum">
		        <li><a href="/translation/shasha/backstage/file.html?pagenum=${pagenum}"  <c:if test="${page2.pagenum eq pagenum}"> class="slected"   </c:if>>${pagenum}</a></li>
		    </c:forEach>
		    <c:if test="${page2.totalpage gt page2.pagenum}">
		    <li><a href="/translation/shasha/backstage/file.html?pagenum=${page2.pagenum+1}" rel="next">下一页</a></li>
		    </c:if>
		    <c:if test="${page2.totalpage eq page2.pagenum}">
		    <li><a rel="next">到尾了</a></li>
		    </c:if>
		    <li><a href="/translation/shasha/backstage/file.html?pagenum=${page2.totalpage}" rel="last">尾 页</a></li>
          <strong>[共${page2.totalpage}页]</strong>
        </ol>
        </td>
   		</tr>
    	</table>
  </body>
</html>
