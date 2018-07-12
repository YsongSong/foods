<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>中国地图</title>
</head>
<body>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 800px;height:600px;margin: 0 auto"></div>

    <script src="<c:url value='/forgound/js/echarts.min.js'/>"></script>
    <script src="<c:url value='/forgound/js/china.js'/>"></script>
    <script>
        function randomData() {
            return Math.round(Math.random()*1000);
        }

        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        var option = {
            title: {
                text: '全国菜品推荐',
                left: 'center'
            },
            tooltip:{
                trigger:'item'
            },
            visualMap: {
                min: 0,
                max: 2500,
                show:false
            },
            series: [{
                type: 'map',
                map: 'china',
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[
                	{name: '北京',value: '北京烤鸭|10010|forgound/img/116.jpg'},
                    {name: '天津',value: randomData() },
                    {name: '上海',value: randomData() },
                    {name: '重庆',value: randomData() },
                	<c:forEach items="${map }" var="food">
                    {name: '${food.district}',value: '${food.foodName}|热度：${food.level}|${food.src}'},
                    </c:forEach>
                    {name: '台湾',value: randomData() },
                    {name: '香港',value: randomData() },
                    {name: '澳门',value: randomData() }
                ],
                tooltip:{
                    formatter:function(param) {
                        var arr = param.data.value.split("|");
                        return "<img width='250px' height='150px' src=" + arr[2] + "><br/>" + arr[0] + "&nbsp;&nbsp" + arr[1];
                    }

                }

            }]
        }

        myChart.setOption(option);
    </script>
</body>
</html>