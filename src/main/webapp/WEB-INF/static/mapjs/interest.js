$(document).ready(function() {
  var cc = document.getElementById("content");
  var hh = document.createElement('div');
  hh.setAttribute("id", "droppable");
  hh.setAttribute("class", "ui-widget-header  ui-droppable");
  hh.setAttribute("style", "border-radius: 90px; opacity: 0.4; color: rgb(240, 55, 141); background: blue");
  var ii = document.createElement('div');
  ii.setAttribute("id", "aaa");
  var jj = document.createElement('img');
  jj.setAttribute("src", "/bigdata/static/image/me.png");
  jj.setAttribute("width", "150");
  jj.setAttribute("height", "150");
  ii.appendChild(jj);
  hh.appendChild(ii);
  cc.appendChild(hh);
  
$(function() {
  var tags = $("#tag").val();
  var counts = tags.replace(/(.)(?=[^$])/g, "$1").split(","); //字符串转化为数组
  for (var i = 1; i <= 10; i++) {
    var oc = document.getElementById(i);
    if (counts[i - 1] % 2 == 1) {
      $(oc).css({
        color: "#FFFFFF",
        background: "blue"
      });
    }
    if (counts[i - 1] % 2 == 0) {
      $(oc).css({
        color: "#FFFFFF",
        background: "green"
      });
    }
  }
  $(".drag").draggable({
    revert: "valid",
    stop: function() {
      var k = $(this).attr('id');
      if (counts[k - 1] % 2 == 1) {
        $(this)
          .addClass("ui-state-highlight");
        $(this)
          .css({
            color: "#FFFFFF",
            background: "blue"
          });
      } else {
        $(this)
          .removeClass("ui-state-highlight");
        $(this)
          .css({
            color: "#FFFFFF",
            background: "green"
          });
      }
    }
  });

  $("#droppable").droppable({
    activeClass: "ui-state-default ",
    hoverClass: "ui-state-hover",
    drop: function(event, ui) {
      var k = ui.draggable.attr('id');
      counts[k - 1]++;
    }
  });

  // 改变透明度以及颜色
  $("#droppable").css("opacity", 0.4);
  $(".drag").css("opacity", 0.4);


  $("#subbutton").click(function() {

    // 创建一个 form  
    for (var i = 1; i <= 10; i++) {
      counts[i - 1] = counts[i - 1] % 2;
    }
    var count = counts.join(",")
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

});