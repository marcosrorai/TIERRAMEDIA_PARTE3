package modelos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import persistencia.AtraccionDAO;
import persistencia.comunes.DAOFactory;
import persistencia.impl.PromocionDAOImpl;
import persistencia.UsuarioDAO;

public class Parque {

	private static List<Usuario> usuarios;
	private static List<Producto> productos = new LinkedList<Producto>();

	public Parque() throws Exception {
		this.crearListas();
	}

	private void crearListas() throws Exception {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		List<Atraccion> atracciones = atraccionDAO.getAll();

		PromocionDAOImpl promocionDAO = new PromocionDAOImpl();
		List<Promocion> promociones = promocionDAO.getAllPromo(atracciones);

		productos.addAll(atracciones);
		productos.addAll(promociones);

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarios = usuarioDAO.getAll(productos);

	}

	public void ofrecerProductos() throws Exception {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		PromocionDAOImpl promocionDAO = new PromocionDAOImpl();
		for (Usuario usuario : usuarios) {
			productos.sort(new ProductosPorPreferencia(usuario.getPreferencia()));
			System.out.println("¡Hola " + usuario.getNombre() + "! Tienes " + usuario.getPresupuesto() + " monedas, "
					+ usuario.getTiempoDisponible() + " horas disponibles y siempre prefieres "
					+ usuario.getPreferencia() + ".\n¡Reserva tus paseos!\n");

			char respuesta;

			for (Producto oferta : productos) {
				boolean contiene = false;
				Iterator<Producto> itr = usuario.getMiItinerario().iterator();
				while (!contiene && itr.hasNext()) {
					contiene = oferta.contiene(itr.next());
				}

				if ((!contiene) && usuario.getPresupuesto() >= oferta.getCosto()
						&& usuario.getTiempoDisponible() >= oferta.getDuracion() && oferta.hayCupo()) {
					Scanner aceptacionOferta = new Scanner(System.in);

					System.out.println("Ingrese S para aceptar o N para seguir viendo otras ofertas de atracciones");
					System.out.println(oferta);

					respuesta = aceptacionOferta.next().charAt(0);
					while (!(respuesta == 's') && !(respuesta == 'n')) {
						System.out.println("opcion invalida");
						respuesta = aceptacionOferta.next().charAt(0);

					}
					if (respuesta == 's') {
						usuario.addProductoComprado(oferta);
						usuario.descontarDinero(oferta);
						usuario.descontarTiempo(oferta);
						oferta.descontarCupo();
						if (oferta.esPromo() == false) {
							Atraccion ofertaAtraccion = (Atraccion) oferta;
							atraccionDAO.update(ofertaAtraccion);

						} else if (oferta.esPromo()) {
							Promocion ofertaPromo = (Promocion) oferta;
							promocionDAO.update(ofertaPromo);
						}
						System.out.println("Ya has reservado: " + usuario.getMiItinerario());

					}

				}

			}
			System.out.println(usuario.getMiItinerario());
			usuarioDAO.update(usuario);
			usuarioDAO.insertarItinerario(usuario, usuario.getMiItinerario());

		}

	}

}
