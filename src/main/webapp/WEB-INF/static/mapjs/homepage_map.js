var map = new BMap.Map("map-home");   
$(document).ready(function(){
    
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r){
        if(this.getStatus() == BMAP_STATUS_SUCCESS){
            var myIcon = new BMap.Icon("static/image/marker_blue.png", new BMap.Size(300,157));
            var mk = new BMap.Marker(r.point,{icon:myIcon});
            map.addOverlay(mk);
            alert('您的位置：'+r.point.lng+','+r.point.lng);
            map.centerAndZoom(r.point, 20);
        }
        else {
            alert('failed'+this.getStatus());
        }
});
  $("#toMyMark").click(function(){   
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r){
    	if(this.getStatus() == BMAP_STATUS_SUCCESS){
            var myIcon = new BMap.Icon("static/image/marker_blue.png", new BMap.Size(300,157));
            var mk = new BMap.Marker(r.point,{icon:myIcon});
            map.addOverlay(mk);
            alert('您的位置：'+r.point.lng+','+r.point.lng);
            map.panTo(r.point);
            alert("ss");
        }
        else {
            alert('failed'+this.getStatus());
        }
  });
})
});



$(document).ready(function($){
    $("#test_btn").click(function() {
        
    });
})









	
