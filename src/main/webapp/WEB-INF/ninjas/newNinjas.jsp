<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninjas</title>
</head>
<body>

<h1>Ingresar Nuevo Ninja</h1><hr>

<form:form action="/ninjas" method="post" modelAttribute="ninja">
    <p>
        <form:label path="dojo">Nombre del Dojo:</form:label>
        <form:errors path="dojo"/>
 
        <select id="dojo" name="dojo">
         <c:forEach items="${dojos}" var="dojo">
			    <option value="${dojo.id}">${dojo.name}</option>
		 </c:forEach>
		   </select>
    </p>
    <p>
        <form:label path="firstName">Nombre: </form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
       <p>
        <form:label path="lastName">Apellido: </form:label>
        <form:errors path="lastName"/>
        <form:input type="text" path="lastName"/>
    </p>
    <p>
        <form:label path="age">Edad: </form:label>
        <form:errors path="age"/>
        <form:input type="text" path="age"/>
    </p>
    
    <input type="submit" value="Crear Nuevo Ninja"/>
</form:form>    

</body>
</html>