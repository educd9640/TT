<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="container rounded p-3 contenido">
<s:set var="title" value="%{'Registro Managers'}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <s:head />
        <link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
        <style>td { white-space:nowrap; }</style>
        <title><s:property value="#title"/></title>
    </head>
    <body>
        <div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:property value="#title"/></h1>
        <s:actionerror />
        <s:actionmessage />
        <s:form action="registro" method="post">
            <s:textfield key="managerForm.nombrePila" /> 
            <s:textfield key="managerForm.apellidoPat" /> 
            <s:textfield key="managerForm.apellidoMat" />
            <s:textfield key="managerForm.telefono" />
            <s:textfield key="managerForm.correo" />
            <s:password key="managerForm.contrasenia" />
            <s:select name="managerForm.idEscuela" list="escuelas" listKey="idEscuela" listValue="nombreCortoEscuela" label="%{getText('managerForm.idEscuela')}"/>
            <s:if test="hasActionMessages()">
				<s:submit value="%{getText('button.label.submit')}" disabled="true"/>
			</s:if>
			<s:else>
    			<s:submit value="%{getText('button.label.submit')}"/>
			</s:else>
        </s:form>
        <s:form namespace="/" action="index" >
			<s:submit value="Regresar" targets="index"/>
		</s:form>
    </body>
</html>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>