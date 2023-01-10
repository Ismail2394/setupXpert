<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Impressum_JSP</title>
<link rel="stylesheet" href="../CSS/Login.css">
</head>
<body>
<%@ include file="header.html" %>

	<div class="box">
        <form id="loginForm" autocomplete="off">
            <h2>Anmelden</h2>
            <div class="inputBox">
                <input type="text" required="required" name="email">
                <span>E-mail Adresse</span>
                <i></i>
            </div>
            <div class="inputBox">
                <input type="password" required="required" name="passwort">
                <span>Passwort</span>
                <i></i>
            </div>
            <div class="links">
                <a href="#">Passwort vergessen ?</a>
                <a href="#">Registrieren</a>
                
            </div>
            <input type="submit" id="loginButton" value="Login">
        </form>
         <p class="error-message">${errorMessage}</p>
    </div>
    <script>
        //Funktion die aufgerufen wird wenn der Login-Button geklickt wird
        document.getElementById("loginButton").addEventListener("click", function(){
            //FormData-Objekt erstellen
            var formData = new FormData(document.getElementById("loginForm"));
            //POST-Anfrage an LoginServlet senden
            fetch("LoginServlet", {
                method: "POST",
                body: formData
            })
            .then(function(response) {
                //Serverantwort verarbeiten
                if(response.ok) {
                    //Umleitung auf die Willkommenseite
                    window.location.href = "Index_JSP.jsp";
                } else {
                    //Anzeigen einer Fehlermeldung
                    alert("E-mail Adresse oder Passwort ist falsch.");
                   
                }
            })
            .catch(function(error) {
                console.log(error);
            });
        });
    </script>



<%@ include file="footer.html" %>
</body>
</html>