<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="static/css/jquery.mobile.flatui.min.css">
  	<link rel="stylesheet" href="static/mapcss/homepage_map.css">
  	<script src="static/js/jquery.js"></script>
  	<script src="static/js/jquery.mobile-1.4.5.min.js"></script>  
  </head>
  
  <body>
  <div data-role="page" id="registerpage">
  
  	<div data-role="header" data-position="fixed" >
    <h1>很高兴遇见你</h1>
    <a href="/bigdata/index/login" title="登录" data-icon="search" data-iconpos="right" data-transition="slide" >登录</a>
  	</div>
	
	<div data-role="content">
  	<form method="post" action="/bigdata/user/register">
    <div data-role="fieldcontain">
    <label for="name">账户：</label>
    <input type="text" name="name" id="name">

    <label for="password">密码：</label>
    <input type="text" name="password" id="password">
    
    <label for="password">确认密码：</label>
    <input type="text" name="confirm" id="confirm_password">
    <input type="submit" value="注册"/>
    </div>
  	</form>
	</div>
	
	<div data-role="footer" data-position="fixed"  id="toMyMark">
    <h1>我</h1>
  	</div>
</div> 
  </body>
</html>
