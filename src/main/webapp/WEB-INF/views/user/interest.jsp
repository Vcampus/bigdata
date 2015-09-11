<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html lang="en">
<head>

  <title></title>
  <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>

<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <script src="/bigdata/static/jquery.ui.touch-punch.min.js"></script>
  <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
 </head>
  <style>
  p 
  {
  font-size:14px;
  }
  h1
  {
  font-size:45px;
  }
  .drag
  {
    width: 50px; 
    height: 50px;
    padding: 0.5em; 
	text-align: center;
	position:relative 
   }
  #droppable 
  {
    width: 150px;
    height: 150px;
    left :150px;
    padding: 0.5em;
    margin: 10px ;
    text-align: center;
    position:relative 
  }
  #aaa img{border-radius:90px}

  </style>
<script>

$(document).ready(function(){

 
    $("#draggable").animate({
      left:'-10px',
      opacity:'0.2',
      bottom:'10px',
      speed :'slow',
      easing:'swing'
	});
	$("#draggable1").animate({
      left:'50px',
      opacity:'0.2',
      bottom:'10px',
      speed :'slow',
      easing:'swing'
	});
	
});

  $(function() {
  
   var	counts =new Array (0,0,0,0,0,0,0,0,0,0);
    $( ".drag" ).draggable({
        revert: "valid",
        stop: function() {
       var k=$(this).attr('id');
			if (counts[k-1] % 2 ==1)
				{
				$(this)
				.addClass( "ui-state-highlight" );
				$(this)
				.css({ color: "#F0378D", background: "blue" });
				}
			else
				{
				$(this)
				.removeClass( "ui-state-highlight" );
				$(this)
				.css({ color: "#F0378D", background: "green" });
				}
    	}
    });

    $( "#droppable" ).droppable({
      activeClass: "ui-state-default ",
      hoverClass: "ui-state-hover",
      drop: function( event, ui ) {
      var k=ui.draggable.attr('id');
      counts[k-1]++;
      }
    });

        // 改变透明度以及颜色
    $("#droppable").css("opacity",0.4);
    $("#droppable1").css("opacity",0.5);
    $(".drag").css("opacity",0.4);
    $(".drag").css({ color: "#F0378D", background: "green" });
    $("#droppable").css({ color: "#F0378D", background: "blue" });
     $("#droppable1").css({ color: "#F0378D", background: "blue" });
    
	$("#subbutton").click(function(){  
		 MakeForm();
    });
    });
    function MakeForm()  
{  
  
    // 创建一个 form  
    var form1 = document.createElement("form");  
    form1.id = "form1";  
    form1.name = "form1";  
  
    // 添加到 body 中  
    document.body.appendChild(form1);  
  
    // 创建一个输入  
    var input = document.createElement("input");  
    // 设置相应参数  
    input.type = "text";  
    input.name = "value1";  
    input.value = "1234567";  
  
    // 将该输入框插入到 form 中  
    form1.appendChild(input);  
  
    // form 的提交方式  
    form1.method = "POST";  
    // form 提交路径  
    form1.action = "/bigdata/user/nice";  
  
    // 对该 form 执行提交  
    form1.submit();  
    // 删除该 form  
    document.body.removeChild(form1);  
}  


 </script>

<body>
<div>
<div id="1" class="ui-widget-content drag "  style=" border-radius:40px">
  <p>旅游</p>
  </div>
  <div id="2" class="ui-widget-content drag "  style=" border-radius:40px">
  <p>电影</p>
  </div>
  <div id="3" class="ui-widget-content drag"  style=" border-radius:40px">
  <p>美食</p>
  </div>
  <div id="4" class="ui-widget-content drag"  style=" border-radius:40px">
  <p>电影</p>
  </div>
  <div id="5" class="ui-widget-content drag"  style=" border-radius:40px">
  <p>运动</p>
</div>
<div id="droppable" class="ui-widget-header " style=" border-radius:90px" >
<div id="aaa">
<img src ="/bigdata/static/833f9f634bcbf07bb8ca16fd14cd18c6.jpeg" width="150" height="150">
</div>
  </div>>
<div id="6" class="ui-widget-content drag"  style=" border-radius:40px">
  <p>购物狂</p>
  </div>
  <div id="7" class="ui-widget-content drag"  style=" border-radius:40px">
  <p>手机控</p>
  </div>
  <div id="8" class="ui-widget-content drag"  style=" border-radius:40px">
  <p>动漫</p>
  </div>
  <div id="9" class="ui-widget-content drag"  style=" border-radius:40px">
  <p>K歌</p>
  </div>
  <div id="10" class="ui-widget-content drag"  style=" border-radius:40px">
  <p>摄影</p>
  
</div>
</div>
<div><input type="button" id="subbutton" value="OK!" /></div> 
</body>
</html>