<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
<!--
body {
	background-color: #869de3;
	margin:10px;
}

-->
a {
	font-size: 12pt;
	text-decoration: none
}
</style>
<body>
	<a href="../admin/main.jsp">投票主页
	</a>>>>管理投票 
	<center>
		<br> 
		<br>
		<table border="1" width="75%">
			<c:forEach var="list" items="${voteRoot.list2}" varStatus="st">
				<c:if test="${st.first==true}">
					<tr bgcolor="#5e80e8" bordercolor="#5e80e8">
						<td>
							<div align="center">投票编号</div>
						</td>
						<td>
							<div align="center">投票主题</div>
						</td>
						<td>
							<div align="center">创建时间</div>
						</td>
						<td>
							<div align="center">创建人</div>
						</td>
						<td>
							<div align="center">投票状态</div>
						</td>
						<td>
							<div align="center">投票类型</div>
						</td>
						<td>
							<div align="center">编辑</div>
						</td>
					</tr>
				</c:if>
				<tr>
					<td>
						<div align="center">
							<c:out value="${list.voteId}" />
						</div>
					</td>
					<td>
						<div align="center">
						    <spring:url value="../vote/showVoting.do" var="showVoting" htmlEscape="true">
								<spring:param name="voteId" value="${list.voteId}" />
							</spring:url>
							<a target='_blank' href='${showVoting}'>${list.title} </a>
						</div>
					</td>
					<td>
						<div align="center">
							<c:out value="${list.createdate}" />
						</div>
					</td>
					<td>
						<div align="center">
							<c:out value="${list.adminname}" />
						</div>
					</td>
					<td>
						<div align="center">
							<c:out value="${list.publish}" />
						</div>
					</td>
					<td>
						<div align="center">
							<c:out value="${list.type}" />
						</div>
					</td>
					<td>
						<div align="center">
							<spring:url value="../vote/findOneVote.do" var="findOneVote" htmlEscape="true">
								<spring:param name="flag" value="1" />
								<spring:param name="voteId" value="${list.voteId}" />
							</spring:url>
							<a href='${findOneVote}'> 编辑 </a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>
