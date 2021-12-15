<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<jsp:include page="partials/head.jsp"></jsp:include>
</head>


<body>
	<!-- HEADER SECTION -->
	<jsp:include page="partials/header.jsp"></jsp:include>
	<main class="container">
		
		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>
		<c:if test="${user.esAdmin()}">
			<div class="mb-3">
				<a href="/torre/crear-usuario.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nuevo Usuario
				</a>
			</div>
		</c:if>
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Usuario</th>
					<th>Presupuesto</th>
					<th>Tiempo disponible</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td><strong><c:out value="${usuario.nombre}"></c:out></strong>
						</td>
						<td><c:out value="${usuario.presupuesto}"></c:out></td>
						<td><c:out value="${usuario.tiempoDisponible}"></c:out></td>
						
						
						<td><c:if test="${user.admin}">
								<a href="/torre/editar-atraccion.do?id=${producto.id}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i>Editar</a>
								<a href="/torre/delete.do?id=${producto.id}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill">Eliminar</i></a>
							</c:if> 
										</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<!-- FOOTER -->
	<jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>