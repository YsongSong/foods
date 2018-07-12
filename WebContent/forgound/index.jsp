<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主页</title>
		<link rel="Shortcut Icon" href="<c:url value='/forgound/img/title.gif'/>">
		<link rel="stylesheet" href="<c:url value='/forgound/css/common.css'/>"/>
		<link rel="stylesheet" href="<c:url value='/forgound/img/title.gif'/>"/>
		<link rel="stylesheet" href="<c:url value='/forgound/css/index.css'/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value='/forgound/pager/pager.css'/>" />
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
							<a href="<c:url value='/QuitServlet?method=quit'/>" class="a1">注销退出</a>
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
				<div id="main_2">
					
					<!-- 左边开始 -->
					<div class="left">
						<div style="width: 640px;height: 520px;">
							<ul class="ul1">
								<c:forEach items="${foods.beanList }" var="food">
								
								<li>
									<div class="food_left">
										<img src="${food.image }" class="food_img_1" />
										<a href="CartServlet?method=add&foodId=${food.foodId }"><img src="<c:url value='/forgound/img/cart.png'/>" /></a>
										<!--<input type="image" src="img/cart.png" />-->
									</div>
									<div class="food_right">
										<p>
											<span class="food_name">菜品名称：</span>
											<span class="food_name" id="food_name">${food.fname}</span>
										</p>
										<p>
											<span class="food_name">市场价格：</span>
											<span class="food_name" id="price">${food.price }</span>
										</p>
										<p>
											<span class="food_name">会员价格：</span>
											<span class="food_name" id="price_v">${food.currPrice }</span>
										</p>
										<p>
											<span class="peil_2">配料：</span>
											<span class="peil_detail_2" id="peil_2">${food.material }</span>
										</p>
										<p>
											<span class="food_name">菜品类型：</span>
											<span class="food_name" id="food_type">${food.type.cidName }</span>
										</p>
									</div>
								</li>
								
								</c:forEach>
								
							</ul>
						</div>
						<div style="float:left; width: 400px; text-align: center;">
							<%@include file="pager/pager.jsp"%>
						</div>
					</div>
					<!-- 左边结束 -->
					
					<!-- 右边开始 -->
					<div class="right">
						<!--上-->
						<div class="right_1">
							<p class="tiele_mess">
								<img src="<c:url value='/forgound/img/notice.jpg'/>" class="mess_img" /><span class="mess_title">餐厅公告</span>
								<a href="#" class="mess_a1">更多》</a>
							</p>
							<ul class="ul2">
							
							<c:forEach items="${message.beanList }" var="mess">
								<li>
									<img src="<c:url value='/forgound/img/43.gif'/>" class="detail_img" />
									<p class="mess_detail">
										<span class="mess_detail_1"><a href="FindByConditionServlet?mid=${mess.mid }" class="mess_a2">${mess.title }</a></span>
										<span class="mess_detail_2">${mess.messdate }</span>
									</p>
								</li>
							</c:forEach>
								
							</ul>
						</div>
						<!--中-->
						<div class="right_2">
							<p class="tiele_mess">
								<img src="<c:url value='/forgound/img/car.jpg'/>" class="mess_img" /><span class="mess_title">我的餐车</span>
								<a href="<c:url value='/CartServlet?method=getCartItem'/>" class="mess_a1">更多》</a>
							</p>
							<table cellpadding="0" cellspacing="0" style="width:250px;height: 100%;font-size: 12px" >
								
						<c:choose>
							<c:when test="${empty itemList }">
								没有餐车数据
							</c:when>
							<c:otherwise>
								<tr style="background-color: #FFC0CB;font-weight: bold;">
									<td width="50px"></td>	
									<td width="100px">菜单名称</td>
									<td width="50px">单价</td>
									<td width="50px">数量</td>
								</tr>
								<c:forEach items="${itemList }" var="Cartitem">
								<tr>
									<td></td>
									<td>${Cartitem.food.fname }</td>
									<td>
										<font color="red">
											${Cartitem.food.currPrice }
										</font>
										元
									</td>
									<td>
										<font color="red">
											${Cartitem.quantity }
										</font>
										份
									</td>
								</tr>
								</c:forEach>
								
								<tr>
									<td></td>
									<td colspan="3">
										<a href="<c:url value='/OrderServlet?method=createOrder'/>"><img src="<c:url value='forgound/img/canche_submit.gif'/>" /></a>
										<a href="<c:url value='/CartServlet?method=deleteAll'/>"><img src="<c:url value='forgound/img/quxiao2.gif'/>" /></a>
									</td>
								</tr>
							</c:otherwise>
							</c:choose>
							</table>
						</div>
						<!--下-->
						<div class="right_3">
							<p class="tiele_mess">
								<img src="<c:url value='/forgound/img/sale.jpg'/>" class="mess_img" /><span class="mess_title">销售排行榜</span>
								<a href="#" class="mess_a1">更多》</a>
							</p>
							<ul class="ul2">
							
							<c:choose>
								<c:when test="${empty sales }">
									暂无销售记录
								</c:when>
								<c:otherwise>
									<c:forEach items="${sales }" var="sale">
										<li>
											<img src="<c:url value='/forgound/img/43.gif'/>" class="detail_img" />
											<p class="mess_detail">
												<span class="mess_detail_1"><a href="#" class="mess_a2">${sale.food.fname }</a></span>
												<span class="mess_detail_2">售出${sale.quantity }份</span>
											</p>
										</li>
									</c:forEach>
								</c:otherwise>
							</c:choose>
								
								
							</ul>
						</div>
					</div>
					<!-- 右边开始 -->
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
