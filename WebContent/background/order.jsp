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
			}
			
		</style>
	</head>
	<body>
		<div>
			<div class="main">
			
			<div class="top1">
				
			</div>
			<div class="top2">
				
			</div>
			<div class="top3">
				订单信息
			</div>
			<div >
			<c:choose>
				<c:when test="${empty orderList }">
					没有订单数据
				</c:when>
				<c:otherwise>
			<table width="98%" height="250px" border="1px" cellspacing="0" bordercolor="#D6D7D9" class="d" >
				<tr >
					 <th colspan="11">销售订单查询结果信息列表</th>
				</tr>
				<tr >
					<th>用户ID</th>
					<th>真实姓名</th>
					<th>联系方式</th>
					<th>家庭住址</th>
					<th>菜品名称</th>
					<th>订购数量</th>
					<th>单价(元)</th>
					<th>合计(元)</th>
					<th>订购时间</th>
					<th>是否派送</th>
					<th>确认订单</th>	
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
					<td>
						<a href="<c:url value='/BackOrderServlet?method=sureOrder&orderId=${order.oderId }'/>">确认</a>
					</td>	
				</tr>
				
				</c:forEach>
				
				<!-- 
				<tr>
					<td>4</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>番茄</td>
					<td>2</td>
					<td>21.0</td>
					<td>24.0</td>
					<td>2015-07-26 23:16:20</td>
					<td>是</td>
					<td></td>	
				</tr>
				<tr>
					<td>4</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>鸡肉排骨</td>
					<td>1</td>
					<td>24.0</td>
					<td>24.0</td>
					<td>2015-07-27 00:16:20</td>
					<td>是</td>
					<td></td>	
				</tr>
				<tr>
					<td>4</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>万香驴肉</td>
					<td>1</td>
					<td>21.0</td>
					<td>21.0</td>
					<td>2015-07-27 00:36:20</td>
					<td>是</td>
					<td></td>	
				</tr>
				<tr>
					<td>2221</td>
					<td>王二</td>
					<td>1</td>
					<td>1</td>
					<td>回锅肉</td>
					<td>2</td>
					<td>42.0</td>
					<td>84.0</td>
					<td>2015-07-27 01:36:20</td>
					<td>是</td>
					<td></td>	
				</tr>
				
				-->
				
				
				<tr>
					<td colspan="11">第1页&nbsp;&nbsp;共2页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[首页]&nbsp;&nbsp;[尾页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[上一页]&nbsp;&nbsp;[下一页]</td>
				</tr>
			</table>
			</c:otherwise>
			</c:choose>
			</div>
		</div>
		
		</div>
		
	</body>
</html>
