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
                <h1>attraction title</h1>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit.
                  Voluptas modi assumenda numquam soluta pariatur necessitatibus
                  cupiditate iure veritatis officia doloribus.
                </p>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam
                  dolorem cum enim totam sed facilis illum. Itaque voluptate
                  nihil nisi!
                </p>
              </div>
              <div class="product-buy">
                <h2>$999.00</h2>
                <div class="product-buttons">
                  <a href="#" class="button-1">buy now</a>
                  <a href="#" class="ri-heart-line button-2"></a>
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