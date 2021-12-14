package servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Atraccion;
import modelos.Producto;
import modelos.Promocion;
import modelos.Usuario;
import persistencia.AtraccionDAO;
import persistencia.PromocionDAO;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;

public class ComprarProductoServicio {
	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
	UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();

	public Map<String, String> buy(Integer userId, Integer productoId, Boolean esPromo, List<Atraccion> atracciones) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = userDAO.find(userId);
		if (esPromo) {

			Producto producto = promocionDAO.findPromo(productoId, atracciones);
			if (!producto.hayCupo()) {
				errors.put("producto", "No hay cupo disponible");
			}
			if (!user.tieneDinero(producto)) {
				errors.put("user", "No tienes dinero suficiente");
			}
			if (!user.tieneTiempo(producto)) {
				errors.put("user", "No tienes tiempo suficiente");
			}

			if (errors.isEmpty()) {
				user.addProducto(producto);
				user.descontarDinero(producto);
				user.descontarTiempo(producto);
				producto.descontarCupo();
				Promocion prodPromo = (Promocion) producto;
				promocionDAO.update(prodPromo);
				userDAO.update(user);
			}}

		else  {
				Producto producto = attractionDAO.find(productoId);
				if (!producto.hayCupo()) {
					errors.put("producto", "No hay cupo disponible");
				}
				if (!user.tieneDinero(producto)) {
					errors.put("user", "No tienes dinero suficiente");
				}
				if (!user.tieneTiempo(producto)) {
					errors.put("user", "No tienes tiempo suficiente");
				}

				if (errors.isEmpty()) {
					user.addProducto(producto);
					user.descontarDinero(producto);
					user.descontarTiempo(producto);
					producto.descontarCupo();
					Atraccion prodAtraccion = (Atraccion) producto;
					attractionDAO.update(prodAtraccion);
					userDAO.update(user);
				}
			}


		return errors;

	}

}
