<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Crear Nuevo Dojo</h1><hr>
<form:form action="/dojos" method="post" modelAttribute="dojo">
    <p>
        <form:label path="name">Nombre</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>

   <input type="submit" value="Crear Nuevo"/>
</form:form>  

</body>
</html>