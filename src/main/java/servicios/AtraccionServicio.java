package servicios;

import java.util.List;

import modelos.Atraccion;

import persistencia.AtraccionDAO;
import persistencia.comunes.DAOFactory;

import modelos.TipoDeAtraccion;

public class AtraccionServicio {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().getAll();
	}

	public Atraccion create(String name, Double cost, Double duration, String tipo, Integer capacity) {

		Atraccion attraction = new Atraccion(name, cost, duration, (TipoDeAtraccion.valueOf(tipo)), capacity, -1);

		if (attraction.esValida()) {
			AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
			attractionDAO.insert(attraction);

		}

		return attraction;
	}

	public Atraccion update(Integer id, String name, Double cost, Double duration, String tipo, Integer capacity) {

		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		Atraccion attraction = attractionDAO.find(id);

		attraction.setNombre(name);
		attraction.setCosto(cost);
		attraction.setDuracion(duration);
		attraction.setTipo(TipoDeAtraccion.valueOf(tipo));
		attraction.setCupo(capacity);

		if (attraction.esValida()) {
			attractionDAO.update(attraction);

		}

		return attraction;
	}

	public void delete(Integer id) {
		Atraccion attraction = new Atraccion(null, 0, 0, null, 0, id);

		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		attractionDAO.delete(attraction);
	}

	public Atraccion find(Integer id) {
		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		return attractionDAO.find(id);
	}
}
