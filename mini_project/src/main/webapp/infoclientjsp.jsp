<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.client.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b style="color:green">
<%String k= (String) request.getAttribute("mess");
if(k!=null){
	out.println(k);
}
 %></b>
  <jsp:useBean id="client" class="com.client.bean.Client" scope="request"/>
  

        

<p><b>ID Client :</b> <jsp:getProperty property="id_client" name="client"/></p>
<p><b>Nom :</b> <jsp:getProperty property="nom_cli" name="client"/></p>
<p><b>Téléphone :</b> <jsp:getProperty property="num_tele" name="client"/></p>
<p><b>Date de naissance :</b> <jsp:getProperty property="date_nais" name="client"/></p>


         
   
         
</body>
</html>