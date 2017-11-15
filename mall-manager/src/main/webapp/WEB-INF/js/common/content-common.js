$(function() {
	setContentTable = function() {
		var parentHeight = $("#content-table").parent().parent("#showDiv")
				.height();
		var curHeight = parentHeight * 0.8;
		$("#content-table").css("height", curHeight + "px");
		$("#table-body").height((curHeight - 100) + "px");
		$("#table-body").css("overflow", "auto");

		// 显示当前可显示的条数
		$("#pageSize option[value='" + curPageSize + "']").attr("selected",
				true);

	}
	setContentTable();
	$("#pageSize").change(function() {
		var value = $(this).children("option:selected").val();
		$("#showDiv").load(uri, {
			pageSize : value
		});
	})
	flip = function(pageIndex) {
		console.log(pageIndex);
		$("#showDiv").load(uri, {
			pageIndex : pageIndex
		});
	}
	search1 = function() {
		var value = $("#search").val();
		console.log(value);
		$("#showDiv").load(uri, {
			pageIndex : curPageIndex,
			pageSize : curPageSize,
			name : value
		});
	}
})