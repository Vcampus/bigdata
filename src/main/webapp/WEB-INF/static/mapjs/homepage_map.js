//定义地图
var map = new BMap.Map("map-home");

//设置中心点和缩放级别
map.centerAndZoom("南京",20);


//定时给服务器发送信息
function sendLocation () {
    
    setTimeout("sendLocation()",2000);
}

function MarkByGps() {
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r) {
        if (this.getStatus() == BMAP_STATUS_SUCCESS) {
            var myIcon = new BMap.Icon("static/image/blue.png", new BMap.Size(300, 157));
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
}
function MarkByIP(){
    var myCity = new BMap.LocalCity();
    var cityName = myCity.name;
    map.setCenter(cityName);
    alert("当前定位城市:"+cityName);
}

function MarkByName() {
    map.centerAndZoom("南京", 15);
    var myIcon = new BMap.Icon("static/image/blue.png", new BMap.Size(300, 157));
    var mk = new BMap.Marker(r.point, {
        icon: myIcon
    });
    map.addOverlay(mk);
}

function MarkByData() {
    var new_point = new BMap.Point(118.825115, 31.889903);
    var myIcon = new BMap.Icon("static/image/blue.png", new BMap.Size(300, 157));
    var mk = new BMap.Marker(new_point, {
        icon: myIcon
    });
    map.addOverlay(mk); // 将标注添加到地图中
    map.panTo(new_point);
}

//添加地图点击事件
function showInfo(e) {
    alert(e.point.lng + ", " + e.point.lat);
    console.log(e.point.lng);
    console.log(e.point.lat);
    console.log($("#userid").val());

    //获取最近点
    var geocoder = new BMap.Geocoder();
    var locationOptions = {
        poiRadius: 500,
        numPois: 5
    }
    geocoder.getLocation(e.point, function(result) {
        var allPois = result.surroundingPois;
        //获取附近的5个点
        for (i = 0; i < allPois.length; i++) {
            console.log(allPois[i].title);
        }
        tag = 4;

        //获取5个点中最近的点
        for (i = 0; i < allPois.length - 1; i++) {
            if (map.getDistance(e.point, allPois[tag].point) > map.getDistance(e.point, allPois[i].point)) {
                tag = i;
            }
        }

        //组织要发送的数据
        var location = {
            lat: e.point.lat,
            lng: e.point.lng,
            userid: $("#userid").val(),
            poi: allPois[tag].title,
            address: allPois[tag].address,
        }


        console.log(allPois[tag].title);

        // 发送数据
        $.ajax({
                url: '/bigdata/location/loc',
                contentType: "application/json; charset=utf-8",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(location),
            })
            .done(function(msg) {
                console.log(msg);
                for (jsonmsg in msg) {
                    ;
                    var new_point = new BMap.Point(msg[jsonmsg]["lng"], msg[jsonmsg]["lat"]);
                    var myIcon = new BMap.Icon("static/image/red.png", new BMap.Size(300, 157));
                    var mk = new BMap.Marker(new_point, {
                        icon: myIcon
                    });
                    map.addOverlay(mk); // 将标注添加到地图中
                }
                console.log("success");
            })
            .fail(function() {
                console.log("error");
            })
            .always(function() {
                console.log("complete");
            });


    }, locationOptions);
}
map.addEventListener("click", showInfo);


$(document).ready(function() {
    sendLocation();
    var str = $("#userid").val();
    console.log(str);
    console.log("str");

    //资源加载完成后定位到自己所在点
    $("#toMyMark").click(function(event) {
        /* Act on the event */
        MarkByData();
    });
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