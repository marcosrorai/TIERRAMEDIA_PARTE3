package controlador.productos;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Atraccion;
import modelos.Producto;
import modelos.Promocion;
import modelos.Usuario;
import persistencia.comunes.DAOFactory;
import persistencia.impl.PromocionDAOImpl;
import servicios.ComprarProductoServicio;

@WebServlet("/buy.do")
	public class ComprarProductoServlet extends HttpServlet {

	private static final long serialVersionUID = -1059387310981771796L;
		private ComprarProductoServicio comprarProductoServicio;

		@Override
		public void init() throws ServletException {
			super.init();
			this.comprarProductoServicio = new ComprarProductoServicio();
		}

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
			Integer productoId = Integer.parseInt(req.getParameter("id"));
			Boolean esPromo = Boolean.parseBoolean(req.getParameter("esPromo"));
			Usuario user = (Usuario) req.getSession().getAttribute("user");
			List<Atraccion> atracciones = DAOFactory.getAtraccionDAO().getAll();
			List<Producto> productos = new LinkedList<Producto>();
			productos.addAll(atracciones);
			PromocionDAOImpl promocionDAO = new PromocionDAOImpl();
			List<Promocion> promociones =  promocionDAO.getAllPromo(atracciones);
			productos.addAll(promociones);
			Map<String, String> errors = comprarProductoServicio.buy(user.getId(), productoId, esPromo, atracciones, productos);

			Usuario user2 = DAOFactory.getUsuarioDAO().find(user.getId(), productos);
			req.getSession().setAttribute("user", user2);

			if (errors.isEmpty()) {
				req.setAttribute("flash", "¡Gracias por comprar!");
			} else {
				req.setAttribute("errors", errors);
				req.setAttribute("flash", "No ha podido realizarse la compra");
			}

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.do");
			dispatcher.forward(req, resp);
		}
	}


