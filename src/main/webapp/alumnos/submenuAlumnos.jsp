<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
	<head>
		<!--  SETANDO CSS's  -->
		<link href="<s:url value='/page.css'/>" rel="stylesheet" type="text/css"/>
	</head>
	
	<body>
	
		<h3> Gestionar Alumnos </h3>
	
		<div class="row">
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb1 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">01</span>
    					<h2 class="card-title mb-4">Registrar Alumno</h2>
    					<p class="card-text">Proporciona los datos necesarios para registrar a un alumno</p>
    					<a href='<s:url namespace="/alumnos" action="formularioRegistro" />' class="btn btn-outline-light">Registrar</a>
  					</div>
				</div>
			</div>
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb2 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">02</span>
    					<h2 class="card-title mb-4">Consultar alumnos</h2>
    					<p class="card-text">Consulta los alumnos registrados en el sistema</p>
    					<a href='<s:url namespace="/alumnos" action="consultarAlumnos" />' class="btn btn-outline-light">Consultar Alumnos Registrados</a>
  					</div>
				</div>
			</div>
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb2 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">00</span>
    					<h2 class="card-title mb-4">Menu principal</h2>
    					<p class="card-text">Regresar al menu principal</p>
    					<a href='<s:url namespace="/" action="menuPrincipal" />' class="btn btn-outline-light">Ir</a>
  					</div>
				</div>
			</div>
			
		</div>
	</body>
<jsp:include page="/bases/footer.jsp"></jsp:include>
</html>