package controlador.atracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Atraccion;
import servicios.AtraccionServicio;

@WebServlet("/editar-atraccion.do")
public class EditarAtraccionServlet extends HttpServlet {


	private static final long serialVersionUID = 4602136213023734616L;
	private AtraccionServicio atraccionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionServicio = new AtraccionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion attraction = atraccionServicio.find(id);
		req.setAttribute("attraction", attraction);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/editar-atraccion.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Double cost = Double.parseDouble(req.getParameter("cost"));
		Double duration = Double.parseDouble(req.getParameter("duration"));
		String tipo = req.getParameter("tipo");
		Integer capacity = Integer.parseInt(req.getParameter("capacity"));

		Atraccion attraction = atraccionServicio.update(id, name, cost, duration, tipo, capacity);

		if (attraction.esValida()) {
			resp.sendRedirect("/torre/listado.do");
		} else {
			req.setAttribute("attraction", attraction);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/editar-atraccion.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
