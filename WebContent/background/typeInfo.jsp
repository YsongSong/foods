<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			td,th{
				width:304px ;
				
			}
			*{
				font-size: 12px;
			}
			
		</style>
	</head>
	<body bgcolor="#EEF2FB">
		<center>
			<table border="1px" cellspacing="0px" bgcolor="aliceblue">
				<tr align="center">
					<th colspan="4">本日销售额统计</th>
				</tr>
				<tr align="center">
					<th>菜品名称</th>
					<th>订购数量</th>
					<th>单价</th>
					<th>合计</th>
				</tr>
				<tr align="center">
					<th colspan="4">本日销售总额：<span></span>元</th>
				</tr>
			</table>
		</center>
	</body>
</html>
