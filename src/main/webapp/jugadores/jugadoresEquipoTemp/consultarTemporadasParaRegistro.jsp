<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="container rounded p-3 contenido">

        <script>
    		function limpiarBusqueda(){
				document.forms[0].nombreLiga.value=null;
				document.forms[0].fechaInicialTemporada.value=null;
				document.forms[0].fechaFinalTemporada.value=null;
				document.forms[0].submit();
			}
        	//Inician metodos JQuery
	        $(document).ready(function(){
	        
	        });
        </script>
		<div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.seleccionar.titulo"/></h1>
        <br/><br/>
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
 
		        <s:actionmessage />
        
       <s:form action="consultarTemporadasRegistro" method="post">
        <table style="border:none">
        	<tr>
        	<td><b>Busqueda por Nombre Liga</b> <input type="text" id="nombreLiga" name="form.nombreLiga"/></td>
        	<td><b>Busqueda por rango de fechas del: </b> <input type="date" id="fechaInicialTemporada" name="form.fechaInicialTemporada"></td>
        	<td><b> al </b> <input type="date" id="fechaFinalTemporada" name="form.fechaFinalTemporada"></td>
        	</tr>
        	<tr>
        		<td align="left" colspan="3"><s:submit value="%{getText('button.label.submit')}" theme="simple"/> <input type="button" value="Limpiar" onclick="javascript:limpiarBusqueda()"></td>
        	</tr>
        </table>
        </s:form>
        
        <div>
			<display:table export="true" id="equipoTemporada" name="form.equiposTemporada" pagesize="7" requestURI="" class="table table-hover table-striped">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="EquiposDeTemporadas.xls" />
				<display:setProperty name="export.csv.filename" value="EquiposDeTemporadas.csv" />
				<display:setProperty name="export.xml.filename" value="EquiposDeTemporadas.xml" />
				<display:setProperty name="export.pdf.filename" value="EquiposDeTemporadas.pdf" />
				<display:column property="temporada.liga.nombre" title="Nombre Liga" sortable="true"></display:column>
				<display:column property="temporada.fechaInicial" title="Fecha Inicial Temporada" sortable="true" escapeXml="true"></display:column>
				<display:column property="temporada.fechaFinal" title="Fecha Final Temporada" sortable="true" escapeXml="true"></display:column>
				<display:column title="Activo" sortable="true" media="html">
					<s:if test="%{#attr.equipoTemporada.fechaAlta!=null}">
						<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
					</s:if>
                    <s:else>
                   		<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
                    </s:else>
				</display:column>
				<display:column media="html">
					<s:if test="%{#attr.equipoTemporada.fechaAlta!=null}">
							<s:url action="alternarEstadoEquipoTemp" var="url" escapeAmp="false">
	                            <s:param name="form.idTemporada" value="%{#attr.equipoTemporada.idTemporada}"/>
	                            <s:param name="form.idEquipo" value="%{#attr.equipoTemporada.idEquipo}"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Baja</a>
					</s:if>
                    <s:else>
                   			<s:url action="alternarEstadoEquipoTemp" var="url" escapeAmp="false">
	                            <s:param name="form.idTemporada" value="%{#attr.equipoTemporada.idTemporada}"/>
	                            <s:param name="form.idEquipo" value="%{#attr.equipoTemporada.idEquipo}"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Alta</a>
                    </s:else>
				</display:column>
				<display:column media="html">
					<s:if test="%{#attr.equipoTemporada.fechaAlta!=null}">
							<s:url action="registrarJugadores" var="url" escapeAmp="false">
	                            <s:param name="form.idTemporada" value="%{#attr.equipoTemporada.idTemporada}"/>
	                            <s:param name="form.idEquipo" value="%{#attr.equipoTemporada.idEquipo}"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Registrar Jugadores</a>
					</s:if>
				</display:column>
			</display:table>
		</div>
        
        <s:form namespace="/jugadores" action="submenuJugadores">
			<s:submit value="Regresar" targets="submenuJugadores" />
		</s:form>
	
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>