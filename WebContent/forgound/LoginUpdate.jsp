LoginUpdateServlet<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录</title>
		<link rel="Shortcut Icon" href="<c:url value='/forgound/img/title.gif'/>">
		<link rel="stylesheet" href="<c:url value='/forgound/css/common.css'/>"/>
		<link rel="stylesheet" href="<c:url value='/forgound/css/login.css'/>" />
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
				<div class="middle">
					<div class="main">

						<div class="main1">

							<form method="post" action="<c:url value='/LoginUpdateServlet'/>">
								<table>
									<tr>
										<td>登录账号 <input type="text" name="userName" /></td>
									</tr>

									<tr>
										<td>身份证号 <input type="text" name="userNum"  /></td>
									</tr>
									
									
									<tr>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;新密码&nbsp;<input type="text" name="userPwd1" /></td>
									</tr>
									

									<tr>
										<td align="center">
											<input type="submit" name="Updatelogin" id="Updatelogin" class="Updateloginbutton" 
											value="重设"/>
										</td>
									</tr>
									
									<tr>
										<td>${error }</td>
									</tr>
								</table>
							</form>
						</div>

						<div class="main2">
							<table>
								<tr>
									<td><img src="<c:url value='/forgound/img/cateitems.gif'/>">如果您已经是会员，请在左侧登录</td>
								</tr>

								<tr>
									<td><img src="<c:url value='/forgound/img/cateitems.gif'/>">如果您还没有注册会员，
										<a href="regist.jsp" id="a1" >点击这里注册新会员</a>
									</td>
								</tr>

								<tr>
									<td><img src="<c:url value='/forgound/img/cateitems.gif'/>">如果您忘记了密码，
										<a href="#" id="a2" action="LoginUpdateServlet">点这里重设一个密码</a>
									</td>
								</tr>

							</table>

						</div>

					</div>

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