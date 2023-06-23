<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
<head>

	<script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
	<script src="<s:url value='/bs/js/bootstrap.bundle.min.js'/>"></script>
	<link rel="stylesheet" href="<s:url value='/bs/css/bootstrap.min.css'/>">
	<!--  SETANDO CSS's  -->
	<link href="<s:url value='/page.css'/>" rel="stylesheet" type="text/css"/>

</head>


<body>
<h1>Gestionar Equipos </h1>

<s:actionmessage />

<s:url action="formularioRegistro" var="url" escapeAmp="false">
	<s:param name="operacion">actualizado</s:param>
</s:url>



<div class="row">

	<div class="col-md-6 d-flex justify-content-center">
		<div class="card m-2 cb1 text-center">
  			<div class="card-body">
  				<span class="card-number fw-bold">01</span>
    			<h2 class="card-title mb-4">Registrar</h2>
    			<p class="card-text">Registra tu equipo. Si ya tienes uno, solo podras modificar los datos de tu equipo</p>
    			<a href='<s:url namespace="/equipos" action="verificarEquipo" />' class="btn btn-outline-light">Registrar</a>
  			</div>
		</div>
	</div>
	
	<div class="col-md-6 d-flex justify-content-center">
		<div class="card m-2 cb2 text-center">
  			<div class="card-body">
  				<span class="card-number fw-bold">02</span>
    			<h2 class="card-title mb-4">Editar Equipo</h2>
    			<p class="card-text">Modifica los datos de tu equipo</p>
    			<a href="<s:property value="#url"/>" class="btn btn-outline-light">Modificar</a>
  			</div>
		</div>
	</div>
	
	<div class="col-md-6 d-flex justify-content-center">
		<div class="card m-2 cb1 text-center">
  			<div class="card-body">
  				<span class="card-number fw-bold">03</span>
    			<h2 class="card-title mb-4">Editar estatus</h2>
    			<p class="card-text">Da click aqui para activar/desactivar a tu equipo</p>
    			<a href='<s:url namespace="/equipos" action="estatusEquipo" />' class="btn btn-outline-light">Activar/Desactivar</a>
  			</div>
		</div>
	</div>
	
	<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb2 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">00</span>
    					<h2 class="card-title mb-4">Men&uacute; principal</h2>
    					<p class="card-text">Regresar al men&uacute; principal</p>
    					<a href='<s:url namespace="/" action="menuPrincipal" />' class="btn btn-outline-light">Ir</a>
  					</div>
				</div>
			</div>
	
</div>

</body>
<jsp:include page="/bases/footer.jsp"></jsp:include>

</html>