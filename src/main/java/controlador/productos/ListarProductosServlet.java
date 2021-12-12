package controlador.productos;

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
import modelos.ProductosPorPreferencia;
import modelos.Usuario;
import servicios.ProductoServicio;

@WebServlet("/listado.do")
public class ListarProductosServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private ProductoServicio productoServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.productoServicio = new ProductoServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Producto> productos = productoServicio.list();
		Usuario usuario = (Usuario) req.getSession().getAttribute("user");
		
		productos.sort(new ProductosPorPreferencia(usuario.getPreferencia()));
		req.setAttribute("productos", productos);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
		dispatcher.forward(req, resp);

	}

}
