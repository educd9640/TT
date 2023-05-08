<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container rounded p-3 contenido">
<h3> Bienvenido al Sistema! </h3>

<p><a href='<s:url namespace="/alumnos" action="submenuAlumnos" />' >Gestionar Alumnos</a></p>

<p><a href='<s:url namespace="/jugadores" action="submenuJugadores" />' >Gestionar Jugadores</a></p>

<p><a href='<s:url namespace="/equipos" action="submenuEquipos" />' >Gestionar Equipo</a></p>

<p><a href='<s:url namespace="/ligas" action="submenuLigas" />' >Gestionar Ligas</a></p>

<p><a href='<s:url namespace="/temporadas" action="submenuTemporadas" />' >Gestionar Temporadas</a></p>

<p><a href='<s:url namespace="/partidos" action="submenuPartidos" />' >Gestionar Partidos</a></p>

<p><a href='<s:url namespace="/" action="logout" />' >Cerrar sesi�n</a></p>
<p><a href='<s:url namespace="/" action="sessionTest" />' >Test de sesi�n</a></p>

<s:url namespace="/jugadores/partido" action="consultarJugadoresPartido" var="url" escapeAmp="false">
         <s:param name="form.idPartido" value="%{1}"/>
         <s:param name="form.idEquipo" value="%{6}"/>
         <s:param name="form.idTemporada" value="%{22}"/>
 </s:url>
 <a href="<s:property value="#url"/>">Registrar jugadores partido</a>
</div>

<p><a href='<s:url namespace="/jugadores/partido" action="presentarRegistroResultados" />' >presentarRegistroResultados</a></p>

<jsp:include page="/bases/footer.jsp"></jsp:include>