<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="false" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/styles/main.css"/> "/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToDo Tracking</title>
</head>
<body>

You have a total number of
<c:if test="${todoList != null}" >
	<c:out value="${fn:length(todoList)}" />
</c:if>
ToDos.
 
<a class="actions" href="<c:url value="/"/> ">Home</a>
<table>
	<tr>
		<th>Owner</th>
		<th>Short description</th>
		<th>Long Description</th>
		<th>URL</th>
		<th>Done</th>
		<th>Delete</th>
		<th>Complete</th>
	</tr>
	<!-- Loop through all found ToDos -->
	<c:forEach var="todo" items="${todoList}">
	<tr>
		<!--  new row per ToDo -->
		<!-- owner column -->
		<td>${todo.owner}</td>
		<!-- summary column -->
		<td>${todo.summary}</td>
		<!-- description column -->
		<td>${todo.description}</td>
		<!-- url column -->
		<td>${todo.url}</td>
		<!-- completed column -->
		<td>${todo.completed}</td>		
		<!-- delete column -->
		<td>
		<a class="actions" href="<c:url value="/deletetodo/${todo.id}"/> ">Delete</a>	    
		</td>
		<!-- complete column -->
		<td>
		<a class="actions" href="<c:url value="/completetodo/${todo.id}"/> ">Complete</a>	    
		</td>
		
	</tr>
	</c:forEach>
</table>
<hr />
<form:form name="addForm" modelAttribute="todo" method="post">
 <table>
 	<tr>
 		<td><form:label id="ownerLabel" path="owner">Owner</form:label></td>
 		<td><form:input path="owner" size="10"/></td>
 	</tr>
 	<tr>
 		<td><form:label id="summaryLabel" path="summary">Summary</form:label></td>
 		<td><form:input path="summary" size="65"/></td>
 	</tr>
 	<tr>
 		<td><form:label id="descriptionLabel" path="description">Description</form:label></td>
 		<td><form:textarea path="description" rows="4" cols="50"></form:textarea></td>
 	</tr>
 	<tr>
 		<td><form:label id="urlLabel" path="url">URL</form:label></td>
 		<td><form:input path="url" size="65"/></td>
 	</tr> 	
 	<tr>
 		<td colspan="2" align="center"><input id="submitButton" type="submit" value="Create"/></td>
 	</tr>
 </table>
</form:form>

</body>
</html>