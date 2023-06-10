var ajaxCallMade;

document.addEventListener('DOMContentLoaded', function() {
  if (!ajaxCallMade) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/ProjectRed/ArtikelListeServlet', true);
    
    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          var data = xhr.responseText;
          var parser = new DOMParser();
          var doc = parser.parseFromString(data, 'text/html');
          var bodyContent = doc.querySelector('body').innerHTML;
          var artikelliste = document.getElementById('artikelliste');
          var random = document.getElementById('random');
          
          artikelliste.innerHTML = bodyContent;
          random.innerHTML = bodyContent;
          
          console.log('Ajax-Aufruf erfolgreich');
        } else {
          console.log('Ajax-Aufruf fehlgeschlagen');
        }
      }
    };
    
    xhr.send();
    ajaxCallMade = true;
  }
});
