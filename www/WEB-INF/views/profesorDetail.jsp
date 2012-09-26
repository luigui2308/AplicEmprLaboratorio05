<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE>

<html>
	<head>
		<title><fmt:message key="title"/></title>
	</head>
	<body>
		<h1><fmt:message key="title"/></h1>
		<h2><fmt:message key="insertHeading"/></h2>
		<form name="frmUpdateProfesor" action="/profesor.htm" method="GET">
			<label>Cedula</label><br/>
			<input type="text" name="txtProfessorId" required="required" readonly="readonly" value="<c:out value="${model.idProf}"/>"/><br/>
			<label>Nombre</label><br/>
			<input type="text" name="txtProfessorName" required="required" value="<c:out value="${model.nombProf}"/>"/><br/>
			<label>Titulo</label><br/>
			<input type="text" name="txtProfessorGrade" required="required" value="<c:out value="${model.tituloProf}"/>"/><br/>
			<input type="hidden" name="mode" value="edit"/>
			<input type="submit" name="btnSubmit" value="Guardar"/>
		</form>
		<br/>
		<a href="/profesor.htm?mode=list">
			volver
		</a>
	</body>
</html>