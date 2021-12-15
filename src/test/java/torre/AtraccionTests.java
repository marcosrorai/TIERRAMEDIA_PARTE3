package torre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelos.Atraccion;
import modelos.PromocionPorcentual;
import modelos.TipoDeAtraccion;
import modelos.Usuario;
import persistencia.AtraccionDAO;
import persistencia.comunes.DAOFactory;
import persistencia.impl.AtraccionDAOImpl;

public class AtraccionTests {
	
	LinkedList<Atraccion> listaAtraccion;
	Atraccion Erebor, Mordor;
	Usuario Gandalf;
	PromocionPorcentual promo;
	int cambioCupo = 20;

	@Before
	public void crear() {
		Gandalf = new Usuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE, 1,0);
		
		Erebor = new Atraccion("Erebor", 12, 3, TipoDeAtraccion.PAISAJE, 32, 5);
		
		Mordor = new Atraccion("Mordor", 25, 3, TipoDeAtraccion.AVENTURA, cambioCupo, 4);

		listaAtraccion = new LinkedList<Atraccion>();
		listaAtraccion.add(Erebor);
		
		promo = new PromocionPorcentual("Promo", TipoDeAtraccion.PAISAJE, listaAtraccion, 20, 2);

	}
	
	@Test
	public void espacioDisponible() {
		Boolean cupoEsperado = true;
		assertEquals(cupoEsperado, promo.hayCupo());
	}
	
	@Test
	public void getAtracciones() {
		AtraccionDAOImpl atraccion = new AtraccionDAOImpl();
		assertTrue(atraccion.getAll().size() == 8);
	}
	
	@Test
	public void comprobarNombreAtraccion() {
		AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
		List<Atraccion> listaAtracciones = atraccionDao.getAll();
		
		assertEquals("Moria", listaAtracciones.get(0).getNombre());
		assertEquals("Mordor", listaAtracciones.get(3).getNombre());
	}
	
	@Test
	public void atraccionesNotNull() {
		AtraccionDAOImpl atraccion = new AtraccionDAOImpl();
		assertNotNull(atraccion.getAll());
	}
	
	@Test
	public void actualizarCupo() throws SQLException {
		AtraccionDAOImpl atraccion = new AtraccionDAOImpl();
		atraccion.update(Mordor);
		assertEquals(cambioCupo, Mordor.getCupo(), 0);		
	}
	
	
}
