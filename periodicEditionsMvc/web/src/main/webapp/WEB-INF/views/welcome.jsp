<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>	  
<html>	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Welcome</title>
	</head>
	<body>
		<a href="?mylocale=en">English </a> | <a href="?mylocale=ru">Russian </a>
		<h3><spring:message code="allpage.periodicals"/></h3>
   		
       	<p><spring:message code="page.welcome.specification"/></p>
       
        <sec:authorize access="!isAuthenticated()">
        	<c:url var="login_page" value="/loginPage"/>
      		<p><a href="${login_page}" role="button"><spring:message code="page.welcome.LogIn"/></a></p>
        </sec:authorize>
       
       	<sec:authorize access="isAuthenticated()">
       		<p><spring:message code="page.welcome.logged"/>  <sec:authentication property="principal.username"/>  <spring:message code="page.welcome.role"/>
      		<sec:authentication property="principal.authorities"/>
           	
           	<sec:authorize access="hasRole('ROLE_ADMIN')">		
        		<p><spring:message code="page.welcome.select"/></p>
				<fieldset>
		 			<legend><spring:message code="page.welcome.editdatabase"/></legend>
		 			<form name="PeriodicEditionsAdmin" method="get" action="periodicEditionsAdmin">
		 				<input type="submit" value="<spring:message code="page.welcome.edit"/>"/>
					</form>
				</fieldset><br/>
				<fieldset>
		 			<legend><spring:message code="page.welcome.viewusers"/></legend>
		 			<form name="readersList" method="get" action="readers">
						<input type="submit" value="<spring:message code="page.welcome.readers"/>"/>
					</form>
				</fieldset><br/>
			</sec:authorize>		
			 <sec:authorize access="hasRole('ROLE_USER')">
				 <fieldset>
					<legend><spring:message code="page.welcome.selection"/></legend>
					<form name="PeriodicEditionsUser" method="get" action="periodicEditionsUser">
						<input type="submit" value="<spring:message code="page.welcome.begin"/>"/>
					</form>
				</fieldset><br/>
			</sec:authorize>
          	<c:url var="logout_but" value="/logout"/>
           	<p><a  href="${logout_but}" role="button"><spring:message code="allpage.LogOut"/></a></p>
       	</sec:authorize>
   	 </body>
</html>