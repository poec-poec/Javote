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
<title>Liste de nos clients</title>
</head>
<%@include file="/WEB-INF/include/header.jsp" %>
  <section class="container">
    <h2 class="text-center">Liste des clients</h2>
    <br />
    <hr />
    <br />
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Nom, Prénom</th>
              <th>Profil</th>
            </tr>
          </thead>
          <c:forEach
            items="${ clients }"
            var="client"
          >
            <tbody>
              <tr>
                <td>${ client.nom }   ${ client.prenom }</td>
                <td><a href="client?id=${client.id}">Voir le profil</a></td>
              </tr>
            </tbody>

          </c:forEach>
        </table>
      </div>
    </div>
  </section>
</body>
</html>