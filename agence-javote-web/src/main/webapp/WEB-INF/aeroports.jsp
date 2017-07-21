<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta charset=UTF-8>

<title>Liste aeroports</title>

</head>

<body>

  <c:forEach items="${ aeroports }" var="aeroport">

    <p><a href="aeroport?id=${ aeroport.idAero }" >${aeroport.nom}</a></p>
  </c:forEach>

</body>

</html>