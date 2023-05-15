<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
	<head>
		<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
		<link href="<s:url value='/css/tinystyle.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <style>td { white-space:nowrap; }</style>
        <title><s:property value="#title"/></title>
        <script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
        
		<div class="container rounded p-3 contenido">
        
		<div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.registrados.titulo"/></h1>
        <br/><br/>
        <s:actionerror />
        <s:actionmessage />
        
        
    	
        
        <table id="tabla" class="borderAll">
        	<tr>
        		<th><s:text name="partidoF.idPartido"/></th>
        		<th><s:text name="partidoF.idTemporada"/></th>
        		<th><s:text name="partidoF.idEquipoLocal"/></th>
        		<th><s:text name="partidoF.idEquipoVisitante"/></th>
        		<th><s:text name="partidoF.campo"/></th>
        		<th><s:text name="partidoF.fechaAnuncioPartido"/></th>
        		<th><s:text name="partidoF.fechaAlta"/></th>
        		<th>&nbsp;</th>
        	</tr>
        	<s:iterator value="partidosRegistrados" status="status">
        		<tr>
        			<td class="nowrap"><s:property value="idPartido"/></td>
        			<td class="nowrap"><s:property value="idTemporada"/></td>
        			<td class="nowrap"><s:property value="idEquipoLocal"/></td>
        			<td class="nowrap"><s:property value="idEquipoVisitante"/></td>
        			<td class="nowrap"><s:property value="campo"/></td>
        			<td class="nowrap"><s:property value="fechaAnuncioPartido"/></td>
        			<td class="nowrap">
        				<s:if test="fechaAlta != null">
        					<s:property value="%{'Activada'}"></s:property>
        				</s:if>
        				<s:else>
        					<s:property value="%{'Desactivada'}"></s:property>
        				</s:else>
        			</td>
        			<td class="nowrap">
        				<s:url action="modificarPartido" var="url" escapeAmp="false">
                            <s:param name="partidoF.idPartido" value="idPartido"/>
                            <s:param name="operacion">actualizado</s:param>
                        </s:url>
                        <a href="<s:property value="#url"/>">Modificar</a>
                        &nbsp;&nbsp;&nbsp;
                        
        				<s:url action="estadoPartido" var="url">
                            <s:param name="partidoF.idPartido" value="idPartido"/>
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
        <s:form action="submenuPartidos">
			<s:submit value="Regresar" targets="submenuPartidos" />
		</s:form>
	
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>