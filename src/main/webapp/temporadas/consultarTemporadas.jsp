<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
        
        <table id="tabla" class="borderAll">
        	<tr>
        		<th><s:text name="temporadaF.idTemporada"/></th>
        		<th><s:text name="temporadaF.idEquipoCampeon"/></th>
        		<th><s:text name="temporadaF.fechaInicial"/></th>
        		<th><s:text name="temporadaF.fechaFinal"/></th>
        		<th><s:text name="temporadaF.liga.idLiga"/></th>
        		<th><s:text name="temporadaF.fechaAlta"/></th>
        		<th>&nbsp;</th>
        	</tr>
        	<s:iterator value="temporadasRegistradas" status="status">
        		<tr>
        			<td class="nowrap"><s:property value="idTemporada"/></td>
        			<td class="nowrap"><s:property value="idEquipoCampeon"/></td>
        			<td class="nowrap"><s:property value="fechaInicial"/></td>
        			<td class="nowrap"><s:property value="fechaFinal"/></td>
        			<td class="nowrap"><s:property value="liga.idLiga"/></td>
        			<td class="nowrap">
        				<s:if test="fechaAlta != null">
        					<s:property value="%{'Activada'}"></s:property>
        				</s:if>
        				<s:else>
        					<s:property value="%{'Desactivada'}"></s:property>
        				</s:else>
        			</td>
        			<td class="nowrap">
        				<s:url action="modificarTemporada" var="url" escapeAmp="false">
                            <s:param name="temporadaF.idTemporada" value="idTemporada"/>
                            <s:param name="operacion">actualizado</s:param>
                        </s:url>
                        <a href="<s:property value="#url"/>">Modificar</a>
                        &nbsp;&nbsp;&nbsp;
                        
                        <s:url action="consultarEquipos" var="url" escapeAmp="false">
                            <s:param name="temporadaseleccionada" value="idTemporada"/>
                        </s:url>
                        <a href="<s:property value="#url"/>" >Registrar Equipo</a>
                        &nbsp;&nbsp;&nbsp;
                        
        				<s:url action="estadoTemporada" var="url">
                            <s:param name="temporadaF.idTemporada" value="idTemporada"/>
                        </s:url>
                        <s:if test="fechaAlta != null">
                        	<a href="<s:property value="#url"/>">Desactivar</a>		
                        </s:if>
                        <s:else>
                        	<a href="<s:property value="#url"/>">Activar</a>
                        </s:else>
                        
        			
        			</td>
        		</tr>
        	
        	</s:iterator>
        	<tr class='noSearch hide'>
        	<td colspan="5"></td>
        
        </table>
        <s:form action="submenuTemporadas">
			<s:submit value="Regresar" targets="submenuTemporadas" />
		</s:form>
	
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>