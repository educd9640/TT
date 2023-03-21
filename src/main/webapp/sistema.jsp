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
<h3> Bienvenido al Sistema! </h3>

<p><a href='<s:url namespace="/alumnos" action="submenuAlumnos" />' >Gestionar Alumnos</a></p>
<p><a href='<s:url namespace="/" action="logout" />' >Cerrar sesión</a></p>
<p><a href='<s:url namespace="/" action="sessionTest" />' >Test de sesión</a></p>

</body>

</html>