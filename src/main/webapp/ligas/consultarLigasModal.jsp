<%@ page contentType="text/html; charset=UTF-8"%>
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
        <style>td { white-space:nowrap; }</style>
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
        			const buscarLiga = document.getElementById('busquedaLiga');
        			
        			const textoBuscar = document.getElementById('idTexto').value.toLowerCase();
        			var noCelda=0;
        			if(buscarID.checked){
        				noCelda=0;
        			}else if(buscarLiga.checked){
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
		<div class="container rounded p-3 contenido">
		
			<div class="titleDiv"><s:text name="application.title"/></div>
        	<h1><s:text name="label.registrados.titulo"/></h1>
        	<br/><br/>
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
   
		        	<s:actionmessage />
			<input type="radio" id="busquedaID" name="opcion" value="ID">
    		<label for="busquedaID">Busqueda por ID</label> 
        	<input type="radio" id="busquedaLiga" name="opcion" value="equipo">
    		<label for="busquedaLiga">Busqueda por nombre de la Liga</label>
    		<br></br>
    		<br></br>
    		<label id="etiqueta" for="idTexto"></label>
    		<input type="text" id="idTexto" name="idTexto"/>
    		<input type="button" id="buscar" value="Buscar" />
			
			<display:table export="true" id="ligas" name="ligasRegistradas" pagesize="10" class="table table-bordered">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="EquiposRegistrados.xls" />
				<display:setProperty name="export.csv.filename" value="EquiposRegistrados.csv" />
				<display:setProperty name="export.xml.filename" value="EquiposRegistrados.xml" />
				<display:setProperty name="export.pdf.filename" value="EquiposRegistrados.pdf" />
				<s:if test="%{#attr.ligas.fechaAlta!=null}">
					<display:column property="nombre" title="Nombre de la liga" sortable="true" ></display:column> 
					<display:column property="telefono" title="Telefono" sortable="true" ></display:column>
					<display:column property="estado" title="Estado" sortable="true" ></display:column> 
					<display:column property="delegacion" title="Delegacion" sortable="true" ></display:column> 
					<display:column property="calle" title="Calle" sortable="true" ></display:column>   
					<display:column title="Activo" sortable="true" media="html">
						<s:if test="%{#attr.liga.fechaAlta!=null}">
							<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
						</s:if>
                    	<s:else>
                   			<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
                    	</s:else>
					</display:column>
					<display:column media="html">
						<input type="checkbox" id="<s:property value="%{#attr.ligas.idLiga}" />" name="liga" value="<s:property value="%{#attr.ligas.idLiga}"/>_<s:property value="%{#attr.ligas.nombre}"/>"/>     
					</display:column>
					<display:footer>
						<tr class='noSearch hide'>
                			<td colspan="5"></td>
            			</tr>
					</display:footer>	
				</s:if>
			</display:table>
			<br>
		</div>
		<input id="cerrarVentana" type="button" value="Cerrar"/>
        <input id="aceptarSeleccion" type="button" value="Aceptar"/>
        <input id="LimiparVentana" type="button" value="Limpiar"/>
	</body>
</html>