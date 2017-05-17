<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<jsp:useBean id="voteRoot" class="com.gdpu.controller.rootcontroller.VoteRoot" scope="request" ></jsp:useBean> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
</head>
	<style type="text/css">
<!--
body {
	background-color: #869de3;
	margin:10px
}
-->
a {text-decoration: none}
</style>
	<body>
		<a href="../admin/main.jsp">投票主页</a>
		>>>编辑投票信息>>>创建新投票 
		<center>
			<br>
			<br>
			<br>
			输入投票信息 
			<br>
			<br>
			
			<form:form action="../vote/newVoteValidate.do" method="post" modelAttribute="voteRoot">  
				<input type="hidden" name="formToken" value="${formToken}" />  
				<font color="red">
					<form:errors path="*"/>
				</font>
				<font color="red">
					${error}
				</font>
				<table>
					<tr>
						<td>投票主题</td>
						<td><form:input path="title"/></td>
					</tr>
					<tr>
						<td>子选项个数</td>
						<td><form:input path="contextcount"/></td>
					</tr>
					<tr>
						<td>投票类型投票类型</td>
						<td>
						<form:select path="type">  
		                   <option value="0">单选</option>  
		                   <option value="1">多选</option>  
		               	</form:select></td>  						
					</tr>
					<tr>
						<td>是否开放</td>
						<td>
						<form:select path="publish">  
		                   <option value="0">是</option>  
		                   <option value="1">否</option>  
		               	</form:select></td>
					</tr>	
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="下一步"/></td>
					</tr>
				</table>
				
			</form:form>
		</center>
	</body>
</html>
