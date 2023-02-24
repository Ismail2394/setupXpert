<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html" charset="UTF-8">
<title>Registrierung_JSP</title>
<link rel="stylesheet" type="text/css" href="../CSS/gesamt.css">
</head>
<body>
<%@ include file="00_header.html" %>

	<div id="body">
		<form id="registrierung" method="post" action="../erstelleKunde"
			accept-charset="UTF-8">
			<fieldset>
				<legend>Registrierung</legend>
				<div id="anredeSelect">
					<select name="geschlecht" size="0">
						<option value="m">Herr</option>
						<option value="w">Frau</option>
					</select>
				</div>
				<div>
					<label for="firstName">Vorname:</label> <input type="text"
						name="vorname" id="firstName" placeholder="Ihr Vorname"
						maxlength="25" required><span></span> <br> <label
						for="lastName">Nachname:</label> <input type="text"
						name="nachname" id="lastname" placeholder="Ihr Nachname"
						maxlength="25" required> <span></span> <br> <label
						for="birth">Geburtsdatum</label> <input type="date"
						name="geburtsdatum" id="birth" placeholder="Ihr Geburtsdatum"
						required> <span></span>
				</div>
				<div id="anschrift">
					<label for="street">Straße:</label> <input type="text"
						name="strasse" id="straße" placeholder=" Bitte Straße eingeben"
						maxlength="25" required> <span></span>
						
						<label	for="streetNumber">Hausnummer:</label> <input type="text"
						name="hausnummer" id="streetNumber" placeholder="Ihre Hausnummer"
						maxlength="25" required><span></span>
						<label for="plz">Postleitzahl</label><input type="number" name="plz" id="plz"
						placeholder="I
						<div id="anschrift"> 
						
					
				</div>
				<div>
					<label for="eMail">E-Mail:</label> <input type="email" name="email"
						id="email" placeholder="E-Mail-Adresse" maxlength="25" required>
					<span></span>
				</div>
				<div>
					<label for="passwort">Passwort eingeben:</label> <input
						type="password" name="passwort" id="pwd"
						placeholder="Ihr Passwort" maxlength="25" required> <span></span>
					<label for="passwordRepeat">Passwort wiederholen:</label> <input
						type="password" name="passwordRepeat" id="pwd"
						placeholder="Ihr Passwort" maxlength="25" required> <span></span>
				</div>
				<div>
					<input type="submit" value="Absenden" id="absenden" class="spezial">
				</div>
			</fieldset>
		</form>
	</div>

<%@ include file="00_footer.html" %>
</body>
</html>