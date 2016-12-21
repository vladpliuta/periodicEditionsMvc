<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
  
<html>	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Periodic editions admin work</title>
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
			.hide + label ~ fieldset{
   				display: none;
			}
			.hide:checked + label + fieldset {
    			display: block; 
    		}			
		</style>	
	</head>
	<body>
		<a href="?mylocale=en">English </a> | <a href="?mylocale=ru">Russian </a>
		<h2><spring:message code="allpage.periodicals"/></h2>
		
		<table>
		<caption>Список периодических изданий</caption>
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
						<c:url var="delete_but" value="/delete-${periodicEdition.id}"/>
           				<a href="${delete_but}" role="button">Удалить</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					<input type="checkbox" id="hd-1" class="hide"/>
   					<label for="hd-1" >Нажмите чтобы добавить периодическое издание</label>
    				<fieldset>
		 				<legend>Форма добавления периодического издания</legend>
						<s:form name="PeriodicEditionCreate" method="post" action="create">
							<input type="text" name="ISSN" size="8" required="required" autofocus="autofocus" placeholder="00000000" pattern="[0-9]{8}"/>
							<span>*</span>ISSN<br/>
							<input type="text" name="title"/>Название
							<br/>Краткое описание<br/>
							<textarea name="shortDescription" cols="50" rows="4"></textarea>
							<br/>
							<input type="text" name="monthPeriodicity" pattern="[0-9]{1,2}"/>Количество выпусков в месяц
							<br/>
							<input type="text" name="monthPrice"/>Стоимость подписки в месяц
							<br/>
							<input type="text" name="discountQuarteryear" pattern="[0-9]{0,3}"/>Скидка на квартал
							<br/>
							<input type="text" name="discountHalfyear" pattern="[0-9]{0,3}"/>Скидка на полугодие
							<br/>
							<input type="submit" value="Добавить"/>
						</s:form>
					</fieldset>
				</td>
			</tr>
		</table>
		
		<br/><br/><br/>
		<c:url var="logout_but" value="/logout"/>
        <p><a  href="${logout_but}" role="button"><spring:message code="allpage.LogOut"/></a></p>
	</body>
</html>