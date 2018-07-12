<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#EEF2FB">
	<center>
		<table border="1" cellspacing="0" bgcolor="aliceblue">
			<tr align="center">
				<th>菜单名称</th>
				<th>展示图片</th>
				<th>原料</th>
				<th>类型</th>
				<th>说明</th>
				<th>市场价格</th>
				<th>市场销售数量</th>
				<th>会员单价</th>
				<th>会员价销售数量</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			<c:forEach items="${foods }" var="item">
				<tr>
					<td>${item.fname }</td>
					<td><img alt="菜图" src="${item.image}" width="40px" height="30px"></td>
					<!-- 图片最后添加 -->
					<td>${item.material }</td>
					<td>${sessionScope.convertType.map[item.type.cid]}</td>
					<td>${item.food_desp }</td>
					<td>${item.price }</td>
					<td>无</td>
					<td>${item.currPrice }</td>
					<td>${item.quantity1 }</td>
					<td><a href="<c:url value='/ShowFoodList?index=update&foodId=${item.foodId }'/>">修改</a></td>
					<td><a href="<c:url value='/ShowFoodList?index=delete&foodId=${item.foodId }'/>">删除</a></td>
				</tr>
			</c:forEach>


		</table>
	</center>

</body>
</html>