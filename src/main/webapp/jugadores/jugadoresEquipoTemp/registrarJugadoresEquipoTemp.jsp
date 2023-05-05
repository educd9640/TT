<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
	<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css" />
	<link href="<s:url value='/css/tinystyle.css'/>" rel="stylesheet" type="text/css"/>
	<s:head />
	<title><s:text name="label.registrados.titulo" /></title>
	
	<script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
        <script src="<s:url value='/js/tinybox.js'/>"></script>
        <script>
        	function registrarJugadores(jugadoresARegistrar){
        		alert(jugadoresARegistrar)
				document.getElementById("jugadoresARegistrar").value=jugadoresARegistrar;
				document.forms[0].submit();
				//window.location = "/ballscore/jugadores/equipo/temporada/registrarJugadores.action?form.idTemporada="+<s:property value="form.idTemporada"/>+"&form.idEquipo="+<s:property value="form.idEquipo"/>;
        	}
        </script>
        <script>
        $(document).ready(function(){

		  // jQuery methods go here...
			
			$("#registrarJugadores").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
        		TINY.box.show({
        			iframe:'/ballscore/jugadores/equipo/temporada/modalRegistrarJugador.action?form.idTemporada=<s:property value="form.idTemporada"/>&form.idEquipo=<s:property value="form.idEquipo"/>',
        			boxid:'frameless',
        			width:full_window_width-300,
        			height:full_window_height-250,
        			fixed:true,
        			maskid:'bluemask',
					maskopacity:40
       			})
    		});
		});
        </script>
	
	</head>
<body>
<s:form id="registrarJugadores" action="registrarJugadores" method="post">
	<s:hidden key="form.idTemporada"></s:hidden>
	<s:hidden key="form.idEquipo"></s:hidden>
	<s:hidden id="jugadoresARegistrar" key="form.jugadoresARegistrar"></s:hidden>
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
</s:form>
    <s:form namespace="/jugadores/equipo/temporada" action="consultarTemporadasRegistro">
			<s:submit value="Regresar" targets="consultarTemporadasRegistro" />
	</s:form>
</body>
</html>
   
    
    