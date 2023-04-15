<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
<head>
<!--  SETANDO CSS's  -->
<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
<!--  JQUERY PLUGIN -->
<sj:head jqueryui="true" />
<sb:head/>

</head>


<body>
<h3> Gestionar Equipos </h3>

<s:actionmessage />


<p><a href='<s:url namespace="/equipos" action="verificarEquipo" />' >Registrar Equipo</a></p>
<p>
	<s:url action="formularioRegistro" var="url" escapeAmp="false">
		<s:param name="operacion">actualizado</s:param>
	</s:url>
	<a href="<s:property value="#url"/>">Modificar equipo</a>
</p>
<p><a href='<s:url namespace="/equipos" action="estatusEquipo" />' >Activar/Desactivar Equipo</a></p>
<p><a href='<s:url namespace="/equipos" action="entrarTemporada" />' >Entrar a temporada</a></p>
<p><a href='<s:url namespace="/" action="menuPrincipal" />' >Regresar</a></p>
</body>

</html>