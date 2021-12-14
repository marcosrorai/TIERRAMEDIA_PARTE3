<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <nav class="nav-container">
      <div class="content-wrapper">
        <div class="nav-title">
          <div class="logo">Tierra Media</div>
        </div>
        <div class="nav-menu">
          <div class="action">
            <div class="profile" onclick="menuToggle();">
              <a class="ri-user-line" href="#"></a>
            </div>
            <div class="menu">
              <h3>${user.nombre}<br /><c:if test="${user.esAdmin()}"><span>Administrador</span></c:if></h3>
              <ul>
                <li>
                  <img src="/torre/assets/img/user.png" alt="user" /><a href="#"
                    >Monedas: ${user.presupuesto}</a
                  >
                </li>
                <li>
                  <img src="/torre/assets/img/edit.png" alt="edit" /><a href="#"
                    >Tiempo: ${user.tiempoDisponible}</a
                  >
                </li>
                <li>
                  <img src="/torre/assets/img/log-out.png" alt="log-out" /><a href="/torre/logout"
                    >Cerrar sesión</a
                  >
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </nav>
    
        <!-- Menu -->
    <div class="menu-container">
      <div class="wrapper content-wrapper">
        <nav>
          <input type="checkbox" id="show-search" />
          <input type="checkbox" id="show-menu" />
          <label for="show-menu" class="menu-icon"
            ><i class="fas fa-bars"></i
          ></label>
          <div class="content">
            <ul class="links">
              <li><a href="#">Atracciones</a></li>
              <li><a href="#">Promociones</a></li>
              <li><a href="/torre/listado.do">Comprar Boletos</a></li>
              <li><a href="#">Itinerario</a></li>
            </ul>
          </div>
         
          <form action="#" class="search-box">
            <input
              type="text"
              placeholder="Escribe algo para buscar..."
              required
            />
            <button type="submit" class="go-icon">
              <i class="fas fa-long-arrow-alt-right"></i>
            </button>
          </form>
        </nav>
      </div>
    </div>