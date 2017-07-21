<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ taglib
  uri="http://java.sun.com/jsp/jstl/core"
  prefix="c"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<%@include file="/WEB-INF/include/bootstrapCssCdn.jsp"%>
<title>Profil du client</title>
</head>
<body>
  <%@include file="/WEB-INF/include/header.jsp"%>
  <section class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <h2 class="text-center">Profil de ${ client.prenom } ${ client.nom }</h2>
        <hr />
        <br />
        <h3>Adresse :</h3>
        <br />

        <p>${adresse.adresse }</p>
        <p>${adresse.codePostal }</p>
        <p>${adresse.ville }</p>
        <p>${adresse.pays }</p>
        <br />
        <h3>Téléphone :</h3>
        <br />
        <p>${client.numeroTel }</p>
        <br />
        <h3>Email :</h3>
        <br />
        <p>${client.email }</p>
        <a href="client"><button class="btn btn-defaut">Revenir à la liste des clients</button></a>
      </div>
    </div>
  </section>
  <hr />
  <br />
</body>
</html>