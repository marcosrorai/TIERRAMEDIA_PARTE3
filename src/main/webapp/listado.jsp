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
		<h1>Tu tipo de atracción preferida es: ${user.preferencia}</h1>
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
				<a href="/torre/crear-atraccion.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva Atracción
				</a>
			</div>
		</c:if>
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Producto</th>
					<th>Tipo</th>
					<th>Costo</th>
					<th>Duración</th>
					<th>Cupo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productos}" var="producto">
					<tr>
						<td><strong><c:out value="${producto.nombre}"></c:out></strong>
						</td>
						<td><c:out value="${producto.tipo}"></c:out></td>
						<td><c:out value="${producto.costo}"></c:out></td>
						<td><c:out value="${producto.duracion}"></c:out></td>
						<td><c:if test="${producto.hayCupo()}"><c:out
                                 value= "Hay cupo"></c:out>
                                </c:if><c:choose><c:when test="${!producto.hayCupo()}"><c:out
                                 value= "No hay cupo"></c:out>
                                </c:when></c:choose>
                                </td>

						<td><c:if test="${user.admin}">
								<a href="/torre/editar-atraccion.do?id=${producto.id}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i>Editar</a>
								<a href="/torre/delete.do?id=${producto.id}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill">Eliminar</i></a>
							</c:if> <c:choose>
								<c:when
									test="${user.tieneDinero(producto) && user.tieneTiempo(producto) && producto.hayCupo() && user.productoNoComprado(producto)}">

									<a
										href="/torre/buy.do?id=${producto.id}&esPromo=${producto.esPromo()}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:when
								test="${!user.productoNoComprado(producto)}">

								<a href="#" class="btn btn-secondary rounded disabled"
										role="button">¡Ya lo compraste!</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<!-- FOOTER -->
	<jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>