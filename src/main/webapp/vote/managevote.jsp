<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="voteContextRoot" class="com.gdpu.controller.rootcontroller.VoteContextRoot" scope="request" ></jsp:useBean>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
</head>
<html>
	<style type="text/css">
<!--
body {
	background-color: #869de3;
	text-align: center;
	margin:10px
	
}

-->
a {
	font-size: 12pt;
	text-decoration: none
}

.error {
	color: red
}
</style>
	<body>
			<br>
			<br>
			<br>
			${sessionScope.vote.title}
			<br>
			<form:form action="../vote/updateVoteContext.do" method="post" modelAttribute="voteContextRoot">
				<input type="hidden" name="formToken" value="${formToken}" />  
				<span class="error">
					${error}
				</span>
				<br>
				<spring:url value="../vote/addOneVoteContext.do?voteId=${sessionScope.vote.voteId}" var="url" htmlEscape="true"/>
				<a href="${url}">新增一个投票选项</a>
				<table style="margin:0 auto;">
					<c:forEach var="list" items="${sessionScope.list}" varStatus="status">
						<tr>
							<td>
								投票内容
								<form:input path="context[${status.index }]"></form:input>
							</td>
							<td>
								<spring:url value="../vote/delVoteContext.do" var="delVoteContext" htmlEscape="true">
									<spring:param name="voteId" value="${sessionScope.vote.voteId}"></spring:param>
									<spring:param name="votecontextId" value="${list.votecontextId}"></spring:param>
								</spring:url>
								<a href="${delVoteContext}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				投票类型
				<form:radiobuttons path="type" items="${typeMap}" delimiter="&nbsp;"/>  
				<br>
				是否开放
				<form:radiobuttons path="publish" items="${publishMap}" delimiter="&nbsp;"/>  
				<br>
				<input type="submit" value="更新"/>
			</form:form>
	</body>
</html>
