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
		<h1> Gestionar Jugadores </h1>
		<div class="row">
		
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb1 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">01</span>
    					<h2 class="card-title mb-4">Registrar Jugador</h2>
    					<p class="card-text">Registra a un alumno en tu equipo</p>
    					<a href='<s:url namespace="/jugadores" action="formulario" />' class="btn btn-outline-light">Registrar</a>
  					</div>
				</div>
			</div>
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb2 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">02</span>
    					<h2 class="card-title mb-4">Consultar Jugadores</h2>
    					<p class="card-text">Consulta los jugadores registrados en el sistema</p>
    					<a href='<s:url namespace="/jugadores" action="consultarJugadores" />' class="btn btn-outline-light">Consultar</a>
  					</div>
				</div>
			</div>
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb1 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">03</span>
    					<h2 class="card-title mb-4">Registrar en Temporada</h2>
    					<p class="card-text">Registra a los jugadores en una de las temporadas disponibles</p>
    					<a href='<s:url namespace="/jugadores/equipo/temporada" action="consultarTemporadasRegistro" />' class="btn btn-outline-light">Registrar</a>
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