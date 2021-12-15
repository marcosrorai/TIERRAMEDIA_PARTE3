package persistencia;

import java.util.LinkedList;
import java.util.List;

import modelos.Atraccion;
import modelos.Producto;
import modelos.Promocion;
import modelos.Usuario;
import persistencia.comunes.GenericDAO;



public interface UsuarioDAO extends GenericDAO<Usuario> {

	void insertarItinerario(Usuario usuario, LinkedList<Producto> productos);
	
	void insertarAtraccion(Usuario usuario, Atraccion atraccion);
	
	void insertarPromocion(Usuario usuario, Promocion promo);

	List<Usuario> getAll(List<Producto> productos);

	public abstract Usuario getNombre(String username, List<Producto> productos);

	Usuario find(Integer id, List<Producto> productos);

	

	
	
	
}

