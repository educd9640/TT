<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
	<head>
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
        
        <script>
        	//Inician metodos JQuery
	        $(document).ready(function(){
	        
	        });
        </script>
	</head>
	<body>
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
	
	</body>
</html>