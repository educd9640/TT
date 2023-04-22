<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:set var="title" value="%{'Buscar Equipo'}"/>
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
        		var infoEquipo = informacion.split("_");
        		document.getElementById("idEquipo").value=infoEquipo[0];
        		document.getElementById("nombreManager").value=infoEquipo[1];
        		document.getElementById("nombreEquipo").value=infoEquipo[2];
        	}
        </script>
        
        <script>
        	$(document).ready(function(){
		  	// jQuery methods go here...
			
			$("#buscarEquipo").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
        		TINY.box.show({
        			iframe:'/ballscore/equipos/buscarEquipoModal.action',
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
	<div class="titleDiv"><s:text name=""/></div>
	<h1><s:property value="#title"/></h1>
	<s:actionerror />
    <s:actionmessage />
    <s:form action="" method="post" >
    	<input id="buscarEquipo" type="button" value="Buscar Equipo"/>
    	<s:textfield id="nombreEquipo" key="equipoForm.nombre"/>
    	<s:textfield id="idEquipo" key="equipoForm.idEquipo"/>
    	<s:textfield id="nombreManager" key="equipoForm.nombreManager"/>
    </s:form>
     <s:form action="submenuEquipos" >
			<s:submit value="Regresar" targets="submenuEquipos"/>
	</s:form>
</body>
</html>