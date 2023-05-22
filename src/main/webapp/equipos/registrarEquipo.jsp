<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<s:if test="operacion=='actualizado'">
	<s:set var="title" value="%{'Modificar Equipo'}"/>
</s:if>
<s:else>
	<s:set var="title" value="%{'Registro Equipo'}"/>
</s:else>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<link rel="stylesheet" href="<s:url value='/bs/css/bootstrap.min.css'/>">
		<script src="<s:url value='/bs/js/bootstrap.bundle.min.js'/>"></script>
	
		<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <style>td { white-space:nowrap; }</style>
        <title><s:property value="#title"/></title>
	</head>
<body>
<div class="container rounded p-3 contenido">
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:property value="#title"/></h1>
	<s:actionerror />
    <s:actionmessage />
    <s:form action="registrarEquipo" namespace="/equipos" method="post" >
    	
    	
    	<s:if test="operacion=='actualizado'">
			<s:textfield name="equipoForm.nombre" key="equipoForm.nombre"/>
			<s:hidden name="operacion" value="%{'actualizado'}"/>
		</s:if>
		<s:else>
			<s:textfield  key="equipoForm.nombre"/>
			<s:hidden name="operacion" value="%{'registrado'}"/>
		</s:else>
		
    	<s:if test="operacion=='actualizado' || hasActionErrors()">
			<s:submit value="%{getText('button.label.actualizar')}" />
		</s:if>
		<s:else>
    		<s:submit value="%{getText('button.label.submit')}"/>
	    </s:else>
    </s:form>
    <s:form action="submenuEquipos" >
			<s:submit value="Regresar" targets="submenuEquipos"/>
	</s:form>
</div>
</body>
<jsp:include page="/bases/footer.jsp"></jsp:include>
</html>