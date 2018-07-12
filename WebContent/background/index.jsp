<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="background/css/blogin.css" />
	</head>
	<style>
			.td{
				height: 319px;
				width: 718px;
			}
			.td1{
				margin-left: 400px;
				margin-top: 51px;
			}
			.td2{
				margin-left: 396px;
			}
			.td3{
				margin-left: 420px;
			}
			.td4{
				margin-left: 353px;
			}
			*{
				font-size: 12px;
			}
			.td5{
				margin-left: 62px;
			}
		</style>
	<body>
		<div class="main">
			<!-- 顶部开始 -->
			<div class="top"></div>

			<!-- 顶部结束 -->

			<!-- 中间开始 -->
			<div class="middle">
				<!-- 左边开始 -->
				<div class="left">
					<div>
						<table class="td">
							<tr>
								<td colspan="2"><img src="background/img/logo.png" class="td1" /></td>
							</tr>
							<tr>
								<td colspan="2"><img src="background/img/icon-mail2.gif" class="td2" />客户服务邮箱：admin@apsfc.com</td>
							</tr>
							<tr>
								<td colspan="2"><img src="background/img/icon-phone.gif" class="td3" />官方网站：http://www.apsfc.com</td>
							</tr>
							<tr>
								<td colspan="2"><img src="background/img/icon-demo.gif" class="td4" />使用说明
								<img src="background/img/icon-login-seaver.gif" class="td5" />在线客服</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- 左边结束 -->

				<!-- 右边开始 -->
				<div class="right">
					<form action="AdminServlet" method="post">
						<table>
							<tr>
								<td colspan="2">
									<span class="title">登录网上订餐后台管理</span>
								</td>
								<td></td>
							</tr>
							<tr>
								<td width="88px">管理员：</td>
								<td>
									<input type="text" name="loginname" id="loginname" />
								</td>
								<td></td>
							</tr>
							<tr>
								<td>密码：</td>
								<td>
									<input type="password" name="password" id="password" />
								</td>
								<td>
									<img src="background/img/luck.gif" />
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="checkbox" name="zlogin" />
									<span>
										5天自动登录
									</span>
								</td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="submit" value="登录" />
								</td>
								<td>
									<input type="reset" value="取消" />
								</td>
							</tr>
						</table>
					</form>
				</div>
				<!-- 右边结束 -->
			</div>
			<!-- 中间结束 -->

			<!-- 底部开始 -->
			<div class="buttom">
				Copyright(C)2015-2020
			</div>
			<!-- 底部结束 -->
		</div>
	</body>

</html>