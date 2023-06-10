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
    	<link href="<s:url value='/css/sexyalertbox.css'/>" rel="stylesheet" type="text/css"/>
    	
        <s:head />
        <title><s:text name="label.registradosLibres.titulo"/></title>

        <script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
        <!-- Script Sexyalertbox -->
        <script src="<s:url value='/js/sexyalertbox.v1.2.jquery.js'/>"></script>
        <!-- Script Jquery easing (Animaciones, usado por sexyalert) -->
        <script src="<s:url value='/js/jquery.easing.1.3.js'/>"></script>
        
        <script>
        function limpiarBusqueda(){
			document.forms[0].boletaAlumno.value=null;
			document.forms[0].nombrePila.value=null;
			document.forms[0].consultarAlumnosModal_alumnoForm_idEscuela.value=null;
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
    			
    				var checkBoxesSeleccionadas = $('input[name="alumno"]:checked');
					if(checkBoxesSeleccionadas.length<1){
						Sexy.error("Debe seleccionar un alumno");
					}else{
						window.parent.settearDesdeModal(checkBoxesSeleccionadas[0].value);
						window.parent.TINY.box.hide();
					}
    			}); 
	        });
        </script>
    </head>
    <body>
        <div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.registradosLibres.titulo"/></h1>
        <br/><br/>
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
    
		<s:actionmessage />
        <s:form action="consultarAlumnosModal" method="post">
        <table style="border:none">
        	<tr>
        	<td><b>B&uacute;squeda por Boleta Alumno</b> <input type="text" id="boletaAlumno" name="alumnoForm.boletaAlumno"/></td>
        	<td><b>B&uacute;squeda por Nombre Pila</b> <input type="text" id="nombrePila" name="alumnoForm.nombrePila"/></td>
        	<td><b>B&uacute;squeda por Escuela</b> <s:select name="alumnoForm.idEscuela" style="display:inline-block;" headerKey="-1" headerValue="Seleccione" list="escuelas" listKey="idEscuela" listValue="nombreCortoEscuela" theme="simple"/></td>
        	</tr>
        	<tr>
        		<td align="left" colspan="3"><s:submit value="%{getText('button.label.submit')}" theme="simple"/> <input type="button" value="Limpiar" onclick="javascript:limpiarBusqueda()"></td>
        	</tr>
        	<s:hidden name="soloLibres" value="%{true}"></s:hidden>
        </table>
        </s:form>
        <div>
			<display:table export="true" id="alumno" name="alumnosRegistrado" pagesize="10" requestURI="" class="table table-hover table-striped">
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
				<display:column property="telefono" title="Tel&eacute;fono" sortable="true"></display:column>
				<display:column property="telEmergencia" title="Tel&eacute;fono Emergencia" sortable="true"></display:column>
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
					<s:if test="%{#attr.alumno.fechaAlta!=null}">
						<input type="checkbox" id="<s:property value="%{#attr.alumno.boletaAlumno}"/>" name="alumno" value="<s:property value="%{#attr.alumno.boletaAlumno}"/>_<s:property value="%{#attr.alumno.nombrePila}"/>_<s:property value="%{#attr.alumno.apellidoPat}"/>_<s:property value="%{#attr.alumno.apellidoMat}"/>" />
					</s:if>
                    <s:else>
                   			&nbsp;
                    </s:else>
				</display:column>
			</display:table>
		</div>
        <input id="cerrarVentana" type="button" value="Cerrar"/>
        <input id="aceptarSeleccion" type="button" value="Aceptar"/>
    </body>
</html>
