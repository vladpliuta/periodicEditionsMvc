<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>	  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Users list</title>
		<style type="text/css">
			table { align: center;
				border: medium solid black;
				border-spacing: 1px 
			}
			td, th { border: thin dotted black;
				padding: 2px 
			}
			caption {
				font-style: italic;
				font-size: large;
			}
		</style>	
	</head>
	<body>
		<a href="?mylocale=en">English </a> | <a href="?mylocale=ru">Russian </a>
		<h2><spring:message code="allpage.periodicals"/></h2>
		<table>
		<caption><spring:message code="page.readers.users"/></caption>
			<tr>
				<th>№п/п</th>
				<th>Фамилия</th>
				<th>Имя</th>
				<th>Логин</th>
				<th>Удалить</th>
			</tr>
			<c:forEach var="reader" items="${readers}" varStatus="status">
				<tr>
					<td><c:out value="${ status.count }" /></td>
					<td><c:out value="${ reader.surname }" /></td>
					<td><c:out value="${ reader.forename }"/></td>
					<td><c:out value="${ reader.login }"/></td>
					<td><c:url var="delete_but" value="/delete/reader-${reader.login}"/>
           				<a href="${delete_but}" role="button"><spring:message code="allpage.delete"/></a><td>
				</tr>
			</c:forEach>
			
				
		</table>
		<br/><br/>
		<c:url var="home_but" value="/welcome"/>
        <p><a  href="${home_but}" role="button"><spring:message code="allpage.home"/></a></p>
    	<br/>
		<c:url var="logout_but" value="/logout"/>
        <p><a  href="${logout_but}" role="button"><spring:message code="allpage.LogOut"/></a></p>
	</body>
</html>