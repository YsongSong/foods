<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8" />
		<title></title>
		<style>
			td{
				width: 304px;
			}
			.td{http://localhost:8080/Food/
				width: 200px;
			}
			.td1{
				width: 720px;
				height: 184px;
			}
			*{
				font-size: 12px;
				align-items: center;
			}
			
		</style>
	</head>
	<body bgcolor="#EEF2FB">
		<div class="td2">
			<center>
			<form action="<c:url value='/AddFoodListServlet'/>" method="post" enctype="multipart/form-data">
			<table border="1" cellspacing="0" bgcolor="aliceblue">
				<tr>
					<td align="right">菜品名称：</td><td colspan="3"><input type="text" class="td" name="fname"/></td>
				</tr>
				<tr>
					<td align="right">市场价格：</td><td colspan="3"><input type="text" class="td"name="price"/></td>
				</tr>
				<tr>
					<td align="right">会员价格：</td><td colspan="3"><input type="text" class="td" name="currPrice"/></td>
				</tr>
				<tr>
					<td align="right">原料：</td><td colspan="3"><input type="text" class="td" name="material"/></td>
				</tr>
				<tr>
					<td align="right">说明：</td><td colspan="3"><textarea class="td1" name="food_desp"></textarea></td>
				</tr>
				<tr>
					<td align="right">菜品类别：</td><td colspan="3"><select name="cid">
					<option selected="selected">--选择类型--</option>
					                                 <c:forEach items="${ sessionScope.convertType.map}" var="item">
					                                         <option value="${item.key }" >${item.value}</option>
					                                 </c:forEach>
					                                 
					                          </select></td>
				</tr>
				<tr>
					<td align="right">上传图片：</td><td colspan="3"><input type="file" value="选择文件" name="image" /></td>
				</tr>
				<tr>
					<td align="right"></td><td colspan="3"><center><input type="submit" value="添加" /></center></td>
				</tr>
			</table>
			</form>
			</center>
		</div>
	</body>
</html>
