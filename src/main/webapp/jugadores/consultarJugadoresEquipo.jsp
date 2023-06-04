<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript">
	function limpiarBusqueda(){
		document.forms[0].boletaAlumno.value=null;
		document.forms[0].nombrePila.value=null;
		document.forms[0].posicionPrim.value=null;
		document.forms[0].posicionSec.value=null;
		document.forms[0].submit();
	}
</script>
<div class="container rounded p-3 contenido">
        <div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.registrados.titulo"/></h1>
        <br/><br/>
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
      
		        <s:actionmessage />
        <s:form action="consultarJugadores" method="post">
        <table style="border:none">
        	<tr>
        	<td><b>Busqueda por Boleta Alumno</b> <input type="text" id="boletaAlumno" name="jugadoresForm.alumno.boletaAlumno"/></td>
        	<td><b>Busqueda por Nombre Pila</b> <input type="text" id="nombrePila" name="jugadoresForm.alumno.nombrePila"/></td>
        	<td><b>Busqueda por Posici&oacute;n Primaria</b> <s:select id="posicionPrim" name="jugadoresForm.posicionPrim" headerKey="" headerValue="Seleccione" list="posiciones" theme="simple"/></td>
        	<td><b>Busqueda por Posici&oacute;n Secundaria</b> <s:select id="posicionSec" name="jugadoresForm.posicionSec" headerKey="" headerValue="Seleccione" list="posiciones" theme="simple"/></td>
        	</tr>
        	<tr>
        		<td align="left" colspan="3"><s:submit value="%{getText('button.label.submit')}" theme="simple"/> <input type="button" value="Limpiar" onclick="javascript:limpiarBusqueda()"></td>
        	</tr>
        </table>
        </s:form>
   		<br>
        <div>
			<display:table export="true" id="jugador" name="jugadoresRegistrados" pagesize="7" requestURI="" class="table table-hover table-striped">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="JugadoresRegistrados.xls" />
				<display:setProperty name="export.csv.filename" value="JugadoresRegistrados.csv" />
				<display:setProperty name="export.xml.filename" value="JugadoresRegistrados.xml" />
				<display:setProperty name="export.pdf.filename" value="JugadoresRegistrados.pdf" />
				<display:column property="alumno.boletaAlumno" title="Boleta Alumno" sortable="true"></display:column>
				<display:column property="alumno.nombrePila" title="Nombre pila" sortable="true" escapeXml="true"></display:column>
				<display:column property="alumno.apellidoPat" title="Apellido Paterno" sortable="true" escapeXml="true"></display:column>
				<display:column property="alumno.apellidoMat" title="Apellido Materno" sortable="true" escapeXml="true"></display:column>
				<display:column property="posicionPrim" title="Posicion Primaria" sortable="true"></display:column>
				<display:column property="posicionSec" title="Posicion Secundaria" sortable="true"></display:column>
				<display:column title="Activo" sortable="true" media="html">
					<s:if test="%{#attr.jugador.fechaAlta!=null}">
						<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
					</s:if>
                    <s:else>
                   		<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
                    </s:else>
				</display:column>
				<display:column media="html">
                    <s:url action="modificarJugador" var="url" escapeAmp="false">
                            <s:param name="jugadoresForm.idJugador" value="%{#attr.jugador.idJugador}"/>
                            <s:param name="operacion">actualizado</s:param>
                    </s:url>
                    <a href="<s:property value="#url"/>">Modificar</a>
				</display:column>
				<display:column media="html">
					<s:if test="%{#attr.jugador.fechaAlta!=null}">
							<s:url action="alternarEstadoJugador" var="url">
	                            <s:param name="jugadoresForm.idJugador" value="%{#attr.jugador.idJugador}"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Baja</a>
					</s:if>
                    <s:else>
                   			<s:url action="alternarEstadoJugador" var="url">
	                            <s:param name="jugadoresForm.idJugador" value="%{#attr.jugador.idJugador}"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Alta</a>
                    </s:else>
				</display:column>
			</display:table>
		</div>
        
        <s:form action="submenuJugadores" >
			<s:submit value="Regresar" targets="submenuJugadores"/>
		</s:form>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>
