<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件列表</title>
<link rel="stylesheet" href="<c:url value='/forgound/img/title.gif'/>"/>
<link rel="stylesheet" href="<c:url value='/forgound/css/common.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/forgound/pager/pager.css'/>" />
<style type="text/css">
.td {
	width: 65%;
	height: 30px;
}

.td1 {
	width: 710px;
	height: 450px;
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
							<a href="<c:url value='ShowHdfsServlet'/>">文件管理</a>
							<a href="<c:url value='/QuitServlet?method=quit'/>">注销退出</a>
						</div>
					</div>
					<!-- 导航栏2结束 -->
				</div>
				<!-- 头部结束 -->

				<!-- 主体内容开始 -->
				<div class="td1">
					<center>
						<table border="1" cellspacing="0" width="710" bordercolor="#cfaa66">
							<tr>
								<th colspan="5">HDFS文件管理</th>
							</tr>
							<tr>
								<td class="td" style="text-align: center;">文件名</td>
								<td colspan="3" style="text-align: center;"><a href="UploadHDFSServlet">上传文件</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="ShowMap" target="_blank">查看地图</a></td>
							</tr>
	                        <c:forEach items="${pb.beanList }" var="item"> 
			                          <tr>
										<td class="td">${item.fileName }</td>
										<td><a href="DetailHDFSServlet?hid=${item.hid }">详情</a></td>
										<td><a href="DownloadServlcet?hid=${item.hid }">下載</a></td>
										<td><a href="DeleteHDFSServlet?hid=${item.hid }">刪除</a></td>
									 </tr>
	                        </c:forEach>
	
						</table>
						<div style="float:left; width: 400px; text-align: center; margin-left: 40px">
							<%@include file="pager/hdfsPage.jsp"%>
						</div>
					</center>
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