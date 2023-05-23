<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="<s:url value='/bs/css/bootstrap.min.css'/>">
    	<script src="<s:url value='/bs/js/bootstrap.bundle.min.js'/>"></script>
	
		<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
    	<link href="<s:url value='/css/sexyalertbox.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <title><s:text name="label.visitante.titulo"/></title>

        <script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
        <!-- Script Sexyalertbox -->
        <script src="<s:url value='/js/sexyalertbox.v1.2.jquery.js'/>"></script>
        <!-- Script Jquery easing (Animaciones, usado por sexyalert) -->
        <script src="<s:url value='/js/jquery.easing.1.3.js'/>"></script>
        
        <script>
        function limpiarBusqueda(){
			document.forms[0].idEquipo.value=null;
			document.forms[0].nombre.value=null;
			document.forms[0].submit();
		}
        	//Inician metodos JQuery
	        $(document).ready(function(){
	        
	        	//Funcion para que solo pueda haber 1 checkbox "checkeado" a la vez
	        	$("input:checkbox").on('click', function() {
				  var $box = $(this);
				  if ($box.is(":checked")) {
				    var group = "input:checkbox[name='" + $box.attr("name") + "']";
				    $(group).prop("checked", false);
				    $box.prop("checked", true);
				  } else {
				    $box.prop("checked", false);
				  }
				});
				

				
				$("#cerrarVentana").click(function(){
					window.parent.TINY.box.hide();
    			}); 
    			
    			$("#aceptarSeleccion").click(function(){
    			
    				var checkBoxesSeleccionadas = $('input[name="equipo"]:checked');
					if(checkBoxesSeleccionadas.length<1){
						Sexy.error("Debe seleccionar un equipo");
					}else{
						window.parent.settearDesdeModalVisitante(checkBoxesSeleccionadas[0].value);
						window.parent.TINY.box.hide();
					}
    			}); 
	        });
        </script>
        
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.visitante.titulo"/></h1>
        <br/><br/>
        <s:actionerror />
        <s:actionmessage />
        
        <s:form action="consultarEquipoVisitanteModal" method="post">
        <table style="border:none">
        	<tr>
        	<td><b>Busqueda por id del equipo</b> <input type="text" id="idEquipo" name="equipoForm.idEquipo"/></td>
        	<td><b>Busqueda por nombre del equipo</b> <input type="text" id="nombre" name="equipoForm.nombre"/></td>
        	</tr>
        	<s:hidden name="idTemporada" value="%{#attr.idTemporada}"></s:hidden>
        	<s:hidden name="equipoL" value="%{#attr.equipoL}"></s:hidden>
        	<tr>
        		<td align="left" colspan="3"><s:submit value="%{getText('button.label.buscar')}" theme="simple"/> <input type="button" value="Limpiar" onclick="javascript:limpiarBusqueda()"></td>
        	</tr>
        </table>
        </s:form>
    	
    	<div>
			<display:table export="true" id="equipo" name="equiposTemporadaRegistrados" pagesize="15" requestURI="" class="table table-hover table-striped">
				<s:if test="%{#attr.equipo.fechaAlta!=null}">
					<display:setProperty name="export.types" value="csv excel xml pdf" />
					<display:setProperty name="export.excel.filename" value="EquiposRegistrados.xls" />
					<display:setProperty name="export.csv.filename" value="EquiposRegistrados.csv" />
					<display:setProperty name="export.xml.filename" value="EquiposRegistrados.xml" />
					<display:setProperty name="export.pdf.filename" value="EquiposRegistrados.pdf" />
					
					<display:column property="idEquipo" title="Id del Equipo" sortable="true"></display:column>
					<display:column property="nombre" title="Nombre del equipo" sortable="true" escapeXml="true"></display:column>
					<display:column property="manager.idManager" title="Id del manager" sortable="true" escapeXml="true"></display:column>
					<display:column property="manager.nombrePila" title="Nombre del manager" sortable="true" escapeXml="true"></display:column>
					
	
					<display:column media="html">
						<input type="checkbox" id="<s:property value="%{#attr.equipo.idEquipo}"/>" 
						name="equipo" value="<s:property value="%{#attr.equipo.idEquipo}"/>" />
					</display:column>
				</s:if>
			</display:table>
		</div>

        <input id="cerrarVentana" type="button" value="Cerrar"/>
        <input id="aceptarSeleccion" type="button" value="Aceptar"/>
	</body>
</html>