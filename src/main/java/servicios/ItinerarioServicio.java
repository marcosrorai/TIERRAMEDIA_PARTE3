package servicios;

import java.util.List;

import modelos.Producto;
import modelos.Usuario;

public class ItinerarioServicio {
	
	public List<Producto> list(Usuario usuario) {
		return usuario.getMiItinerario();
		
	}

}
