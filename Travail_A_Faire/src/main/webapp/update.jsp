<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body>

	<%
	
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/clients_db","root","");
		
		String id = request.getParameter("id");
		String name = "";
		String prenom = "";
		String age = "";

		ps = conn.prepareStatement("SELECT nom, prenom, age FROM client WHERE id = ?");
        ps.setInt(1, Integer.parseInt(id));
        rs = ps.executeQuery();
        if (rs.next()) {
            name = rs.getString("nom");
            prenom = rs.getString("prenom");
            age = rs.getString("age");
        }
		
		if(request.getParameter("submit") != null){
			
			
			String Updated_name = request.getParameter("nom");
			String Updated_prenom = request.getParameter("prenom");
			String Updated_age = request.getParameter("age");
			
			
			
			ps = conn.prepareStatement("UPDATE client SET nom = ?, prenom = ?, age = ? WHERE id = ?");
			
			ps.setString(1, Updated_name);
			ps.setString(2, Updated_prenom);
			ps.setInt(3, Integer.parseInt(Updated_age));
			ps.setInt(4, Integer.parseInt(id));
			
			
			ps.executeUpdate();
			
			name = Updated_name;
			prenom = Updated_prenom;
			age = Updated_age;
			
		}
		
	
	%>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <h3 class="navbar-brand">Mettre a jour Les Information D'un Client  </h3>
  </div>
</nav>
<form class="container" action="update.jsp?id=<%= id %>" method="POST">
<label>
	Nom :
		<input class="form-control" type="text" name="nom" value="<%= name %>" placeholder="Nom Client" aria-label="default input example">

	</label>	<br>
	<label>
	Prenom :
		<input class="form-control" type="text" name="prenom" value="<%= prenom %>" placeholder="Prenom Client" aria-label="default input example">

	</label>	<br>
	<label>
	Age :
		<input class="form-control" type="text" name="age" value="<%= age %>" placeholder="Age Client" aria-label="default input example">

	</label>
	<br>
	<input style="margin-top:10px;" class="btn btn-primary" type="submit" id="submit" name="submit" value="submit">	
	<a style="margin-top:10px;" href="index.jsp" class="btn btn-primary">retour</a>
</form>
</body>
</html>