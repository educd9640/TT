<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container rounded p-3 contenido">
        <script>
        	//Inician metodos JQuery
	        $(document).ready(function(){
	        
	        });
        </script>
		<div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.seleccionar.titulo"/></h1>
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
        		<th><s:text name="form.equiposTemporada.temporada.liga.nombre"/></th>
        		<th><s:text name="form.equiposTemporada.temporada.fechaInicial"/></th>
        		<th><s:text name="form.equiposTemporada.temporada.fechaFinal"/></th>
        		<th><s:text name="labels.esEquipoActivo"/></th>
        		<th>&nbsp;</th>
        	</tr>
        	<s:iterator value="form.equiposTemporada" status="status">
        		<tr>
        			<td class="nowrap"><s:property value="temporada.liga.nombre"/></td>
        			<td class="nowrap"><s:property value="temporada.fechaInicial"/></td>
        			<td class="nowrap"><s:property value="temporada.fechaFinal"/></td>
        			<td class="nowrap" align="center">
        				<s:if test="fechaAlta != null">
        					<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
        				</s:if>
        				<s:else>
        					<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
        				</s:else>
        			</td>
        			<td class="nowrap">
                        <s:if test="fechaAlta != null">
                        	<s:url action="registrarJugadores" var="url" escapeAmp="false">
                            	<s:param name="form.idTemporada" value="idTemporada"/>
                            	<s:param name="form.idEquipo" 	 value="idEquipo"/>
                        	</s:url>
                        	<a href="<s:property value="#url"/>">Registrar Jugadores</a>
                        </s:if>
                        &nbsp;         
        			</td>
        		</tr>
        	
        	</s:iterator>
        	<tr class='noSearch hide'>
        	<td colspan="5"></td>
        
        </table>
        <s:form namespace="/jugadores" action="submenuJugadores">
			<s:submit value="Regresar" targets="submenuJugadores" />
		</s:form>
	
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>