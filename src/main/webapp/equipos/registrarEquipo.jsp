<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:set var="title" value="%{'Registro Equipo'}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <style>td { white-space:nowrap; }</style>
        <title><s:property value="#title"/></title>
	</head>
<body>
	<div class="titleDiv"><s:text name=""/></div>
	<h1><s:property value="#title"/></h1>
	<s:actionerror />
    <s:actionmessage />
    <s:form action="registrarEquipo" method="post" >
    	<s:textfield key="equipoForm.nombre"/>
    	<s:if test="hasActionMessages()">
				<s:submit value="%{getText('button.label.submit')}" disabled="true"/>
			</s:if>
			<s:else>
    			<s:submit value="%{getText('button.label.submit')}"/>
	    </s:else>
    </s:form>
</body>
</html>