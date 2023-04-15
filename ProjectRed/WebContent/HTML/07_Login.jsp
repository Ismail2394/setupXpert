<!--Caglayan, Ismail 24.11.22-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Anmeldeformular</title>
<link rel="stylesheet" href="../CSS/gesamt.css">
</head>
<body>
<%@ include file="00_header.html" %>
<div class=body>
	<div class="box">
        <form method="post" action="../loginServlet">
            <h2>Anmelden</h2>
            <div class="inputBox">
                <input type="text" required="required" name="EingabeEmail">
                <span>E-mail Adresse</span>
                <i></i>
            </div>
            <div class="inputBox">
                <input type="password" required="required" name="EingabePasswort">
                <span>Passwort</span>
                <i></i>
            </div>
            <div class="links">
                <a href="#">Passwort vergessen ?</a>
                <a href="#">Registrieren</a>
                
            </div>
            <input type="submit" id="loginButton" value="Login">
        </form>
         
    </div>
    <div>
  
</div>
</div>
<%
        String storedPassword = (String) request.getAttribute("storedPassword");
        String enteredPassword = (String) request.getAttribute("EingabePasswort");
    %>
   <!--<script>
        //Funktion die aufgerufen wird wenn der Login-Button geklickt wird
        document.getElementById("loginButton").addEventListener("click", function(){
            //FormData-Objekt erstellen
            var formData = new FormData(document.querySelector("form"));
            //POST-Anfrage an LoginServlet senden
            fetch("./loginServlet", {
                method: "POST",
                body: formData
            })
            .then(function(response) {
                //Serverantwort verarbeiten
                if(response.ok) {
                    //Umleitung auf die Willkommenseite
                	window.location.href = "KontaktJSP.jsp";
                } else {
                    //Anzeigen einer Fehlermeldung
                	 alert("Stored Password: <%= storedPassword %> \n Entered Password: <%= enteredPassword %>");
                   
                }
            })
            .catch(function(error) {
                console.log(error);
            });
        });
    </script>

-->

<%@ include file="00_footer.html" %>
</body>
</html>