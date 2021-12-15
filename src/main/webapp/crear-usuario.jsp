<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
	<!-- HEADER SECTION -->
	<jsp:include page="partials/header.jsp"></jsp:include>

	<main class="container">

		<c:if test="${tmp_user != null && !tmp_user.esValido()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear el usuario.</p>
			</div>
		</c:if>

		<form action="/torre/crear-usuario.do" method="post">
			<jsp:include page="/form-usuario.jsp"></jsp:include>
		</form>
	</main>
	<!-- FOOTER -->
	<jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>