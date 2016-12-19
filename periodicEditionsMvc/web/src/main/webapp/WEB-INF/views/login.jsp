<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	<!--<body>
		
		<c:url var="loginUrl" value="/login"/>
		<form action="${loginUrl}" method="post">
			<c:if test="${param.error != null}">
				<font color="red"> <spring:message code="label.loginerror" />
			</c:if>
			<table>
				<tr>
					<td align="right">Логин</td>
					<td><input type="text" name="j_username" /></td>
				</tr>
				<tr>
					<td align="right">Пароль</td>
					<td><input type="password" name="j_password" /></td>
				</tr>
	
				<tr>
					<td colspan="2" align="right"><input type="submit" value="Login" />
					<input type="reset" value="Reset" /></td>
				</tr>
			</table>
		</form>
	</body>-->
	<body>
		<!--<div id="mainWrapper">
			<div class="login-container">
				<div class="login-card">
					<div class="login-form">-->
						<c:url var="loginUrl" value="/login" />
						<form action="${loginUrl}" method="post" class="form-horizontal">
							<c:if test="${not empty param.error}">
								<div class="alert alert-danger">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
								<input type="text" class="form-control" name="j_username" placeholder="Enter Login" required="required"/>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
								<input type="password" class="form-control" name="j_password"" placeholder="Enter Password" required="required"/>
							</div>
							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
								
							<div class="form-actions">
								<input type="submit"
									class="btn btn-block btn-primary btn-default" value="Log in"/>
							</div>
						</form>
					<!--</div>
				</div>
			</div>
		</div>-->
	</body>
</html>