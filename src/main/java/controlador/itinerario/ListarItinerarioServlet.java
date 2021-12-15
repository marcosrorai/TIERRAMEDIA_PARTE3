package controlador.itinerario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Producto;
import modelos.Usuario;
import servicios.ItinerarioServicio;


@WebServlet("/itinerario.do")
public class ListarItinerarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7362660563685945166L;
	private ItinerarioServicio itinerarioServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioServicio = new ItinerarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("user");
		List<Producto> itinerario = itinerarioServicio.list(usuario);
		
		
		req.setAttribute("itinerario", itinerario);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/itinerario.jsp");
		dispatcher.forward(req, resp);

	}

}
