<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript">
	function limpiarBusqueda(){
		document.forms[0].idPartido.value=null;
		document.forms[0].nombreLiga.value=null;
		document.forms[0].nombreEquipoLocal.value=null;
		document.forms[0].nombreEquipoVisitante.value=null;
		document.forms[0].fechaInicialBusqueda.value=null;
		document.forms[0].fechaFinalBusqueda.value=null;
		document.forms[0].submit();
	}
</script>
    <div class="container rounded p-3 contenido">
	<s:form action="consultarPartidos" method="post">
        <div class="titleDiv"><s:text name="application.title"/></div>
        <h3><s:text name="label.registrados.titulo"/></h3>
        <br/><br/>
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
 
        <s:actionmessage />
        <table style="border:none">
        	<tr>
	        	<td><b>Busqueda por Id Partido</b> <input type="text" id="idPartido" name="partidoF.idPartido"/></td>
	        	<td><b>Busqueda por Liga</b> <input type="text" id="nombreLiga" name="partidoF.nombreLiga"/></td>
	        	<td><b>Busqueda por Equipo Local</b> <input type="text" id="nombreEquipoLocal" name="partidoF.nombreEquipoLocal"/></td>
	        	<td><b>Busqueda por Equipo Visitante</b> <input type="text" id="nombreEquipoVisitante" name="partidoF.nombreEquipoVisitante"/></td>
        	</tr>
        	<tr>
	        	<td colspan="2" align="right"><b>Buscar partidos del <input type="date" id="fechaInicialBusqueda" name="partidoF.fechaInicialBusqueda"></b>
	        	<td colspan="2"><b>al <input type="date" id="fechaFinalBusqueda" name="partidoF.fechaInicialBusqueda"></b>
        	</tr>
        	<tr>
        		<td align="left" colspan="4"><s:submit value="%{getText('button.label.submit')}" theme="simple"/> <input type="button" value="Limpiar" onclick="javascript:limpiarBusqueda()"></td>
        	</tr>
        </table>
   		<br>
   		
   </s:form>
        <div>
			<display:table export="true" id="partido" name="partidos" pagesize="7" requestURI="" class="table table-hover table-striped">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="Partidos.xls" />
				<display:setProperty name="export.csv.filename" value="Partidos.csv" />
				<display:setProperty name="export.xml.filename" value="Partidos.xml" />
				<display:setProperty name="export.pdf.filename" value="Partidos.pdf" />
				<display:column property="idPartido" title="Id Partido" sortable="true"></display:column>
				<display:column property="temporada.fechaInicial" title="Fecha Inicial Temporada" sortable="true" escapeXml="true"></display:column>
				<display:column property="temporada.fechaFinal" title="Fecha Final Temporada" sortable="true" escapeXml="true"></display:column>
				<display:column property="temporada.liga.nombre" title="Liga" sortable="true" escapeXml="true"></display:column>
				<display:column property="equipoTemporadaLocal.equipo.nombre" title="Equipo Local" sortable="true" escapeXml="true"></display:column>
				<display:column property="equipoTemporadaVisitante.equipo.nombre" title="Equipo Visitante" sortable="true" escapeXml="true"></display:column>
				<display:column property="campo" title="Campo" sortable="true" escapeXml="true"></display:column>
				<display:column property="fechaAnuncioPartido" title="Fecha Anuncio Partido" sortable="true" escapeXml="true"></display:column>
				<display:column media="html">
						<s:url namespace="/jugadores/partido" action="consultarJugadoresPartido" var="url" escapeAmp="false">
                            <s:param name="form.idPartido" value="%{#attr.partido.idPartido}"/>
         					<s:param name="form.idEquipo" value="%{#attr.partido.idEquipoLocal}"/>
        					<s:param name="form.idTemporada" value="%{#attr.partido.idTemporada}"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">Jugadores Local</a>
				</display:column>
				<display:column media="html">
						<s:url namespace="/jugadores/partido" action="consultarJugadoresPartido" var="url" escapeAmp="false">
                            <s:param name="form.idPartido" value="%{#attr.partido.idPartido}"/>
         					<s:param name="form.idEquipo" value="%{#attr.partido.idEquipoVisitante}"/>
        					<s:param name="form.idTemporada" value="%{#attr.partido.idTemporada}"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">Jugadores Visitante</a>
				</display:column>
			</display:table>
		</div>
        
        <s:form action="submenuPartidos" >
			<s:submit value="Regresar" targets="submenuPartidos"/>
		</s:form>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>

