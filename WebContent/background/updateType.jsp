<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#EEF2FB">
<center >
  <form action="<c:url value='/AddFoodType'/>" method="post">
   <table border="1" cellspacing="0" bgcolor="aliceblue">
    <input type="hidden" name="index" value="update"/>
    <tr align="center"><th colspan="2">修改类型</th></tr>
    <tr align="center">
      <th>类型ID</th>
      <th>类型名</th>
    </tr>
    <tr align="center">
     <td><input type="text" name="cid" readonly="readonly" value="${type.cid }"/></td>
       <td><input type="text" name="cidName" value="${type.cidName }"/></td>
    </tr>
   <tr align="center">
    <td colspan="2"><input type="submit" value="修改"/></td>
   </tr>
   </table>
   </form>
</center>
</body>
</html>