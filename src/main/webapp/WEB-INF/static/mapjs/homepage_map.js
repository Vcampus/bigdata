var map = new BMap.Map("map-home");   
// map.centerAndZoom(new BMap.Point(116.404, 39.915), 14); 
map.centerAndZoom(new BMap.Point(116.404, 39.915), 14);
$(document).ready(function(){
  $("#toMyMark").click(function(){
    var map = new BMap.Map("map-home");   
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r){
    	if(this.getStatus() == BMAP_STATUS_SUCCESS){
            var myIcon = new BMap.Icon("image/marker_blue.png", new BMap.Size(300,157));
            var mk = new BMap.Marker(r.point,{icon:myIcon});
            map.addOverlay(mk);
            alert('您的位置：'+r.point.lng+','+r.point.lng);
            map.centerAndZoom(r.point, 20);
        }
        else {
            alert('failed'+this.getStatus());
        }
  });
})
});

function moveToPoint(point) {
	// body...
	var map = new BMap.Map("map-home"); 
	map.centerAndZoom(point, 20);  
}

function addMark(point){
	var map = new BMap.Map("map-home"); 
	var myIcon = new BMap.Icon("image/marker_blue.png", new BMap.Size(300,157));
    var mk = new BMap.Marker(point,{icon:myIcon});
    map.addOverlay(mk);
}


$(document).ready(function($){
    $("#test_btn").click(function() {
        $.ajax({
            url: 'json.html',
            type: 'Get',
            dataType: 'text',
            success: function(data) {
                // body...
                console.log(data);
            }
        })
        // body...
    });
})







	
