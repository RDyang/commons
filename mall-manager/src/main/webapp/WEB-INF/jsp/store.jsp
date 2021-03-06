<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<script type="text/javascript">
		var uri = "/manager/stock/showStock";
		var curPageSize = "${stock.pageSize }";
		var curPageIndex = "${stock.pageIndex}";
	</script>
	<script type="text/javascript" src="/js/common/content-common.js"></script>

	<div class="row clearfix" style="border: 1px #ccc solid;">
		<div id="content-table" class="col-md-12 column"
			style="overflow: hidden;">
			<div>
				<div class="col-md-12 column">
					<nav class="navbar navbar-default navbar-static-top" role="navigation">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<label for="serarch">产品：</label>
								<input id="search" type="text" class="form-control" />
							</div>
							<button type="button" class="btn btn-default" onclick="javascript:search1()">Search</button>
							<button type="button" class="btn btn-default">Clear</button>
						</form>
					</div>
					</nav>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>编号</th>
							<th>产品</th>
							<th>库存</th>
						</tr>
					</thead>
				</table>
			</div>
			<div id="table-body" style="overflow: auto">
				<table class="table">
					<tbody>
						<c:forEach var="stock" items="${stock.items }">
							<tr>
								<td>${stock.id }</td>
								<td>${stock.name }</td>
								<td>${stock.amount }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-1 column">
			<span class="page"><select id="pageSize" name="pageSize">
					<option id="size5" value="5">5</option>
					<option id="size10" value="10">10</option>
					<option id="size20" value="20">20</option>
					<option id="size50" value="50">50</option>
			</select></span>
		</div>
		<div class="col-md-9 column">
			<ul id="pagination" class="pagination">
				<c:if test="${stock.pageIndex == 1 }">
					<li><a style="cursor: default; color: #ccc"
						href="javascript:return false">Prev</a></li>
				</c:if>
				<c:if test="${stock.pageIndex != 1 }">
					<li><a href="javascript:flip(${stock.pageIndex - 1 })">Prev</a></li>
				</c:if>

				<c:set var="more" value="true"></c:set>
				<c:forEach var="index" begin="1" end="${stock.pageCount }">
					<c:choose>
						<c:when test="${stock.pageCount < 10 }">
							<c:choose>
								<c:when test="${index == stock.pageIndex }">
									<li class="active"><a href="javascript:flip(${index})">${index }</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="javascript:flip(${index})">${index }</a></li>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${index == stock.pageIndex }">
									<c:if
										test="${index > 5 && ( index >= stock.pageIndex - 1 && index <=stock.pageIndex + 1 ) && index != stock.pageCount }">
										<c:set var="more" value="true"></c:set>
									</c:if>
									<li class="active"><a href="javascript:flip(${index})">${index }</a></li>
								</c:when>
								<c:when
									test="${(index <= 5 || index >= stock.pageIndex - 1 && index <=stock.pageIndex + 1 || index == stock.pageCount) }">
									<li><a href="javascript:flip(${index})">${index }</a></li>
								</c:when>
								<c:when test="${more == true }">
									<c:set var="more" value="false"></c:set>
									<li><a>...</a></li>
								</c:when>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${stock.pageIndex == stock.pageCount }">
					<li><a style="cursor: default; color: #ccc"
						href="javascript:return false">Next</a></li>
				</c:if>
				<c:if test="${stock.pageIndex != stock.pageCount }">
					<li><a href="javascript:flip(${stock.pageIndex + 1 })">Next</a></li>
				</c:if>

			</ul>
		</div>
		<div class="col-md-2 column">
			<span class="page">共${stock.rowsCount }条记录</span>
		</div>
	</div>
</body>
</html>