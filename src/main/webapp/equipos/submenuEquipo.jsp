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

<s:url action="formularioRegistro" var="url" escapeAmp="false">
	<s:param name="operacion">actualizado</s:param>
</s:url>

<div class="wrap">
	<span class="decor"></span>
	<nav>
		<ul class="primary">
			<li>
				<a href="">Registrar</a>
				<ul class="sub">
					<li><a href='<s:url namespace="/equipos" action="verificarEquipo" />' >Nuevo Equipo</a></li>
				</ul>
			</li>
			<li>
				<a href="">Editar</a>
				<ul class="sub">
					<li><a href="<s:property value="#url"/>">Equipo</a></li>
					<li><a href='<s:url namespace="/equipos" action="estatusEquipo" />' >Estatus</a></li>
				</ul>
			</li>
			<li>
				<a href='<s:url namespace="/equipos" action="entrarTemporada" />' >Entrar a temporada</a>
			</li>
			<li>
				<a href='<s:url namespace="/" action="menuPrincipal" />' >Regresar</a>
			</li>
		</ul>
	</nav>
</div>

</body>

</html>