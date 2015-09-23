<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html lang="en">
<head>

  <title></title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
  
<!--   <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css"> -->
  <link rel="stylesheet" href="../static/css/jquery.mobile.flatui.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <script src="/bigdata/static/js/jquery.ui.touch-punch.min.js"></script>
 </head>



<body>
<div id="content">
</div>
<div><input type="button" id="subbutton" value="OK!" /></div> 
    <input id="tag" type="hidden" value="${user.tag}"> 
</body>
</html>