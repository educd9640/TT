<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="operacion=='actualizado'">
	<s:set var="title" value="%{'Modificar Jugador'}"/>
</s:if>
<s:else>
    <s:set var="title" value="%{'Registro Jugadores'}"/>
</s:else>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
    	<link href="<s:url value='/css/tinystyle.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <style>td { white-space:nowrap; }</style>
        <title><s:property value="#title"/></title>
        
        <script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
        <script src="<s:url value='/js/tinybox.js'/>"></script>
        <script>
        	function settearDesdeModal(informacion){
        		var infoAlumno = informacion.split("_");
        		document.getElementById("boletaAlumno").value=infoAlumno[0];
        		document.getElementById("nombrePila").value=infoAlumno[1];
        		document.getElementById("apellidoPat").value=infoAlumno[2];
        		document.getElementById("apellidoMat").value=infoAlumno[3];
        	}
        </script>
        <script>
        $(document).ready(function(){

		  // jQuery methods go here...
			
			$("#buscarAlumno").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
        		TINY.box.show({
        			iframe:'/ballscore/alumnos/consultarAlumnosModal.action',
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
        <div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:property value="#title"/></h1>
        <s:actionerror />
        <s:actionmessage />
        <s:form action="registrarJugador" method="post">
        	<s:hidden key="jugadoresForm.idJugador"></s:hidden>
        	<s:hidden key="operacion"></s:hidden>
       		<s:textfield id="boletaAlumno" key="jugadoresForm.alumno.boletaAlumno" readonly="true"/>
       		<s:if test="operacion!='actualizado'">
        		<input id="buscarAlumno" type="button" value="Buscar Alumno"/>
        	</s:if>
            <s:textfield id ="nombrePila" key="jugadoresForm.alumno.nombrePila" readonly="true"/> 
            <s:textfield id ="apellidoPat" key="jugadoresForm.alumno.apellidoPat" readonly="true"/> 
            <s:textfield id ="apellidoMat" key="jugadoresForm.alumno.apellidoMat" readonly="true"/>
            <s:select name="jugadoresForm.posicionPrim" list="posiciones" label="%{getText('jugadoresForm.posicionPrim')}"/>
            <s:select name="jugadoresForm.posicionSec" list="posiciones" label="%{getText('jugadoresForm.posicionSec')}"/>
            <s:if test="hasActionMessages() || hasActionErrors()">
				<s:submit value="%{getText('button.label.submit')}"/>
			</s:if>
			<s:else>
    			<s:submit value="%{getText('button.label.submit')}"/>
			</s:else>
        </s:form>
        <s:form action="submenuJugadores" >
			<s:submit value="Regresar" targets="submenuJugadores"/>
		</s:form>
    </body>
</html>

