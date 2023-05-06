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
<h3>Gestionar Temporadas</h3>

<p><a href='<s:url namespace="/temporadas" action="formularioRegistroTemporada" />' >Registrar Temporada</a></p>
<p><a href='<s:url namespace="/temporadas" action="consultarTemporadas" />' >Consultar Temporadas</a></p>
<p><a href='<s:url namespace="/" action="menuPrincipal" />' >Menu Principal</a></p>
</body>
</html>