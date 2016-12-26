<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>AccessDenied page</title>
</head>
<body>
	 You are not authorized to access this page
	<c:url var="logout_but" value="/logout"/>
           	<p><a  href="${logout_but}" role="button">Logout</a></p>
</body>
</html>