<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body{
				padding-top: 200px;
			}
			
		</style>
	</head>
	<body bgcolor="#EEF2FB">
		<center>
			<marquee bgcolor="#EEF2FB" height="300px">
				<h1>${sessionScope.admin.adminName }欢迎您使用本系统！</h1>
			</marquee>
		</center>
	</body>
</html>
