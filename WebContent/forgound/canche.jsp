<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>我的餐车</title>
	<link rel="Shortcut Icon" href="<c:url value='/forgound/img/title.gif'/>">
	<link rel="stylesheet" href="<c:url value='/forgound/css/common.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/forgound/css/information3.1.css'/>" />
	<script src="<c:url value='/forgound/js/jquery-1.5.1.js'/>"></script>
	<script src="<c:url value='/forgound/js/round.js'/>"></script>
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
	
<script type="text/javascript">
$(function() {
	
});
</script>
	
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
					<!-- 导航栏2结束 -->
				</div>
				<!-- 头部结束 -->

				<!-- 主体内容开始 -->
				<div class="div">
					<center>
					<form action="<c:url value='/OrderServlet'/>">
					<input type="hidden" name="method" value="createOrder"/>
						<table border="1" cellspacing="0" class="table">
							<tr>
								<td colspan="4">
									<center>我的订餐信息列表</center>
								</td>
							</tr>
							<tr>
								<td class="td1"><b>菜品名称</b></td>
								<td class="td2"><b>单价</b></td>
								<td class="td2"><b>数量</b></td>
								<td></td>
							</tr>
							
							<c:forEach items="${itemList.beanList }" var="Cartitem">
							
							<tr>
								<td class="td1" id="men3.1">${Cartitem.food.fname }</td>
								<td id="${Cartitem.cartitemId }">${Cartitem.food.currPrice }</td>
								<td id="number3.1">${Cartitem.quantity }</td>
								<td><input type="button" value="取消" id="cancel3.1" class="td5" /></td>
							</tr> 
							
							</c:forEach>
							
							<!-- 
							
							<tr>
								<td class="td1" id="men3.1"></td>
								<td id="pric3.1"></td>
								<td id="number3.1"></td>
								<td><input type="button" value="取消" id="cancel3.1" class="td5" /></td>
							</tr> 
							<tr>
								<td class="td1" id="men3.1"></td>
								<td id="pric3.1"></td>
								<td id="number3.1"></td>
								<td><input type="button" value="取消" id="cancel3.1" class="td5" /></td>
							</tr> 
							<tr>
								<td class="td1" id="men3.1"></td>
								<td id="pric3.1"></td>
								<td id="number3.1"></td>
								<td><input type="button" value="取消" id="cancel3.1" class="td5" /></td>
							</tr> 
							
							-->
							
							
							
							<tr>
							<td colspan="4">
								<center>小计：<span id="Tprice3.1">${itemList.subtotal }</span>元 共：<label id="Tnumber3.1">${itemList.total }</label>份</center>
							</td>
							</tr>
							<tr>
								<td colspan="4">
									<input type="submit" value="" class="td3" id="submit" />
									<input type="button" value="" class="td4" id="cance3.1" />
								</td>
							</tr>
						</table>
						</form>
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