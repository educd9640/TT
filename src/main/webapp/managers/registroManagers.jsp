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
        <s:form action="registro" method="post">
            <s:textfield key="managerForm.nombrePila" /> 
            <s:textfield key="managerForm.apellidoPat" /> 
            <s:textfield key="managerForm.apellidoMat" />
            <s:textfield key="managerForm.telefono" />
            <s:textfield key="managerForm.correo" />
            <s:password key="managerForm.contrasenia" />
            <s:select name="managerForm.idEscuela" list="escuelas" listKey="idEscuela" listValue="nombreCortoEscuela" label="%{getText('managerForm.idEscuela')}"/>
            <s:if test="hasActionMessages()">
				<s:submit value="%{getText('button.label.submit')}" disabled="true"/>
			</s:if>
			<s:else>
    			<s:submit value="%{getText('button.label.submit')}"/>
			</s:else>
        </s:form>
        <s:form namespace="/" action="index" >
			<s:submit value="Regresar" targets="index"/>
		</s:form>
		
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>


