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
		<h2><fmt:message key="listHeading"/></h2>
		<table>
			<tr><th>Cedula</th><th>Nombre</th><th>Titulo</th><th/><th/></tr>
			<c:forEach items="${model.profesores}" var="prof">
			<tr>
				<td><c:out value="${prof.idProf}"/></td>
				<td><c:out value="${prof.nombProf}"/></td>
				<td><c:out value="${prof.tituloProf}"/></td>
				<td>
					<a href="/profesor.htm?mode=detail&id=<c:out value="${prof.idProf}"/>">Editar</a>
				</td>
				<td>
					<a href="/profesor.htm?mode=delete&id=<c:out value="${prof.idProf}"/>">Eliminar</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<br/>
		<a href="/profesor.htm?mode=new">Registrar</a>
	</body>
</html>