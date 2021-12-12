package controlador.usuarios;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Usuario;
import servicios.UsuarioServicio;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/users/create.do")
public class CrearUsuarioServlet extends HttpServlet {
	
		private static final long serialVersionUID = 3455721046062278592L;
		private UsuarioServicio usuarioServicio;

		@Override
		public void init() throws ServletException {
			super.init();
			this.usuarioServicio = new UsuarioServicio();
		}

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/users/create.jsp");
			dispatcher.forward(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String username = req.getParameter("username");
			Double coins = Double.parseDouble(req.getParameter("coins"));
			Double time = Double.parseDouble(req.getParameter("time"));
			String preferencia = req.getParameter("preferencia");

			Usuario tmp_user = usuarioServicio.create(username, coins, time, preferencia);
			
			if (tmp_user.esValido()) {
				resp.sendRedirect("/turismo/users/index.do");
			} else {
				req.setAttribute("tmp_user", tmp_user);

				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/users/create.jsp");
				dispatcher.forward(req, resp);
			}

		}

	}