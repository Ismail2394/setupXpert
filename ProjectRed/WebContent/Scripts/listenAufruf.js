//Caglayan, Ismail 01.05.23
var ajaxCallMade;
$(document).ready(function() {
	if (!ajaxCallMade) {
		$.ajax({
			url: "http://localhost:8080/ProjectRed/ArtikelListeServlet",
			success: function(data) {
				$("#artikelliste").empty();
				console.log("AJAX-Aufruf erfolgreich");

				$("#artikelliste").html(data); // HTML-Inhalt einfügen
			},
			error: function() {
				console.log("AJAX-Aufruf fehlgeschlagen");
			}
		});
		ajaxCallMade = true;
	}

});
