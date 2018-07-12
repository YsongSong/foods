<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			*{
				font-size: 12px;
			}
		</style>
	</head>
	<body bgcolor="#EEF2FB">
		<center>
			<table border="1" cellspacing="0px" bordercolor="#EEF2FB">
				<tr align="center">
					<th>菜单管理</th>
				</tr>
				
				<tr align="center">
					<td><a href="<c:url value='/AddFoodListServlet'/>" target="content">添加新菜单</a></td>
				</tr>
				<tr align="center">
					<td><a href="<c:url value='/ShowFoodList?index=find'/>" target="content">菜单信息列表</a></td>
				</tr>
				<tr align="center">
					<th>菜单类别管理</th>
				</tr>
				<tr align="center">
					<td><a href="<c:url value='/AddFoodType?index=add'/>"  target="content">添加新类别</a></td>
				</tr>
				<tr align="center">
					<td><a href="<c:url value='/AddFoodType?index=list'/>" target="content">类别信息列表</a></td>
				</tr>
				<tr align="center">
					<th>公告信息管理</th>
				</tr>
				<tr align="center">
					<td><a href="notice.jsp" target="content">添加新公告</a></td>
				</tr>
				<tr align="center">
					<td><a href="<c:url value='/ShowAllNoticeSerlet'/>" target="content">公告信息列表</a></td>
				</tr>
				<tr align="center">
					<th>销售订单管理</th>
				</tr>
				<tr align="center">
					<td><a href="<c:url value='/BackOrderServlet?method=getOrder'/>" target="content">销售订单信息列表</a></td>
				</tr>
				<tr align="center">
					<td><a href="orderquery.jsp" target="content">销售订单查询</a></td>
				</tr>
				<tr align="center">
					<td><a href="<c:url value='/BackOrderServlet?method=getSaleList'/>" target="content">本日销售统计</a></td>
				</tr>
				<tr align="center">
					<th><a href="<c:url value='/LogoutServlet?index=info'/>"  target="content">系统用户管理</a></th>
				</tr>
				<tr align="center">
					<th><a href="<c:url value='/LogoutServlet?index=logout'/>" target="_parent">退出</a></th>
				</tr>
			</table>
			
		</center>
	</body>
</html>
