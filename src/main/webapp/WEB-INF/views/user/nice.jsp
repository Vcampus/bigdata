<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta charset="utf-8">
  	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<title>一个页面</title>
	<link rel="stylesheet" href="static/css/jquery.mobile.flatui.min.css">
  	<link rel="stylesheet" href="static/mapcss/homepage_map.css">
  	<script src="static/js/jquery.js"></script>
  	<script src="static/js/jquery.mobile-1.4.5.min.js"></script>   
  	<script src="http://api.map.baidu.com/api?v=1.5&ak=ZvGx486DtaVtWrydYG5uOAPA"></script>  

  </head>
  
  <body>
 	
 	<div data-role="page" id="homepage">
  <div data-role="header" data-position="fixed" data-fullscreen="true">
    <a href="#info_page" title="打开设置" data-icon="grid" data-iconpos="left" data-transition="slide" data-direction="reverse">设置</a>
    <a href="" title="打开菜单" data-icon="grid" data-iconpos="left" id="test_btn" class="ui-btn-right">测试按钮</a>
    <h1>很高兴遇见你</h1>
    <a href="search.html" title="搜索" data-icon="search" data-iconpos="right" data-transition="slide">雷达</a>
  </div>

  <div data-role="content">
  <div id="map-home" style="height: 600px "></div>
  <script type="text/javascript" src="static/mapjs/homepage_map.js"></script>
  </div>

  <div data-role="footer" data-position="fixed" data-fullscreen="true" id="toMyMark">
    <h1>我的位置</h1>
  </div>
</div> 

<!-- 设置页面 -->
<div data-role="page" id="info_page" name="info_settings">
  <div data-role="header" data-position="fixed" >
    <h1>偏好设置</h1>
    <a href="#homepage" title="" page-role="button" data-transition="slide" class="ui-btn-right" data-icon="back">返回</a>
    </div>

    <div data-role="content">
    gerenxinxi
    </div>

    <div data-role="footer" data-position="fixed" >
    <div data-role="navbar">
      <ul>
        <li><a href="#info_page" data-icon="info" class="ui-btn-active ui-state-persist" >个人信息</a></li>
        <li><a href="#habbit_page" data-icon="minus" >偏好设置</a></li>
     </ul>
    </div>
    </div>
</div>

<div data-role="page" id="habbit_page" name="habbit_settings">
  <div data-role="header" data-position="fixed" >
    <h1>偏好设置</h1>
    <a href="#homepage" title="" page-role="button" data-transition="slide" class="ui-btn-right" data-icon="back">返回</a>
    </div>

    <div data-role="content">
      <h1></h1>
    </div>

    <div data-role="footer" data-position="fixed" >
    <div data-role="navbar">
     <ul>
        <li><a href="#info_page" data-icon="info"  >个人信息</a></li>
        <li><a href="#habbit_page" data-icon="minus" class="ui-btn-active ui-state-persist">偏好设置</a></li>
     </ul>
    </div>
    </div>
</div>
  </body>
</html>
