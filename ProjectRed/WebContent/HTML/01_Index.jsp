<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../CSS/gesamt.css">
<title>Index_JSP</title>
</head>
<body>
session.setAttribute("eMail", enteredEmail);

<% String enteredEmail = (String)session.getAttribute(“enteredEmail”); if(enteredEmail==null) 
{ %> <%@ include file=“00_header.html” %> <% } else 
{ %> <%@ include file=“00_headerLogin.html” %> <% } %>

<%@ include file="00_footer.html" %>

</body>
</html>