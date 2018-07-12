<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			td{
				width: 1215px;
			
			}
			*{
				font-size: 12px;
			}
			.td1{
				margin-top: 23px;
				margin-left: 12px;
			}
			
		</style>
	</head>
	<body bgcolor="#EEF2FB">
		<div class="td1">
			<form action="<c:url value='/AddFoodType'/>" method="post">
			<input type="hidden" name="index" value="add"/>
				<table border="1" cellspacing="0" bgcolor="aliceblue">
					<tr align="center">
						<td>菜品类别：<input type="text" name="cidName"/></td>
					</tr>
					<tr align="center">
						<td  ><input type="submit" value="添加"/> </td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
