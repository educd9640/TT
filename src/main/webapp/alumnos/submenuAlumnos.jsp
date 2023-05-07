<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container rounded p-3 contenido">
	<h3> Gestionar Alumnos </h3>
	<br>
	<p><a href='<s:url namespace="/alumnos" action="formularioRegistro" />' >Registrar Alumno</a></p>
	<br>
	<p><a href='<s:url namespace="/alumnos" action="consultarAlumnos" />' >Consultar Alumnos Registrados</a></p>
	<br>
	<p><a href='<s:url namespace="/" action="menuPrincipal" />' >Menu Principal</a></p>
	<br>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>
