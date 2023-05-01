<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
	<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css" />
	<s:head />
	<title><s:text name="label.registrados.titulo" /></title>
	</head>
<body>
	<s:hidden key="form.idTemporada"></s:hidden>
	<s:hidden key="form.idEquipo"></s:hidden>
	<div class="titleDiv">
		<s:text name="application.title" />
	</div>
	<h1>
		<s:text name="label.registrados.titulo" />
	</h1>
	<br /><br />
	<s:actionerror />
    <s:actionmessage />
    <table class="borderAll">
    	<tr>
    		<td align="center" colspan="4">Registrando jugadores en la liga [<b><s:property value="form.temporada.liga.nombre"/></b>] temporada del <b><s:property value="form.temporada.fechaInicial"/></b> al <b><s:property value="form.temporada.fechaInicial"/></b></td>
    	</tr>
    	<tr>
    		<td align="center" colspan="4">Jugadores Registrados:</td>
    	</tr>
    	<tr>
    		<th>Boleta Alumno</th>
    		<th>Nombre Alumno</th>
    		<th>Posicion Primaria</th>
    		<th>Posicion Secundaria</th>
    	</tr>
    	<s:iterator value="form.jugadoresTemporada" status="status">
    		<tr>
    			<td class="nowrap"><s:property value="jugador.alumno.boletaAlumno"/></td>
    			<td class="nowrap"><s:property value="jugador.alumno.nombrePila"/> <s:property value="jugador.alumno.apellidoPat"/> <s:property value="jugador.alumno.apellidoMat"/></td>
    			<td class="nowrap"><s:property value="jugador.posicionPrim"/></td>
    			<td class="nowrap"><s:property value="jugador.posicionSec"/></td>
    		</tr>
    	</s:iterator>
    	<tr>
    		<td colspan="4"><input id="registrarJugadores" type="button" value="Registrar jugadores"/></td>
    	</tr>
    </table>
</body>
</html>
   
    
    