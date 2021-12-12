package modelos;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class Promocion extends Producto {
	LinkedList<Atraccion> atracciones;
	protected int id;

	public Promocion(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.atracciones = atracciones;
		this.calcularDuracion();
	}

	public LinkedList<String> obtenerNombreAtraccionesDeLista() {
		LinkedList<String> atraccionesQueIncluye = new LinkedList<String>();
		for (Atraccion atraccion : atracciones) {
			atraccionesQueIncluye.add(atraccion.getNombre());
		}
		return atraccionesQueIncluye;
	}
	

	public int getId() {
		return id;
	}
	public LinkedList<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	@Override
	public boolean contiene(Producto prod) {
		boolean contiene = false;
		Iterator<Atraccion> itr = this.atracciones.iterator();
		while (!contiene && itr.hasNext()) {
			contiene = prod.contiene(itr.next());
		}
		return contiene;
	}

	public void calcularDuracion() {
		for (Atraccion atraccion : atracciones) {
			this.duracion += atraccion.duracion;
		}
	}
	
	public boolean hayCupo() {
		boolean hayCupo = true;
		Iterator<Atraccion> itr = this.atracciones.iterator();
		while (hayCupo && itr.hasNext()) {
			hayCupo = itr.next().hayCupo();

		}
		return hayCupo;
	}

	public void descontarCupo()  {
		for (Atraccion atraccion : atracciones) {
			atraccion.descontarCupo();
		}
	}
	


	@Override
	public boolean esPromo() {
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", Incluye: " + obtenerNombreAtraccionesDeLista();
	}

	

	
	
	
}