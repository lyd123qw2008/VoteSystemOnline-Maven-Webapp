<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:useBean id="voteContextRoot" class="com.gdpu.controller.rootcontroller.VoteContextRoot" scope="request" ></jsp:useBean>
<html><style type="text/css">
<!--
body {
	background-color: #869de3;
	text-align: center
}
-->
a { font-size: 12pt; text-decoration: none}
</style>
	<body>
		${sessionScope.vote2.title}
		<form:form action="../voter/checkVoter.do" method="post" modelAttribute="voteContextRoot">
			<c:choose>
			<c:when test="${type==0}">
				<form:radiobuttons path="context" items="${requestScope.map}"  delimiter="&nbsp;"/>
			</c:when>
			<c:otherwise>
				<form:checkboxes items="${requestScope.map}" path="context"  delimiter="&nbsp;"/>
			</c:otherwise>
			</c:choose>
			<br>
			<input type="submit" value="下一步"/>
		</form:form>
	</body>
</html>
