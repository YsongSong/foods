<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8" />
		<title></title>
		
	</head>
	<frameset rows="10.3%,*" frameborder="0.5px" >
		<frame src="background/head.jsp" noresize="noresize" border="1px"/>
		<frameset cols="15%,*" frameborder="0.5px">
			<frame src="background/left.jsp" noresize=""/>
			<frame  name="content" src="background/welcome.jsp"/>
		</frameset>
	</frameset>
</html>