<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User Payment</title>
	</head>
	<body>
				
		 <h4>Уважаемый <sec:authentication property="principal.username"/>.<h4>
		 <h4>Вы подписались на "${title}".<h4> 
		 <h4>Период подписки(в месяцах): ${period}.<h4>
		 <h4>Сумма платежа ${coast}.<h4>
		 
	</body>
</html>