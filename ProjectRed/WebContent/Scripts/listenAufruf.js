//Caglayan, Ismail 01.05.23
/**
 * Diese javascript-Datei enthält eine Ajax-Funktion, welches dafür sorgt, dass unsere ArtikelListe (die Tabelle mit den Artikeln)
 * in Echtzeit aktualisiert wird. Das Problem bestand bisher darin, dass das Servlet "ArtikelListeServlet"" beim Aufruf der JSP NICHT
 * sofort gestartet wird. Das Servlet musste durch eine Aktion getriggert werden. Dieser Ajax Code macht also nichts anderse als
 * zu prüfen ob die JSP aufgerufen wurde, und wenn ja, "aktiviert" es das Servlet "ArtikelListeServlet".
 */
var ajaxCallMade; //Variable, die später prüft, ob der Ajax-Aufruf bereits stattgefunden hat (um eine Dauerschleife zu vermeiden)
$(document).ready(function() { //Hier wird geprüft, ob das Dokument bereit steht. (Ob die JSP geöffnet ist)
	if (!ajaxCallMade) {     //Überprüfung, ob der Ajax-Aufruf nicht schon gemacht wurde
		$.ajax({
			url: "http://localhost:8080/ProjectRed/ArtikelListeServlet",  //URL des Servlets, welches aufgerufen werden soll
			success: function(data) {               
				$("#artikelliste").empty();                      /**Die ArtikelListe-HTML wird zunächst geleert, da sie sonst zwei mal aufgerufen wird
																 Einmal von dem JSP-Aufruf und einmal vom Ajax-Aufruf.*/
																 
				console.log("AJAX-Aufruf erfolgreich");      //Konsolen-Ausgabe, ob Ajax-Aufruf erfolgreich. Im Browser "STR+Shift+J" drücken zum nachsehen.
				

				$("#artikelliste").html(data); // Ajax-Aufruf fügt hier die aktualisierte HTML ein
			},
			error: function() {
				console.log("AJAX-Aufruf fehlgeschlagen"); //Konsolen-Ausgabe, ob Ajax-Aufruf fehlgeschlagen. Im Browser "STR+Shift+J" drücken zum nachsehen.
			}
		});
		ajaxCallMade = true;           //variable wird auf true gesetzt, ansonsten wird der call in einer Endlosschleife erneut durchgeführt.
	}

});
