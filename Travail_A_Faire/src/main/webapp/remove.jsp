<%@ page import="java.sql.*" %>
    
    
    <%
    	
	    String id = request.getParameter("id");
	
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/clients_db","root","");
		
		
		ps = conn.prepareStatement("delete from client WHERE id = ?");
		ps.setString(1, id);
		
		
		ps.executeUpdate();
		
			
		
	
	%>
	<script>
		alert("are you sure ?");
	</script>
	<a href="index.jsp"> retour </a>