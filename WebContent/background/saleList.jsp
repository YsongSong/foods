<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>銷售統計</title>
		<style>
			*{
				font-size: 12px;
				margin: 0;
				padding:0;
			}
			td{
				text-align: center;
			}
			.main{
				border:1px solid #D2D3D5;
				height:100%;
				width:98%;
				border-radius: 2px;
			}
			
			.top1{
				width:100%;
				height:20px;
				border:1px solid #D2D3D5;
				background-color: #E4ECEF;
				margin:auto;
			}
			.top2{
				width:100%;
				height:2px;
				border:1px solid black;
				background-color:black;
			}
			.top3{
				border:1px solid #D2D3D5;
				width:50px;
				height:20px;
				border-radius: 2px;
				margin-top:-23px;
				margin-left:5px;
				background-color: white;
				text-align:center;
				line-height: 20px;
			}
			.d{
				margin-left: 5px;
				margin:auto;
				margin-top:10px;
			}
			
		</style>
	</head>
	<body>
		<div >
			<div class="main">
			
				<div class="top1">
				</div>
			
				<div class="top2">	
				</div>
			
				<div class="top3">
					订单查询
				</div>
			
				<div class="m">
					<table width="98%	" height="100%" border="1px" cellspacing="0" bordercolor="#D6D7D9" class="d" >
						<tr>
							<th colspan="4">本日销售额统计</th>
						</tr>
						<tr>
							<th>奖品名称</th>
							<th>订购数量</th>
							<th>单价</th>
							<th>合计</th>
						</tr>
						
					<c:forEach items="${saleList.beanList }" var="order">
						
						<tr>
							<th>${order.food.fname }</th>
							<th>${order.quantity }</th>
							<th>${order.food.currPrice }</th>
							<th>${order.total }</th>
						</tr>
						
					</c:forEach>
									
						<tr>
							<td colspan="4">本日销售总额:${saleList.subtotal }元</td>
						</tr>
					</table>
				</div>
			
			</div>
			
		</div>
			
		
		
	</body>
</html>
