//定义地图
var map = new BMap.Map("map-home");
var locationOptions = {
    poiRadius: 500,
    numPois: 5
}
//设置中心点和缩放级别
var point = new BMap.Point(116.404, 39.915);
map.centerAndZoom(point, 15);

//添加地图点击事件
function showInfo(e){
        alert(e.point.lng + ", " + e.point.lat);
    }
map.addEventListener("click", showInfo);


$(document).ready(function() {

    //资源加载完成后定位到自己所在点
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r) {
        if (this.getStatus() == BMAP_STATUS_SUCCESS) {
            var myIcon = new BMap.Icon("static/image/marker_blue.png", new BMap.Size(300, 157));
            var mk = new BMap.Marker(r.point, {
                icon: myIcon
            });
            map.addOverlay(mk);
            alert('您的位置：' + r.point.lng + ',' + r.point.lng);
            map.centerAndZoom(r.point, 20);
        } else {
            alert('failed' + this.getStatus());
        }
    });


    $("#toMyMark").click(function() {
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function(r) {
            if (this.getStatus() == BMAP_STATUS_SUCCESS) {
                var myIcon = new BMap.Icon("static/image/marker_blue.png", new BMap.Size(300, 157));
                var mk = new BMap.Marker(r.point, {
                    icon: myIcon
                });
                map.addOverlay(mk);
                alert('您的位置：' + r.point.lng + ',' + r.point.lng);
                map.panTo(r.point);
                alert("ss");
            } else {
                alert('failed' + this.getStatus());
            }
        });
    })
});



$(document).ready(function($) {
    $("#test_btn").click(function(event) {
        /* Act on the event */
        // var geolocation = new BMap.Geolocation();
        // geolocation.getCurrentPosition(function(r) {
        //     var geoc = new BMap.Geocoder();
        //     geoc.getLocation(r.point,
        //         function mCallback(rs) {
                    
        //             var allPois = rs.surroundingPois; 
        //             tag = 0;
        //             for (i = 0; i < 5; i++) {
        //                 if (map.getDistance(r.point, allPois[tag].point) > map.getDistance(r.point, allPois[i + 1].point))
        //                     tag = i + 1;
        //             }

        //             var location = {
        //                 lat: r.point.lat,
        //                 lng: r.point.lng,
        //                 poi: allPois[tag].title,
        //                 address: allPois[tag].address,
        //             }

        //             $.ajax({
        //                 type: "POST",
        //                 url: "/bigdata/location/loc",
        //                 contentType: "application/json; charset=utf-8",
        //                 dataType: "json",
        //                 data: JSON.stringify(location),
        //                 success: function(msg) {
        //                     alert("success");
        //                 }
        //             });
        //             //////////////////////////////////////
        //             /////////////////////////////////////
        //             alert(r.point.lng + " " + r.point.lat + " " + allPois[tag].title + " " + allPois[tag].address);
        //         }, locationOptions);
        // });
    
    })

});