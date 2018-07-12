<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			td,th{
				width:1215px ;
				
			}
			*{
				font-size: 12px;
			}
			
		</style>
	</head>
	<body bgcolor="#EEF2FB">
		<center>
			<form action="<c:url value='/LogoutServlet'/>" method="post">
			<input type="hidden" name="id" value="${admin.id }"/>
				<table border="1px" cellspacing="0px" bgcolor="aliceblue">
					<tr align="center">
						<th>更改管理员信息</th>
					</tr>
					<tr align="center">
						<th>管理员姓名<input type="text"  name="adminName" value="${admin.adminName }"/></th>
					</tr>
					<tr align="center">
						<th>管理员密码<input type="text" name="adminPwd" value="${admin.adminPwd }"/></th>
					</tr>
					<tr align="center">
						<th>
							<input type="submit" value="修改"/>
						</th>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>
