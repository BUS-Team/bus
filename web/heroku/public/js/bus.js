var line = null;
var direction = null;
var warning = 0;



lar = screen.width - 180;
alt = screen.height - 135;
var divMapa = document.getElementById('map');
//var divConteudo = document.getElementById('conteudoprincipal');
divMapa.style.minHeight = "" + alt + "px";
//divConteudo.style.minHeight = "" + alt + "px";

var map = L.map('map').setView([ -23.308094, -51.160484 ], 13);
var trajetorias = [];
var itinerarios = [];
var color = ['#e71112', '#f603f0', '#531c9f', '#097634', '#000', '#5e6e8c', '#71fa12', '#2010b4'];

var colors = ['red', 'purple', 'green', 'orange', 'darkred', 'cadetblue', 'darkpurple', 'darkgreen', 'darkblue'];

L
    .tileLayer(
        // 'http://{s}.tile.cloudmade.com/{key}/22677/256/{z}/{x}/{y}.png'

        'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
        ,
        {
          attribution : 'Map data &copy; 2013 OpenStreetMap contributors, Imagery &copy; 2012 CloudMade',
          key : 'BC9A493B41014CAABB98F0471D759707'
        }).addTo(map);

function clearMap() {
  for (i in map._layers) {
    if (map._layers[i]._path != undefined) {
      try {
        map.removeLayer(map._layers[i]);
      } catch (e) {
        console.log("problem with " + e + map._layers[i]);
      }
    }
  }
};

function desenhaCirculo(lat, lng, cor, corLinha, raio, legenda) {
  L.circle([ lat, lng ], raio, {
    color : cor,
    fillcolor : corLinha,
    fillOpacity : 0.6
  }).addTo(map).bindPopup(legenda);
};

function getPosition(line) {
    $.ajax({
      url : "/line?line=" + line,
      success: 
        function(data) {
          parsed = data;

          var x = new Array(L.marker);

          if (typeof data === "string") {
            parsed = JSON.parse(data);
          }
          
          for (var i = parsed.length - 1; i >= 0; i--) {
            indexColor = i % 8;
            
            line = parsed[i].line;
            direction = parsed[i].direction;

            //desenhaCirculo(parsed[i].lat, parsed[i].lng, color[indexColor-1], 'white', 50, "( " + parsed[i].line + " ) Indo para " + parsed[i].direction);
            
            L.marker([parsed[i].lat, parsed[i].lng], {icon: L.AwesomeMarkers.icon({icon: 'icon-map-marker', color: colors[indexColor], spin:false}) }).bindPopup("( " + parsed[i].line + " ) Indo para " + parsed[i].direction).openPopup().addTo(map);

          };

          
          //map.panTo(new L.LatLng(parsed[0].lat, parsed[0].lng));
            
            
            /**

            for ( var i = 0; i < parsed.length; ++i) {
              var trajetoria = parsed[i], pontos = [];

              for ( var j = 0; j < trajetoria.pontos.length; ++j) {
                var ponto = trajetoria.pontos[j];
                pontos.push(new L.LatLng(ponto.latitude, ponto.longitude));
              }
              // var polyline = L.polyline(pontos, {color: 'black'}).addTo(map);
              var polyline = L.polyline(pontos, {
                color : 'red'
              });
              trajetorias.push(polyline);

              // Criar botão para o veículo, se necessário
              if (ultimoVeiculo != trajetoria.pontos[0].veiculoId) {
                var opcaoVeiculo = document.createElement("option");

                opcaoVeiculo.setAttribute("value", i);
                opcaoVeiculo.innerHTML = trajetoria.pontos[0].veiculoId;

                divVeiculos.appendChild(opcaoVeiculo);
                ultimoVeiculo = trajetoria.pontos[0].veiculoId;
              }
            }
            /**/
          
        }
    });
};

function clearMap() {
  for (i in map._layers) {
    if (map._layers[i]._path != undefined) {
      try {
        map.removeLayer(map._layers[i]);
      } catch (e) {
        console.log("problem with " + e + map._layers[i]);
      }
    }
  }
};

function clearMarkers() {
  for (i in map._layers) {
    if(map._layers[i]._tileImg == undefined) {
      map.removeLayer(map._layers[i]);
    }
    else
    {
      
    }
  }
}

function okClicked() {
  line = document.getElementById('selectLine');
  getPosition(line.value);
  window.setInterval('getPosition(line.value)', 15000);
};