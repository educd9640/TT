<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<html style="margin: 0">
<head>
<title>BallScore</title>
<script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
<script src="<s:url value='/bs/js/bootstrap.bundle.min.js'/>"></script>

<link rel="stylesheet" href="<s:url value='/bs/css/bootstrap.min.css'/>">
<link rel="stylesheet" href="<s:url value='/css/tinystyle.css'/>" type="text/css"/>
<link rel="stylesheet" href="<s:url value='/main.css'/>"  type="text/css"/>
<link rel="stylesheet" href="<s:url value='/css/sexyalertbox.css'/>"  type="text/css"/>

<script src="<s:url value='/js/tinybox.js'/>"></script>
<!-- Script Sexyalertbox -->
<script src="<s:url value='/js/sexyalertbox.v1.2.jquery.js'/>"></script>
<!-- Script Jquery easing (Animaciones, usado por sexyalert) -->
<script src="<s:url value='/js/jquery.easing.1.3.js'/>"></script>
<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }
      .bd-mode-toggle {
        z-index: 1500;
      }
      
      body {
		  background-image: url('/ballscore/bases/background.jpg');
		  background-repeat: no-repeat;
		  background-attachment: fixed;
		  background-size: cover;
		  width:100%;
		  heigth:100%;
		  position:relative;
	  }
	  
	  .contenido{
	  	  background-color: #f5fcfc; 
	  	  height: 75%;
	  	  max-width: 90%; 
	  	  margin-top: 1%; 
	  	  opacity:.9;
	  	  overflow-x: auto;
	  }
</style>
<body style="margin: 0">
<header class="p-3 text-bg-dark" style="width: 100%">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
          <img alt="logo" src="/ballscore/bases/ball.png" width="50" height="50">
        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href='<s:url namespace="/" action="menuPrincipal" />' class="nav-link px-2 text-secondary">Principal</a></li>
          <li><a href='<s:url namespace="/alumnos" action="submenuAlumnos" />' class="nav-link px-2 text-white">Alumnos</a></li>
          <li><a href='<s:url namespace="/jugadores" action="submenuJugadores" />' class="nav-link px-2 text-white">Jugadores</a></li>
          <li><a href='<s:url namespace="/equipos" action="submenuEquipos" />' class="nav-link px-2 text-white">Equipo</a></li>
          <li><a href='<s:url namespace="/ligas" action="submenuLigas" />' class="nav-link px-2 text-white">Ligas</a></li>
          <li><a href='<s:url namespace="/temporadas" action="submenuTemporadas" />' class="nav-link px-2 text-white">Temporadas</a></li>
        </ul>

        <div class="text-end">
          <button type="button" onclick="window.location.href='<s:url namespace="/" action="logout" />';" class="btn btn-outline-light me-2">Salir</button>
        </div>
      </div>
</header>
