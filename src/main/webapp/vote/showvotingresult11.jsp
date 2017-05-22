<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><style type="text/css">
<!--
body {
	background-color: #869de3;
	/* text-align: center */
}
-->
a { font-size: 12pt; text-decoration: none}
</style>
	<body>
		<center>
		目前共有
		<c:out value="${sessionScope.totalcount}"></c:out>
		人参加了投票
		<c:out value="${sessionScope.vote.title}"></c:out>
		<br>
		<table width="30%">
			<c:forEach var="vt" items="${requestScope.list2}" varStatus="st">
				<tr>
					<td>
						<c:out value="${vt.context}"></c:out>
					</td>
					<td width="25%">
						<c:out value="${vt.count }"></c:out>
					</td>
					<td>
						票
					</td>
					<td>
						<img src="${pageContext.request.contextPath}/static/images/bar.jpg" width="${vt.count}" height="10" />
					</td>
					<td>
						<c:out value="${vt.percent }"></c:out>
					</td>
				</tr>
			</c:forEach>
		</table>
		</center>
	</body>
</html>

