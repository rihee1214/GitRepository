<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="./join" method="post" modelAttribute="memberVO">
	<form:input path="username"/>
	<form:errors path="username"></form:errors>
	<form:password path="password"/>
	<form:errors path="password"></form:errors>
	<form:input path="name"/>
	<form:errors path="name"></form:errors>
	<form:input path="email"/>
	<form:errors path="email"></form:errors>
	<form:input path="phone"/>
	<form:errors path="phone"></form:errors>
	<form:button>join</form:button>
</form:form>
</body>
</html>