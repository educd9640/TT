<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<html>
<head>
<!--  SETANDO CSS's  -->
<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
<!--  JQUERY PLUGIN -->
<sj:head jqueryui="true" />
<sb:head/>

</head>

<body>
<h3>Gestionar Partidos</h3>

<p><a href='<s:url namespace="/partidos" action="formularioRegistroPartido" />' >Registrar Partido</a></p>
<p><a href='<s:url namespace="/partidos" action="consultarPartidos" />' >Consultar Partido</a></p>
<p><a href='<s:url namespace="/" action="menuPrincipal" />' >Menu Principal</a></p>
</body>
</html>