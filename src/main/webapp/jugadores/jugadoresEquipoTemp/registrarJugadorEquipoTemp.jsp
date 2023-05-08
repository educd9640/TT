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
        <title><s:text name="label.registrados.titulo"/></title>

        <script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
        <!-- Script Sexyalertbox -->
        <script src="<s:url value='/js/sexyalertbox.v1.2.jquery.js'/>"></script>
        <!-- Script Jquery easing (Animaciones, usado por sexyalert) -->
        <script src="<s:url value='/js/jquery.easing.1.3.js'/>"></script>
        
        <script>
        	//Inician metodos JQuery
	        $(document).ready(function(){
				
				$("#cerrarVentana").click(function(){
					window.parent.TINY.box.hide();
    			}); 
    			
    			$("#aceptarSeleccion").click(function(){
    			
    				var jugadoresARegistrar = "";
    			
    				$("input:checkbox[name='jugador']:checked").each(function(){
					    jugadoresARegistrar = jugadoresARegistrar + $(this).val() + "_";
					});
					if(jugadoresARegistrar.length<1){
						Sexy.error("Debe seleccionar al menos un jugador");
					}else{
						window.parent.TINY.box.hide();
						window.parent.registrarJugadores(jugadoresARegistrar);
					}
    			}); 
	        });
	        
	        function limpiarBusqueda(){
				document.forms[0].boletaAlumno.value=null;
				document.forms[0].nombrePila.value=null;
				document.forms[0].posicionPrim.value=null;
				document.forms[0].posicionSec.value=null;
				document.forms[0].submit();
			}
        </script>
    </head>
    <body>
        <div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.registradosModal.titulo"/></h1>
        <br/><br/>
        <s:actionerror />
        <s:actionmessage />
        
        <s:form action="modalRegistrarJugador" method="post">
                <table style="border:none">
        	<tr>
        	<td><b>Busqueda por Boleta Alumno</b> <input type="text" id="boletaAlumno" name="form.boletaAlumno"/></td>
        	<td><b>Busqueda por Nombre Pila</b> <input type="text" id="nombrePila" name="form.nombrePila"/></td>
        	<td><b>Busqueda por Posici&oacute;n Primaria</b> <s:select id="posicionPrim" name="form.posicionPrim" headerKey="" headerValue="Seleccione" list="posiciones" theme="simple"/></td>
        	<td><b>Busqueda por Posici&oacute;n Secundaria</b> <s:select id="posicionSec" name="form.posicionSec" headerKey="" headerValue="Seleccione" list="posiciones" theme="simple"/></td>
        	</tr>
        	<tr>
        		<td align="left" colspan="3"><s:submit value="%{getText('button.label.submit')}" theme="simple"/> <input type="button" value="Limpiar" onclick="javascript:limpiarBusqueda()"></td>
        	</tr>
        	<s:hidden name="form.idEquipo"></s:hidden>
        	<s:hidden name="form.idTemporada"></s:hidden>
    	</table>
        </s:form>
        
        <div>
			<display:table export="true" id="jugadorEquipo" name="form.jugadoresEquipo" pagesize="7" requestURI="" class="table table-hover table-striped">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="JugadoresEquipoLibres.xls" />
				<display:setProperty name="export.csv.filename" value="JugadoresEquipoLibres.csv" />
				<display:setProperty name="export.xml.filename" value="JugadoresEquipoLibres.xml" />
				<display:setProperty name="export.pdf.filename" value="JugadoresEquipoLibres.pdf" />
				<display:column property="alumno.boletaAlumno" title="Boleta Alumno" sortable="true"></display:column>
				<display:column property="alumno.nombrePila" title="Nombre pila" sortable="true" escapeXml="true"></display:column>
				<display:column property="alumno.apellidoPat" title="Apellido Paterno" sortable="true" escapeXml="true"></display:column>
				<display:column property="alumno.apellidoMat" title="Apellido Materno" sortable="true" escapeXml="true"></display:column>
				<display:column property="posicionPrim" title="Posici&oacute;n Primaria" sortable="true"></display:column>
				<display:column property="posicionSec" title="Posici&oacute;n Secundaria" sortable="true"></display:column>
				<display:column title="Activo" sortable="true" media="html">
					<s:if test="%{#attr.jugadorEquipo.fechaAlta!=null}">
						<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
					</s:if>
                    <s:else>
                   		<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
                    </s:else>
				</display:column>
				<display:column media="html">
					<s:if test="%{#attr.jugadorEquipo.fechaAlta!=null}">
                   		<input type="checkbox" name="jugador" id="<s:property value="%{#attr.jugadorEquipo.idJugador}"/>" value="<s:property value="%{#attr.jugadorEquipo.idJugador}"/>"/>
                   	</s:if>
				</display:column>
			</display:table>
		</div>
        
        <input id="cerrarVentana" type="button" value="Cerrar"/>
        <input id="aceptarSeleccion" type="button" value="Aceptar"/>
        <input id="LimiparVentana" type="button" value="Limpiar"/>
    </body>
</html>
