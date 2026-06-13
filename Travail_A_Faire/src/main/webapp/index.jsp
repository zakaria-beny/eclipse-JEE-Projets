<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body>
 <nav class="navbar bg-body-tertiary Dark bg-Dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp" > List Des Client </a>
  </div>
</nav>

<%
		String search = request.getParameter("search");		
%>

<div class="input-group w-50 shadow-sm " Style="margin:10px">
<form method="GET" action="index.jsp" class="d-flex w-100">
    <input type="text" class="form-control" placeholder="Search..." name="search" value="<%= (search != null ? search : "") %>" aria-label="Search">
    <!-- value="<condition ? valeur_si_vrai : valeur_si_fausse>" hadi sta3mlnaha bach nhaydo ntfadaw nullPointerException (bach ila kan input
    khawi maytala3ch lina null itala3 lina champ khawi"") -->
    <button style="margin-left: 10px;" class="btn btn-success" type="submit">Search</button>
    <a style="margin-left: 10px;color: white;" class="btn btn-primary" href="add.jsp">ajouter un client </a>
   </form>
  </div>
 
<table class="table" style="margin: 10px">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nom</th>
      <th scope="col">Prenom</th>
      <th scope="col">Age</th>
       <td> </td>
    </tr>
  </thead>
  <tbody>
  
  	<%

		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/clients_db","root","");
		
		if (search != null){
			ps = conn.prepareStatement("SELECT * FROM client WHERE nom LIKE ? or prenom LIKE ?");
			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");
		}else{
			ps = conn.prepareStatement("SELECT * FROM client");
		}
		
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			//String id = rs.getString("id");
			//String name = rs.getString("nom");
			//String prenom = rs.getString("prenom");
			//String age = rs.getString("age");

	%>
  	
  
    <tr>
      <th scope="row"><%= rs.getString("id") %></th>
      <td><%= rs.getString("nom") %></td>
      <td><%= rs.getString("prenom") %></td>
      <td><%= rs.getString("age") %></td>
      <td>
        <a class="btn btn-warning" href="update.jsp?id=<%= rs.getInt("id") %>">modifier</a>
        <a class="btn btn-danger"  href="remove.jsp?id=<%= rs.getInt("id") %>">supprimer</a>
        </td>
     
  </tbody>
  <%
			
		} 
	
  %>
</table>
</body>
</html>