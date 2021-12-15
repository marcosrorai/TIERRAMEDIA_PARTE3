package persistencia;

import java.util.List;

import modelos.Atraccion;
import modelos.Promocion;
import persistencia.comunes.GenericDAO;

public interface PromocionDAO extends GenericDAO<Promocion> {
	abstract public List<Promocion> getAllPromo(List<Atraccion> atracciones);
	Promocion findPromo(Integer id, List<Atraccion> atracciones);

}
