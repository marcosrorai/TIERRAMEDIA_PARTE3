package servicios;

import java.util.HashMap;
import java.util.Map;

import modelos.Atraccion;
import modelos.Usuario;
import persistencia.AtraccionDAO;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;

public class ComprarAtraccionServicio {
	AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
	UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();

	public Map<String, String> buy(Integer userId, Integer attractionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = userDAO.find(userId);
		Atraccion attraction = attractionDAO.find(attractionId);

		if (!attraction.hayCupo()) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (user.tieneDinero(attraction)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (user.tieneTiempo(attraction)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.addProducto(attraction);
			user.descontarDinero(attraction);
			user.descontarTiempo(attraction);
			attraction.descontarCupo();

			attractionDAO.update(attraction);
			userDAO.update(user);
		}

		return errors;

	}

}
