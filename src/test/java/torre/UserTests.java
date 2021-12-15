package torre;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelos.Atraccion;
import modelos.Producto;
import modelos.TipoDeAtraccion;
import modelos.Usuario;
import persistencia.impl.UsuarioDAOImpl;

public class UserTests {

	Atraccion Moria, Lothlorien;
	Usuario Eowyn, Gandalf;
	int nuevoPresupuesto = 200;
	double nuevoTiempo = 8;
	List<Producto> productos;
	

	@Before
	public void crear() {
		Eowyn = new Usuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA, 1);
		
		Gandalf = new Usuario("Gandalf", nuevoPresupuesto, nuevoTiempo, TipoDeAtraccion.PAISAJE, 1);

		Moria = new Atraccion("Moria", 10, 2, TipoDeAtraccion.AVENTURA, 6, 1);
		
		Lothlorien = new Atraccion("Lothlorien", 35, 1, TipoDeAtraccion.DEGUSTACION, 26, 7);
	}

	@Test
	public void atraccionCorrecta() {
		TipoDeAtraccion atraccionEsperada = TipoDeAtraccion.AVENTURA;
		assertEquals(atraccionEsperada, Eowyn.getPreferencia());
	}

	@Test
	public void comprarProducto() {
		int presupuestoEsp = 0;
		Eowyn.descontarDinero(Moria);
		assertEquals(presupuestoEsp, Eowyn.getPresupuesto(), 0);
	}

	@Test
	public void tiempoDisponible() {
		double tiempoDesponibleEsp = 6;
		Eowyn.descontarTiempo(Moria);
		assertEquals(tiempoDesponibleEsp, Eowyn.getTiempoDisponible(), 0);
	}
	
	
	@Test 
	public void actualizarPresupuestoYTiempoUsuario() throws SQLException {
		UsuarioDAOImpl usuario = new UsuarioDAOImpl();
		usuario.update(Gandalf); 
		assertEquals(nuevoPresupuesto, Gandalf.getPresupuesto(), 0);
	}

}