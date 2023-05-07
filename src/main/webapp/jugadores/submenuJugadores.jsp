<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container rounded p-3 contenido">
<h3> Gestionar Jugadores </h3>
<br>
<p><a href='<s:url namespace="/jugadores" action="formulario" />' >Registrar Jugador</a></p>
<br>
<p><a href='<s:url namespace="/jugadores" action="consultarJugadores" />' >Consultar Jugadores Registrados</a></p>
<br>
<p><a href='<s:url namespace="/jugadores/equipo/temporada" action="consultarTemporadasRegistro" />' >Registrar Jugadores En Temporada</a></p>
<br>
<p><a href='<s:url namespace="/" action="menuPrincipal" />' >Menu Principal</a></p>
<br>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>