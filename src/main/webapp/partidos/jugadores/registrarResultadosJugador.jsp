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
    			
    			$('#partidoIniciado').on('change', function(){
			   this.value = this.checked ? 1 : 0;
				}).change();
				$('#partidoSalvado').on('change', function(){
				   this.value = this.checked ? 1 : 0;
				}).change();
				$('#partidoTerminado').on('change', function(){
				   this.value = this.checked ? 1 : 0;
				}).change();
				$('#partidoGanado').on('change', function(){
				   this.value = this.checked ? 1 : 0;
				}).change();
				$('#partidoPerdido').on('change', function(){
				   this.value = this.checked ? 1 : 0;
				}).change();
				$('#esOportunidadSalvado').on('change', function(){
				   this.value = this.checked ? 1 : 0;
				}).change();
				$('#esShoutout').on('change', function(){
				   this.value = this.checked ? 1 : 0;
				}).change();
	        });

   			
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
      <s:form action="registrarEstadisticasPitcher" method="post">
		<s:hidden id="idPartido" key="form.IdPartido"></s:hidden>
		<s:hidden id="idJugador" key="form.idJugador"></s:hidden>
		<s:hidden id="idEquipo" key="form.idEquipo"></s:hidden>
		<s:hidden id="idTemporada" key="form.idTemporada"></s:hidden>
        <table>
				<tr>
					<th>Resultados Pitcher: </th>
				</tr>
				<tr>
					<td>Partido Iniciado: <input id="partidoIniciado" name="form.estadisticasPitcherVO.partidoIniciado" class="form-check-input" type="checkbox" value="0"></td>
					<td>Partido Salvado: <input id="partidoSalvado" name="form.estadisticasPitcherVO.partidoSalvado" class="form-check-input" type="checkbox" value="0"></td>
					<td>Partido Terminado: <input id="partidoTerminado" name="form.estadisticasPitcherVO.partidoTerminado" class="form-check-input" type="checkbox" value="0"></td>
					<td>Partido Ganado: <input id="partidoGanado" name="form.estadisticasPitcherVO.partidoGanado" class="form-check-input" type="checkbox" value="0"></td>
					<td>Partido Perdido: <input id="partidoPerdido" name="form.estadisticasPitcherVO.partidoPerdido" class="form-check-input" type="checkbox" value="0"></td>
					<td>Oportunidad Salvado: <input id="esOportunidadSalvado" name="form.estadisticasPitcherVO.esOportunidadSalvado" class="form-check-input" type="checkbox" value="0"></td>
					<td>Shutout: <input id="esShoutout" class="form-check-input" name="form.estadisticasPitcherVO.esShutout" type="checkbox" value="0"></td>
				</tr>
				<tr>
					<td>Innings Pitcheadas: <br><input class="form-control" name="form.estadisticasPitcherVO.inningsPitcheadas" id="inningsPitch" type="number"></td>
					<td>Bases por bola: <br><input class="form-control" name="form.estadisticasPitcherVO.basesPorbola" id="walks" type="number"></td>
					<td>Bases por bola intencionales: <br><input class="form-control" name="form.estadisticasPitcherVO.basesPorBolaInt" id="intWalk" type="number"></td>
					<td>Bases por golpe:<br><input class="form-control" name="form.estadisticasPitcherVO.basesPorGolpe" id="hbp" type="number"></td>
					<td>Balks:<br><input class="form-control" name="form.estadisticasPitcherVO.balks" id="balks" type="number"></td>
					<td>WildPitchs:<br><input class="form-control" name="form.estadisticasPitcherVO.wildpitchs" id="wp" type="number"></td>
				</tr>
				<tr>
					<td>Hits Permitidos:<br><input class="form-control" name="form.estadisticasPitcherVO.hitsPermitidos" id="hitsPermitidos" type="number"></td>
					<td>Carreras:<br><input class="form-control" name="form.estadisticasPitcherVO.carreras" id="carreras" type="number"></td>
					<td>Carreras permitidas:<br><input class="form-control" name="form.estadisticasPitcherVO.carrerasPermitidas" id="carrerasPermitidas" type="number"></td>
					<td>Homeruns:<br><input class="form-control" name="form.estadisticasPitcherVO.homeruns" id="homeruns" type="number"></td>
				</tr>
				<tr>
					<td>Strike Outs:<br><input class="form-control" name="form.estadisticasPitcherVO.strikeouts" id="strikeoutsPitch" type="number"></td>
					<td>Fly Outs: <br><input class="form-control" name="form.estadisticasPitcherVO.flyouts" id="flyouts" type="number"></td>
					<td>Ground Outs: <br><input class="form-control"  name="form.estadisticasPitcherVO.groundOuts" id="groundouts" type="number"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><input class="btn btn-primary" type="submit" value="Registrar Resultados"></td>
				</tr>
		</table>
	</s:form>
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
      <s:form action="registrarEstadisticasDefensivas" method="post">
		<s:hidden id="idPartido" key="form.IdPartido"></s:hidden>
		<s:hidden id="idJugador" key="form.idJugador"></s:hidden>
		<s:hidden id="idEquipo" key="form.idEquipo"></s:hidden>
		<s:hidden id="idTemporada" key="form.idTemporada"></s:hidden>
        <table>
				<tr>
					<th>Resultados defensivos:</th>
				<tr>
					<td>Innings jugadas:<br><input class="form-control" name="form.estadisticasDefensivasVO.inningsJugadas" id="inningsJugadas" type="number"></td>
				</tr>
				<tr>
					<td>Outs:<br><input class="form-control" name="form.estadisticasDefensivasVO.outs" id="outs" type="number"></td>
					<td>Putouts:<br><input class="form-control" name="form.estadisticasDefensivasVO.putouts" id="putouts" type="number"></td>
					<td>Doble plays:<br><input class="form-control" name="form.estadisticasDefensivasVO.dobleplays" id="dobleplays" type="number"></td>
					<td>Triple Plays<br><input class="form-control" name="form.estadisticasDefensivasVO.triplePlays" id="triplePlays" type="number"></td>
					<td>Passed Balls: <br><input class="form-control" name="form.estadisticasDefensivasVO.passedballs" id="passedballs" type="number"></td>
				</tr>
				<tr>
					<td>Asitencia Out Outfield:<br><input class="form-control" name="form.estadisticasDefensivasVO.asistenciaOutField" id="asistenciaOutField" type="number"></td>
					<td>Asistencias:  <br><input class="form-control" name="form.estadisticasDefensivasVO.asistencias" id="asistencias" type="number"></td>
					<td>Atradas en robo: <br><input class="form-control" name="form.estadisticasDefensivasVO.atrapadasEnRobo" id="atrapadasEnRobo" type="number"></td>
					<td>Robos: <br><input class="form-control" name="form.estadisticasDefensivasVO.robos" id="robos" type="number"></td>
					<td>Errores:<br><input class="form-control" name="form.estadisticasDefensivasVO.errores" id="errores" type="number"></td>
					<td><input class="btn btn-primary" type="submit" value="Registrar Resultados"></td>
				</tr>
		</table>
		</s:form>
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
					<td>Walk off: <input class="form-check-input" id="walkoff" type="checkbox"></td>
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
