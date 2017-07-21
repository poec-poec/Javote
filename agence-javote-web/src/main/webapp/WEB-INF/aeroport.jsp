<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta charset=UTF-8>

<title>Detail aéroport</title>

</head>

<body>
  <p>${aeroport.nom }</p>
  <p>${aeroport.idAero }</p>

  <c:forEach items="${ aeroport.villes }" var="ville">

    <p>${ ville.nom }</p>

  </c:forEach>





</body>

</html>