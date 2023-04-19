<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
<head>
<!--  SETANDO CSS's  -->
<link href="<s:url value='/menu.css'/>" rel="stylesheet" type="text/css"/>
<!--  JQUERY PLUGIN -->
<sj:head jqueryui="true" />
<sb:head/>

</head>


<body>
<h1> Bienvenido al menu de Equipos </h1>

<s:actionmessage />

<nav>
<a href='<s:url namespace="/equipos" action="verificarEquipo" />' >Registrar Equipo</a>
<s:url action="formularioRegistro" var="url" escapeAmp="false">
	<s:param name="operacion">actualizado</s:param>
</s:url>
<a href="<s:property value="#url"/>">Modificar equipo</a>
<a href='<s:url namespace="/equipos" action="estatusEquipo" />' >Activar/Desactivar Equipo</a>
<a href='<s:url namespace="/equipos" action="entrarTemporada" />' >Entrar a temporada</a>
<a href='<s:url namespace="/" action="menuPrincipal" />' >Regresar</a>
<div class="animation start-home"></div>
</nav>

<p>
	<span>BallScore ESCOM</span>
</p>

</body>

</html>