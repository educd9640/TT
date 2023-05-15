<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container rounded p-3 contenido">
<h3>Gestionar Partidos</h3>

<p><a href='<s:url namespace="/partidos" action="formularioRegistroPartido" />' >Registrar Partido</a></p>
<p><a href='<s:url namespace="/partidos" action="consultarPartidos" />' >Consultar Partidos</a></p>
<!-- <p><a href='<s:url namespace="/ligas" action="consultarPartidos" />' >Consultar Partido</a></p> -->
<p><a href='<s:url namespace="/" action="menuPrincipal" />' >Menu Principal</a></p>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>
