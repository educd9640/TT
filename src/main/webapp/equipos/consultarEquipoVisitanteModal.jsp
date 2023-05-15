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
				
				
				$("#buscar").click(function(){
        			const tablaReg = document.getElementById('tabla');
        			const buscarID = document.getElementById('busquedaID');
        			const buscarEquipo = document.getElementById('busquedaEquipo');
        			
        			const textoBuscar = document.getElementById('idTexto').value.toLowerCase();
        			var noCelda=0;
        			if(buscarID.checked){
        				noCelda=0;
        			}else if(buscarEquipo.checked){
        				noCelda=1;
        			}else{
        				Sexy.error("Debes seleccionar una opcion");
        			}
        			var total=0;
        			for(var r=1;r<tablaReg.rows.length; r++){
        				
        				// Si el td tiene la clase "noSearch" no se busca en su contenido
        				if (tablaReg.rows[r].classList.contains("noSearch")) {
                            continue;
                        }
        				
        				var encontrado = false;
        				const celdaRenglon = tablaReg.rows[r].getElementsByTagName('td');
        				//buscamos en la celda especifica de acuerdo a la opcion seleccionada
        				const textoTabla = celdaRenglon[noCelda].innerHTML.toLowerCase();
        				if(textoTabla.indexOf(textoBuscar)>-1){
        					console.log(textoTabla);
        					encontrado = true;
        					total++;
        				}
        				if(encontrado){
        					tablaReg.rows[r].style.display='';
        				}else{
        					tablaReg.rows[r].style.display='none';
        				}
        			}
        			
        			// mostramos las coincidencias
                    const ultimoTR=tablaReg.rows[tablaReg.rows.length-1];
                    const td=ultimoTR.querySelector("td");
                    ultimoTR.classList.remove("hide", "red");
                    if (total>=1) {
                        td.innerHTML="Se ha encontrado "+total+" coincidencia"+((total>1)?"s":"");
                    } else {
                        ultimoTR.classList.add("red");
                        td.innerHTML="No se han encontrado coincidencias";
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
        <h1><s:text name="label.registrados.titulo"/></h1>
        <br/><br/>
        <s:actionerror />
        <s:actionmessage />
        
        <s:hidden name="partidoF.idTemporada"></s:hidden>
        <s:hidden name="idTemporada" value="partidoF.idTemporada"></s:hidden>
        
        <input type="radio" id="busquedaID" name="opcion" value="ID">
    	<label for="busquedaID">Busqueda por ID</label> 
        <input type="radio" id="busquedaEquipo" name="opcion" value="equipo">
    	<label for="busquedaEquipo">Busqueda por nombre del equipo</label>
    	<br></br>
    	<br></br>
    	<label id="etiqueta" for="idTexto"></label>
    	<input type="text" id="idTexto" name="idTexto"/>
    	<input type="button" id="buscar" value="Buscar" />
    	
    	
        <table id="tabla" class="borderAll">
        	<tr>
        		<th><s:text name="equipoForm.idEquipo"/></th>
        		<th><s:text name="equipoForm.nombre"/></th>
        		<th><s:text name="equipoForm.manager.idManager"/></th>
        		<th>&nbsp;</th>
        	</tr>
        	<s:iterator value="equiposTemporadaRegistrados" status="status">
        		<s:if test="fechaAlta != null">
        				
	        		<tr>
	        			<td class="nowrap"><s:property value="idEquipo"/></td>
	        			<td class="nowrap"><s:property value="nombre"/></td>
	        			<td class="nowrap"><s:property value="manager.idManager"/></td>
	        			
	        			<td class="nowrap">
	                    	<input type="checkbox" id="<s:property value="idEquipo"/>" name="equipo" 
	                    	value="<s:property value="idEquipo"/>" />
	                    </td>
	        		</tr>
	        		
	        	</s:if>
        	
        	</s:iterator>
        	<tr class='noSearch hide'>
        	<td colspan="5"></td>
        
        </table>
        <input id="cerrarVentana" type="button" value="Cerrar"/>
        <input id="aceptarSeleccion" type="button" value="Aceptar"/>
        <input id="LimiparVentana" type="button" value="Limpiar"/>
	</body>
</html>