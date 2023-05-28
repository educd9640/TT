<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container rounded p-3 contenido">
<s:set var="title" value="%{'Registrar equipo en temporada'}"/>
        <script>
        	function settearDesdeModal(informacion){
        		var infoEquipo = informacion.split("_");
        		document.getElementById("idEquipo").value=infoEquipo[0];
        		document.getElementById("nombreManager").value=infoEquipo[1];
        		document.getElementById("nombreEquipo").value=infoEquipo[2];
        	}
        </script>
        
        <script>
        	$(document).ready(function(){
		  	// jQuery methods go here...
			
			$("#buscarEquipo").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
        		TINY.box.show({
        			iframe:'/ballscore/equipos/buscarEquipoModal.action?temporadaElegida=<s:property value="temporadaseleccionada"/>',
        			boxid:'frameless',
        			width:full_window_width-300,
        			height:full_window_height-250,
        			fixed:true,
        			maskid:'bluemask',
					maskopacity:40
       			})
    		});
		});
        </script>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:property value="#title"/></h1>
	<s:actionerror />
    <s:actionmessage />
    <s:form action="ingresarEquipo" method="post" >
    	<input id="buscarEquipo" type="button" value="Buscar Equipo"/>
    	<br>
		<s:hidden key="label.temporada" name="temporadaseleccionada" readonly="true"/>
		<br>
    	<s:textfield id="nombreEquipo" key="equipoForm.nombre" name="nombreEquipo"/>
    	<br>
    	<s:hidden id="idEquipo" key="equipoForm.idEquipo" name="equiposeleccionado"/>
    	<br>
    	<br>
    	<s:textfield id="nombreManager" key="equipoForm.nombreManager" name="managerequipo"/>
    	<br>
    	<s:submit value="Entrar a temporada"></s:submit>
    </s:form>
     <s:form action="submenuTemporadas" >
			<s:submit value="Regresar" targets="submenuEquipos"/>
	</s:form>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>