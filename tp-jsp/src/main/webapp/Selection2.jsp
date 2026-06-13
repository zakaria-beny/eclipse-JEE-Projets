<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jakarta.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
	<body>
		<form method="POST" action="Selection2.jsp">
			Choisissez une couleur
			<p>
				<input type="radio" name="couleur" value="rouge" />Rouge<br />
				<input type="radio" name="couleur" value="bleu" />Bleu<br />
				<input type="radio" name="couleur" value="vert" />Vert<br />
				<input type="radio" name="couleur" value="orange" />Orange<br />
			</p>
			<input type="submit" value="Envoyer">
		</form>
		
		<%@ page errorPage="erreur.jsp"%>
	
		<%
			if(request.getMethod().equals("POST")){
				String color = request.getParameter("couleur");
				
				if(color != null && !color.isEmpty()){
					String cssColor = null;
			        if ("rouge".equals(color))
			        { 
			        	cssColor = "red";
			        }
			        else if ("bleu".equals(color))
			        {
			        	cssColor = "blue";
			        }
			        else if ("vert".equals(color))
			        {
			        	cssColor = "green";
			        }
			        else if ("orange".equals(color))
			        {
			        	throw new Exception("Cette couleur n'est pas belle");
			        
			        }
			      
				
		%>
					<p>votre couleur est : 
						<span style="color:<%=cssColor %>"><%=color %></span>
					</p>
		<% 	
				}else{ 
		%>
					<P>Aucune couleur choisie</P>
		<% 
				}
		
			}
		%>
		
		</body>
</html>