<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h2>Ajouter un client</h2>
<form action="ControlServlet?action=INSERT" method="POST" class="w-50">
<div class="mb-3">
<label>ID Client :</label>
<input type="number" name="id" class="form-control" required>
</div>
<div class="mb-3">
<label>Nom :</label>
<input type="text" name="nom" class="form-control" required>
</div>
<div class="mb-3">
<label>Prenom :</label>
<input type="text" name="prenom" class="form-control" required>
</div>
<div class="mb-3">
<label>Age :</label>
<input type="number" name="age" class="form-control" required>
</div>
<button type="submit" class="btn btn-primary">Ajouter</button>
<a href="ControlServlet" class="btn btn-secondary">Retour a accueil</a>
</form>
</body>
</html>
