<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<s:set var="title" value="%{'Buscar Equipo'}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<link rel="stylesheet" href="<s:url value='/bs/css/bootstrap.min.css'/>">
		<script src="<s:url value='/bs/js/bootstrap.bundle.min.js'/>"></script>
		
		<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
		<link href="<s:url value='/css/sexyalertbox.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <style>td { white-space:nowrap; }</style>
        <title><s:property value="#title"/></title>
        
        <script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
        <!-- Script Sexyalertbox -->
        <script src="<s:url value='/js/sexyalertbox.v1.2.jquery.js'/>"></script>
        <!-- Script Jquery easing (Animaciones, usado por sexyalert) -->
        <script src="<s:url value='/js/jquery.easing.1.3.js'/>"></script>
        
        <script >
        	//Se inician los metodos JQuery
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
        		
        		$("#buscar").click(function(){
        			const tablaReg = document.getElementById('tabla');
        			const buscarEquipo = document.getElementById('busquedaEquipo');
        			const buscarManager = document.getElementById('busquedaManager');
        			const textoBuscar = document.getElementById('idTexto').value.toLowerCase();
        			var noCelda=0;
        			if(buscarEquipo.checked){
        				noCelda=0;
        			}else if(buscarManager.checked){
        				noCelda=1;
        			}else{
        				Sexy.error("Debes seleccionar una opcion");
        			}
        			var total=0;
        			for(var r=1;r<tablaReg.rows.length; r++){
        				
        				// Si el td tiene la clase "noSearch" no se busca en su cntenido
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
        		
        		$("#confirmar").click(function(){
        			var equipoSeleccionado = $('input[name="equipoElegido"]:checked');
        				if(equipoSeleccionado.length<1){
        					Sexy.error("Debe seleccionar un equipo");
        				}else{
        					window.parent.settearDesdeModal(equipoSeleccionado[0].value);
        					window.parent.TINY.box.hide();
        				}
        		});
        		
        	});
        </script>
        
        <style>
        	#tabla {border: 1px solid #ccc;padding:10px;font-size:1em;}
        	#tabla tr:nth-child(even) {background:#ccc;}
        	#tabla td {padding:5px;}
        	#tabla tr.noSearch td {padding-top:10px;text-align:right;}
        	#tabla tr.noSearch {background:White;font-size:0.8em;}
        	.hide {display:none;}
        	.red {color:Red;}
        </style>
        	

        
	</head>
<body>
	<div class="titleDiv">Equipos registrados</div>
	<h1><s:property value="#title"/></h1>
	<br>
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>

		<s:actionmessage />
    	<input type="radio" id="busquedaEquipo" name="opcion" value="equipo">
    	<label for="busquedaEquipo">Busqueda por nombre del Equipo</label>
    	<input type="radio" id="busquedaManager" name="opcion" value="manager">
    	<label for="busquedaManager">Busqueda por nombre del Manager</label>
    	<br></br>
    	<br></br>
    	<label id="etiqueta" for="idTexto"></label>
    	<input type="text" id="idTexto" name="idTexto"/>
    	<input type="button" id="buscar" value="Buscar" />
    	<br></br>
    	<br></br>
    		<display:table export="true" id="tabla" name="equiposRegistrados" pagesize="10" class="table table-hover table-striped" requestURI="" >
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="EquiposRegistrados.xls" />
				<display:setProperty name="export.csv.filename" value="EquiposRegistrados.csv" />
				<display:setProperty name="export.xml.filename" value="EquiposRegistrados.xml" />
				<display:setProperty name="export.pdf.filename" value="EquiposRegistrados.pdf" />
				<display:column property="nombre" title="Nombre del equipo" sortable="true" escapeXml="true"></display:column>    
				<display:column property="manager.nombrePila" title="Nombre del manager" sortable="true" escapeXml="true"></display:column>
				<display:column media="html">
					<input type="checkbox" id="<s:property value="%{#attr.tabla.idEquipo}" />" name="equipoElegido" value="<s:property value="%{#attr.tabla.idEquipo}"/>_<s:property value="%{#attr.tabla.manager.nombrePila}"/>_<s:property value="%{#attr.tabla.nombre}"/>" />
				</display:column>
    		</display:table>
    	
    	<input id="confirmar" type="button" value="Confirmar seleccion"> 
</body>
</html>