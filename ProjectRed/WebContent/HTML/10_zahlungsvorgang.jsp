<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Stefan Küspert, 17.06.2023 -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bezahlung durchführen</title>

<link rel="stylesheet" type="text/css" href="../CSS/gesamt.css">

</head>
<body>
	<%@include file="00_header.html"%>

	<main>
		<form action="Zahlungsantwort.jsp" id="bezahlmethoden" method="post">
		<fieldset>
			<legend>Bezahlung durchführen</legend>
			<label class="container"> <img alt="AmEx"
				src="../Resources/Images/AmEx.png" style="width: 100px" /> <input
				type="radio" id="amEx" name="bezahlen" value="AmericanExpress"> <span
				class="checkmark"></span>
			</label> <label class="container"> <img alt="MasterCard"
				src="../Resources/Images/Master.png" style="width: 100px" /> <input
				type="radio" id="master" name="bezahlen"value="MasterCard"> <span
				class="checkmark"></span></label> <label class="container"> <img
				alt="Gutschein" src="../Resources/Images/Logo.png"
				style="width: 100px" /><input type="radio" id="gutschein"
				name="bezahlen" value="Gutschein"> <span class="checkmark"></span></label> <label
				class="container"> <img alt="PayPal"
				src="../Resources/Images/PayPal.png" style="width: 100px" /> <input
				type="radio" id="payPal" name="bezahlen" value="PayPal"> <span
				class="checkmark"></span>
			</label> <label class="container"> <img alt="Leber"
				src="../Resources/Images/Organe.jpeg" style="width: 100px" /> <input
				type="radio" id="organ" name="bezahlen" value ="Organen"> <span
				class="checkmark"></span></label>

			<button type="submit" name="submit" value="submit">Jetzt bezahlen!</button>
		</fieldset>
		</form>
	</main>

	<%@include file="00_footer.html"%>
</body>
</html>