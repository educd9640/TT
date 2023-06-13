<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container rounded p-3 contenido">
		<div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:property value="#title"/></h1>
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
   
				<s:actionmessage />
		<s:form action="registrarLiga" method="post">
	
			<s:if test="operacion=='actualizado'">
        		<s:hidden name="operacion" value="%{'actualizado'}"/>
        		<s:textfield key="ligaF.idLiga" readonly="true"/>        		
        	</s:if>
        	<s:else>
        		<s:hidden name="operacion" value="%{'registrado'}"/>
        	</s:else>
			*Obligatorio
			<s:textfield key="ligaF.nombre" />
			<s:textfield key="ligaF.telefono" />
			<s:textfield key="ligaF.calle" />
			<s:textfield key="ligaF.colonia" />
			<s:textfield key="ligaF.codigoPostal" />
			<s:textfield key="ligaF.delegacion" />
			<s:textfield key="ligaF.estado" />
	
			<s:if test="hasActionMessages()">
				<s:submit value="%{getText('button.label.submit')}" disabled="true" />
			</s:if>
			<s:else>
				<s:submit value="%{getText('button.label.submit')}" />
			</s:else>
	
		</s:form>
		<s:form action="submenuLigas">
			<s:submit value="Regresar" targets="submenuLigas" />
		</s:form>
	
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>