<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="Shortcut Icon" href="<c:url value='/forgound/img/title.gif'/>">
		<link rel="stylesheet" href="<c:url value='/forgound/css/common.css'/>"/>

		<style>
			a:link {
				text-decoration: none;
				color: black;
			}
			
			font {
				/*文字颜色*/
				color: red;
			}
				#top{
			width: 910px;
			height: 510px;
		}
		
		#middle{
			width: 910px;
			height: 355px;
			margin: auto;			
		}
		
		#bottom{
			width: 910px;
			height: 40px;
		}
		
		span{
			color: red;
		}
		.font1{
			color: #996633;
		}
		td{
			height: 26;
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
				<div class="middle">
					<table border="1px" cellpadding="0" cellspacing="0" align="center">
						<form method="post" action="<c:url value='/RegisterServlet'/>">
							<tr>
								<td colspan="7" align="center">请填写用户信息（带<span>*</span>为必选项）</td>
							</tr>

							<tr>
								<td class="font1" align="right">&nbsp;用户名：</td>
								<td colspan="2">&nbsp;<input type="text" name="userName" value="${user.userName}" }">&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><span>*</span>您用来登录的用户名</td>
							</tr>

							<tr>
								<td class="font1" align="right">密码：</td>
								<td colspan="2">&nbsp;<input type="password" name="userPwd" value="${user.userPwd}">&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><span>*</span>长度必须大于5个小于16个字符，只能为英语字、数字</td>
							</tr>

							<tr>
								<td class="font1" align="right">确认密码：</td>
								<td colspan="2">&nbsp;<input type="password" name="userPwd2" value="${user.userPwd}">&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><span>*</span>请将输入的密码再次输入</td>
							</tr>

							<tr>
								<td class="font1" align="right">性别：</td>
								<td colspan="2"><input type="radio"  name="userSex" value="男" checked="checked" value="${user.userSex}">男
									<input type="radio" name="userSex" value="女" value="${user.userSex}">女
								</td>
								<td><span>*</span>请填写您的真实年龄</td>
							</tr>

							<tr>
								<td class="font1" align="right">年龄：</td>
								<td colspan="2">&nbsp;<input type="text" name="userAge" value="${user.userAge}">&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><span>*</span>请填写您的真实年龄</td>
							</tr>

							<tr>
								<td class="font1" align="right">身份证号：</td>
								<td colspan="2">&nbsp;<input type="text" name="userNum" value="${user.userNum}">&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><span>*</span>请填写您的真实信息</td>
							</tr>

							<tr>
								<td class="font1" align="right">家庭住址：</td>
								<td colspan="2">&nbsp;<input type="text" name="userAddress" value="${user.userAddress }">&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><span>*</span>请填写您的真实信息</td>
							</tr>

							<tr>
								<td class="font1" align="right">电话号码：</td>
								<td colspan="2">&nbsp;<input type="text" name="userPhone" value="${user.userPhone }">&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><span>*</span>请填写您的真实信息（格式02411111111或13911111111）</td>
							</tr>

							<tr>
								<td class="font1" align="right">电子邮箱：</td>
								<td colspan="2">&nbsp;<input type="text" name="userEmail" value="${user.userEmail }">&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><span>*</span>请填写您有效的邮件地址，以便于我们为您提供有效的服务</td>
							</tr>

							<tr>
								<td class="font1" align="right">邮政编码：</td>
								<td colspan="2">&nbsp;<input type="text" name="userPostNum" value="${user.userPostNum }">&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><span>*</span>请填写您的真实信息（格式为111111）</td>
							</tr>

							<tr>
								<td colspan="7" align="center"><input type="submit" value="注册" /></td>
							</tr>
							
							<tr>
								<td colspan="7" align="center"><label style="color:red;">${error }</label></td>
							</tr>
						</form>

					</table>

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