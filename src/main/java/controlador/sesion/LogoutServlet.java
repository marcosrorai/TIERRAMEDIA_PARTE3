package controlador.sesion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Usuario;
import servicios.LoginService;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = -2998663650450957515L;

	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.getSession().removeAttribute("user");
		req.setAttribute("flash", "¡Hasta pronto!");
		
		RequestDispatcher dispatcher = getServletContext()
  		      .getRequestDispatcher("/login.jsp");
  		    dispatcher.forward(req, resp); 	
    }
}