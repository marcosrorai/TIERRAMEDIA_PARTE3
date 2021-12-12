package persistencia;

import java.util.LinkedList;
import java.util.List;

import modelos.Producto;
import modelos.Usuario;
import persistencia.comunes.GenericDAO;


public interface UsuarioDAO extends GenericDAO<Usuario> {

	void insertarItinerario(Usuario usuario, LinkedList<Producto> productos);

	List<Usuario> getAll(List<Producto> productos);

	public abstract Usuario getNombre(String username);
	
	
}

