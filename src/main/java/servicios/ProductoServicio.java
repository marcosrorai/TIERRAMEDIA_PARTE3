package servicios;

import java.util.LinkedList;
import java.util.List;

import persistencia.impl.*;
import modelos.Producto;
import persistencia.AtraccionDAO;
import persistencia.comunes.DAOFactory;
import modelos.Atraccion;
import modelos.Promocion;


public class ProductoServicio {

	public List<Producto> list() {
		List<Producto> productos = new LinkedList<Producto>();
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		List<Atraccion> atracciones = atraccionDAO.getAll();
		PromocionDAOImpl promocionDAO = new PromocionDAOImpl();
		List<Promocion> promociones = promocionDAO.getAllPromo(atracciones);

		productos.addAll(atracciones);
		productos.addAll(promociones);
		return productos;
	}
	
	
}
