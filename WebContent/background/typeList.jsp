<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  th,td{
    width: 300px;
  }
</style>
</head>
<body bgcolor="#EEF2FB">
	<center>
		<table border="1" cellspacing="0" bgcolor="aliceblue">
			<tr align="center">
				<th>类别ID</th>
				<th>类别名称</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			<c:forEach items="${types }" var="item">
				<tr align="center">
					<td>${item.cid }</td>
					<td>${item.cidName }</td>
					<td><a href="<c:url value='/AddFoodType?index=update&cid=${item.cid }'/>">修改</a></td>
					<td><a href="<c:url value='/AddFoodType?index=delete&cid=${item.cid }'/>">删除</a></td>
				</tr>
			</c:forEach>


		</table>
	</center>

</body>
</html>