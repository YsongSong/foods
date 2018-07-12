<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
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
				height:250px;
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
			.d{
				margin-left: 5px;
				margin:auto;
				margin-top:10px;
			}
			.text{
				width:120px;
			}
			.m{
				width: 100%;
				height:100%;
			}
		</style>
	</head>
	<body>
		<div >
		<div>
			
			<div class="main">
			
			<div class="top1">
			</div>
			
			<div class="top2">	
			</div>
			
			<div >		
			<table width="98%" height="110px" border="1px" cellspacing="0" bordercolor="#D6D7D9" class="d" >
				<tr >
					<td colspan="10">按用户ID查询
						<form action="<c:url value='/BackOrderServlet'/>">
							<input type="hidden" name="method" value="getOrderByUserId" />
							<input type="text" class="text" name="userId"/>&nbsp;
							<input type="submit" value="查询"/>
						</form>
					</td>		
				</tr>
				<tr>
					<td colspan="10">按菜品名称查询
						<form action="<c:url value='/BackOrderServlet'/>">
							<input type="hidden" name="method" value="getOrderByFoodName" />
							<input type="text" class="text" name="foodName"/>&nbsp;
							<input type="submit" value="查询"/>
						</form>
					</td>
				</tr>
				<tr>
					<td colspan="10">按销售日期查询
						<form action="<c:url value='/BackOrderServlet'/>">
							<input type="hidden" name="method" value="getOrderByOrderTime" />
							<input type="text" class="text" name="ordertime"/>&nbsp;
							<input type="submit" value="查询"/>
						</form>
					</td>
				</tr>
			</table>
			</div>
			
			<div class="m">
			<table width="98%" height="80px" border="1px" cellspacing="0" bordercolor="#D6D7D9" class="d" >
				<tr>
					<th colspan="11">销售订单查询结果信息列表</th>
				</tr>
				<tr >
					<td>用户ID</td>
					<td>真实姓名</td>
					<td>联系方式</td>
					<td>家庭住址</td>
					<td>菜品名称</td>
					<td>订购数量</td>
					<td>单价(元)</td>	
					<td>合计(元)</td>
					<td>订购时间</td>
					<td>是否派送</td>
				</tr>
				<c:forEach items="${orderList }" var="order">
				
				<tr>
					<td>${order.user.userId }</td>
					<td>${order.user.userName }</td>
					<td>${order.user.userPhone }</td>
					<td>${order.user.userAddress }</td>
					<td>${order.food.fname }</td>
					<td>${order.quantity }</td>
					<td>${order.food.currPrice }</td>
					<td>${order.total }</td>
					<td>${order.ordertime }</td>
					<td>
						<c:if test="${order.status eq 1 }">
							是
						</c:if>
						<c:if test="${order.status eq 0 }">
							否
						</c:if>
					</td>
					<td></td>	
				</tr>
				
				</c:forEach>
				
				
			</table>
			</div>
			
		</div>
		
		
		</div>
		
		</div>
	</body>
</html>
