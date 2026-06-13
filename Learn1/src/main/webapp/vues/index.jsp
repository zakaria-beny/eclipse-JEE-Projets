<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>TAF - Liste des Clients</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body { background:#f7f9fc; }
    .app-bar { background:#2f2f2f; color:#fff; padding:.75rem 1rem; font-weight:700; }
    .table td, .table th { vertical-align: middle; }
  </style>
</head>
<body>
  <div class="app-bar">TAF</div>

  <div class="container py-4">
    <div class="card shadow-sm">
      <div class="card-header bg-primary text-white fw-semibold">Liste des Clients</div>
      <div class="card-body">
	  <form action="search.do" method="get" class="row g-2 align-items-center mb-3">
		  <label class="col-sm-1 col-form-label">Client :</label>
		  <div class="col-sm-4">
		    <input name="motsCle" type="text" class="form-control" placeholder="Rechercher par nom ou prénom...">
		  </div> 
		  <div class="col-sm-2">
		    <button class="btn btn-outline-primary w-100" type="submit">Chercher</button>
		  </div>
		  <div class="col-sm-3 ms-auto text-sm-end">
		    <a href="${pageContext.request.contextPath}/vues/add.jsp" class="btn btn-warning">Nouveau Client</a>
		  </div>
	</form>
        
        <div class="table-responsive">
          <table class="table table-hover align-middle" id="clientsTable">
            <thead class="table-light">
              <tr>
                <th style="width:90px;">id</th>
                <th>nom</th>
                <th>prenom</th>
                <th style="width:90px;">age</th>
                <th style="width:200px;">Actions</th>
              </tr>
            </thead>
            <tbody>
             <c:forEach var="c" items="${LsitOfClients}">
              <tr>
                <td>${c.getId()}</td>
                <td>${c.getNom()}</td>
                <td>${c.getPrenom()}</td>
                <td>${c.getAge()}</td>
                <td>
                  <a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/update.do?id=${c.getId()}">Éditer</a>
                  <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/delete.do?id=${c.getId()}" onclick="alert('are you sure!')">Supprimer</a>
                </td>
              </tr>
               </c:forEach>
            </tbody>
          </table>
        </div>

      </div>
    </div>
  </div>

</body>
</html>