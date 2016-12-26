<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Periodic editions user work</title>
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
			label{color:green
			}
			.hide {
    			display: none; 
			}
			.hide + label ~ form{
   				display: none;
			}
			.hide:checked + label + form {
    			display: block; 
    		}
						
		</style>	
	</head>
	<body>
		<a href="?mylocale=en">English </a> | <a href="?mylocale=ru">Russian </a>
		<h3><spring:message code="allpage.periodicals"/></h3>
		
		<table>
		<caption><spring:message code="allpage.periodicalsList"/></caption>
			<tr>
				<th>№п/п</th>
				<th style="width:5em">ISSN</th>
				<th>Название</th>
				<th style="width:5em">Кол-во выпусков в месяц</th>
				<th style="width:5em">Стоимость подписки в месяц</th>
				<th style="width:5em">Скидка на квартал</th>
				<th style="width:5em">Скидка на полугодие</th>
			</tr>
			<c:forEach var="periodicEdition" items="${periodicEditionsList}" varStatus="status">
				<tr>
					<td rowspan="3"><c:out value="${ status.count }" /></td>
					<td><c:out value="${ periodicEdition.id }" /></td>
					<th><c:out value="${ periodicEdition.title }"/></th>
					<td><c:out value="${ periodicEdition.monthPeriodicity }" /></td>
					<td><c:out value="${ periodicEdition.monthPrice }" /></td>
					<td><c:out value="${ periodicEdition.discountQuarteryear }" /></td>
					<td><c:out value="${ periodicEdition.discountHalfyear }" /></td>
				</tr>
				<tr>
					<td colspan="6"><c:out value="${ periodicEdition.shortDescription }" /></td>
				</tr>
				<tr>
					<td colspan="6">
						<input type="checkbox" id="${ status.count }" class="hide"/>
						<label for="${ status.count }" >Нажмите чтобы подписаться на периодическое издание</label>
						<form name="subscriptionCreate" method="get" action="subscriptionCreate">
		 					<input type="hidden" name="idPeriodicEdition" value="${ periodicEdition.id }"/>
		 					<input type="hidden" name="username" value="<sec:authentication property="principal.username"/>"/>
		 					
		 					<select name="period" required="required">
								<option value="1" selected="selected">месяц</option>
								<option value="3">квартал</option>
								<option value="6">полугодие</option>
								<option value="12">год</option>
							</select>
							<input type="submit" value="Подписаться"/>
		 				</form>
		 			</td>
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