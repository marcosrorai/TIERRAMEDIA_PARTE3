package controlador.usuarios;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
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
import servicios.UsuarioServicio;

@WebServlet("/usuarios.do")
public class ListarUsuariosServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3831368386232977028L;
	private UsuarioServicio usuarioServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioServicio = new UsuarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Atraccion> atracciones = DAOFactory.getAtraccionDAO().getAll();
		List<Producto> productos = new LinkedList<Producto>();
		productos.addAll(atracciones);
		PromocionDAOImpl promocionDAO = new PromocionDAOImpl();
		List<Promocion> promociones =  promocionDAO.getAllPromo(atracciones);
		productos.addAll(promociones);
		List<Usuario> usuarios = usuarioServicio.list(productos);
			
		req.setAttribute("usuarios", usuarios);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/usuarios.jsp");
		dispatcher.forward(req, resp);

	}

}
