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
	<link rel="stylesheet" href="static/css/jquery.mobile-1.4.5.min.css">
  	<link rel="stylesheet" href="static/mapcss/homepage_map.css">
  	<script src="static/js/jquery.js"></script>
  	<script src="static/js/jquery.mobile-1.4.5.min.js"></script>   

  </head>
  
  <body>
  <div data-role="page" id="loginpage">
  
  	<div data-role="header" data-position="fixed" >
    <h1>很高兴遇见你</h1>
    <a href="/bigdata/user/register" title="注册新用户" data-icon="search" data-iconpos="right" data-transition="slide">注册</a>
  	</div>
	
	<div data-role="content">
  	<form method="post" action="/bigdata/user/login">
    <div data-role="fieldcontain">
    <label for="name">账户：</label>
    <input type="text" name="name" id="name">

    <label for="password">密码：</label>
    <input type="text" name="password" id="password">
    <input type="submit" value="登录"/>
  	</form>
	</div>
	
	<div data-role="footer" data-position="fixed" data-fullscreen="true" id="toMyMark">
    <h1>我的位置</h1>
  	</div>
</div> 
   
  </body>
</html>
