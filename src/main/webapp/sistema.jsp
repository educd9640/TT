<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container rounded p-3 contenido">
<h3> Bienvenido al Sistema! </h3>

<p><a href='<s:url namespace="/alumnos" action="submenuAlumnos" />' >Gestionar Alumnos</a></p>

<p><a href='<s:url namespace="/jugadores" action="submenuJugadores" />' >Gestionar Jugadores</a></p>

<p><a href='<s:url namespace="/equipos" action="submenuEquipos" />' >Gestionar Equipo</a></p>

<p><a href='<s:url namespace="/ligas" action="submenuLigas" />' >Gestionar Ligas</a></p>

<p><a href='<s:url namespace="/temporadas" action="submenuTemporadas" />' >Gestionar Temporadas</a></p>

<p><a href='<s:url namespace="/" action="logout" />' >Cerrar sesión</a></p>
<p><a href='<s:url namespace="/" action="sessionTest" />' >Test de sesión</a></p>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>