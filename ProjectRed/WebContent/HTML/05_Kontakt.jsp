<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kontakt</title>
<link rel="stylesheet" type="text/css" href="../CSS/gesamt.css">
</head>
<body>
<%@ include file="00_header.html" %>

<div class = "form">
		<form id="kontakt" method="post" action=""
			accept-charset="UTF-8">
			<fieldset>
				<legend>So erreichen Sie uns</legend>
				<div id="anredeSelect">
					<select name="anrede" size="0">
						<option value="herr">Herr</option>
						<option value="frau">Frau</option>
					</select>
				</div>
				<div>
					<label for="firstName">Vorname:</label> <input type="text"
						name="firstName" id="firstName" placeholder="Ihr Vorname"
						maxlength="25" required><span></span> <br> <label
						for="lastName">Nachname:</label> <input type="text"
						name="lastName" id="lastname" placeholder="Ihr Nachname"
						maxlength="25" required> <span></span> <br> <label
						for="mail">Ihre E-Mail:</label> <input type="email" name="eMail"
						id="eMail" placeholder="E-Mail-Adresse" maxlength="25" required>
					<span></span>
				</div>
				<div>
					<label for="orderNumber">Ihre Bestellnummer</label> <input
						type="number" name="orderNumber" id="orderNumber"
						placeholder="Bestellnummer"
						maxlength="25"><span></span>
				</div>
				<div>
					<textarea class=" custmessage" name="custmessage" rows="5" cols="51"
						placeholder="Teilen Sie uns hier bitte möglichst ausführlich Ihr Anliegen mit."
						maxlength="255" required></textarea>
					<span></span>
				</div>

				<div>
					<button type="submit" name="submit" value="submit">Absenden</button>
					<button type="reset" name="reset" value="reset">Zurücksetzen</button>
					<span></span>
				</div>
				<div id="duty">
					<p>* = Pflichtfeld</p>
				</div>
			</fieldset>
		</form>
	</div>

<%@ include file="00_footer.html" %>
</body>
</html>