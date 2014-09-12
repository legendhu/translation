<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>设置广告</title>
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
	
</style>
</head>

<body>
	<h1>设置广告</h1>
    <table>
	   
            <form name="formlunbo1" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=1" method="post">
	   		<tr>
	   		<td>轮播一：</td>
			<td>选择图片：<input type="file" name="lunbo1"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                   <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为670px，高度330px。</td>
             </tr>
            </form>
           
            <tr>
            <form name="formlunbo2" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=2" method="post">
	   		<td>轮播二：</td>
			<td>选择图片：<input type="file" name="lunbo2"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为670px，高度330px。</td>
            </form>
            </tr>
            <tr>
            <form name="formlunbo3" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=3" method="post">
	   		<td>轮播三：</td>
			<td>选择图片：<input type="file" name="lunbo3"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为670px，高度330px。</td>
            </form>
            </tr>
            <tr>
            <form name="formlunbo4" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=4" method="post">
	   		<td>轮播四：</td>
			<td>选择图片：<input type="file" name="lunbo4"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为670px，高度330px。</td>
            </form>
            </tr>
              <tr>
            <form name="formlunbo5" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=5" method="post">
	   		<td>轮播五：</td>
			<td>选择图片：<input type="file" name="lunbo5"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为670px，高度330px。</td>
            </form>
            </tr>
               <tr>
            <form name="formtealeft" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=6" method="post">
	   		<td>目录页悬挂广告左：</td>
			<td>选择图片：<input type="file" name="tealeft"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为100px，高度200px。</td>
            </form>
            </tr>
             <tr>
            <form name="formtearight" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=7" method="post">
	   		<td>目录页悬挂广告右：</td>
			<td>选择图片：<input type="file" name="tearight"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为100px，高度200px。</td>
            </form>
            </tr>
            <tr>
            <form name="formnewslu" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=8" method="post">
	   		<td>新闻页广告左上：</td>
			<td>选择图片：<input type="file" name="newslu"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为150px，高度150px。</td>
            </form>
            </tr>
            <tr>
            <form name="formnewsru" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=9" method="post">
	   		<td>新闻页广告右上：</td>
			<td>选择图片：<input type="file" name="newsru"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为150px，高度150px。</td>
            </form>
            </tr>
              <tr>
            <form name="formnewslb" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=10" method="post">
	   		<td>新闻页广告左下：</td>
			<td>选择图片：<input type="file" name="newslb"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为150px，高度150px。</td>
            </form>
            </tr>
              <tr>
            <form name="formnewsrb" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=11" method="post">
	   		<td>新闻页广告右下：</td>
			<td>选择图片：<input type="file" name="newsrb"></td>
                  <td>广告链接：<input type="text" name="url"></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为150px，高度150px。</td>
            </form>
            </tr>
             <tr>
            <form name="formfaq" enctype="multipart/form-data" action="/translation/admin/servlet/ChangeAdvertServlet?id=12" method="post">
	   		<td>faq页广告：</td>
			<td>选择图片：<input type="file" name="faq"></td>
                  <td>广告链接：<input type="text" name="url" ></td>
                  <td><input type="submit" value="上传"></td>
                  <td>说明：宽度为250px，高度350px。</td>
            </form>
            </tr>
            <tr>
            <td></td>
             <td></td>
             <td></td>
             <td></td>
             <td align="right"><input type="button" value="取消" onclick="window.location.href='/translation/shasha/backstage/advert.html'"/></td>
            </tr>
   	</table>
   </body>
</html>
