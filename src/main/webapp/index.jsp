<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<div>
	<img alt="logo" src="/ballscore/bases/ball.png" style="display: block; margin-left: auto; margin-right: auto;" width=250 height=250>
	</div>
	<div id="login" class="rounded" style="background-color: white;width: 500px; padding: 1%; margin-top:1%">
		<h4>Inicio de sesión: </h4>
		<s:form action="login"  theme="bootstrap" cssClass="well form-vertical">
			<s:textfield name="login"  placeholder="Login" />
			<s:password name="contrasenia"  placeholder="Contraseña" />
			<br>
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
<jsp:include page="/bases/footer.jsp"></jsp:include>