<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:useBean id="voteContextRoot" class="com.gdpu.controller.rootcontroller.VoteContextRoot" scope="request" ></jsp:useBean> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><style type="text/css">
<!--
body {
	background-color: #869de3;
	margin:10px
}
-->
a { font-size: 12pt; text-decoration: none}
</style>
	<body>
		<a href="../admin/main.jsp">投票主页 
	</a>&gt;&gt;&gt;创建投票 
		<center>
		输入投票选项内容:
		<br>
		<br>
		<br>
			<form:form action="../vote/newVoteContextValidate.do" method="post" commandName="voteContextRoot"> 
			 <font color="red">
					<form:errors path="*"/>
			</font>
			<input type="hidden" name="formToken" value="${formToken}" />  
			    <c:forEach var="list" items="${list}">

			       <span>第${list}项</span>
			       <span><form:input path="context" value="请输入投票选项内容"/></span><br/>
			
			    </c:forEach>
			    <input type="submit" value="下一步"/>
			</form:form>

		</center>
	</body>
</html>