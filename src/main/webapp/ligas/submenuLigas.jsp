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
	
	<h1>Gestionar Ligas</h1>
	
	<div class="row">
	
		<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb1 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">01</span>
    					<h2 class="card-title mb-4">Registrar Liga</h2>
    					<p class="card-text">Registra una nueva liga</p>
    					<a href='<s:url namespace="/ligas" action="formularioRegistroLiga" />' class="btn btn-outline-light">Registrar</a>
  					</div>
				</div>
		</div>
		
		<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb2 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">02</span>
    					<h2 class="card-title mb-4">Consultar Ligas</h2>
    					<p class="card-text">Consulta las ligas regsitradas</p>
    					<a href='<s:url namespace="/ligas" action="consultarLigas" />' class="btn btn-outline-light">Consultar</a>
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
