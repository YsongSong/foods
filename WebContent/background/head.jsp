<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			#left{
				width: 75%;
				height: 62px;
				background-image: url(img/top-right.gif);
			}
			#right{
				float: right;
				width: 25%;
				height: 62px;
				background-image: url(img/top-right.gif);
			}
			marquee{
				padding-top: 10px;
				color: white;
			}
			#right_r{
				float: right;
				width: 35%;
				height: 62px;
				background-image: url(img/top-right.gif);
				
			}
			#right_l{
				width: 65%;
				height: 62px;
				background-image: url(img/top-right.gif);
			}
			a{
				color: whitesmoke;
				line-height: 46px;
				text-decoration: none;
				font-weight: bold;
			}
			a:hover{
				color: lightgray;
			}
			*{
				font-size: 12px;
			}
		</style>
		
	</head>
	<body bgcolor="#EEF2FB">
		<div id="right">
			<div id="right_r">
				<center><a href="../LogoutServlet?index=logout" target="_parent">退出</a></center>
			</div>
			<div id="right_l"><marquee >管理员：<span>${sessionScope.admin.adminName }</span>您好 感谢登录使用！</marquee></div>
		</div>
		<div id="left">
			<img src="img/logo.gif" height="64px" align="left"/>
			
		</div>
	</body>
</html>
