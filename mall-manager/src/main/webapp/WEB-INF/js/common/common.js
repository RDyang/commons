$(function() {
	/**
	 * 设置页面大小
	 */
	setWinHeight = function(){
		var winHeight;
		if (window.innerHeight)
			winHeight = window.innerHeight;
		else if ((document.body) && (document.body.clientHeight))
			winHeight = document.body.clientHeight;
		
		$(".container").css("height",winHeight + "px");
		$("div").css("overflow","auto");
		var contentHeight = winHeight * 0.7;
		$("#content").css("height",contentHeight + "px");
		$("#showDiv").css("height",contentHeight + "px");
	}
	setWinHeight();
	$.ajax({
		url : '/manager/menu/showMenu',
		method : 'post',
		success : function(v) {
			$.each(v, function(idx, item) {
				var html = "<li><a href='javascript:void(0)' onclick=\"clickMenu('"
					+ item.id + "','" + item.url + "')\">" + item.text + "</a></li>";
				$("#menu").append(html);
			});
		}
	});
	clickMenu = function(id,url){
		$(this).parent().addClass("active");
		$("#showDiv").load(url);
	}
})