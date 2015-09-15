<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="static/css/jquery.mobile.flatui.css">
  	<link rel="stylesheet" href="static/mapcss/homepage_map.css">
  	<link rel="stylesheet" href="static/mapcss/ntmui.css">
  	<script src="static/js/jquery.js"></script>
  	<script src="static/js/jquery.mobile-1.4.5.min.js"></script>   

  </head>
  
  <body>
  <div data-role="page" id="loginpage" style="background-image:url('static/image/background.jpg');">
  
  	<div data-role="header" data-position="fixed" >
    <h1>登录</h1>
    <a href="/bigdata/index/register" title="注册新用户" data-icon="search" data-iconpos="right" data-transition="slide" data-direction="reverse">注册</a>
  	</div>
	

	<div data-role="content" id="content-page-login">
	<h1 align="center" style="color: #FFFFFF">Nice to meet u!</h1>
  	<form method="post" action="/bigdata/user/login" data-ajax="false">
    <div data-role="fieldcontain">
    <br>
    <input type="text" name="name" id="name"  placeholder="账号">

    <br>
    <input type="password" name="password" id="password"  placeholder="密码">
    <br>
    <button type="submit" class="ui-btn ui-btn-f ui-icon-flat-menu ui-btn-icon-left ui-shadow ui-corner-all" >登录</button>
 	</div>
  	</form>
	</div>
	
	<div data-role="footer" data-position="fixed"  id="toMyMark">
    <h1>hi</h1>
  	</div>
</div> 
   
  </body>
</html>
