<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html lang="en">
<head>

  <title></title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
  
  <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <script src="/bigdata/static/js/jquery.ui.touch-punch.min.js"></script>
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
	position:fixed ;
	top: 50px;
	left:50px;
   }

#droppable

  {
    width: 150px;
    height: 150px;
    padding: 0.5em;
    text-align: center;
    position:fixed;
    top:100px;
    left:100px
    
  }
  #aaa img{border-radius:90px}
  #content
  {width:500px;
  height:500px;
  }
  

  </style>
<script>

$(document).ready(function(){
var cc = document.getElementById("content");
 /*  var i=1;
   var eve=["旅游","电影","美食","运动","购物狂","动漫","手机控","户外","K歌","摄影"];
   for (i;i<=5;i++)
   {
   var aa=document.createElement('div');
   var bb=document.createElement('p');
   bb.innerHTML=eve[i-1];
	aa.setAttribute("id",i);
	aa.appendChild(bb);
	aa.setAttribute("class", "ui-widget-content drag");
	aa.setAttribute("style", "border-radius:40px");
	var cc = document.getElementById("content");
	cc.appendChild(aa);
		if (i == 1){
	$("#1").animate({speed :'slow',easing:'swing',left: '312px',top: '240px',bottom: '10px'});
	}
		if (i == 2){
	$("#2").animate({speed :'slow',easing:'swing',left: '209px', top: '80px',bottom: '10px'});
	}
		if (i == 3){
	  $("#3").animate({speed :'slow',easing:'swing',left: '129px', top: '119px',bottom: '10px'});
	}
		if (i == 4){
  $("#4").animate({speed :'slow',easing:'swing',left: '-35px', top: '57px',bottom: '10px'});
	}
		if (i == 5){
 $("#5").animate({speed :'slow',easing:'swing',left: '18px', top: '292px',bottom: '10px'});
	}
	

   }
   */
   var hh=document.createElement('div');
   hh.setAttribute("id","droppable");
   hh.setAttribute("class","ui-widget-header  ui-droppable");
   hh.setAttribute("style","border-radius: 90px; opacity: 0.4; color: rgb(240, 55, 141); background: blue");
   var ii=document.createElement('div');
   ii.setAttribute("id","aaa");
   var jj=document.createElement('img');
   jj.setAttribute("src","/bigdata/static/image/833f9f634bcbf07bb8ca16fd14cd18c6.jpeg");
   jj.setAttribute("width","150");
   jj.setAttribute("height","150");
    ii.appendChild(jj);
   hh.appendChild(ii);
  
   cc.appendChild(hh);
/*   for (i=6;i<=10;i++)
   {
      var aa=document.createElement('div');
   var bb=document.createElement('p');
   bb.innerHTML=eve[i-1];
	aa.setAttribute("id",i);
	aa.appendChild(bb);
	aa.setAttribute("class", "ui-widget-content drag");
	aa.setAttribute("style", "border-radius:40px");
	cc = document.getElementById("content");
    cc.appendChild(aa);
	if (i == 6){
  $("#6").animate({speed :'slow',easing:'swing',left: '54px', top: '-118px',bottom: '10px'});
	}
		if (i == 7){
  $("#7").animate({speed :'slow',easing:'swing',left: '464px', top: '-344px',bottom: '10px'});
	}
		if (i == 8){
  $("#8").animate({speed :'slow',easing:'swing',left: '203px', top: '-135px',bottom: '10px'});
	}
		if (i == 9){
  $("#9").animate({speed :'slow',easing:'swing',left: '353px', top: '-324px',bottom: '10px'});
	}
			if (i == 10){
  $("#10").animate({speed :'slow',easing:'swing',left: '395px', top: '-221px',bottom: '10px'});
	}
	
   }


	var dd= document.createElement('div');
	dd.setAttribute("data-corners", "true");
	dd.setAttribute("data-shadow", "true");
	dd.setAttribute("data-iconshadow", "true" );
	dd.setAttribute("data-wrapperels", "span");
	dd.setAttribute("data-theme", "c");
	dd.setAttribute("data-disabled", "false");
	dd.setAttribute("class", "ui-btn ui-btn-up-c ui-shadow ui-btn-corner-all");
	dd.setAttribute("aria-disabled", "false");
	var ee=document.createElement('span');
	ee.setAttribute("class","ui-btn-inner");
	var ff=document.createElement('span');
	ff.setAttribute("class","ui-btn-text");
	ff.innerHTML="OK!";
	ee.appendChild(ff);
	dd.appendChild(ee);

	var gg=document.createElement('input');
	gg.setAttribute("type","button");
	gg.setAttribute("class","ui-btn-hidden");
	dd.appendChild(gg);
		cc.appendChild(dd);
		*/
$("#1").animate({left:' 278px', top:' 182px'});
$("#2").animate({left:' 278px', top:' 182px'});
$("#3").animate({left:' 129px', top:' 119px'});
$("#4").animate({left:' -35px', top:' 57px'});
$("#5").animate({left:' 18px', top:' 292px'});
$("#6").animate({left:' 54px', top:' -118px'});
$("#7").animate({left:' 464px', top:' -344px'});
$("#8").animate({left:' 203px', top:' -135px'});
$("#9").animate({left:' 353px', top:' -324px'});
$("#10").animate({left:' 395px', top:' -221px'});
});

  $(function() {
   var tags = $("#tag").val();
   var counts=tags.replace(/(.)(?=[^$])/g,"$1").split(",");       //字符串转化为数组
   for (var i=1;i<=10;i++)
   {
   		var oc= document.getElementById(i);
   		if (counts[i-1]%2==1)
   		{	
   		$(oc).css({ color: "#F0378D", background: "blue" });
   		}
   		if (counts[i-1]%2==0)
   		{
	   	$(oc).css({ color: "#F0378D", background: "green" });
   		}
   }
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
    $(".drag").css("opacity",0.4);  
    
    
	$("#subbutton").click(function(){  

    // 创建一个 form  
    for (var i=1;i<=10;i++)
    {
    	counts[i-1]=counts[i-1]%2;
    }
    var count=counts.join(",")
    var form1 = document.createElement("form");  
    form1.id = "form1";  
    form1.name = "form1";  
  
    // 添加到 body 中  
    document.body.appendChild(form1);  
  
    // 创建一个输入  
    var input = document.createElement("input");  
    // 设置相应参数  
    input.type = "text";  
    input.name = "tag";  
    
    input.value = count;  
    var input1 = document.createElement("input");  
    input1.type = "text";  
    input1.name = "userid";  
    input1.value = "${user.id}";  
  
    // 将该输入框插入到 form 中  
    form1.appendChild(input);  
    form1.appendChild(input1);  
  
    // form 的提交方式  
    form1.method = "POST";  
    // form 提交路径  
    form1.action = "/bigdata/user/nice";  
  
    // 对该 form 执行提交  
    form1.submit();  
    // 删除该 form  
    document.body.removeChild(form1);  

});


    

 });
  
 </script>

<body>
<div id="content">
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
    <input id="tag" type="hidden" value="${user.tag}">  
</body>
</html>