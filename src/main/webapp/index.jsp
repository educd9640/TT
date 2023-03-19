<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
<head>
<!--  SETANDO CSS's  -->
<link rel="stylesheet" href="main.css">
<!--  JQUERY PLUGIN -->
<sj:head jqueryui="true" />
<sb:head/>

</head>
<body>
	<div id="titulo">
	</div>

	<div id="login">
		<h4>Sistema: </h4>
		<s:form action="login"  theme="bootstrap" cssClass="well form-vertical">
			<s:textfield name="login"  placeholder="Login" />
			<s:password name="contrasenia"  placeholder="Contraseña" />
			<s:submit value="Entrar" cssClass="btn btn-primary" targets="login" effect="highlight"/>
			<s:submit value="Test" cssClass="btn btn-primary" targets="login" effect="highlight"/>
		</s:form>
		<s:form namespace="/managers" action="formularioRegistro"  theme="bootstrap" cssClass="well form-vertical">
			<s:submit value="Registrarse" cssClass="btn btn-primary" targets="registro" effect="highlight"/>
		</s:form>
		
	</div>

	<!-- ACTION ERROR -->
	<s:if test="hasActionErrors()">
		<div class="errorsLogin">
			<s:actionerror theme="bootstrap"/>
		</div>
	</s:if>
	<!-- ACTION MESSAGE -->
	<s:if test="hasActionMessages()">
		<div class="messageLogin">
			<s:actionmessage theme="bootstrap"/>
		</div>
	</s:if>
</body>
</html>