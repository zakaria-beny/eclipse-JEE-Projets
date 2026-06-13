<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info Client</title>
</head>
<body>

	<div align ="center">
	<h2>Client Information</h2>
	<ul style="list-style-type: none;">
	<li>Type mime de la requête : <%= request.getContentType() %></li>
	<li>Protocole de la requête : <%= request.getProtocol() %></li>
	<li>Adresse IP du client : <%= request.getRemoteAddr() %></li>
	<li>Nom du client : <%= request.getRemoteHost() %></li>
	<li>Nom du serveur qui a reçu la requête :  <%= request.getServerName() %></li>
	<li>Port du serveur qui a reçu la requête : <%= request.getServerPort() %></li>
	<li>scheme : <%= request.getScheme() %></li>
	</ul><br>
	
	<ul style="list-style-type: none;">
		<h3>Liste des parametres :</h3>
		<%
			Enumeration<String> Params = request.getParameterNames();
			while(Params.hasMoreElements()){
				String Pname = Params.nextElement();
				String Pvalue = request.getParameter(Pname);
				
				%>
                <li>nom : <%= Pname %>    valeur : <%= Pvalue %></li>
        		<%
			}
		%>
		
	</ul>
	</div>
	
</body>
</html>