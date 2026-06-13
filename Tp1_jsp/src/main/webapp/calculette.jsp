<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculette en JSP</title>
</head>
<body>

	<form>
		Number 1 : <input type="number" name="Num1"><br>
    	Number 2 : <input type="number" name="Num2"><br>
    	
    	<select name="Operation">
      <option value="">Choisir un operation</option>
      <option value="add">+</option>
      <option value="sub">-</option>
      <option value="mul">×</option>
      <option value="div">÷</option>
    </select><br>
    
    <button type="submit">Calculer</button>
	</form>
	
	
	<% 
	    String Number1 = request.getParameter("Num1");
	    String Number2 = request.getParameter("Num2");
	    String Operation = request.getParameter("Operation");
	    
	    
	    if (Number1 != null && Number2 != null && Operation != null
	    		&& !Number1.isEmpty() && !Number2.isEmpty()) {
            double n1 = Double.parseDouble(Number1);
            double n2 = Double.parseDouble(Number2);
            double result = 0;
            String symbole = "";
	    
	        switch (Operation) {
	        case "add": result = n1 + n2; symbole = "+"; break;
	        case "sub": result = n1 - n2; symbole = "-"; break;
	        case "mul": result = n1 * n2; symbole = "×"; break;
	        case "div": 
        	
            if (n2 != 0) { 
            	result = n1 / n2; symbole = "÷"; } 
            
            else { 
            	out.println("<p style='color:red;'>Erreur : division par zéro !</p>"); }
            break;
    }
        if (!(Operation.equals("div") && n2 == 0)) {
        	  %>
        	        <h3>Résultat :</h3>
        	        <p><%= n1 %> <%= symbole %> <%= n2 %> = <strong><%= result %></strong></p>
        	  <%
        	        }}
	%>
	
	
	
</body>
</html>