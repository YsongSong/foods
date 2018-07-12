<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body bgcolor="#EEF2FB">
		<form>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  bgcolor="aliceblue">
				<tr>
					<th>公告标题</th>
					<th>公告细节</th>
					<th>公告时间</th>
				    <th></th>
				    <th></th>
				</tr>
				<c:forEach items="${list}" var="notice">
				<tr>
					<th>${notice.title}</th>
					<th>${notice.detail}</th>
					<th>${notice.messdate}</th>
				    <th><a href="<c:url value='/DeleteNoticeServlet?mid=${notice.mid}'/>">删除</a></th>
				    <th><a href="<c:url value='/UpdateNoticeServlet?mid=${notice.mid}'/>">修改</a></th>
				</tr>	
				</c:forEach>
				
			</table>
		</form>
	</body>
</html>