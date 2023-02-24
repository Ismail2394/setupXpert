<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adminansicht</title>
<link rel="stylesheet" type="text/css" href="../CSS/gesamt.css">
</head>

<body>
<%@ include file="00_headerAdmin.html" %>
<h2 class="ueberschrift">Administration</h2>

<div class="flex-table">





<button class = "buttondesign"> Kunden verwalten</button>
<button onclick="window.location.href = 'produktHinzufuegen.html';" class = "buttondesign"  type="button"> Produkte verwalten</button>
<button onclick="window.location.href = 'produktHinzufuegen.html';" class = "buttondesign"  type="button"> Kontaktverwaltung</button>
<button onclick="window.location.href = 'produktHinzufuegen.html';" class = "buttondesign"  type="button"> Rollenverwaltung</button>
        
                


</div>  

<%@ include file="00_footer.html" %>
</body>
</html>