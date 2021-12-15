package servicios;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelos.Atraccion;
import modelos.Producto;
import modelos.Promocion;
import modelos.Usuario;
import modelos.nullobjects.NullUser;
import persistencia.AtraccionDAO;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;
import persistencia.impl.PromocionDAOImpl;

public class LoginService {
	public Usuario login(String username) throws SQLException {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		List<Producto> productos = new LinkedList<Producto>();
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		List<Atraccion> atracciones = atraccionDAO.getAll();
		PromocionDAOImpl promocionDAO = new PromocionDAOImpl();
		List<Promocion> promociones = promocionDAO.getAllPromo(atracciones);

		productos.addAll(atracciones);
		productos.addAll(promociones);
		
		Usuario user = userDao.getNombre(username, productos);
    	
    	if (user.isNull()) {
    		user = NullUser.build();
    	}
    	return user;
	}
}
