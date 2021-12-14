<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<jsp:include page="/partials/HeadForms.jsp"></jsp:include>
</head>
<body>
	<!-- HEADER SECTION -->
	<jsp:include page="/partials/header.jsp"></jsp:include>

	<main class="container">

		<c:if test="${attraction != null && !attraction.esValida()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al actualizar la atracción.</p>
			</div>
		</c:if>

		<form action="/torre/editar-atraccion.do" method="post">
			<input type="hidden" name="id" value="${attraction.id}">
			<jsp:include page="/views/form-atraccion.jsp"></jsp:include>
		</form>
	</main>
	<!-- FOOTER -->
	<jsp:include page="/partials/footer.jsp"></jsp:include>
</body>
</html>
