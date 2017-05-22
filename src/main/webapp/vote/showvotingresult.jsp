<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/echarts.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>

</head>
<style type="text/css">
<!--
body {
	/* background-color: #869de3; */
	/* text-align: center */
	
}

-->
a {
	font-size: 12pt;
	text-decoration: none
}
</style>
<body>
	<center>
		目前共有
		<c:out value="${sessionScope.totalcount}"></c:out>
		人参加了投票
		<%-- <c:out value="${sessionScope.vote2.title}"></c:out> --%>
		<br>
		<div id="main" style="width: 600px;height:400px;"></div>
		<div id="main1" style="width: 600px;height:400px;"></div>
		<div id="main2" style="width: 600px;height:400px;"></div>
		<script type="text/javascript">
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('main'));
			var myChart1 = echarts.init(document.getElementById('main1'));
			var myChart2 = echarts.init(document.getElementById('main2'));
			// 初始 option
			option = {
				title : {
					text : '${sessionScope.vote2.title}'
				},
				tooltip : {},
				legend : {
					data : [ '票数' ]
				},
				xAxis : {
					data : []
				},
				yAxis : {},
				series : [ {
					name : '票数',
					type : 'bar',
					data : []
				} ]
			};
			// 初始饼图 option2
			option2 = {
				title : {
					text : '${sessionScope.vote2.title}',
					x:'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					left : 'left',
					data : []
				},
				series : [ {
					name : '票数',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '60%' ],
					data : [],
					itemStyle : {
						emphasis : {
							shadowBlur : 10,
							shadowOffsetX : 0,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				} ]
			};

			myChart.setOption(option);
			myChart1.setOption(option);
			myChart2.setOption(option2);
			//myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

			$.ajax({
				type : "post",
				async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
				url : "../vote/showVotingResult1.do", //请求发送
				data : {},
				dataType : "json", //返回数据形式为json
				success : function(result) {
					//请求成功时执行该函数内容，result即为服务器返回的json对象
					if (result) {
						myChart.setOption({
							xAxis : {
								data : result.categories
							},
							series : [ {
								// 根据名字对应到相应的系列
								name : '票数',
								type : 'bar',
								data : result.data
							} ]
						});
						myChart1.setOption({
							xAxis : {
								data : result.categories
							},
							series : [ {
								// 根据名字对应到相应的系列
								name : '票数',
								type : 'line',
								data : result.data
							} ]
						});
					}

				},
				error : function(errorMsg) {
					//请求失败时执行该函数
					alert("图表请求数据失败!");
					myChart.hideLoading();
				}
			})

			$.ajax({
				type : "post",
				async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
				url : "../vote/showVotingResult2.do", //请求发送
				data : {},
				dataType : "json", //返回数据形式为json
				success : function(result) {
					//请求成功时执行该函数内容，result即为服务器返回的json对象
					if (result) {
						myChart2.setOption({
							legend : {
								data : result.categories
							},
							series : [ {
								data : result.array,
							} ]
						});
					}

				},
				error : function(errorMsg) {
					//请求失败时执行该函数
					alert("图表请求数据失败!");
					myChart.hideLoading();
				}
			})
		</script>

	</center>
</body>
</html>

