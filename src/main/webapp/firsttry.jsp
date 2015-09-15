<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">    
    <title>NTCE TO MEET YOU!</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->



		
	  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />  
	  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
	  <title>Nice To Meet You!</title>  
	  <style type="text/css">  
		html{height:100%}  
		body{height:100%;margin:0px;padding:0px}  
		#container{height:100%}
	  </style>  
	  <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.5&ak=gj2OWV0SPcUG7eyR4OKsoNE1">
	  //v1.5çæ¬çå¼ç¨æ¹å¼ï¼src="http://api.map.baidu.com/api?v=1.5&ak=gj2OWV0SPcUG7eyR4OKsoNE1"
	  //v1.4çæ¬åä»¥åçæ¬çå¼ç¨æ¹å¼ï¼src="http://api.map.baidu.com/api?v=1.4&key=gj2OWV0SPcUG7eyR4OKsoNE1&callback=initialize"
	  </script>
	  <script type="text/javascript" src="static/jquery-1.11.3.min.js"></script>
	  <script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/data/points-sample-data.js"></script>

  </head>
  
  
  
  
  
  
  
  
  
  
  
  <body>
	<div id="container"></div> 
	<script type="text/javascript">               //ç¾åº¦å°å¾apiåè½
	
	var map = new BMap.Map("container");          // åå»ºå°å¾å®ä¾  
	var point = new BMap.Point(118.826058,31.893375);  // åå»ºç¹åæ   åäº¬
	var nanjingpoint=new BMap.Point(118.78333,32.05000);//åäº¬
		
	var marker = new BMap.Marker(point);          //åäº¬marker
	var nanjingmarker=new BMap.Marker(nanjingpoint);//åäº¬marker
	
	map.centerAndZoom(point, 16);                // åå§åå°å¾ï¼è®¾ç½®ä¸­å¿ç¹åæ åå°å¾çº§å«  
	map.enableScrollWheelZoom();
	map.addOverlay(marker);//å°å¾ä¸æ·»å markerç¹
	map.addOverlay(nanjingmarker);//å°å¾ä¸æ·»å markerç¹
	nanjingmarker.setAnimation(BMAP_ANIMATION_BOUNCE);//å¨ç¹ä¸æ·»å å¨å¾
    
    
    var p = marker.getPosition();    
    var geoc = new BMap.Geocoder();
    var add="";
    var opts={width : 50,     // ä¿¡æ¯çªå£å®½åº¦
	  	      height: 50,     // ä¿¡æ¯çªå£é«åº¦
	  	      title : "Hello" 
	  	      };
	var locationOptions = {
			poiRadius: 500,
			numPois :5
			}
         
	//é¼ æ æ¬åææ
  	marker.addEventListener("mouseover", function(){
  	             //geoc.getLocation(p, function(rs){
				 //var addComp = rs.addressComponents;
			     //add=addComp.province + addComp.city + addComp.district +  addComp.street + addComp.streetNumber;
					//}); 
					
				geoc.getLocation(p,
					function mCallback(rs){
                            var allPois = rs.surroundingPois;//è·åå¨é¨POIï¼è¯¥ç¹åå¾ä¸º100ç±³åæ6ä¸ªPOIç¹ï¼  

                            tag=0;  
                            for(i=0;i<5;i++)   
                            {
                            if(map.getDistance(p,allPois[tag].point)>map.getDistance(p,allPois[i].point)) 
                               tag=i+1;                       
                            }
                            add=allPois[tag].title;
          
                            },locationOptions);

					
				var infoWindow=new BMap.InfoWindow(""+add+"",opts);  
   				this.openInfoWindow(infoWindow);
  				});
  				
    marker.addEventListener("mouseout", function(){
                var infoWindow=new BMap.InfoWindow("",opts);
    			this.closeInfoWindow(infoWindow);
  		});
	
	
	
	
      
//é¼ æ ç¹å»è·åä¿¡æ¯
      map.addEventListener("click",function(e){
		//e.point.lng //jingdu 
		//e.point.lat//weidu
		var geoc = new BMap.Geocoder();
			
		geoc.getLocation(e.point,
			function mCallback(rs){
                  var allPois = rs.surroundingPois;//è·åå¨é¨POIï¼è¯¥ç¹åå¾ä¸º100ç±³åæ6ä¸ªPOIç¹ï¼  

                   tag=0;  
                   for(i=0;i<5;i++)   
                   {
                      if(map.getDistance(e.point,allPois[tag].point)>map.getDistance(e.point,allPois[i+1].point)) 
                               tag=i+1;                       
                   }

					var location = {
						lat : e.point.lat,
						lng : e.point.lng,
						poi : allPois[tag].title,
						address : allPois[tag].address,
					}
					
					$.ajax({
						  type: "POST",
						  url: "/bigdata/location/loc",
						  contentType: "application/json; charset=utf-8",
						  dataType: "json",
						  data: JSON.stringify(location),
						  success : function(msg){
							  $("#div01").append(msg.Location)
						  }
						});
                   //////////////////////////////////////
                   /////////////////////////////////////
                   alert(e.point.lng+" "+e.point.lat+" "+allPois[tag].title+" "+allPois[tag].address);
                   },locationOptions);
		
	});
	
		// æ·»å å¸¦æå®ä½çå¯¼èªæ§ä»¶(å½æ°)
	 var navigationControl = new BMap.NavigationControl({
	    anchor: BMAP_ANCHOR_TOP_LEFT,// é å·¦ä¸è§ä½ç½®
	    type: BMAP_NAVIGATION_CONTROL_LARGE, // LARGEç±»å
	    enableGeolocation: true// å¯ç¨æ¾ç¤ºå®ä½
	  });
	  map.addControl(navigationControl);
	  // æ·»å å®ä½æ§ä»¶
	 var geolocationControl = new BMap.GeolocationControl();
	  geolocationControl.addEventListener("locationSuccess", function(e){
	    // å®ä½æåäºä»¶
	    var address = '';
	    address += e.addressComponent.province;
	    address += e.addressComponent.city;
	    address += e.addressComponent.district;
	    address += e.addressComponent.street;
	    address += e.addressComponent.streetNumber;
	    alert("不行" + address);
	  });
	  geolocationControl.addEventListener("locationError",function(e){
	    // å®ä½å¤±è´¥äºä»¶
	    alert(e.message);
	  });
	  map.addControl(geolocationControl);
	  
	  
	  
	  
	 

	</script>
    
  </body>
</html>
