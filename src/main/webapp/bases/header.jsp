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
          <li><a href='<s:url namespace="/partidos" action="submenuPartidos" />' class="nav-link px-2 text-white">Partidos</a></li>
        </ul>

        <div class="text-end">
          <button type="button" onclick="window.location.href='<s:url namespace="/" action="logout" />';" class="btn btn-outline-light me-2">Salir</button>
        </div>
      </div>
</header>
