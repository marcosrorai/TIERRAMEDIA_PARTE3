<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
<body>
	<div class="content-wrapper main">
		<div class="header">
			<h1>tierra media</h1>
		</div>
		<div class="login">
			<div class="image-container">
				<img src="../torre/assets/img/Login.png" alt="Imagen login" />
			</div>
			<div class="login-container">
			<c:if test="${flash != null}">
					<div class="alert alert-danger">
						<p>
							<c:out value="${flash}" />
						</p>
					</div>
				</c:if><!--Restaurar al valor inicial al actualizar la pagina-->
				<div class="login-buttons-top">
					
				</div>
				<form action="login" method="post">
					<div class="login-content">
						<div class="login-input">
							<h2>usuario</h2>
							<label for="username" class="form-label"></label> <input
								class="form-control" name="username">
						</div>
						<div class="login-checkbox">
							
						</div>
						<div class="login-buttons-bottom">
							<button type="submit" class="button">Ingresar</button>
							<a class="member" href="#">Ya soy miembro</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>