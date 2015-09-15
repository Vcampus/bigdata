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
<script>
$(document).ready(function() {
alert(${message});
});
</script>
  <body>
  <div data-role="page" id="registerpage">
  
  	<div data-role="header" data-position="fixed" >
    <h1>注册新用户</h1>
    <a href="/bigdata/index/login" title="登录" data-icon="search" data-iconpos="right" data-transition="slide" >登录</a>
  	</div>
	
	<div data-role="content">
	
		<h1 align="center">Sign in now!</h1>

		<form method="post" action="/bigdata/user/register">
    	<div data-role="fieldcontain">
    	<br>
    	<input type="text" name="name" id="name" placeholder="账号">

    	<br>
    	<input type="text" name="password" id="password" placeholder="密码">
    
    	<br>
    	<input type="text" name="confirm" id="confirm_password " placeholder="确认密码">
    	<br>
    	<button type="submit" class="ui-btn ui-btn-b ui-icon-flat-menu ui-btn-icon-left ui-shadow ui-corner-all" >注册</button>
		
   		</div>
  		</form>
	</div>

  	
	
	<div data-role="footer" data-position="fixed"  id="toMyMark">
    <h1>Hi</h1>
  	</div>
</div> 
  </body>
</html>
