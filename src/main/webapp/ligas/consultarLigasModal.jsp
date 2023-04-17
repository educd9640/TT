<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
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
    			
    				var checkBoxesSeleccionadas = $('input[name="liga"]:checked');
					if(checkBoxesSeleccionadas.length<1){
						Sexy.error("Debe seleccionar una liga");
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
        		<th><s:text name="ligaF.idLiga"/></th>
        		<th><s:text name="ligaF.nombre"/></th>
        		<th><s:text name="ligaF.telefono"/></th>
        		<th><s:text name="ligaF.calle"/></th>
        		<th><s:text name="ligaF.colonia"/></th>
        		<th><s:text name="ligaF.codigoPostal"/></th>
        		<th><s:text name="ligaF.delegacion"/></th>
        		<th><s:text name="ligaF.estado"/></th>
        		<th><s:text name="ligaF.fechaAlta"/></th>
        		<th>&nbsp;</th>
        	</tr>
        	<s:iterator value="ligasRegistradas" status="status">
        		<s:if test="fechaAlta != null">
        				
	        		<tr>
	        			<td class="nowrap"><s:property value="idLiga"/></td>
	        			<td class="nowrap"><s:property value="nombre"/></td>
	        			<td class="nowrap"><s:property value="telefono"/></td>
	        			<td class="nowrap"><s:property value="calle"/></td>
	        			<td class="nowrap"><s:property value="colonia"/></td>
	        			<td class="nowrap"><s:property value="codigoPostal"/></td>
	        			<td class="nowrap"><s:property value="delegacion"/></td>
	        			<td class="nowrap"><s:property value="estado"/></td>
	        			
	        			<td class="nowrap">
	                    	<input type="checkbox" id="<s:property value="idLiga"/>" name="liga" 
	                    	value="<s:property value="idLiga"/>_<s:property value="nombre"/>" />
	                    </td>
	        		</tr>
	        		
	        	</s:if>
        	
        	</s:iterator>
        
        </table>
        <input id="cerrarVentana" type="button" value="Cerrar"/>
        <input id="aceptarSeleccion" type="button" value="Aceptar"/>
        <input id="LimiparVentana" type="button" value="Limpiar"/>
	</body>
</html>