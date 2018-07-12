<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
<link rel="Shortcut Icon" href="<c:url value='/forgound/img/title.gif'/>">
		<link rel="stylesheet" href="<c:url value='/forgound/css/common.css'/>"/>
		<link rel="stylesheet" href="<c:url value='/forgound/css/order3.2.css'/>" />
		<style>
			a:link {
				text-decoration: none;
				color: black;
			}
			
			font {
				/*文字颜色*/
				color: red;
			}
		</style>
	</head>

	<body>
		<center>
			<!-- 整个页面div -->
			<div id="all">
				<!-- 头部 -->
				<div id="head_2">
					<!-- 导航栏1 -->
					<div id="menu1_2">
						<div class="menu1_2">
							<a href="<c:url value='/forgound/login.jsp'/>" target="_blank">会员登录</a>
							<a href="<c:url value='/forgound/regist.jsp'/>" class="a1" target="_blank">会员注册</a>
							<a href="#会员登录" class="a1">注销退出</a>
							<a href="<c:url value='/forgound/introduct.jsp'/>" class="a1">配送说明</a>
							<a href="<c:url value='/forgound/about.jsp'/>" class="a1" target="_blank">关于我们</a>
						</div>
					</div>
					<!-- 导航栏1结束 -->
					
					<!-- 导航栏2 -->
					<div id="menu2_2">
						<div class="welcome">
							${userSession.userName}
						</div>
						<div class="menu2_2">
							<a href="<c:url value='/index.jsp'/>">首页</a>
							<a href="<c:url value='/CartServlet?method=getCartItem'/>">我的餐车</a>
							<a href="<c:url value='/OrderServlet?method=getOrderByUserId'/>">我的订单</a>
							<a href="#">用户中心</a>
							<a href="<c:url value='/forgound/introduct.jsp'/>">配送说明</a>
							<a href="<c:url value='/forgound/about.jsp' />" target="_blank">关于我们</a>
							<a href="<c:url value='/ShowHdfsServlet'/>">文件管理</a>
							<a href="<c:url value='/QuitServlet?method=quit'/>">注销退出</a>
						</div>
					</div>
					<!-- 导航栏2结束 -->
				</div>
				<!-- 头部结束 -->

				<!-- 主体内容开始 -->
				<div class="div2">
					<center>
						<table border="1" cellspacing="0" class="table" id="td2">
							<tr>
								<td>
								<form action="<c:url value='/OrderServlet'/>" >
								<input type="hidden" name="method" value="getOrderFood" />	
									<center>按菜品名称查询 <input type="text" id="search3.2" name="foodname"/><input type="submit" value="查询" id="searc3.2" /></center>
								</form>
								</td>
							</tr>
							<tr>		
								<td>
								<form action="<c:url value='/OrderServlet'/>" >
								<input type="hidden" name="method" value="getOrderTime" />
									<center>按销售日期查询 <input type="text" id="sear3.2" name="ordertime"/><input type="submit" value="查询" id="sea3.2" /></center>
								</form>
								</td>	
							</tr>
							<tr>
								<td>
									<center>
										<a href="<c:url value='/OrderServlet?method=getOrderByUserId1'/>" class="td" id="order3.2" >我的所有订单</a>
										<a href="<c:url value='/OrderServlet?method=getOrderStatus&status=1'/>" class="td" id="orde3.2" >已派送订单</a>
										<a href="<c:url value='/OrderServlet?method=getOrderStatus&status=0'/>"  class="td" id="ord3.2" >未派送订单</a>
									</center>
								</td>
							</tr>
						</table>
						<table border="1" cellspacing="0" id="td3">
							<tr>
								<td class="td1" colspan="9"><b>订单查询结果信息列表</b></td>
							</tr>
							<tr>
								<center>
									<td><b>菜品名称</b></td>
									<td><b>真实姓名</b></td>
									<td><b>订购电话</b></td>
									<td><b>派送地址</b></td>
									<td><b>订购数量</b></td>
									<td><b>单价(元)</b></td>
									<td><b>合计(元)</b></td>
									<td><b>订购时间</b></td>
									<td><b>是否派送</b></td>
								</center>
							</tr>
							<tr>
								<td id="menuname3.2">菜品名称</td>
								<td id="name3.2">真实姓名</td>
								<td id="phonenumber3.2">订购电话</td>
								<td id="address3.2">派送地址</td>
								<td id="number3.2">订购数量</td>
								<td id="price3.2">单价(元)</td>
								<td id="Tprice3.2">合计(元)</td>
								<td id="time3.2">订购时间</td>
								<td id="if3.2">是否派送</td>
							</tr>
					<c:forEach items="${orderList }" var="order">
				
				<tr>
					<td>${order.food.fname }</td>
					<td>${order.user.userName }</td>
					<td>${order.user.userPhone }</td>
					<td>${order.user.userAddress }</td>
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
				</tr>
				</c:forEach>
			
						</table>
					</center>
			
				</div>
				<!-- 主体内容结束 -->

				<!-- 底部开始 -->
				<div id="foot_2">
					<span>
						<a href="#关于我们">关于我们</a>
						<a href="#配送说明">配送说明</a>
					</span>
					<span style="color: #7D7C7C; font-size: 14px;">
							Copyright(C)2015-2020
					</span>
				</div>
				<!-- 底部结束 -->
			</div>
			<!-- 整个页面div 结束 -->
		</center>

	</body>

</html>