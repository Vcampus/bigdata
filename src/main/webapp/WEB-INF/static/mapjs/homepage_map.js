//定义地图
var map = new BMap.Map("map-home");

//设置中心点和缩放级别
map.centerAndZoom("南京",20);
var tpoint = new BMap.Point(118.803484, 32.065714);



//定时给服务器发送信息
function sendLocation () {
    
    setTimeout("sendLocation()",2000);
}

function MarkByGps() {
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r) {
        if (this.getStatus() == BMAP_STATUS_SUCCESS) {
            var myIcon = new BMap.Icon("static/image/blue.png", new BMap.Size(50, 60));
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
    var myIcon = new BMap.Icon("static/image/blue.png", new BMap.Size(50, 60));
    var mk = new BMap.Marker(r.point, {
        icon: myIcon
    });
    map.addOverlay(mk);
}

function MarkByData() {
    var new_point = new BMap.Point(118.825115, 31.889903);
    var myIcon;
    if($("#lock").text() == "lock"){
        map.clearOverlays();   
        var myIcon = new BMap.Icon("static/image/blue.gif", new BMap.Size(50, 60));
    }
    if($("#lock").text() == "unlock"){
        map.clearOverlays();   
        var myIcon = new BMap.Icon("static/image/shadow.png", new BMap.Size(50, 60));
    }
    
    var mk = new BMap.Marker(new_point, {
        icon: myIcon
    });
    map.addOverlay(mk); // 将标注添加到地图中
    mk.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
    map.panTo(new_point);
}

//添加地图点击事件
function showInfo(e) {
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
                    var new_point = new BMap.Point(msg[jsonmsg]["lng"], msg[jsonmsg]["lat"]);
                    var myIcon = new BMap.Icon("static/image/red.png", new BMap.Size(50, 60));
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



//显示离自己范围很近的区域内的朋友
function showFriends(point) {
    console.log(point.lng);
    console.log(point.lat);
    console.log($("#userid").val());

    //获取最近点
    var geocoder = new BMap.Geocoder();
    var locationOptions = {
        poiRadius: 500,
        numPois: 5
    }
    geocoder.getLocation(point, function(result) {
        var allPois = result.surroundingPois;
        //获取附近的5个点
        for (i = 0; i < allPois.length; i++) {
            console.log(allPois[i].title);
        }
        tag = 4;

        //获取5个点中最近的点
        for (i = 0; i < allPois.length - 1; i++) {
            if (map.getDistance(point, allPois[tag].point) > map.getDistance(point, allPois[i].point)) {
                tag = i;
            }
        }
        console.log(allPois[tag]);
        //组织要发送的数据
        var location = {
            lat: point.lat,
            lng: point.lng,
            userid: $("#userid").val(),
            poi: allPois[tag]["title"],
            address: allPois[tag]["address"],
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
                    var new_point = new BMap.Point(msg[jsonmsg]["lng"], msg[jsonmsg]["lat"]);
                    var myIcon = new BMap.Icon("static/image/red.png", new BMap.Size(50, 60));
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

//雷达搜索，上传当前位置，找到附近的爱好区域
function searchFriends() {
        console.log($("#userid").val());
        //组织要发送的数据
        var location = {
            userid:$("#userid").val(),
        }
        console.log(location);
        // 发送数据
        $.ajax({
                url: '/bigdata/location/interest',
                contentType: "application/json; charset=utf-8",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(location),
            })
            .done(function(msg) {
                console.log(msg);
                for(var i in msg){
                    console.log(i);
                    var hnum = i;//兴趣爱好
                    var hdata = msg[""+i];
                    for(jsonmsg in hdata){
                        var opacity = (i+1)/10;
                        console.log(hdata[jsonmsg]["poi"]);
                        console.log(hdata[jsonmsg]["lng"]);
                        console.log(hdata[jsonmsg]["lat"]);
                        var hpoint = new BMap.Point(hdata[jsonmsg]["lng"], hdata[jsonmsg]["lat"]);
                        var hoval = new BMap.Polygon(add_oval(hpoint,0.0020,0.0015), {strokeColor:"red", strokeWeight:6, strokeOpacity:0.5,fillColor: "red",fillOpacity: 0.5});
                        map.addOverlay(hoval);
                    }
                }
                console.log("success");
            })
            .fail(function() {
                console.log("error");
            })
            .always(function() {
                console.log("complete");
            });
    }

$(document).ready(function() {
    sendLocation();
    var str = $("#userid").val();
    console.log(str);
    console.log("str");

    //资源加载完成后定位到自己所在点
    $("#toMyMark").click(function(event) {
        /* Act on the event */
        MarkByData();
        var new_point = new BMap.Point(118.825115, 31.889903);
        showFriends(new_point);
    });
    //位置共享隐身按钮
    $("#lock").click(function(event) {
        /* Act on the event */
        console.log($("#lock").text());
        if($("#lock").text() == "lock"){
           $("#lock").text('unlock');
           $("#lock").attr('style', 'background: #BE2121;border-color: #BE2121');
           $("#toMyMark").click();

        }
        else{
            $("#lock").text('lock');
            $("#lock").attr('style', 'background: #1abc9c;border-color: #1abc9c');
            $("#toMyMark").click();
        }

    });

    $("#like").click(function(event) {
        /* Act on the event */
        console.log("搜索爱好者集中区域");
        searchFriends();
    });

    $("#search").click(function(event) {
        /* Act on the event */
        console.log("搜索爱好者集中区域");
        searchFriends();
    });

    

});

//centre:椭圆中心点,X:横向经度,Y:纵向纬度
function add_oval(centre, x, y) {
    var assemble = new Array();
    var angle;
    var dot;
    var tangent = x / y;
    for (i = 0; i < 36; i++) {
        angle = (2 * Math.PI / 36) * i;
        dot = new BMap.Point(centre.lng + Math.sin(angle) * y * tangent, centre.lat + Math.cos(angle) * y);
        assemble.push(dot);
    }
    return assemble;
}
var oval = new BMap.Polygon(add_oval(tpoint,0.0020,0.0015), {strokeColor:"red", strokeWeight:6, strokeOpacity:0.5,fillColor: "red",fillOpacity: 0.5});
map.addOverlay(oval);