package servicios;


import java.util.List;

import modelos.Atraccion;
import modelos.TipoDeAtraccion;
import modelos.Usuario;
import persistencia.AtraccionDAO;
import persistencia.comunes.DAOFactory;

public class UsuarioServicio {
	

		//public List<Usuario> list() {
			//return DAOFactory.getUsuarioDAO().findAll();
		//}

		public Usuario create(String username, Double coins, Double time, String preferencia) {
			Usuario user = new Usuario(username, coins, time, TipoDeAtraccion.valueOf(preferencia), -1, false);
			

			if (user.esValido()) {
				DAOFactory.getUsuarioDAO().insert(user);
				
			}

			return user;
		}
}
