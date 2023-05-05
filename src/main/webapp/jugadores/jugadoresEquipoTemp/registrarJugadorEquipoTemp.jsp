<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
    <head>
    	<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
    	<link href="<s:url value='/css/sexyalertbox.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <title><s:text name="label.registrados.titulo"/></title>

        <script src="<s:url value='/js/jquery-3.6.4.min.js'/>"></script>
        <!-- Script Sexyalertbox -->
        <script src="<s:url value='/js/sexyalertbox.v1.2.jquery.js'/>"></script>
        <!-- Script Jquery easing (Animaciones, usado por sexyalert) -->
        <script src="<s:url value='/js/jquery.easing.1.3.js'/>"></script>
        
        <script>
        	//Inician metodos JQuery
	        $(document).ready(function(){
				
				$("#cerrarVentana").click(function(){
					window.parent.TINY.box.hide();
    			}); 
    			
    			$("#aceptarSeleccion").click(function(){
    			
    				var jugadoresARegistrar = "";
    			
    				$("input:checkbox[name='jugador']:checked").each(function(){
					    jugadoresARegistrar = jugadoresARegistrar + $(this).val() + "_";
					});
					if(jugadoresARegistrar.length<1){
						Sexy.error("Debe seleccionar al menos un jugador");
					}else{
						window.parent.TINY.box.hide();
						window.parent.registrarJugadores(jugadoresARegistrar);
					}
    			}); 
	        });
        </script>
    </head>
    <body>
        <div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.registrados.titulo"/></h1>
        <br/><br/>
        <s:actionerror />
        <s:actionmessage />
        <table class="borderAll">
            <tr>
                <th><s:text name="form.jugadoresEquipo.alumno.boletaAlumno"/></th>
                <th><s:text name="form.jugadoresEquipo.alumno.nombreAlumno"/></th>
                <th><s:text name="form.jugadoresEquipo.posicionPrim"/></th>
                <th><s:text name="form.jugadoresEquipo.posicionSec"/></th>
                <th><s:text name="label.esJugadorActivo"/></th>
                <th>&nbsp;</th>
            </tr>
            <s:iterator value="form.jugadoresEquipo" status="status">
                <tr>
                    <td class="nowrap"><s:property value="alumno.boletaAlumno"/></td>
                    <td class="nowrap"><s:property value="alumno.nombrePila"/> <s:property value="alumno.apellidoPat"/> <s:property value="alumno.apellidoMat"/></td>
                    <td class="nowrap"><s:property value="posicionPrim"/></td>
                    <td class="nowrap"><s:property value="posicionSec"/></td>
                    <td class="nowrap" align="center">
        				<s:if test="fechaAlta != null">
        					<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
        				</s:if>
        				<s:else>
        					<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
        				</s:else>
        			</td>
                    <td class="nowrap">
                    	<s:if test="fechaAlta != null">
                    		<input type="checkbox" name="jugador" id="<s:property value="idJugador"/>" value="<s:property value="idJugador"/>"/>
                    	</s:if>
                    </td>
                </tr>
            </s:iterator>
        </table>
        
        <input id="cerrarVentana" type="button" value="Cerrar"/>
        <input id="aceptarSeleccion" type="button" value="Aceptar"/>
        <input id="LimiparVentana" type="button" value="Limpiar"/>
    </body>
</html>
