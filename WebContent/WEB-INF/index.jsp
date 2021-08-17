<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<h1>Bienvenue</h1>

	  
      <c:if test ="${hidden}" >
         <p> hidden est à true <p>
      </c:if>
     
      <c:if test = "${not hidden}" >
         <p> hidden est à false <p>
      </c:if>
</body>
</html>