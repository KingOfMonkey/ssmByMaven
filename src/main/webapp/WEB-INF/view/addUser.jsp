<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加新员工</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath }/user/addUser" method="post" modelAttribute="command">
		<c:if test="${command.userId != null }">
			<form:hidden path="userId"/>
			<input type="hidden" name="_method" value="PUT"/>
			<%-- 对于 _method 不能使用 form:hidden 标签, 因为 modelAttribute 对应的 bean 中没有 _method 这个属性 --%>
			<%-- 
			<form:hidden path="_method" value="PUT"/>
			--%>
		</c:if>
		userName : <form:input path="userName"/><br><br>
		userAge　: <form:input path="userAge"/><br><br>
		userAddress :　<form:input path="userAddress"/><br><br>
		<input type="submit" value="提交"/>
	</form:form>
</body>
</html>