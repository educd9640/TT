<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="operacion=='actualizado'">
	<s:set var="title" value="%{'Modificar Partido'}"/>
</s:if>
<s:else>
    <s:set var="title" value="%{'Registro Partido'}"/>
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
        		document.getElementById("idTemporada").value=informacion;
        	}
        </script>
        <script>
        $(document).ready(function(){

		  // jQuery methods go here...
			
			$("#buscarTemporada").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
        		TINY.box.show({
        			iframe:'/ballscore/temporadas/consultarEquipoTemporadasModal.action',
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
        <s:form action="registrarPartido" method="post">
        	
        	<s:if test="operacion=='actualizado'">
        		<s:hidden name="operacion" value="%{'actualizado'}"/>
        		<s:textfield key="partidoF.idPartido" readonly="true"/>        	
        	</s:if>
        	<s:else>
        		<s:hidden name="operacion" value="%{'registrado'}"/>
        	</s:else>
        
        
        	<s:textfield id="idTemporada" key="partidoF.idTemporada" readonly="true"/>
        	<input id="buscarTemporada" type="button" value="Buscar Temporada">
        	
        	<s:textfield id="fechaAnuncioPartido" key="fechaAnuncioPartido" label="Fecha de Anuncio" placeholder="dd/mm/yyyy"/>
			<s:textfield id="horaAnuncioPartido" key="horaAnuncioPartido" label="Hora de Anuncio formato 24hrs" placeholder="xx:xx"/>        	
        	
        	<s:if test="hasActionMessages() || hasActionErrors()">
				<s:submit value="%{getText('button.label.submit')}"/>
			</s:if>
			<s:else>
    			<s:submit value="%{getText('button.label.submit')}"/>
			</s:else>
        	
        </s:form>
        <s:form action="submenuPartidos" >
			<s:submit value="Regresar" targets="submenuPartidos"/>
		</s:form>
	</body>
</html>