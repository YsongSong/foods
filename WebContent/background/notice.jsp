<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="css/4.1.css" />
	</head>
	<body bgcolor="#EEF2FB">
		<div>
		<form action="<c:url value='/InsertServlet'/>" method="post">
			
			<table border="1px" cellpadding="0px" cellspacing="0px"  bgcolor="aliceblue">
				
				<tr>
					<th align="right" class="td2">公告标题：</th>
					<td class="td3"><input type="text" name="noticetitle"></td>
				</tr>
				
				<tr>
					<th align="right" class="td2" >公告内容：</th>
					<td><textarea name="noticecontent">
					</textarea>
					</td>
				</tr>
				
				<tr>
					<td align="center" colspan="2" class="td1"><input type="submit" value="添加" name="notice4.1"/></td>
				</tr>
				
			</table>
		</form>
		</div>
	</body>
</html>
