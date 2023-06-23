<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="container rounded p-3 contenido">
        <script>
        	function registrarJugadores(jugadoresARegistrar){
				document.getElementById("jugadoresARegistrar").value=jugadoresARegistrar;
				document.forms[0].submit();
				//window.location = "/ballscore/jugadores/equipo/temporada/registrarJugadores.action?form.idTemporada="+<s:property value="form.idTemporada"/>+"&form.idEquipo="+<s:property value="form.idEquipo"/>;
        	}
        	
        	function alternarEstado(idJugador){
        		document.getElementById("idJugador").value=idJugador;
        		document.forms[0].action="/ballscore/jugadores/equipo/temporada/alternarEstado.action";
        		document.forms[0].submit();
        	}
        	function limpiarBusqueda(){
				document.forms[0].boletaAlumno.value=null;
				document.forms[0].nombrePila.value=null;
				document.forms[0].posicionPrim.value=null;
				document.forms[0].posicionSec.value=null;
				document.forms[0].submit();
			}
        </script>
        <script>
        $(document).ready(function(){

		  // jQuery methods go here...
			
			$("#registrarJugadoresModal").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
        		TINY.box.show({
        			iframe:'/ballscore/jugadores/equipo/temporada/modalRegistrarJugador.action?form.idTemporada=<s:property value="form.idTemporada"/>&form.idEquipo=<s:property value="form.idEquipo"/>',
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
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
       
		    <s:actionmessage />
    <br>
    Registrando jugadores en la liga [<b><s:property value="form.temporada.liga.nombre"/></b>] temporada del <b><s:property value="form.temporada.fechaInicial"/></b> al <b><s:property value="form.temporada.fechaFinal"/></b>
    <br>
    
    <s:form action="registrarJugadores" method="post">
    	<s:hidden id="idJugador" key="form.idJugador"></s:hidden>
		<s:hidden key="form.idTemporada"></s:hidden>
		<s:hidden key="form.idEquipo"></s:hidden>
		<s:hidden id="jugadoresARegistrar" key="form.jugadoresARegistrar"></s:hidden>
        <table style="border:none">
        	<tr>
        	<td><b>Búsqueda por Boleta Alumno</b> <input type="text" id="boletaAlumno" name="form.boletaAlumno"/></td>
        	<td><b>Búsqueda por Nombre Pila</b> <input type="text" id="nombrePila" name="form.nombrePila"/></td>
        	<td><b>Búsqueda por Posici&oacute;n Primaria</b> <s:select id="posicionPrim" name="form.posicionPrim" headerKey="" headerValue="Seleccione" list="posiciones" theme="simple"/></td>
        	<td><b>Búsqueda por Posici&oacute;n Secundaria</b> <s:select id="posicionSec" name="form.posicionSec" headerKey="" headerValue="Seleccione" list="posiciones" theme="simple"/></td>
        	</tr>
        	<tr>
        		<td align="left" colspan="3"><s:submit value="%{getText('button.label.submit')}" theme="simple"/> <input type="button" value="Limpiar" onclick="javascript:limpiarBusqueda()"></td>
        	</tr>
    </table>
    </s:form>
        <br>
    Jugadores Registrados:
    <div>
			<display:table export="true" id="jugadorTemporada" name="form.jugadoresTemporada" pagesize="7" requestURI="" class="table table-hover table-striped">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="jugadoresTemporada.xls" />
				<display:setProperty name="export.csv.filename" value="jugadoresTemporada.csv" />
				<display:setProperty name="export.xml.filename" value="jugadoresTemporada.xml" />
				<display:setProperty name="export.pdf.filename" value="jugadoresTemporada.pdf" />
				<display:column property="jugador.alumno.boletaAlumno" title="Boleta Alumno" sortable="true"></display:column>
				<display:column property="jugador.alumno.nombrePila" title="Nombre pila" sortable="true" escapeXml="true"></display:column>
				<display:column property="jugador.alumno.apellidoPat" title="Apellido Paterno" sortable="true" escapeXml="true"></display:column>
				<display:column property="jugador.alumno.apellidoMat" title="Apellido Materno" sortable="true" escapeXml="true"></display:column>
				<display:column property="jugador.posicionPrim" title="Posici&oacute;n Primaria" sortable="true"></display:column>
				<display:column property="jugador.posicionSec" title="Posici&oacute;n Secundaria" sortable="true"></display:column>
				<display:column title="Activo" sortable="true" media="html">
					<s:if test="%{#attr.jugadorTemporada.fechaAlta!=null}">
						<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
					</s:if>
                    <s:else>
                   		<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
                    </s:else>
				</display:column>
				<display:column media="html">
					<s:if test="%{#attr.jugadorTemporada.fechaAlta!=null}">
							<s:url action="alternarEstado" var="url" escapeAmp="false">
	                            <s:param name="form.idTemporada" value="%{#attr.jugadorTemporada.idTemporada}"/>
	                            <s:param name="form.idEquipo" value="%{#attr.jugadorTemporada.idEquipo}"/>
	                            <s:param name="form.idJugador" value="%{#attr.jugadorTemporada.idJugador}"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Baja</a>
					</s:if>
                    <s:else>
                   			<s:url action="alternarEstado" var="url" escapeAmp="false">
	                            <s:param name="form.idTemporada" value="%{#attr.jugadorTemporada.idTemporada}"/>
	                            <s:param name="form.idEquipo" value="%{#attr.jugadorTemporada.idEquipo}"/>
	                            <s:param name="form.idJugador" value="%{#attr.jugadorTemporada.idJugador}"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Alta</a>
                    </s:else>
				</display:column>
				<display:column media="html">
							<s:url namespace="/jugadores/estadisticas" action="consultarEstadisticasTemporada" var="url" escapeAmp="false">
	                            <s:param name="form.idTemporada" value="%{#attr.jugadorTemporada.idTemporada}"/>
	                            <s:param name="form.idEquipo" value="%{#attr.jugadorTemporada.idEquipo}"/>
	                            <s:param name="form.idJugador" value="%{#attr.jugadorTemporada.idJugador}"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Estad&iacute;sticas Temporada</a>
				</display:column>
			</display:table>
		</div>
	<input id="registrarJugadoresModal" type="button" value="Registrar jugadores"/>
    <s:form namespace="/jugadores/equipo/temporada" action="consultarTemporadasRegistro">
			<s:submit value="Regresar" targets="consultarTemporadasRegistro" />
	</s:form>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>
   
    
    