<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<html>
	<head>
		<link rel="stylesheet" href="<s:url value='/bs/css/bootstrap.min.css'/>">
		<script src="<s:url value='/bs/js/bootstrap.bundle.min.js'/>"></script>
		
		<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
	<div class="container rounded p-3 contenido">
        <script>
	        function limpiarBusqueda(){
				document.forms[0].idTemporada.value=null;
				document.forms[0].idLiga.value=null;
				document.forms[0].nombre.value=null;
				document.forms[0].submit();
			}
        	function realizarBusqueda() {
		        var opcionIdTemporada = document.getElementById("busquedaIdTemporada");
		        var opcionIdLiga = document.getElementById("busquedaIdLiga");
		
		        if (!opcionIdTemporada.checked && !opcionIdLiga.checked) {
		            return; // No se seleccionó ninguna opción, no se hace nada
		        }else if(opcionIdTemporada.checked && !opcionIdLiga.checked){
		        	opcionIdTemporada.value=true;
		        }else if(!opcionIdTemporada.checked && opcionIdLiga.checked){
		        	opcionIdLiga.value=false;
		        }
		        document.forms[0].submit();
	        }
        </script>
		<div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.registrados.titulo"/></h1>
        <br/><br/>
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
     
        <s:actionmessage />
        <s:form action="consultarTemporadas" method="post">
        <table style="border:none">
        	<tr>
        	<td><input type="radio" id="busquedaIdTemporada" name="opcion" value="IdTemporada"> <label for="busquedaIdTemporada">Busqueda por Id de la Temporada</label> </td>
        	<td><input type="radio" id="busquedaIdLiga" name="opcion" value="IdLiga"> <label for="busquedaIdLiga">Busqueda por Nombre de la Liga</label></td>
    		</tr>
    		<tr>
        	<td><label id="etiqueta" for="idTexto"></label></td>
        	<td><input type="text" id="idTexto" name="idTexto"/></td>
        	<td><input type="button" id="buscar" value="Buscar" onclick="realizarBusqueda()" /> <input type="button" value="Limpiar" onclick="javascript:limpiarBusqueda()"></td>
        	</tr>
        </table>
        </s:form>
        
        <display:table export="true" id="temporadas" name="temporadasRegistradas" pagesize="10" requestURI="" class="table table-hover table-striped">
        	<display:setProperty name="export.types" value="csv excel xml pdf" />
			<display:setProperty name="export.excel.filename" value="temporadasRegistradas.xls" />
			<display:setProperty name="export.csv.filename" value="temporadasRegistradas.csv" />
			<display:setProperty name="export.xml.filename" value="temporadasRegistradas.xml" />
			<display:setProperty name="export.pdf.filename" value="temporadasRegistradas.pdf" />
			<display:column property="liga.nombre" title="Nombre de la liga" sortable="true" ></display:column>
			<display:column property="idTemporada" title="ID de la temporada" sortable="true" ></display:column>
			<display:column property="fechaInicial" title="Fecha de inicio" sortable="true" ></display:column>
			<display:column property="fechaFinal" title="Fecha de cierre" sortable="true" ></display:column>
			<display:column title="Activa" sortable="true" media="html">
					<s:if test="%{#attr.temporadas.fechaAlta!=null}">
						<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
					</s:if>
                    <s:else>
                   		<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
                    </s:else>
			</display:column>
			<display:column media="html">
				<s:url action="modificarTemporada" var="url" escapeAmp="false">
                    <s:param name="temporadaF.idTemporada" value="{#attr.temporadas.idTemporada}"/>
                	<s:param name="operacion">actualizado</s:param>
                </s:url>
                <a href="<s:property value="#url"/>">Modificar</a>
			</display:column>
			<display:column media="html">
				<s:url action="consultarEquipos" var="url" escapeAmp="false">
                	<s:param name="temporadaseleccionada" value="{#attr.temporadas.idTemporada}"/>
                </s:url>
                <a href="<s:property value="#url"/>" >Registrar Equipo</a>
			</display:column>
			<display:column media="html">
				<s:url action="consultarEquiposParticipantes" var="url" escapeAmp="false">
                <s:param name="temporadaseleccionada" value="{#attr.temporadas.idTemporada}"/>
                <s:param name="consultar">equipos</s:param>
                </s:url>
                <a href="<s:property value="#url"/>">Consultar equipos</a>
			</display:column>
			<display:column media="html">
				<s:url action="estadoTemporada" var="url">
                	<s:param name="temporadaF.idTemporada" value="{#attr.temporadas.idTemporada}"/>
                </s:url>
                <s:if test="%{#attr.temporadas.fechaAlta!=null}">
                	<a href="<s:property value="#url"/>">Desactivar</a>		
                </s:if>
                <s:else>
                	<a href="<s:property value="#url"/>">Activar</a>
                </s:else>
			</display:column>
        </display:table>
        <br>
        <br>
        <s:form action="submenuTemporadas">
			<s:submit value="Regresar" targets="submenuTemporadas" />
		</s:form>
	
	</div>
	</body>
	<jsp:include page="/bases/footer.jsp"></jsp:include>
</html>