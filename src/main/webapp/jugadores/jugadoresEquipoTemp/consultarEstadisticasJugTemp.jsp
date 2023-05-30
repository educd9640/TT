<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="container rounded p-3 contenido">
        <script>
			funcion
        </script>
        <script>

        </script>
	<div class="titleDiv">
		<s:text name="application.title.estadisticas" />
	</div>
	<h1>
		<s:text name="label.estadisticas.temporada" />
	</h1>
	<s:actionerror />
    <s:actionmessage />
    <br>
<div class="accordion" id="accordionExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingOne">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        Estadisticas Pitcher
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      	<div>
			<display:table export="true" id="estPitcherPart" name="form.estadisticasPitcher" pagesize="7" requestURI="" class="table table-hover table-striped" uid="estPitch">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="EstadisticasPitcherTemp.xls" />
				<display:setProperty name="export.csv.filename" value="EstadisticasPitcherTemp.csv" />
				<display:setProperty name="export.xml.filename" value="EstadisticasPitcherTemp.xml" />
				<display:setProperty name="export.pdf.filename" value="EstadisticasPitcherTemp.pdf" />
				<display:column property="jugadorPartido.jugadorEquipoTemp.jugador.alumno.nombrePila" title="Nombre pila" sortable="true" escapeXml="true"></display:column>
				<display:column property="partidoIniciado" title="I" sortable="true" escapeXml="true"></display:column>
				<display:column property="partidoSalvado" title="S" sortable="true" escapeXml="true"></display:column>
				<display:column property="partidoTerminado" title="T" sortable="true" escapeXml="true"></display:column>
				<display:column property="partidoGanado" title="W" sortable="true" escapeXml="true"></display:column>
				<display:column property="partidoPerdido" title="L" sortable="true" escapeXml="true"></display:column>
				<display:column property="esOportunidadSalvado" title="SVO" sortable="true" escapeXml="true"></display:column>
				<display:column property="esShutout" title="Shout" sortable="true" escapeXml="true"></display:column>
				<display:column property="inningsPitcheadas" title="Inns" sortable="true" escapeXml="true"></display:column>
				<display:column property="basesPorbola" title="BB" sortable="true" escapeXml="true"></display:column>
				<display:column property="basesPorBolaInt" title="BB Int" sortable="true" escapeXml="true"></display:column>
				<display:column property="basesPorGolpe" title="HBP" sortable="true" escapeXml="true"></display:column>
				<display:column property="balks" title="Bals" sortable="true" escapeXml="true"></display:column>
				<display:column property="wildpitchs" title="WP" sortable="true" escapeXml="true"></display:column>
				<display:column property="hitsPermitidos" title="H" sortable="true" escapeXml="true"></display:column>
				<display:column property="carreras" title="R" sortable="true" escapeXml="true"></display:column>
				<display:column property="carrerasPermitidas" title="ER" sortable="true" escapeXml="true"></display:column>
				<display:column property="homeruns" title="HR" sortable="true" escapeXml="true"></display:column>
				<display:column property="strikeouts" title="K" sortable="true" escapeXml="true"></display:column>
				<display:column property="flyouts" title="FOuts" sortable="true" escapeXml="true"></display:column>
				<display:column property="groundOuts" title="GOuts" sortable="true" escapeXml="true"></display:column>
				<display:column property="knine" title="K/9" sortable="true" escapeXml="true"></display:column>
				<display:column property="bbnine" title="BB/9" sortable="true" escapeXml="true"></display:column>
				<display:column property="kbb" title="K/BB" sortable="true" escapeXml="true"></display:column>
				<display:column property="hrnine" title="HR/9" sortable="true" escapeXml="true"></display:column>
				<display:column property="kperc" title="K%" sortable="true" escapeXml="true"></display:column>
				<display:column property="bbperc" title="BB%" sortable="true" escapeXml="true"></display:column>
				<display:column property="avg" title="AVG" sortable="true" escapeXml="true"></display:column>
			</display:table>
		</div>
		<s:if test="%{form.estadisticasPitcher.size()>49}">
			<a href="http://localhost:5000/estadisticas/jugadores/${form.idJugador}/equipos/${form.idEquipo}/temporadas/${form.idTemporada}/reporte/pitcher" class="btn btn-primary">Generar Reporte</a>
		</s:if>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingTwo">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
        Estadisticas Defensivas
      </button>
    </h2>
    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      	<div>
			<display:table export="true" id="estadisticasDefensivas" name="form.estadisticasDefensivas" pagesize="7" requestURI="" class="table table-hover table-striped" uid="estDef">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="EstadisticasDefensivasTemp.xls" />
				<display:setProperty name="export.csv.filename" value="EstadisticasDefensivasTemp.csv" />
				<display:setProperty name="export.xml.filename" value="EstadisticasDefensivasTemp.xml" />
				<display:setProperty name="export.pdf.filename" value="EstadisticasDefensivasTemp.pdf" />
				<display:column property="jugadorPartido.jugadorEquipoTemp.jugador.alumno.nombrePila" title="Nombre pila" sortable="true" escapeXml="true"></display:column>
				<display:column property="inningsJugadas" title="Inns" sortable="true" escapeXml="true"></display:column>
				<display:column property="asistencias" title="Asis" sortable="true" escapeXml="true"></display:column>
				<display:column property="dobleplays" title="DP" sortable="true" escapeXml="true"></display:column>
				<display:column property="triplePlays" title="TP" sortable="true" escapeXml="true"></display:column>
				<display:column property="errores" title="E" sortable="true" escapeXml="true"></display:column>
				<display:column property="passedballs" title="PBalls" sortable="true" escapeXml="true"></display:column>
				<display:column property="outs" title="Outs" sortable="true" escapeXml="true"></display:column>
				<display:column property="asistenciaOutField" title="Outfield Outs" sortable="true" escapeXml="true"></display:column>
				<display:column property="putouts" title="Pouts" sortable="true" escapeXml="true"></display:column>
				<display:column property="totalChances" title="Total C." sortable="true" escapeXml="true"></display:column>
				<display:column property="caughtStealingPerc" title="CS %" sortable="true" escapeXml="true"></display:column>
				<display:column property="fieldingPercentage" title="Fielding %" sortable="true" escapeXml="true"></display:column>
			</display:table>
		</div>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingThree">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
        Estadisticas Ofensivas
      </button>
    </h2>
    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      	<div>
			<display:table export="true" id="estadisticasOfensivas" name="form.estadisticasOfensivas" pagesize="7" requestURI="" class="table table-hover table-striped" uid="estOfen">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="EstadisticasOfensivasTemp.xls" />
				<display:setProperty name="export.csv.filename" value="EstadisticasOfensivasTemp.csv" />
				<display:setProperty name="export.xml.filename" value="EstadisticasOfensivasTemp.xml" />
				<display:setProperty name="export.pdf.filename" value="EstadisticasOfensivasTemp.pdf" />
				<display:column property="jugadorPartido.jugadorEquipoTemp.jugador.alumno.nombrePila" title="Nombre pila" sortable="true" escapeXml="true"></display:column>
				<display:column property="gamesPlayed" title="GP" sortable="true" escapeXml="true"></display:column>
				<display:column property="plateAppearance" title="PA" sortable="true" escapeXml="true"></display:column>
				<display:column property="alBat" title="AB" sortable="true" escapeXml="true"></display:column>
				<display:column property="leftOnBase" title="LOB" sortable="true" escapeXml="true"></display:column>
				<display:column property="carreras" title="R" sortable="true" escapeXml="true"></display:column>
				<display:column property="carrerasBateadas" title="RBI" sortable="true" escapeXml="true"></display:column>
				<display:column property="hitsSacrificio" title="SacH" sortable="true" escapeXml="true"></display:column>
				<display:column property="elevadosSacrificio" title="SacF" sortable="true" escapeXml="true"></display:column>
				<display:column property="basesRobadas" title="Robos" sortable="true" escapeXml="true"></display:column>
				<display:column property="caughtStealing" title="CS" sortable="true" escapeXml="true"></display:column>
				<display:column property="porcentajeBasesRobadas" title="% Robo" sortable="true" escapeXml="true"></display:column>
				<display:column property="sencillos" title="1H" sortable="true" escapeXml="true"></display:column>
				<display:column property="dobles" title="2H" sortable="true" escapeXml="true"></display:column>
				<display:column property="triples" title="3H" sortable="true" escapeXml="true"></display:column>
				<display:column property="homeruns" title="HR" sortable="true" escapeXml="true"></display:column>
				<display:column property="hits" title="H" sortable="true" escapeXml="true"></display:column>
				<display:column property="extraBaseHits" title="XBH" sortable="true" escapeXml="true"></display:column>
				<display:column property="walkOff" title="WOff" sortable="true" escapeXml="true"></display:column>
				<display:column property="grandslam" title="GS" sortable="true" escapeXml="true"></display:column>
				<display:column property="basesPorBola" title="BB" sortable="true" escapeXml="true"></display:column>
				<display:column property="intentionalBB" title="IBB" sortable="true" escapeXml="true"></display:column>
				<display:column property="reachedOnError" title="RoE" sortable="true" escapeXml="true"></display:column>
				<display:column property="hitsByPitch" title="HBP" sortable="true" escapeXml="true"></display:column>
				<display:column property="strikeouts" title="K" sortable="true" escapeXml="true"></display:column>
				<display:column property="groundOuts" title="GOuts" sortable="true" escapeXml="true"></display:column>
				<display:column property="flyOuts" title="FOuts" sortable="true" escapeXml="true"></display:column>
				<display:column property="groundIntoDoubleplays" title="G2P" sortable="true" escapeXml="true"></display:column>
				<display:column property="totalBases" title="TBases" sortable="true" escapeXml="true"></display:column>
				<display:column property="groundoutToAiroutRatio" title="G/A Out Radio" sortable="true" escapeXml="true"></display:column>
				<display:column property="onBasePercentage" title="OBP" sortable="true" escapeXml="true"></display:column>
				<display:column property="onBasePlusSlugging" title="OBP+S" sortable="true" escapeXml="true"></display:column>
				<display:column property="slugger" title="SLG" sortable="true" escapeXml="true"></display:column>
				<display:column property="avg" title="AVG" sortable="true" escapeXml="true"></display:column>
			</display:table>
		</div>
      </div>
    </div>
  </div>
</div>		
		
<s:form namespace="/partidos" action="consultarPartidos">
	<s:submit value="Regresar" targets="consultarPartidos" />
</s:form>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>
   
    
    