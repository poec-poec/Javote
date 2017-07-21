<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib
  uri="http://java.sun.com/jsp/jstl/core"
  prefix="c"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<%@include file="/WEB-INF/include/bootstrapCssCdn.jsp" %>
<title>Profil du client</title>
</head>
<body>
<p>${client.prenom } </p>
<p>${adresse.adresse } </p>
<a href="client"><button class="btn btn-defaut">Revenir à la liste des clients</button></a>
</body>
</html>