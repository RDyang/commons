<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="/css/common/common.css" rel="stylesheet"/>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/common/common.js"></script>
<title>电商平台管理系统</title>
</head>
<body>
	<div class="container">
		<div id="header" class="row clearfix">
			<div class="col-md-12 column">
				<h3>电商平台管理系统</h3>
				<br />
				<br />
			</div>
		</div>
		<div id="content" class="row clearfix">
			<div class="col-md-2 column">
				<ul id="menu" class="nav nav-tabs nav-stacked">
				</ul>
			</div>
			<div id="showDiv" class="col-md-10 column">
				<table class="table">
					<thead>
						<tr>
							<th>编号</th>
							<th>产品</th>
							<th>交付时间</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Default</td>
						</tr>
						<tr class="success">
							<td>1</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Approved</td>
						</tr>
						<tr class="error">
							<td>2</td>
							<td>TB - Monthly</td>
							<td>02/04/2012</td>
							<td>Declined</td>
						</tr>
						<tr class="warning">
							<td>3</td>
							<td>TB - Monthly</td>
							<td>03/04/2012</td>
							<td>Pending</td>
						</tr>
						<tr class="info">
							<td>4</td>
							<td>TB - Monthly</td>
							<td>04/04/2012</td>
							<td>Call in to confirm</td>
						</tr>
					</tbody>
				</table>
				<ul class="pagination">
					<li><a href="#">Prev</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">Next</a></li>
				</ul>
			</div>
		</div>
		<div id="footer" class="row clearfix">
			<div class="col-md-12 column">
				<address>
					<strong>Twitter, Inc.</strong><br /> 795 Folsom Ave, Suite 600<br />
					San Francisco, CA 94107<br /> <abbr title="Phone">P:</abbr> (123)
					456-7890
				</address>
			</div>
		</div>
	</div>
</body>
</html>