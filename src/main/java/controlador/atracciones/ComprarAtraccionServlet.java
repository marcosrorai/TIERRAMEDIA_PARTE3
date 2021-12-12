package controlador.atracciones;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Usuario;
import persistencia.comunes.DAOFactory;
import servicios.ComprarAtraccionServicio;

@WebServlet("/attractions/buy.do")
	public class ComprarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = -1059387310981771796L;
		private ComprarAtraccionServicio comprarAtraccionServicio;

		@Override
		public void init() throws ServletException {
			super.init();
			this.comprarAtraccionServicio = new ComprarAtraccionServicio();
		}

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			Integer attractionId = Integer.parseInt(req.getParameter("id"));
			Usuario user = (Usuario) req.getSession().getAttribute("user");
			Map<String, String> errors = comprarAtraccionServicio.buy(user.getId(), attractionId);

			Usuario user2 = DAOFactory.getUsuarioDAO().find(user.getId());
			req.getSession().setAttribute("user", user2);

			if (errors.isEmpty()) {
				req.setAttribute("flash", "¡Gracias por comprar!");
			} else {
				req.setAttribute("errors", errors);
				req.setAttribute("flash", "No ha podido realizarse la compra");
			}

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/attractions/index.do");
			dispatcher.forward(req, resp);
		}
	}


