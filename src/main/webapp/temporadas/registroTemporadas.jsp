<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<s:if test="operacion=='actualizado'">
	<s:set var="title" value="%{'Modificar Temporada'}"/>
</s:if>
<s:else>
    <s:set var="title" value="%{'Registro Temporadas'}"/>
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
        		var infoLiga = informacion.split("_");
        		document.getElementById("idLiga").value=infoLiga[0];
        		document.getElementById("nombre").value=infoLiga[1];
        	}
        </script>
        <script>
        $(document).ready(function(){

		  // jQuery methods go here...
			
			$("#buscarLiga").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
        		TINY.box.show({
        			iframe:'/ballscore/ligas/consultarLigasModal.action',
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
        <s:form action="registrarTemporada" method="post">
        	<s:textfield id="idLiga" key="temporadaF.liga.idLiga" readonly="true"/>
        	<input id="buscarLiga" type="button" value="Buscar Liga">
        	<s:textfield id="nombre" key="temporadaF.liga.nombre" readonly="true"/>
        	
        	<sx:datetimepicker name="fechaInicial" label="Format(dd-mm-yyyy)" displayFormat="dd-MM-yyyy"> </sx:datetimepicker>
        	
        	
        	<s:if test="hasActionMessages() || hasActionErrors()">
				<s:submit value="%{getText('button.label.submit')}"/>
			</s:if>
			<s:else>
    			<s:submit value="%{getText('button.label.submit')}"/>
			</s:else>
        	
        </s:form>
        <s:form action="submenuTemporadas" >
			<s:submit value="Regresar" targets="submenuTemporadas"/>
		</s:form>
	</body>
</html>