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
  	
	

    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="/bigdata/static/js/jquery.ui.touch-punch.min.js"></script>
    
  </head>
  <body>
 	
 	<div data-role="page" id="homepage" >
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
<div data-role="page" id="info_page" name="info_settings" style="background-image:url('static/image/meet.jpg');">
  <div data-role="header" data-position="fixed" >
    <h1>偏好设置</h1>
    <a href="#homepage" title="" page-role="button" data-transition="slide" class="ui-btn-right" data-icon="back">返回</a>
    </div>

    <div data-role="content">
    <div class="ui-grid-b">
      <div class="ui-block-a"></div>
      <div class="ui-block-b">
      <div style="weight:100px;height:100px;border-radius: 50%;background-color: #FFFFFF">
        <img src="static/image/me.png" style="weight:100px;height:100px" alt="">
      </div>
      </div>
      <div class="ui-block-c"></div>
    </div>

    <form method="post"  >
      <fieldset data-role="fieldcontain">
        <label for="sex" style="text-align: center;font-family: '微软雅黑';color: #FFFFFF">选择性别</label>
        <select name="sex" id="sex" value = "${user.sex}">
         <option value="boy">男</option>
         <option value="girl">女</option>
        </select>
        <label for="work" style="text-align: center;font-family: '微软雅黑';color: #FFFFFF">选择职业</label>
        <select name="work" id="work">
         <option value="student">学生</option>
         <option value="employ">白领</option>
         <option value="other">其他</option>
        </select>
      </fieldset>
      <button type="submit" class=" ui-btn ui-btn-b ui-icon-flat-new ui-btn-icon-left ui-shadow ui-corner-all">确认修改</button>
    </form>

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

<div data-role="page" id="habbit_page" name="habbit_settings" style="background-image:url('static/image/meet.jpg');">
    <div data-role="header" data-position="fixed" >
    <h1>偏好设置</h1>
    <a href="#homepage" title="" page-role="button" data-transition="slide" class="ui-btn-right" data-icon="back">返回</a>
    </div>


    <div id="content" >
     <div class="ui-grid-d">
        <div class="ui-block-a"><div id="1" class="drag ui-widget-content" ><p>旅游</p></div></div>
        <div class="ui-block-b"><div id="2" class="drag ui-widget-content" ><p>电影</p></div></div>
        <div class="ui-block-c"><div id="3" class="drag ui-widget-content" ><p>美食</p></div></div>
        <div class="ui-block-d"><div id="4" class="drag ui-widget-content" ><p>电影</p></div></div>
        <div class="ui-block-e"><div id="5" class="drag ui-widget-content" ><p>运动</p></div></div>
     </div>

     <div class="ui-grid-d">
        <div class="ui-block-a"><div id="6" class="drag ui-widget-content" ><p>购物狂</p></div></div>
        <div class="ui-block-b"><div id="7" class="drag ui-widget-content" ><p>手机控</p></div></div>
        <div class="ui-block-c"><div id="8" class="drag ui-widget-content" ><p>动漫</p></div></div>
        <div class="ui-block-d"><div id="9" class="drag ui-widget-content" ><p>K歌</p></div></div>
        <div class="ui-block-e"><div id="10" class="drag ui-widget-content" ><p>摄影</p></div></div>
     </div>

    <div class="ui-block-a">
      <div class="ui-block-a"></div>
      <div class="ui-block-b">
        
      </div>
      <div class="ui-block-c"></div>
    </div>
    


    <div data-role="content">
    <script type="text/javascript" src="static/mapjs/interest.js"></script>
    <link rel="stylesheet" type="text/css" href="static/mapcss/interest.css">



    <div data-role="footer" data-position="fixed" >
    <div data-role="navbar">
     <ul>
        <li><a href="#info_page" data-icon="info"  >个人信息</a></li>
        <li><a href="#habbit_page" data-icon="minus" class="ui-btn-active ui-state-persist">偏好设置</a></li>
        
     </ul>
    </div>
</div>
<input id="userid" type="hidden" value="${user.id}">
<input id="tag" type="hidden" value="${user.tag}"> 

<script type="text/javascript">
  console.log("${user.id}");
  console.log("${user.tag}");
</script>
  </body>
</html>
