<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
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
		<div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.registrados.titulo"/></h1>
        <br/><br/>
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
    
		        <s:actionmessage />
        	<display:table export="true" id="liga" name="ligasRegistradas" pagesize="10" class="table table-bordered">
        		<display:setProperty name="export.types" value="csv excel xml pdf" />
				<display:setProperty name="export.excel.filename" value="EquiposRegistrados.xls" />
				<display:setProperty name="export.csv.filename" value="EquiposRegistrados.csv" />
				<display:setProperty name="export.xml.filename" value="EquiposRegistrados.xml" />
				<display:setProperty name="export.pdf.filename" value="EquiposRegistrados.pdf" />
				<display:column property="nombre" title="Nombre de la liga" sortable="true" ></display:column> 
				<display:column property="telefono" title="Telefono" sortable="true" ></display:column>
				<display:column property="estado" title="Estado" sortable="true" ></display:column> 
				<display:column property="delegacion" title="Delegacion" sortable="true" ></display:column> 
				<display:column property="calle" title="Calle" sortable="true" ></display:column>   
				<display:column title="Activo" sortable="true" media="html">
					<s:if test="%{#attr.liga.fechaAlta!=null}">
						<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
					</s:if>
                    <s:else>
                   		<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
                    </s:else>
				</display:column>
				<display:column media="html">
					<s:url action="modificarLiga" var="url" escapeAmp="false">
                    <s:param name="ligaF.idLiga" value="%{#attr.liga.idLiga}"/>
                    <s:param name="operacion">actualizado</s:param>
                    </s:url>
                        <a href="<s:property value="#url"/>">Modificar</a>
				</display:column>
				<display:column media="html">
					<s:url action="estadoLiga" var="urlAlternar">
                       <s:param name="ligaF.idLiga" value="%{#attr.liga.idLiga}"/>
                   </s:url>
					<s:if test="%{#attr.liga.fechaAlta!=null}">
						<a href="<s:property value="#urlAlternar"/>">Desactivar</a>	
					</s:if>
                    <s:else>
                   		<a href="<s:property value="#urlAlternar"/>">Activar</a>	
                    </s:else>
				</display:column>
        	</display:table>
        <br>
        	<s:form action="submenuLigas">
				<s:submit value="Regresar" targets="submenuLigas" />
			</s:form>
	
		</div>
	</body>
	<jsp:include page="/bases/footer.jsp"></jsp:include>	
</html>

