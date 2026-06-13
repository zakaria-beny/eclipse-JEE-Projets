<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Clients</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white text-center fw-bold">
            Liste des Clients
        </div>
        <div class="card-body">
            <form class="row g-2 align-items-center mb-4" method="get" action="clients.do">
                <div class="col-auto">
                    <input type="text" name="motCle" id="client" class="form-control" placeholder="Nom du client">
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary">Chercher</button>
                </div>
                <div class="col-auto">
                    <a href="addClient.do" class="btn btn-success">Nouveau Client</a>
                </div>
            </form>
            <table class="table table-bordered table-hover align-middle text-center">
                <thead class="table-light">
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Âge</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pm}" var="client">
                        <tr>
                            <td>${client.idClient}</td>
                            <td>${client.nom}</td>
                            <td>${client.prenom}</td>
                            <td>${client.age}</td>
                            <td>
                                <a href="EditClient.do?idClient=${client.idClient}" class="btn btn-sm btn-warning text-white">Éditer</a>
                                <a href="DeleteClient.do?idClient=${client.idClient}" class="btn btn-sm btn-danger">Supprimer</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
