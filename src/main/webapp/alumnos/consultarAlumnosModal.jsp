<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
    <head>
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
        <h1><s:text name="label.registrados.titulo"/></h1>
        <br/><br/>
        <s:actionerror />
        <s:actionmessage />
        <table class="borderAll">
            <tr>
                <th><s:text name="alumnoForm.boletaAlumno"/></th>
                <th><s:text name="alumnoForm.nombrePila"/></th>
                <th><s:text name="alumnoForm.apellidoPat"/></th>
                <th><s:text name="alumnoForm.apellidoMat"/></th>
                <th><s:text name="alumnoForm.semestre"/></th>
                <th><s:text name="alumnoForm.curp"/></th>
                <th><s:text name="alumnoForm.nss"/></th>
                <th><s:text name="alumnoForm.telefono"/></th>
                <th><s:text name="alumnoForm.telEmergencia"/></th>
                <th><s:text name="alumnoForm.correo"/></th>	
                <th><s:text name="alumnoForm.idEscuela"/></th>	
                <th>&nbsp;</th>
            </tr>
            <s:iterator value="alumnosRegistrado" status="status">
                <tr>
                    <td class="nowrap"><s:property value="boletaAlumno"/></td>
                    <td class="nowrap"><s:property value="nombrePila"/></td>
                    <td class="nowrap"><s:property value="apellidoPat"/></td>
                    <td class="nowrap"><s:property value="apellidoMat"/></td>
                    <td class="nowrap"><s:property value="semestre"/></td>
                    <td class="nowrap"><s:property value="curp"/></td>
                    <td class="nowrap"><s:property value="nss"/></td>
                    <td class="nowrap"><s:property value="telefono"/></td>
                    <td class="nowrap"><s:property value="telEmergencia"/></td>
                    <td class="nowrap"><s:property value="correo"/></td>
                    <td class="nowrap"><s:property value="escuela.nombreCortoEscuela"/></td>
                    <td class="nowrap">
                    	<input type="checkbox" id="<s:property value="boletaAlumno"/>" name="alumno" value="<s:property value="boletaAlumno"/>_<s:property value="nombrePila"/>_<s:property value="apellidoPat"/>_<s:property value="apellidoMat"/>" />
                    </td>
                </tr>
            </s:iterator>
        </table>
        
        <input id="cerrarVentana" type="button" value="Cerrar"/>
        <input id="aceptarSeleccion" type="button" value="Aceptar"/>
        <input id="LimiparVentana" type="button" value="Limpiar"/>
    </body>
</html>
