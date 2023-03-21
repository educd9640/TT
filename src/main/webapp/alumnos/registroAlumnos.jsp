<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set var="title" value="%{'Registro Alumnos'}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
        <s:form action="registrarAlumno" method="post">
        	<s:textfield key="alumnoForm.boletaAlumno"/>
            <s:textfield key="alumnoForm.nombrePila" /> 
            <s:textfield key="alumnoForm.apellidoPat" /> 
            <s:textfield key="alumnoForm.apellidoMat" />
            <s:select name="alumnoForm.semestre" list="semestres" label="%{getText('alumnoForm.semestre')}"/>
            <s:textfield key="alumnoForm.curp" />
            <s:textfield key="alumnoForm.nss" />
            <s:textfield key="alumnoForm.telefono" />
            <s:textfield key="alumnoForm.telEmergencia" />
            <s:textfield key="alumnoForm.correo" />
            <s:select name="alumnoForm.idEscuela" list="escuelas" listKey="idEscuela" listValue="nombreCortoEscuela" label="%{getText('alumnoForm.idEscuela')}"/>
            <s:if test="hasActionMessages()">
				<s:submit value="%{getText('button.label.submit')}" disabled="true"/>
			</s:if>
			<s:else>
    			<s:submit value="%{getText('button.label.submit')}"/>
			</s:else>
        </s:form>
        <s:form action="submenuAlumnos" >
			<s:submit value="Regresar" targets="submenuAlumnos"/>
		</s:form>
    </body>
</html>

