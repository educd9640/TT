<jsp:include page="/bases/header.jsp"></jsp:include>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container rounded p-3 contenido">
<s:if test="operacion=='actualizado'">
	<s:set var="title" value="%{'Modificar Temporada'}"/>
</s:if>
<s:else>
    <s:set var="title" value="%{'Registro Temporadas'}"/>
</s:else>
        <script>
        	function settearDesdeModal(informacion){
        		var infoLiga = informacion.split("_");
        		document.getElementById("idLiga").value=infoLiga[0];
        		document.getElementById("nombre").value=infoLiga[1];
        	}
        </script>
        <script>
        $(document).ready(function(){

		  // jQuery methods go here...
			
			$("#buscarLiga").click(function(){
				var full_window_height = window.outerHeight;
				var full_window_width = window.outerWidth;
        		TINY.box.show({
        			iframe:'/ballscore/ligas/consultarLigasModal.action',
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
        <s:if test="hasActionErrors()">
		<div class="errors">
        <s:actionerror />
		</div>
		</s:if>
       
        <s:actionmessage />
        <s:form action="registrarTemporada" method="post">
        	
        	<s:if test="operacion=='actualizado'">
        		<s:hidden name="operacion" value="%{'actualizado'}"/>
        		<s:textfield key="temporadaF.idTemporada" readonly="true"/>        	
        	</s:if>
        	<s:else>
        		<s:hidden name="operacion" value="%{'registrado'}"/>
        	</s:else>
        
        
        	<s:textfield id="idLiga" key="temporadaF.liga.idLiga" readonly="true"/>
        	<input id="buscarLiga" type="button" value="Buscar Liga">
        	<s:textfield id="nombre" key="temporadaF.liga.nombre" readonly="true"/>
        	
        	<input type="date" id="fechaInicial" name="fechaInicial">
        	<input type="date" id="fechaFinal" name="fechaFinal">
        	
        	
        	
        	<s:if test="hasActionMessages() || hasActionErrors()">
				<s:submit value="%{getText('button.label.submit')}"/>
			</s:if>
			<s:else>
    			<s:submit value="%{getText('button.label.submit')}"/>
			</s:else>
        	
        </s:form>
        <s:form action="submenuTemporadas" >
			<s:submit value="Regresar" targets="submenuTemporadas"/>
		</s:form>
</div>
<jsp:include page="/bases/footer.jsp"></jsp:include>