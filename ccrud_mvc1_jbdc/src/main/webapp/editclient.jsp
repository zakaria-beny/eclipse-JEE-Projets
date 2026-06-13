<%@ page import="com.model.javabeans.client" %>
<%
client c=(client)request.getAttribute("client");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h2>Modifier le client</h2>
<form action="ControlServlet?action=UPDATE&id=<%=c.getId()%>" method="POST" class="w-50">
<div class="mb-3">
<label>Nom :</label>
<input type="text" name="nom" value="<%=c.getNom()%>" class="form-control" required>
</div>
<div class="mb-3">
<label>Prenom :</label>
<input type="text" name="prenom" value="<%=c.getPrenom()%>" class="form-control" required>
</div>
<div class="mb-3">
<label>Age :</label>
<input type="number" name="age" value="<%=c.getAge()%>" class="form-control" required>
</div>
<button type="submit" class="btn btn-primary">Modifier</button>
<a href="ControlServlet" class="btn btn-secondary">Retour a accueil</a>
</form>
</body>
</html>
