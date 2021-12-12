package modelos;

import java.util.LinkedList;

public class PromocionAXB extends Promocion {
	private Atraccion atraccionBonificada;

	public PromocionAXB(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones,
			Atraccion atraccionBonificada, int id) {
		super(nombre, tipo, atracciones);
		this.atraccionBonificada = atraccionBonificada;
		this.calcularCosto();
		this.duracion += atraccionBonificada.duracion;
		this.id = id;
	}

	@Override
	public boolean contiene(Producto prod) {

		return super.contiene(prod) || this.atraccionBonificada.contiene(prod);
	}
	

	@Override
	public boolean hayCupo() {

		return super.hayCupo() && atraccionBonificada.hayCupo();
	}

	public void descontarCupo() {
		super.descontarCupo();

		atraccionBonificada.descontarCupo();
	}
	
	@Override
	public LinkedList<Atraccion> getAtracciones() {
		LinkedList<Atraccion> atraccionesEnAXB = super.getAtracciones();
		atraccionesEnAXB.add(atraccionBonificada);
		return atraccionesEnAXB;
	}

	private void calcularCosto() {
		for (Atraccion atraccion : atracciones) {
			this.costo += atraccion.costo;
		}
	}

	@Override
	public String toString() {

		return super.toString() + ", y lleva de regalo: " + this.atraccionBonificada.getNombre() + "]";
	}
}
