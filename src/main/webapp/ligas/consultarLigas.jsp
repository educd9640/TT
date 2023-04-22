<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
	<head>
		<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <style>td { white-space:nowrap; }</style>
        <title><s:property value="#title"/></title>
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
        				<s:if test="fechaAlta != null">
        					<s:property value="%{'Activada'}"></s:property>
        				</s:if>
        				<s:else>
        					<s:property value="%{'Desactivada'}"></s:property>
        				</s:else>
        			</td>
        			<td class="nowrap">
        				<s:url action="modificarLiga" var="url" escapeAmp="false">
                            <s:param name="ligaF.idLiga" value="idLiga"/>
                            <s:param name="operacion">actualizado</s:param>
                        </s:url>
                        <a href="<s:property value="#url"/>">Modificar</a>
                        &nbsp;&nbsp;&nbsp;
                        
                        
        				<s:url action="estadoLiga" var="url">
                            <s:param name="ligaF.idLiga" value="idLiga"/>
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
        
        </table>
        <s:form action="submenuLigas">
			<s:submit value="Regresar" targets="submenuLigas" />
		</s:form>
	
	</body>
</html>