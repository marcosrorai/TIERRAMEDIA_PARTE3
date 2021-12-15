package servicios;


import java.util.List;

import modelos.Atraccion;
import modelos.Producto;
import modelos.TipoDeAtraccion;
import modelos.Usuario;
import persistencia.AtraccionDAO;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;

public class UsuarioServicio {
	

		public List<Usuario> list(List<Producto> productos) {
			return DAOFactory.getUsuarioDAO().getAll(productos);
		}

		public Usuario create(String username, Double coins, Double time, String preferencia) {
			Usuario user = new Usuario(username, coins, time, (TipoDeAtraccion.valueOf(preferencia)), -1, false);
			

			if (user.esValido()) {
				UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
				usuarioDAO.insert(user);
				
			}

			return user;
		}
}
