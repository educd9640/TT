<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
<head>
<!--  SETANDO CSS's  -->
<link rel="stylesheet" href="main.css">
<!--  JQUERY PLUGIN -->
<sj:head jqueryui="true" />
<sb:head/>
</head>


<body>
<h3> Bienvenido al Sistema! </h3>

<p><a href='<s:url namespace="/alumnos" action="submenuAlumnos" />' >Gestionar Alumnos</a></p>

</body>

</html>