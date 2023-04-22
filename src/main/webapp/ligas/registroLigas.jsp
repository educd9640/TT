<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="operacion=='actualizado'">
	<s:set var="title" value="%{'Modificar Liga'}"/>
</s:if>
<s:else>
    <s:set var="title" value="%{'Registro Liga'}"/>
</s:else>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<title><s:property value="#title" /></title>
	<head>
    	<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <style>td { white-space:nowrap; }</style>
        <title><s:property value="#title"/></title>
    </head>


	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:property value="#title"/></h1>
		<s:actionerror />
		<s:actionmessage />
		<s:form action="registrarLiga" method="post">
	
			<s:if test="operacion=='actualizado'">
        		<s:hidden name="operacion" value="%{'actualizado'}"/>
        		<s:textfield key="ligaF.idLiga" readonly="true"/>        		
        	</s:if>
        	<s:else>
        		<s:hidden name="operacion" value="%{'registrado'}"/>
        	</s:else>
	
			<s:textfield key="ligaF.nombre" />
			<s:textfield key="ligaF.telefono" />
			<s:textfield key="ligaF.calle" />
			<s:textfield key="ligaF.colonia" />
			<s:textfield key="ligaF.codigoPostal" />
			<s:textfield key="ligaF.delegacion" />
			<s:textfield key="ligaF.estado" />
	
			<s:if test="hasActionMessages()">
				<s:submit value="%{getText('button.label.submit')}" disabled="true" />
			</s:if>
			<s:else>
				<s:submit value="%{getText('button.label.submit')}" />
			</s:else>
	
		</s:form>
		<s:form action="submenuLigas">
			<s:submit value="Regresar" targets="submenuLigas" />
		</s:form>
	
	</body>
</html>