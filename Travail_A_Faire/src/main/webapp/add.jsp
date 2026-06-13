<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouveau Client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	
<%

	if(request.getParameter("submit") != null){
		
		String id = request.getParameter("id");
		String name = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String age = request.getParameter("age");
		
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/clients_db","root","");
		
		ps = conn.prepareStatement("insert into client(id,nom,prenom,age) values(?,?,?,?)");
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, prenom);
		ps.setString(4, age);
		ps.executeUpdate();
	}

%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <h3 class="navbar-brand">Nouveau Client </h3>
  </div>
</nav>
<form style="margin: 10px;margin-left:70px;"action="add.jsp" method="POST">
	<label>
	id Client :
		<input class="form-control col-3" type="text" name="id" placeholder="Id Client" aria-label="default input example">

	</label>
	<br>
	<label>
	Nom :
		<input class="form-control col-3" type="text" name="nom" placeholder="Nom Client" aria-label="default input example">

	</label>	<br>
	<label>
	Prenom :
		<input class="form-control " type="text" name="prenom" placeholder="Prenom Client" aria-label="default input example">

	</label>	<br>
	<label>
	Age :
		<input class="form-control" type="text" name="age" placeholder="Age Client" aria-label="default input example">

	</label>	
	
	<br>
	<input style="margin-top:10px;" class="btn btn-primary" type="submit" id="submit" name="submit" value="Submit">
	<a style="margin-top:10px;" href="index.jsp" class="btn btn-primary" > retour </a>
	
</form>
	
</body>
</html>