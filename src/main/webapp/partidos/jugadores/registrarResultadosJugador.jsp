<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<html>
    <head>
    	<link rel="stylesheet" href="<s:url value='/bs/css/bootstrap.min.css'/>">
    	<script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
    	<script src="<s:url value='/bs/js/bootstrap.bundle.min.js'/>"></script>
    	
    	<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <title><s:text name="label.registrados.titulo"/></title>
        <script>
        	//Inician metodos JQuery
	        $(document).ready(function(){
				
				$("#cerrarVentana").click(function(){
					window.parent.TINY.box.hide();
    			}); 
    			
    			$("#aceptarSeleccion").click(function(){
    			
    				var jugadoresARegistrar = "";
    			
    				$("input:checkbox[name='jugador']:checked").each(function(){
					    jugadoresARegistrar = jugadoresARegistrar + $(this).val() + "_";
					});
					if(jugadoresARegistrar.length<1){
						Sexy.error("Debe seleccionar al menos un jugador");
					}else{
						window.parent.TINY.box.hide();
						window.parent.registrarJugadores(jugadoresARegistrar);
					}
    			}); 
	        });
	        
	        function limpiarBusqueda(){
				document.forms[0].boletaAlumno.value=null;
				document.forms[0].nombrePila.value=null;
				document.forms[0].posicionPrim.value=null;
				document.forms[0].posicionSec.value=null;
				document.forms[0].submit();
			}
        </script>

	<style>
      table, th, td {
		 padding: 7px;
      }
   </style>
    </head>
    <body>
        <div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.resultadosModal.titulo"/></h1>
        <br/><br/>
        <s:actionerror />
        <s:actionmessage />
        Registrando resultados del jugador:

<div class="accordion" id="accordionExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingOne">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        Registrar Resultados de Pitcher
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <table>
				<tr>
					<th>Resultados Pitcher: </th>
				</tr>
				<tr>
					<td>Partido Iniciado: <input id="partidoIniciado" class="form-check-input" type="checkbox"></td>
					<td>Partido Salvado: <input id="partidoSalvado" class="form-check-input" type="checkbox"></td>
					<td>Partido Terminado: <input id="partidoSalvado" class="form-check-input" type="checkbox"></td>
					<td>Partido Ganado: <input id="partidoSalvado" class="form-check-input" type="checkbox"></td>
					<td>Partido Perdido: <input id="partidoSalvado" class="form-check-input" type="checkbox"></td>
				</tr>
				<tr>
					<td>Innings Pitcheadas: <br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Bases por bola: <br><input class="form-control" id="walks" type="number"></td>
					<td>Bases por bola intencionales: <br><input class="form-control" id="intWalk" type="number"></td>
					<td>Bases por golpe:<br><input class="form-control" id="intWalk" type="number"></td>
					<td>Balks:<br><input class="form-control" id="balks" type="number"></td>
					<td>WildPitchs:<br><input class="form-control" id="wp" type="number"></td>
				</tr>
				<tr>
					<td>Hits Permitidos:<br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Carreras:<br><input class="form-control" id="walks" type="number"></td>
					<td>Carreras permitidas:<br><input class="form-control" id="intWalk" type="number"></td>
					<td>Homeruns:<br><input class="form-control" id="hitsByPitch" type="number"></td>
				</tr>
				<tr>
					<td>Strike Outs:<br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Fly Outs: <br><input class="form-control" id="walks" type="number"></td>
					<td>Ground Outs: <br><input class="form-control" id="intWalk" type="number"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><input class="btn btn-primary" type="button" value="Registrar Resultados"></td>
				</tr>
		</table>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingTwo">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
        Registrar Resultados de Defensiva
      </button>
    </h2>
    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <table>
				<tr>
					<th>Resultados defensivos:</th>
				<tr>
					<td>Innings jugadas:<br><input class="form-control" id="wp" type="number"></td>
				</tr>
				<tr>
					<td>Outs:<br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Putouts:<br><input class="form-control" id="hitsByPitch" type="number"></td>
					<td>Doble plays:<br><input class="form-control" id="intWalk" type="number"></td>
					<td>Triple Plays<br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Passed Balls: <br><input class="form-control" id="intWalk" type="number"></td>
				</tr>
				<tr>
					<td>Asitencia Out Outfield:<br><input class="form-control" id="walks" type="number"></td>
					<td>Asistencias:  <br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Atradas en robo: <br><input class="form-control" id="walks" type="number"></td>
					<td>Robos: <br><input class="form-control" id="intWalk" type="number"></td>
					<td>Errores:<br><input class="form-control" id="balks" type="number"></td>
					<td><input class="btn btn-primary" type="button" value="Registrar Resultados"></td>
				</tr>
		</table>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingThree">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
        Registrar Resultados de Ofensiva
      </button>
    </h2>
    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <table>
				<tr>
					<th>Resultados ofensivos:</th>	
				</tr>
				<tr>
					<td>Walk off: <input class="form-check-input" id="partidoIniciado" type="checkbox"></td>
				<tr>
				<tr>
					<td>Turnos al bat:  <br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Apariciones al plato: <br><input class="form-control" id="inningsPitch" type="number"></td>
				</tr>
				<tr>
					<td>Sencillos: <br><input class="form-control" id="walks" type="number"></td>
					<td>Dobles: <br><input class="form-control" id="intWalk" type="number"></td>
					<td>Triples: <br><input class="form-control" id="intWalk" type="number"></td>
					<td>Homeruns: <br><input class="form-control" id="balks" type="number"></td>
					<td>Grandslam: <br><input class="form-control" id="wp" type="number"></td>
				</tr>
				<tr>
					<td>Carreras: <br><input class="form-control"  id="walks" type="number"></td>
					<td>Carreras bateadas:<br><input  class="form-control" id="intWalk" type="number"></td>
					<td>Bases Robadas:<br><input class="form-control" id="hitsByPitch" type="number"></td>
					<td>Atrapado en robos: <br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Safe en error: <br><input class="form-control" id="inningsPitch" type="number"></td>
				</tr>
				<tr>
					<td>Ground outs: <br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Ground double play: <br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Hit by Pitch<br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Walks Intencionales<br><input class="form-control" id="inningsPitch" type="number"></td>
				</tr>
				<tr>
					<td>Dejado en base: <br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Toques de sacrifico<br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Elevados de sacrificio<br><input class="form-control" id="inningsPitch" type="number"></td>
				</tr>
				<tr>
					<td>Bases por bola: <br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>Strike outs: <br><input class="form-control" id="inningsPitch" type="number"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><input class="btn btn-primary" type="button" value="Registrar Resultados"></td>
				</tr>
		</table>
      </div>
    </div>
  </div>
</div>

<input id="cerrarVentana" type="button" value="Cerrar"/>
    </body>
</html>
