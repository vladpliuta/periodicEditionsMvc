<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	<body>
		<a href="?mylocale=en">English </a> | <a href="?mylocale=ru">Russian </a>
		<h3><spring:message code="allpage.periodicals"/></h3>
	
		<c:url var="loginUrl" value="/login" />
		<form action="${loginUrl}" method="post">
			<c:if test="${not empty param.error}">
				<div>
					<p><spring:message code="page.login.loginerror"/></p>
				</div>
			</c:if>
			<table>
				<tr>
					<td align="right"><spring:message code="page.login.loginfild"/></td>
					<td><input type="text" name="j_username" placeholder="Enter Login" required/></td>
				</tr>
				<tr>
					<td align="right"><spring:message code="page.login.passwordfild"/></td>
					<td><input type="password" name="j_password" placeholder="Enter Password" required/>
					<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="Login" />
				</tr>
			</table>
		</form>
	</body>
</html>