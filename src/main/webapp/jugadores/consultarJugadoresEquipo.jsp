<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
    <head>
    	<link href="<s:url value='/main.css'/>" rel="stylesheet" type="text/css"/>
        <s:head />
        <title><s:text name="label.registrados.titulo"/></title>
    </head>
    <body>
        <div class="titleDiv"><s:text name="application.title"/></div>
        <h1><s:text name="label.registrados.titulo"/></h1>
        <br/><br/>
        <s:actionerror />
        <s:actionmessage />
        <table class="borderAll">
            <tr>
                <th><s:text name="jugadoresForm.alumno.boletaAlumno"/></th>
                <th><s:text name="jugadoresForm.alumno.nombrePila"/></th>
                <th><s:text name="jugadoresForm.alumno.apellidoPat"/></th>
                <th><s:text name="jugadoresForm.alumno.apellidoMat"/></th>
                <th><s:text name="jugadoresForm.posicionPrim"/></th>
                <th><s:text name="jugadoresForm.posicionSec"/></th>
                <th><s:text name="label.estatus"/></th>	
                <th>&nbsp;</th>
            </tr>
            <s:iterator value="jugadoresRegistrados" status="status">
                <tr>
                    <td class="nowrap"><s:property value="alumno.boletaAlumno"/></td>
                    <td class="nowrap"><s:property value="alumno.nombrePila"/></td>
                    <td class="nowrap"><s:property value="alumno.apellidoPat"/></td>
                    <td class="nowrap"><s:property value="alumno.apellidoMat"/></td>
                    <td class="nowrap"><s:property value="posicionPrim"/></td>
                    <td class="nowrap"><s:property value="posicionSec"/></td>
                    <s:if test="%{fechaAlta!=null}">
						<td class="nowrap" style="text-align: center; vertical-align: middle;">
							<img width="15" height="15" src="<s:url value='/img/checked.png'/>">
						</td>
					</s:if>
                    <s:else>
                    	<td class="nowrap" style ="text-align: center; vertical-align: middle;">
                    		<img width="15" height="15" src="<s:url value='/img/cross.png'/>">
                    	</td>
                    </s:else>
                    <td class="nowrap">
                        <s:url action="modificarJugador" var="url" escapeAmp="false">
                            <s:param name="jugadoresForm.idJugador" value="idJugador"/>
                            <s:param name="operacion">actualizado</s:param>
                        </s:url>
                        <a href="<s:property value="#url"/>">Modificar</a>
                        &nbsp;&nbsp;&nbsp;
                        <s:if test="%{fechaAlta!=null}">
	                        <s:url action="alternarEstadoJugador" var="url">
	                            <s:param name="jugadoresForm.idJugador" value="idJugador"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Baja</a>
                        </s:if>
                        <s:else>
	                        <s:url action="alternarEstadoJugador" var="url">
	                            <s:param name="jugadoresForm.idJugador" value="idJugador"/>
	                        </s:url>
	                        <a href="<s:property value="#url"/>">Alta</a>
                        </s:else>
                    </td>
                </tr>
            </s:iterator>
        </table>
        
        <s:form action="submenuJugadores" >
			<s:submit value="Regresar" targets="submenuJugadores"/>
		</s:form>
    </body>
</html>
