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
        <table class="borderAll">
            <tr>
                <th><s:text name="alumnoForm.boletaAlumno"/></th>
                <th><s:text name="alumnoForm.nombrePila"/></th>
                <th><s:text name="alumnoForm.apellidoPat"/></th>
                <th><s:text name="alumnoForm.apellidoMat"/></th>
                <th><s:text name="alumnoForm.semestre"/></th>
                <th><s:text name="alumnoForm.curp"/></th>
                <th><s:text name="alumnoForm.nss"/></th>
                <th><s:text name="alumnoForm.telefono"/></th>
                <th><s:text name="alumnoForm.telEmergencia"/></th>
                <th><s:text name="alumnoForm.correo"/></th>	
                <th><s:text name="alumnoForm.idEscuela"/></th>	
                <th>&nbsp;</th>
            </tr>
            <s:iterator value="alumnosRegistrado" status="status">
                <tr>
                    <td class="nowrap"><s:property value="boletaAlumno"/></td>
                    <td class="nowrap"><s:property value="nombrePila"/></td>
                    <td class="nowrap"><s:property value="apellidoPat"/></td>
                    <td class="nowrap"><s:property value="apellidoMat"/></td>
                    <td class="nowrap"><s:property value="semestre"/></td>
                    <td class="nowrap"><s:property value="curp"/></td>
                    <td class="nowrap"><s:property value="nss"/></td>
                    <td class="nowrap"><s:property value="telefono"/></td>
                    <td class="nowrap"><s:property value="telEmergencia"/></td>
                    <td class="nowrap"><s:property value="correo"/></td>
                    <td class="nowrap"><s:property value="escuela.nombreCortoEscuela"/></td>
                </tr>
            </s:iterator>
        </table>
        
        <s:form action="submenuAlumnos" >
			<s:submit value="Regresar" targets="submenuAlumnos"/>
		</s:form>
    </body>
</html>
