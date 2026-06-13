<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supprimer Client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg border-danger">
                <div class="card-header bg-danger text-center text-white fw-bold">
                    Supprimer ${pm.nom} ?
                </div>
                <div class="card-body d-flex justify-content-end gap-2">
                    <form method="POST" action="DeleteClient.do?idClient=${pm.idClient}">
                        <button type="submit" class="btn btn-danger">Supprimer</button>
                    </form>
                    <a href="client.do" class="btn btn-secondary">Annuler</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
