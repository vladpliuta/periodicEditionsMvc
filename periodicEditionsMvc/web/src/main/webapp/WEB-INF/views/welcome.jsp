<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>	  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Welcome</title>
	</head>
	<body>
	<a href="?mylocale=en">English </a> | <a href="?mylocale=ru">Russian </a>
		
		   
      			<h2>PERIODIC EDITION 4</h2>
       			<p><spring:message code="label.specification"/></p>
       
        		<sec:authorize access="!isAuthenticated()">
        			<c:url var="login_page" value="/loginPage"/>
       			<p><a href="${login_page}" role="button">Войти</a></p>
        		</sec:authorize>
       
        		<sec:authorize access="isAuthenticated()">
           			<p>Вы вошли как: <sec:authentication property="principal.username"/>  с ролью:
           			<sec:authentication property="principal.authorities"/>
           			
            		<p>Выберете необходимое действие:</p>
					<fieldset>
		 				<legend>Редактировать базу</legend>
		 				<form name="PeriodicEditionsAdmin" method="get" action="periodicEditionsAdmin">
		 					<input type="submit" value="Редактировать"/>
						</form>
			
					</fieldset>	<br/>
					<fieldset>
		 				<legend>Просмотреть список пользователей</legend>
		 				<form name="UsersList" method="get" action="usersList">
							<input type="submit" value="Пользователи"/>
						</form>
					</fieldset>
		
            		
            		<c:url var="logout_but" value="/logout"/>
            		<p><a  href="${logout_but}" role="button">Выйти</a></p>
        		</sec:authorize>
   			 
   			<br/>
        		<p>&copy; Плюта Владимир</p>
    		
		</body>
</html>