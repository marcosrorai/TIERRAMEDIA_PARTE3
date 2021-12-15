<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
	<!-- HEADER SECTION -->
	<jsp:include page="partials/header.jsp"></jsp:include>

	<!-- MAIN SECTION -->
	<main>
		<!-- Product -->
		<section class="product-section">
			<div class="product-container content-wrapper">
				<div class="product-content">
					<div class="product-image">
						<img src="/torre/assets/img/product.png" alt="product" />
					</div>
					<div class="product-box">
						<div class="product-description">
							<h1>${producto.nombre}</h1>
							<h1>${user.nombre}</h1>
							<p>Tipo ${producto.tipo} Tipo ${producto.duracion}</p>
							<p>
								<c:if test="${producto.esPromo()}">
                                    Atracciones que incluye : ${producto.obtenerNombreAtraccionesDeLista() }

                                </c:if>
							</p>
						</div>
						<div class="product-buy">
							<h2>${producto.costo }</h2>
							<div class="product-buttons">
								<a href="#" class="button-1">buy now</a> <a href="#"
									class="ri-heart-line button-2"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<!-- FOOTER -->
	<jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>