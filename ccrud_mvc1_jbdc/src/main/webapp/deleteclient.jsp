<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supprimer un client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2 class="mb-4">Suppression du client</h2>

<a href="listclient.jsp" class="btn btn-secondary mb-3">Retour à la liste</a>

<%
if(request.getParameter("id") != null){
    String id = request.getParameter("id");
    int ID = Integer.parseInt(id);
    String url = "jdbc:mysql://localhost:3307/dbclient";
    String user_name = "root";
    String user_pwd = "";
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user_name, user_pwd);

        PreparedStatement ps = conn.prepareStatement("DELETE FROM client WHERE id=?");
        ps.setInt(1, ID);
        ps.executeUpdate();

        ps.close();
        conn.close();
%>
        <div class="alert alert-success mt-3" role="alert">
            Le client a été supprimé avec succès !
        </div>
<%
    } catch(ClassNotFoundException e) { e.printStackTrace(); }
      catch(SQLException e) { e.printStackTrace(); }
}
%>

</body>
</html>
