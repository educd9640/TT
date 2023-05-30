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
        	//Inician metodos JQuery
	        $(document).ready(function(){
	        
				$("#buscar").click(function(){
        			const tablaReg = document.getElementById('tabla');
        			const buscarIdTemporada = document.getElementById('busquedaIdTemporada');
        			const buscarIdLiga = document.getElementById('busquedaIdLiga');
        			
        			const textoBuscar = document.getElementById('idTexto').value.toLowerCase();
        			var noCelda=0;
        			if(buscarIdTemporada.checked){
        				noCelda=0;
        			}else if(buscarIdLiga.checked){
        				noCelda=4;
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
				
    			 
	        });
        </script>
		<div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.registrados.titulo"/></h1>
        <br/><br/>
        <s:actionerror />
        <s:actionmessage />
        
        <input type="radio" id="busquedaIdTemporada" name="opcion" value="IdTemporada">
    	<label for="busquedaIdTemporada">Busqueda por Id de la Temporada</label> 
        <input type="radio" id="busquedaIdLiga" name="opcion" value="IdLiga">
    	<label for="busquedaIdLiga">Busqueda por Id de la Liga</label>
    	<br></br>
    	<label id="etiqueta" for="idTexto"></label>
    	<input type="text" id="idTexto" name="idTexto"/>
    	<input type="button" id="buscar" value="Buscar" />
        <br></br>
        
        <display:table export="true" id="temporadas" name="temporadasRegistradas" pagesize="10" class="table table-bordered">
        	<display:setProperty name="export.types" value="csv excel xml pdf" />
			<display:setProperty name="export.excel.filename" value="EquiposRegistrados.xls" />
			<display:setProperty name="export.csv.filename" value="EquiposRegistrados.csv" />
			<display:setProperty name="export.xml.filename" value="EquiposRegistrados.xml" />
			<display:setProperty name="export.pdf.filename" value="EquiposRegistrados.pdf" />
			<display:column property="liga.idLiga" title="ID de la liga" sortable="true" ></display:column>
			<display:column property="idTemporada" title="ID de la temporada" sortable="true" ></display:column>
			<display:column property="idEquipoCampeon" title="Id del equipo Campeon" sortable="true" ></display:column>
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