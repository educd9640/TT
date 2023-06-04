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
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
   
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
					<td>Partido Iniciado: <s:textfield id="partidoIniciado" key="form.estadisticasPitcherVO.partidoIniciado" class="form-control" theme="simple" type="number" min="0" max="1"
										value="%{form.estadisticasPitcherVO.partidoIniciado!=null ? form.estadisticasPitcherVO.partidoIniciado: 0}"/></td>
					<td>Partido Salvado: <s:textfield id="partidoSalvado" key="form.estadisticasPitcherVO.partidoSalvado" class="form-control" theme="simple" type="number" min="0" max="1"
										value="%{form.estadisticasPitcherVO.partidoSalvado!=null ? form.estadisticasPitcherVO.partidoSalvado: 0}"/></td>
					<td>Partido Terminado: <s:textfield id="partidoTerminado" key="form.estadisticasPitcherVO.partidoTerminado" class="form-control" theme="simple" type="number" min="0" max="1"
										value="%{form.estadisticasPitcherVO.partidoTerminado!=null ? form.estadisticasPitcherVO.partidoTerminado: 0}"/></td>
					<td>Partido Ganado: <s:textfield id="partidoGanado" key="form.estadisticasPitcherVO.partidoGanado" class="form-control"  theme="simple" type="number" min="0" max="1"
										value="%{form.estadisticasPitcherVO.partidoGanado!=null ? form.estadisticasPitcherVO.partidoGanado: 0}"/></td>
					<td>Partido Perdido: <s:textfield id="partidoPerdido" key="form.estadisticasPitcherVO.partidoPerdido" class="form-control"  theme="simple" type="number" min="0" max="1"
										value="%{form.estadisticasPitcherVO.partidoPerdido!=null ? form.estadisticasPitcherVO.partidoPerdido: 0}"/></td>
					<td>Oportunidad Salvado: <s:textfield id="esOportunidadSalvado" key="form.estadisticasPitcherVO.esOportunidadSalvado" class="form-control" theme="simple" type="number" min="0" max="1"
										value="%{form.estadisticasPitcherVO.esOportunidadSalvado!=null ? form.estadisticasPitcherVO.esOportunidadSalvado: 0}"/></td>
					<td>Shutout: <s:textfield id="esShoutout" class="form-control" key="form.estadisticasPitcherVO.esShutout" theme="simple" type="number" min="0" max="1"
										value="%{form.estadisticasPitcherVO.esShutout!=null ? form.estadisticasPitcherVO.esShutout: 0}"/></td>
				</tr>
				<tr>
					<td>Innings Pitcheadas: <br><s:textfield class="form-control" key="form.estadisticasPitcherVO.inningsPitcheadas" id="inningsPitch" theme="simple" type="number" min="0" 
															value="%{form.estadisticasPitcherVO.inningsPitcheadas!=null ? form.estadisticasPitcherVO.inningsPitcheadas: 0}"/></td>
					<td>Bases por bola: <br><s:textfield class="form-control" key="form.estadisticasPitcherVO.basesPorbola" id="walks" theme="simple" type="number" min="0" 
															value="%{form.estadisticasPitcherVO.basesPorbola!=null ? form.estadisticasPitcherVO.basesPorbola: 0}"/></td>
					<td>Bases por bola intencionales: <br><s:textfield class="form-control" key="form.estadisticasPitcherVO.basesPorBolaInt" id="intWalk" theme="simple" type="number" min="0" 
															value="%{form.estadisticasPitcherVO.basesPorBolaInt!=null ? form.estadisticasPitcherVO.basesPorBolaInt: 0}"/></td>
					<td>Bases por golpe:<br><s:textfield class="form-control" key="form.estadisticasPitcherVO.basesPorGolpe" id="hbp" theme="simple" type="number" min="0" 
															value="%{form.estadisticasPitcherVO.basesPorGolpe!=null ? form.estadisticasPitcherVO.basesPorGolpe: 0}"/></td>
					<td>Balks:<br><s:textfield class="form-control" key="form.estadisticasPitcherVO.balks" id="balks" theme="simple" type="number" min="0" 
															value="%{form.estadisticasPitcherVO.balks!=null ? form.estadisticasPitcherVO.balks: 0}"/></td>
					<td>WildPitchs:<br><s:textfield class="form-control" key="form.estadisticasPitcherVO.wildpitchs" id="wp" theme="simple" type="number" min="0" 
															value="%{form.estadisticasPitcherVO.wildpitchs!=null ? form.estadisticasPitcherVO.wildpitchs: 0}"/></td>
				</tr>
				<tr>	
					<td>Hits Permitidos:<br><s:textfield class="form-control" key="form.estadisticasPitcherVO.hitsPermitidos" id="hitsPermitidos" theme="simple" type="number" min="0" 
															value="%{form.estadisticasPitcherVO.hitsPermitidos!=null ? form.estadisticasPitcherVO.hitsPermitidos: 0}"/></td>
					<td>Carreras:<br><s:textfield class="form-control" key="form.estadisticasPitcherVO.carreras" id="carreras" theme="simple" type="number" min="0" 
															value="%{form.estadisticasPitcherVO.carreras!=null ? form.estadisticasPitcherVO.carreras: 0}"/></td>
					<td>Carreras permitidas:<br><s:textfield class="form-control" key="form.estadisticasPitcherVO.carrerasPermitidas" theme="simple" id="carrerasPermitidas" type="number" min="0" 
															value="%{form.estadisticasPitcherVO.carrerasPermitidas!=null ? form.estadisticasPitcherVO.carrerasPermitidas: 0}"/></td>
					<td>Homeruns:<br><s:textfield class="form-control" key="form.estadisticasPitcherVO.homeruns" id="homeruns" theme="simple" type="number" min="0"
															value="%{form.estadisticasPitcherVO.homeruns!=null ? form.estadisticasPitcherVO.homeruns: 0}"/></td>
				</tr>
				<tr>
					<td>Strike Outs:<br><s:textfield class="form-control" key="form.estadisticasPitcherVO.strikeouts" id="strikeoutsPitch" theme="simple" type="number" min="0"
															value="%{form.estadisticasPitcherVO.strikeouts!=null ? form.estadisticasPitcherVO.strikeouts: 0}"/></td>
					<td>Fly Outs: <br><s:textfield class="form-control" key="form.estadisticasPitcherVO.flyouts" id="flyouts" theme="simple" type="number" min="0"
															value="%{form.estadisticasPitcherVO.flyouts!=null ? form.estadisticasPitcherVO.flyouts: 0}"/></td>
					<td>Ground Outs: <br><s:textfield class="form-control"  key="form.estadisticasPitcherVO.groundOuts" id="groundouts" theme="simple" type="number" min="0"
															value="%{form.estadisticasPitcherVO.groundOuts!=null ? form.estadisticasPitcherVO.groundOuts: 0}"/></td>
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
					<td>Innings jugadas:<br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.inningsJugadas" id="inningsJugadas" type="number" min="0" theme="simple"/></td>
				</tr>
				<tr>
					<td>Outs:<br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.outs" id="outs" type="number" min="0" theme="simple"/></td>
					<td>Putouts:<br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.putouts" id="putouts" type="number" min="0" theme="simple"/></td>
					<td>Doble plays:<br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.dobleplays" id="dobleplays" type="number" min="0" theme="simple"/></td>
					<td>Triple Plays<br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.triplePlays" id="triplePlays" type="number" min="0" theme="simple"/></td>
					<td>Passed Balls: <br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.passedballs" id="passedballs" type="number" min="0" theme="simple"/></td>
				</tr>
				<tr>
					<td>Asitencia Out Outfield:<br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.asistenciaOutField" id="asistenciaOutField" type="number" min="0" theme="simple"/></td>
					<td>Asistencias:  <br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.asistencias" id="asistencias" type="number" min="0" theme="simple"/></td>
					<td>Atrapadas en robo: <br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.atrapadasEnRobo" id="atrapadasEnRobo" type="number" min="0" theme="simple"/></td>
					<td>Robos: <br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.robos" id="robos" type="number" min="0" theme="simple"/></td>
					<td>Errores:<br><s:textfield class="form-control" name="form.estadisticasDefensivasVO.errores" id="errores" type="number" min="0" theme="simple"/></td>
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
      <s:form action="registrarEstadisticasOfensivas" method="post">
		<s:hidden id="idPartido" key="form.IdPartido"></s:hidden>
		<s:hidden id="idJugador" key="form.idJugador"></s:hidden>
		<s:hidden id="idEquipo" key="form.idEquipo"></s:hidden>
		<s:hidden id="idTemporada" key="form.idTemporada"></s:hidden>
        <table>
				<tr>
					<th>Resultados ofensivos:</th>	
				</tr>
				<tr>
					<td>Walk off: <s:textfield  class="form-control" id="esWalkOff" name="form.estadisticasOfensivasVO.walkOff"  type="number" theme="simple" min="0" max="1"/></td>
				<tr>
				<tr>
					<td>Turnos al bat:  <br><s:textfield  class="form-control" id="turnosAlBat" name="form.estadisticasOfensivasVO.alBat" type="number" min="0" theme="simple"/></td>
					<td>Apariciones al plato: <br><s:textfield  class="form-control" id="aparicionesAlPlato" name="form.estadisticasOfensivasVO.plateAppearance" type="number" min="0" theme="simple"/></td>
				</tr>
				<tr>
					<td>Sencillos: <br><s:textfield  class="form-control" id="sencillos" name="form.estadisticasOfensivasVO.sencillos" type="number" min="0" theme="simple"/></td>
					<td>Dobles: <br><s:textfield  class="form-control" id="dobles" name="form.estadisticasOfensivasVO.dobles" type="number" min="0" theme="simple"/></td>
					<td>Triples: <br><s:textfield  class="form-control" id="triples" name="form.estadisticasOfensivasVO.triples" type="number" min="0" theme="simple"/></td>
					<td>Homeruns: <br><s:textfield  class="form-control" id="homeruns" name="form.estadisticasOfensivasVO.homeruns" type="number" min="0" theme="simple"/></td>
					<td>Grandslam: <br><s:textfield  class="form-control" id="grandslam" name="form.estadisticasOfensivasVO.grandslam" type="number" min="0" theme="simple"/></td>
				</tr>
				<tr>
					<td>Carreras: <br><s:textfield  class="form-control"  id="carreras" name="form.estadisticasOfensivasVO.carreras" type="number" min="0" theme="simple"/></td>
					<td>Carreras bateadas:<br><s:textfield   class="form-control" id="carrerasBateadas" name="form.estadisticasOfensivasVO.carrerasBateadas" type="number" min="0" theme="simple"/></td>
					<td>Bases Robadas:<br><s:textfield  class="form-control" id="basesRobadas" name="form.estadisticasOfensivasVO.basesRobadas" type="number" min="0" theme="simple"/></td>
					<td>Atrapado en robos: <br><s:textfield  class="form-control" id="atrapadoEnRobo" name="form.estadisticasOfensivasVO.caughtStealing" type="number" min="0" theme="simple"/></td>
					<td>Safe en error: <br><s:textfield  class="form-control" id="safeEnError" name="form.estadisticasOfensivasVO.reachedOnError" type="number" min="0" theme="simple"/></td>
				</tr>
				<tr>
					<td>Ground outs: <br><s:textfield  class="form-control" id="groundOuts" name="form.estadisticasOfensivasVO.groundOuts" type="number" min="0" theme="simple"/></td>
					<td>Fly outs: <br><s:textfield  class="form-control" id="flyOuts" name="form.estadisticasOfensivasVO.flyOuts" type="number" min="0" theme="simple"/></td>
					<td>Ground double play: <br><s:textfield  class="form-control" id="groundDoublePlay" name="form.estadisticasOfensivasVO.groundIntoDoubleplays" type="number" min="0" theme="simple"/></td>
					<td>Hit by Pitch<br><s:textfield  class="form-control" id="hitByPitch" name="form.estadisticasOfensivasVO.hitsByPitch" type="number" min="0" theme="simple"/></td>
					<td>Walks Intencionales<br><s:textfield  class="form-control" id="walksIntencionales" name="form.estadisticasOfensivasVO.intentionalBB" type="number" min="0" theme="simple"/></td>
				</tr>
				<tr>
					<td>Dejado en base: <br><s:textfield  class="form-control" id="dejadoEnBase" name="form.estadisticasOfensivasVO.leftOnBase" type="number" min="0" theme="simple"/></td>
					<td>Toques de sacrifico<br><s:textfield  class="form-control" id="toqueSacrificio" name="form.estadisticasOfensivasVO.hitsSacrificio" type="number" min="0" theme="simple"/></td>
					<td>Elevados de sacrificio<br><s:textfield  class="form-control" id="elevadoSacrificio" name="form.estadisticasOfensivasVO.elevadosSacrificio" type="number" min="0" theme="simple"/></td>
				</tr>
				<tr>
					<td>Bases por bola: <br><s:textfield  class="form-control" id="basesPorBola" name="form.estadisticasOfensivasVO.basesPorBola" type="number" min="0" theme="simple"/></td>
					<td>Strike outs: <br><s:textfield  class="form-control" id="strikeOuts" name="form.estadisticasOfensivasVO.strikeouts" type="number" min="0" theme="simple"/></td>
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
</div>
<input id="cerrarVentana" type="button" value="Cerrar"/>
    </body>
</html>
