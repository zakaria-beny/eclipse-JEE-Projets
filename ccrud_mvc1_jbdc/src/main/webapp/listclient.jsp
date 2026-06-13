<%@ page import="java.util.*, com.model.javabeans.client" %>
<%
List<client> listClients=(List<client>)request.getAttribute("listClients");
%>
<!DOCTYPE html>
<html>
<head>
<title>Liste des clients</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h2>Liste des clients</h2>


<div class="row mb-3">
    <div class="col-md-6">
        <form action="ControlServlet" method="GET" class="d-flex">
            <input type="hidden" name="action" value="SEARCH">
            <input type="text" name="keyword" class="form-control me-2" placeholder="Rechercher par nom ou prénom..." required>
            <button type="submit" class="btn btn-outline-primary">Rechercher</button>
        </form>
    </div>
    <div class="col-md-6 text-end">
        <a href="ControlServlet?action=ADD" class="btn btn-primary">Ajouter un client</a>
    </div>
</div>

<table class="table table-bordered table-striped">
<thead>
<tr>
<th>ID</th>
<th>Nom</th>
<th>Prénom</th>
<th>Age</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<%
if(listClients!=null){
for(client c:listClients){
%>
<tr>
<td><%=c.getId()%></td>
<td><%=c.getNom()%></td>
<td><%=c.getPrenom()%></td>
<td><%=c.getAge()%></td>
<td>
<a href="ControlServlet?action=EDIT&id=<%=c.getId()%>" class="btn btn-success btn-sm">Éditer</a>
<a href="ControlServlet?action=DELETE&id=<%=c.getId()%>" class="btn btn-danger btn-sm"
onclick="return confirm('Voulez-vous vraiment supprimer ce client ?');">Supprimer</a>
</td>
</tr>
<%
}
}
%>
</tbody>
</table>
</body>
</html>