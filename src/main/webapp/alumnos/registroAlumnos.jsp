<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container rounded p-3 contenido">

<s:if test="operacion=='actualizado'">
	<s:set var="title" value="%{'Modificar Alumno'}"/>
</s:if>
<s:else>
    <s:set var="title" value="%{'Registro de Alumnos'}"/>
</s:else>
        <div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:property value="#title"/></h1>
        <s:actionerror theme="simple"/> <s:actionmessage theme="simple"/>
        <s:form action="registrarAlumno" method="post">
        	<s:if test="operacion=='actualizado'">
        		<s:textfield key="alumnoForm.boletaAlumno" readonly="true"/>
        		<s:hidden name="operacion" value="%{'actualizado'}"/>
        	</s:if>
        	<s:else>
        		<s:textfield key="alumnoForm.boletaAlumno"/>
        		<s:hidden name="operacion" value="%{'registrado'}"/>
        	</s:else>
            <s:textfield key="alumnoForm.nombrePila" /> 
            <s:textfield key="alumnoForm.apellidoPat" /> 
            <s:textfield key="alumnoForm.apellidoMat" />
            <s:select name="alumnoForm.semestre" list="semestres" label="%{getText('alumnoForm.semestre')}"/>
            <s:textfield key="alumnoForm.curp" />
            <s:textfield key="alumnoForm.nss" />
            <s:textfield key="alumnoForm.telefono" />
            <s:textfield key="alumnoForm.telEmergencia" />
            <s:textfield key="alumnoForm.correo" />
            <s:select name="alumnoForm.idEscuela" list="escuelas" listKey="idEscuela" listValue="nombreCortoEscuela" label="%{getText('alumnoForm.idEscuela')}"/>
            <s:if test="hasActionMessages()">
				<s:submit value="%{getText('button.label.submit')}" disabled="true"/>
			</s:if>
			<s:else>
    			<s:submit value="%{getText('button.label.submit')}"/>
			</s:else>
        </s:form>
        <s:form action="submenuAlumnos" >
			<s:submit value="Regresar" targets="submenuAlumnos"/>
		</s:form>
		
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>

