<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript">
	function limpiarBusqueda(){
		document.forms[0].boletaAlumno.value=null;
		document.forms[0].nombrePila.value=null;
		document.forms[0].consultarAlumnos_alumnoForm_idEscuela.value=null;
		document.forms[0].submit();
	}
</script>
    <div class="container rounded p-3 contenido">
    <s:form action="consultarAlumnos" method="post">
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
        	<td><b>Busqueda por Boleta Alumno</b> <input type="text" id="boletaAlumno" name="alumnoForm.boletaAlumno"/></td>
        	<td><b>Busqueda por Nombre Pila</b> <input type="text" id="nombrePila" name="alumnoForm.nombrePila"/></td>
        	<td><b>Busqueda por Escuela</b> <s:select name="alumnoForm.idEscuela" style="display:inline-block;" headerKey="-1" headerValue="Seleccione" list="escuelas" listKey="idEscuela" listValue="nombreCortoEscuela" theme="simple"/></td>
        	</tr>
        	<tr>
        		<td align="left" colspan="3"><s:submit value="%{getText('button.label.submit')}" theme="simple"/> <input type="button" value="Limpiar" onclick="javascript:limpiarBusqueda()"></td>
        	</tr>
        </table>
   		<br>
   		
   </s:form>
        <div>
			<display:table export="true" id="alumno" name="alumnosRegistrado" pagesize="7" requestURI="" class="table table-hover table-striped">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="AlumnosRegistrados.xls" />
				<display:setProperty name="export.csv.filename" value="AlumnosRegistrados.csv" />
				<display:setProperty name="export.xml.filename" value="AlumnosRegistrados.xml" />
				<display:setProperty name="export.pdf.filename" value="AlumnosRegistrados.pdf" />
				<display:column property="boletaAlumno" title="Boleta Alumno" sortable="true"></display:column>
				<display:column property="nombrePila" title="Nombre pila" sortable="true" escapeXml="true"></display:column>
				<display:column property="apellidoPat" title="Apellido Paterno" sortable="true" escapeXml="true"></display:column>
				<display:column property="apellidoMat" title="Apellido Materno" sortable="true" escapeXml="true"></display:column>
				<display:column property="semestre" title="Semestre" sortable="true"></display:column>
				<display:column property="curp" title="CURP" sortable="true"></display:column>
				<display:column property="nss" title="NSS" sortable="true"></display:column>
				<display:column property="telefono" title="Telefono" sortable="true"></display:column>
				<display:column property="telEmergencia" title="Telefono Emergencia" sortable="true"></display:column>
				<display:column property="correo" title="Correo" sortable="true"></display:column>
				<display:column property="escuela.nombreCortoEscuela" title="Escuela" sortable="true"></display:column>
				<display:column title="Activo" sortable="true" media="html">
					<s:if test="%{#attr.alumno.fechaAlta!=null}">
						<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
					</s:if>
                    <s:else>
                   		<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
                    </s:else>
				</display:column>
				<display:column media="html">
					<s:url action="modificarAlumno" var="url" escapeAmp="false">
                            <s:param name="alumnoForm.boletaAlumno" value="%{#attr.alumno.boletaAlumno}"/>
                            <s:param name="operacion">actualizado</s:param>
                    </s:url>
                    <a href="<s:property value="#url"/>">Modificar</a>
				</display:column>
				<display:column media="html">
					<s:if test="%{#attr.alumno.fechaAlta!=null}">
							<s:url action="bajaAlumno" var="url">
	                            <s:param name="alumnoForm.boletaAlumno" value="%{#attr.alumno.boletaAlumno}"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Baja</a>
					</s:if>
                    <s:else>
                   			<s:url action="altaAlumno" var="url">
	                            <s:param name="alumnoForm.boletaAlumno" value="%{#attr.alumno.boletaAlumno}"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Alta</a>
                    </s:else>
				</display:column>
			</display:table>
		</div>
        
        <s:form action="submenuAlumnos" >
			<s:submit value="Regresar" targets="submenuAlumnos"/>
		</s:form>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>
