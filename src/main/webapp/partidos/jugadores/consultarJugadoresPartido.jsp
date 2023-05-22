<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="container rounded p-3 contenido">
        <script>
        	function registrarJugadores(jugadoresARegistrar){
				document.getElementById("jugadoresARegistrar").value=jugadoresARegistrar;
				document.forms[0].action="/ballscore/jugadores/partido/registrarJugadores.action";
				document.forms[0].submit();
        	}
        	function limpiarBusqueda(){
				document.forms[0].boletaAlumno.value=null;
				document.forms[0].nombrePila.value=null;
				document.forms[0].posicionPrim.value=null;
				document.forms[0].posicionSec.value=null;
				document.forms[0].submit();
			}
			function registrarResultados(idJugador){
				valIdPartido=document.getElementById("idPartido").value
				valIdEquipo=document.getElementById("idEquipo").value;
				valIdTemporada=document.getElementById("idTemporada").value
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
        		TINY.box.show({
        			iframe:'/ballscore/jugadores/estadisticas/presentarRegistroResultados.action?form.idPartido='+valIdPartido+'&form.idJugador='+idJugador+'&form.idEquipo='+valIdEquipo+'&form.idTemporada='+valIdTemporada+'',
        			boxid:'frameless',
        			width:full_window_width-300,
        			height:full_window_height-250,
        			fixed:true,
        			maskid:'bluemask',
					maskopacity:40
       			})
			}
        </script>
        <script>
        $(document).ready(function(){

		  // jQuery methods go here...
			
			$("#registrarJugadoresModal").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
        		TINY.box.show({
        			iframe:'/ballscore/jugadores/partido/consultarJugadoresNoInscritos.action?form.idTemporada=<s:property value="form.idTemporada"/>&form.idEquipo=<s:property value="form.idEquipo"/>&form.idPartido=<s:property value="form.idPartido"/>',
        			boxid:'frameless',
        			width:full_window_width-300,
        			height:full_window_height-250,
        			fixed:true,
        			maskid:'bluemask',
					maskopacity:40
       			})
    		});
		});
        </script>
	<div class="titleDiv">
		<s:text name="application.title" />
	</div>
	<h1>
		<s:text name="label.registrados.titulo" />
	</h1>
	<br /><br />
	<s:actionerror />
    <s:actionmessage />
    <br>
    Registrando jugadores en partido del dia [<b><s:text name="partido.fechaAnuncioPartido"/></b>] de la liga [<b><s:text name="partido.temporada.liga.nombre"/></b>] temporada del <b><s:text name="partido.temporada.fechaInicial"/></b> al <b><s:text name="partido.temporada.fechaInicial"/></b>
    <br>
    del equipo <b><s:text name="equipoTemporada.equipo.nombre"/></b>
    <br>
    <s:form action="consultarJugadoresPartido" method="post">
    	<s:hidden id="sessionManager" key="sessionManager"></s:hidden>
		<s:hidden id="idTemporada" key="form.idTemporada"></s:hidden>
		<s:hidden id="idEquipo" key="form.idEquipo"></s:hidden>
		<s:hidden id="idPartido" key="form.idPartido"></s:hidden>
		<s:hidden key="form.jugadoresARegistrar" id="jugadoresARegistrar"></s:hidden>
        <table style="border:none;" >
        	<tr>
        	<td><b>Busqueda por Boleta Alumno</b> <input type="text" id="boletaAlumno" name="form.boletaAlumno"/></td>
        	<td><b>Busqueda por Nombre Pila</b> <input type="text" id="nombrePila" name="form.nombrePila"/></td>
        	<td><b>Busqueda por Posici&oacute;n Primaria</b> <s:select id="posicionPrim" name="form.posicionPrim" headerKey="" headerValue="Seleccione" list="posiciones" theme="simple"/></td>
        	<td><b>Busqueda por Posici&oacute;n Secundaria</b> <s:select id="posicionSec" name="form.posicionSec" headerKey="" headerValue="Seleccione" list="posiciones" theme="simple"/></td>
        	</tr>
        	<tr>
        		<td align="left" colspan="3"><s:submit value="%{getText('button.label.submit')}" theme="simple"/> <input type="button" value="Limpiar" onclick="javascript:limpiarBusqueda()"></td>
        	</tr>
    	</table>
    </s:form>
        <br>
    Jugadores Registrados:
    <div>
			<display:table export="true" id="jugadoresPartido" name="form.jugadoresPartido" pagesize="7" requestURI="" class="table table-hover table-striped">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="JugadoresPartido.xls" />
				<display:setProperty name="export.csv.filename" value="JugadoresPartido.csv" />
				<display:setProperty name="export.xml.filename" value="JugadoresPartido.xml" />
				<display:setProperty name="export.pdf.filename" value="JugadoresPartido.pdf" />
				<display:column property="jugadorEquipoTemp.jugador.alumno.boletaAlumno" title="Boleta Alumno" sortable="true"></display:column>
				<display:column property="jugadorEquipoTemp.jugador.alumno.nombrePila" title="Nombre pila" sortable="true" escapeXml="true"></display:column>
				<display:column property="jugadorEquipoTemp.jugador.alumno.apellidoPat" title="Apellido Paterno" sortable="true" escapeXml="true"></display:column>
				<display:column property="jugadorEquipoTemp.jugador.alumno.apellidoMat" title="Apellido Materno" sortable="true" escapeXml="true"></display:column>
				<display:column property="jugadorEquipoTemp.jugador.posicionPrim" title="Posición Primaria" sortable="true" escapeXml="true"></display:column>
				<display:column property="jugadorEquipoTemp.jugador.posicionSec" title="Posición Secundaria" sortable="true" escapeXml="true"></display:column>
				<display:column media="html">
					<s:if test="%{sessionManager.idManager==equipoTemporada.equipo.manager.idManager}">
                        <a href="javascript:registrarResultados('<s:property value="%{#attr.jugadoresPartido.idJugador}"/>')">Registrar Resultados</a>
                    </s:if>
				</display:column>
			</display:table>
		</div>
	<s:if test="%{sessionManager.idManager==equipoTemporada.equipo.manager.idManager}">
		<input id="registrarJugadoresModal" type="button" value="Registrar jugadores"/>
	</s:if>
	
	<s:form namespace="/jugadores/estadisticas" action="consultarEstadisticasPartido" method="post">
		<s:hidden id="idTemporada" key="form.idTemporada"></s:hidden>
		<s:hidden id="idEquipo" key="form.idEquipo"></s:hidden>
		<s:hidden id="idPartido" key="form.idPartido"></s:hidden>
		<s:submit value="Consultar Estadisticas" theme="simple"/>
	</s:form>	
	
    <s:form namespace="/partidos" action="consultarPartidos">
			<s:submit value="Regresar" targets="consultarPartidos" />
	</s:form>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>
   
    
    