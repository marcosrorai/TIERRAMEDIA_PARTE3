package modelos;

import java.util.HashMap;
import java.util.Map;

public class Atraccion extends Producto {

	private int cupo;
	private int id;
	private Map<String, String> errores;

	public Atraccion(String nombre, double costo, double duracion, TipoDeAtraccion tipo, int cupo, int id) {
		super(nombre, costo, duracion, tipo);
		this.cupo = cupo;
		this.id = id;
	}

	public boolean hayCupo() {
		return (this.getCupo() > 0);
	}
	
	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public void descontarCupo() {
		if (this.cupo <= 0) {
			System.out.println("no hay cupos disponibles");
		} else {
			this.cupo -= 1;
		}
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return super.toString() + ", Cupo: " + this.cupo + ".]\n";
	}

	@Override
	public boolean contiene(Producto producto) {
		if (producto.esPromo()) {
			return producto.contiene(this);
		}
		return this.equals(producto);
	}
	public boolean esValida() {
		validar();
		return errores.isEmpty();
	}
	
	public void validar() {
		errores = new HashMap<String, String>();

		if (costo <= 0) {
			errores.put("cost", "Debe ser positivo");
		}
		if (duracion <= 0) {
			errores.put("duration", "Debe ser positivo");
		}
		if (cupo <= 0) {
			errores.put("capacity", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrores() {
		return errores;
	}
	
	public void setId(Integer id) {
		this.id= id;
		
	}

}
