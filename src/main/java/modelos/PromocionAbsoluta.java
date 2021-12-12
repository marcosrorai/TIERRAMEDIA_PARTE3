package modelos;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones,
			double costoPaquete, int id) {
		super(nombre, tipo, atracciones);
		this.costo = costoPaquete;
		this.id = id;
	}

}
