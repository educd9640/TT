<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="container rounded p-3 contenido">
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
        		var equipoLocal = document.getElementById("buscarEquipoLocal");
        		
        		document.getElementById("idEquipoLocal").value = null;
        		document.getElementById("idEquipoVisitante").value = null;

        		document.getElementById("idTemporada").value=informacion;
        		
        		equipoLocal.removeAttribute("disabled");
        		equipoLocal.visibility = "visible";
        		
        	}
        </script>
        <script>	
        	function settearDesdeModalLocal(informacion){
        		var equipoVisita = document.getElementById("buscarEquipoVisitante");
        		
        		document.getElementById("idEquipoLocal").value=informacion;
        		document.getElementById("idEquipoVisitante").value = null;
        		
        		equipoVisita.removeAttribute("disabled");
        		equipoVisita.visibility = "visible";
        	}
        </script>
        <script>
        	function settearDesdeModalVisitante(informacion){
        		
        		document.getElementById("idEquipoVisitante").value=informacion;
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
    		
    		//EquipoLocal
    		$("#buscarEquipoLocal").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
				var temporada = document.getElementById("idTemporada").value;
        		TINY.box.show({
        			iframe: '/ballscore/equipos/consultarEquipoLocalModal.action?idTemporada=' + temporada,
        			boxid:'frameless',
        			width:full_window_width-300,
        			height:full_window_height-250,
        			fixed:true,
        			maskid:'bluemask',
					maskopacity:40
       			})
    		});
    		
    		
    		//EquipoVisita
    		$("#buscarEquipoVisitante").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
				var temporada = document.getElementById("idTemporada").value;
				var equipoL = document.getElementById("idEquipoLocal").value;
				
        		TINY.box.show({
        			iframe: '/ballscore/equipos/consultarEquipoVisitanteModal.action?idTemporada=' + temporada+'&equipoL='+equipoL,
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
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>

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
        	
        	
			<input id="buscarEquipoLocal" type="button" value="Buscar Equipo Local" disabled="true">
			<input id="buscarEquipoVisitante" type="button" value="Buscar Equipo Visitante" disabled="true">
        	
        	<s:textfield id="idEquipoLocal" key="partidoF.idEquipoLocal" readonly="true"/>
        	<s:textfield id="idEquipoVisitante" key="partidoF.idEquipoVisitante" readonly="true"/>
        	&nbsp;&nbsp;&nbsp;
        	
        	<s:textfield key="partidoF.campo" />
        	<br>
        	Fecha Partido: <input type="datetime-local" id="fechaAnuncioPartido" name="fechaAnuncioPartido">
        	        	
        	
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
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>