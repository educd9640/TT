<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<s:set var="title" value="%{'Consultar equipos'}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<link rel="stylesheet" href="<s:url value='/bs/css/bootstrap.min.css'/>">
		<script src="<s:url value='/bs/js/bootstrap.bundle.min.js'/>"></script>
		
		<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
		<link href="<s:url value='/css/sexyalertbox.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <style>td { white-space:nowrap; }</style>
        <title><s:property value="#title"/></title>
        
        <script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
        <!-- Script Sexyalertbox -->
        <script src="<s:url value='/js/sexyalertbox.v1.2.jquery.js'/>"></script>
        <!-- Script Jquery easing (Animaciones, usado por sexyalert) -->
        <script src="<s:url value='/js/jquery.easing.1.3.js'/>"></script>
        	

        
	</head>
<body>
    	<div class="container rounded p-3 contenido">
    		<div class="titleDiv"><s:text name="label.equipos.titulo"/></div>
        	<h1><s:text name="label.equipos.registrados"/></h1>
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
        
    		<s:actionmessage />
    		<display:table export="true" id="tabla" name="equiposByTemporada" pagesize="10" requestURI="" class="table table-hover table-striped">
				<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="EquiposRegistrados.xls" />
				<display:setProperty name="export.csv.filename" value="EquiposRegistrados.csv" />
				<display:setProperty name="export.xml.filename" value="EquiposRegistrados.xml" />
				<display:setProperty name="export.pdf.filename" value="EquiposRegistrados.pdf" />
				<display:column property="equipo.nombre" title="Nombre del equipo" sortable="true" ></display:column>    
				<display:column property="equipo.idEquipo" title="ID del Equipo" sortable="true" ></display:column>
				<display:column property="equipo.manager.nombrePila" title="Nombre del manager" sortable="true" ></display:column>
    		</display:table>
    		
    		<br>
    		<br>
    		<s:form action="consultarTemporadas" >
				<s:submit value="Regresar" targets="consultarTemporadas"/>
			</s:form>
    	</div>    	

</body>
<jsp:include page="/bases/footer.jsp"></jsp:include>
</html>