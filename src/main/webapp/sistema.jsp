<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	
	<script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
	<script src="<s:url value='/bs/js/bootstrap.bundle.min.js'/>"></script>
	<link rel="stylesheet" href="<s:url value='/bs/css/bootstrap.min.css'/>">
	<link href="<s:url value='page.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	
		<h3> Bienvenido al Sistema! </h3>
		
		<div class="row">
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb1 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">01</span>
    					<h2 class="card-title mb-4">Alumnos</h2>
    					<p class="card-text">Con BallScore puede registrar a los alumnos de su institucion academica</p>
    					<a href='<s:url namespace="/alumnos" action="submenuAlumnos" />' class="btn btn-outline-light">Gestionar Alumnos</a>
  					</div>
				</div>
			</div>
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb2 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">02</span>
    					<h2 class="card-title mb-4">Equipo</h2>
    					<p class="card-text">Con BallScore puede dar de alta a su equipo deportivo</p>
    					<a href='<s:url namespace="/equipos" action="submenuEquipos" />' class="btn btn-outline-light">Gestionar Equipo</a>
  					</div>
				</div>
			</div>
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb1 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">03</span>
    					<h2 class="card-title mb-4">Jugadores</h2>
    					<p class="card-text">Con BallScore puede gestionar a los jugadores que conforman su equipo</p>
    					<a href='<s:url namespace="/jugadores" action="submenuJugadores" />' class="btn btn-outline-light">Gestionar Jugadores</a>
  					</div>
				</div>
			</div>
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb2 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">04</span>
    					<h2 class="card-title mb-4">Ligas</h2>
    					<p class="card-text">Con BallScore puede registrar y gestionar las ligas de juego</p>
    					<a href='<s:url namespace="/ligas" action="submenuLigas" />' class="btn btn-outline-light">Gestionar Ligas</a>
  					</div>
				</div>
			</div>
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb1 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">05</span>
    					<h2 class="card-title mb-4">Temporadas</h2>
    					<p class="card-text">Con BallScore puede registrar y gestionar las diversas temporadas de una liga</p>
    					<a href='<s:url namespace="/temporadas" action="submenuTemporadas" />' class="btn btn-outline-light">Gestionar Temporadas</a>
  					</div>
				</div>
			</div>
			
			<div class="col-md-6 d-flex justify-content-center">
				<div class="card m-2 cb2 text-center">
  					<div class="card-body">
  						<span class="card-number fw-bold">06</span>
    					<h2 class="card-title mb-4">Partidos</h2>
    					<p class="card-text">Con BallScore puede dar de alta y llevar un control de las estadisticas de un partido</p>
    					<a href='<s:url namespace="/partidos" action="submenuPartidos" />' class="btn btn-outline-light">Gestionar Partidos</a>
  					</div>
				</div>
			</div>
			
			<br>
			<br>
			<br>

	</div>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>

<jsp:include page="/bases/footer.jsp"></jsp:include>