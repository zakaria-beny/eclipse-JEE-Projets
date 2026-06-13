<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Nouveau Client</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body { background:#f7f9fc; }
    .app-bar { background:#2f2f2f; color:#fff; padding:.75rem 1rem; font-weight:700; }
  </style>
</head>
<body>
  <div class="app-bar">TAF</div>

  <div class="container py-4">
    <div class="card shadow-sm">
      <div class="card-header bg-primary text-white fw-semibold">Nouveau Client</div>
      <div class="card-body">
        <form id="createForm" action="${pageContext.request.contextPath}/add.do" method="post">
          <div class="mb-3">
            <input name="id" type="hidden" class="form-control" placeholder="ex: 103" Hidden= required>
          </div>
          <div class="mb-3">
            <label class="form-label">Nom Client :</label>
            <input name="nom" type="text" class="form-control" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Prénom Client :</label>
            <input name="prenom" type="text" class="form-control" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Âge :</label>
            <input name="age" type="number" min="0" class="form-control" required>
          </div>
          <div class="d-flex gap-2">
            <button class="btn btn-primary">Ajouter</button>
            <a href="${pageContext.request.contextPath}/acceuil.do" class="btn btn-light border">Annuler</a>
          </div>
        </form>
      </div>
    </div>
  </div>

</body>
</html>