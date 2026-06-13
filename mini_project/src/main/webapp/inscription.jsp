<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Formulaire d'inscription</h2>
<form action="creer_client" method="POST">
<P>Entrer nom  de client: <input type="text" name="nom_client"><br>
    Entrer id de client : <input type="number" name="id_client"><br>
    Entrer date de client  : <input type="date" name="date_client"><br>
    Entrer tele de client : <input type="number" name="tele_client">
    <input type="submit" value="valider">
    
</P>



</form>

<b style="color:red">
<%String k= (String) request.getAttribute("mess");
if(k!=null){
	out.println(k);
}
 %></b>

</body>
</html>