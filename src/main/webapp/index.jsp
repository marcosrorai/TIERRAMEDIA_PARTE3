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
     <!-- Banner -->
     <section class="banner-section">
       <div class="blur">
         <div class="banner-container content-wrapper">
           <span class="ri-arrow-left-s-line"></span>
           <h2>banner one</h2>
           <span class="ri-arrow-right-s-line"></span>
         </div>
       </div>
     </section>

     <!-- Spotlight -->
     <section class="spotlight-section">
       <div class="spotlight-container content-wrapper">
         <div class="spotlight-title">
           <h2>Spotlight</h2>
         </div>
         <div class="spotlight-content">
           <div class="card">
             <div class="image-content">
               <img src="../torre/assets/img/frodo.png" alt="image-example" />
             </div>
             <div class="card-info">
               <h3>title here</h3>
               <p>
                 Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet,
                 nemo!
               </p>
             </div>
           </div>
           <div class="card">
             <div class="image-content">
               <img src="../torre/assets/img/frodo.png" alt="image-example" />
             </div>
             <div class="card-info">
               <h3>title here</h3>
               <p>
                 Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet,
                 nemo!
               </p>
             </div>
           </div>
           <div class="card">
             <div class="image-content">
               <img src="../torre/assets/img/frodo.png" alt="image-example" />
             </div>
             <div class="card-info">
               <h3>title here</h3>
               <p>
                 Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet,
                 nemo!
               </p>
             </div>
           </div>
         </div>
       </div>
     </section>

     <!-- Attraction -->
     <section class="attraction-section">
       <div class="blur-attraction">
         <div class="attraction-container content-wrapper">
           <h2>atracciones</h2>
           <a class="button" href="#">Ver más</a>
         </div>
       </div>
     </section>

     <!-- More to explore -->
     <section class="spotlight-section spotlight-alt">
       <div class="spotlight-container content-wrapper">
         <div class="spotlight-title">
           <h2>More to explore</h2>
         </div>
         <div class="spotlight-content">
           <div class="card">
             <div class="image-content">
               <img src="../torre/assets/img/frodo.png" alt="image-example" />
             </div>
             <div class="card-info">
               <h3>title here</h3>
               <p>
                 Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet,
                 nemo!
               </p>
             </div>
           </div>
           <div class="card">
             <div class="image-content">
               <img src="../torre/assets/img/frodo.png" alt="image-example" />
             </div>
             <div class="card-info">
               <h3>title here</h3>
               <p>
                 Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet,
                 nemo!
               </p>
             </div>
           </div>
           <div class="card">
             <div class="image-content">
               <img src="../torre/assets/img/frodo.png" alt="image-example" />
             </div>
             <div class="card-info">
               <h3>title here</h3>
               <p>
                 Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet,
                 nemo!
               </p>
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