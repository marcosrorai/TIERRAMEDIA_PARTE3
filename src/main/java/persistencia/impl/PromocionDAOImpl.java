package persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import modelos.Atraccion;
import modelos.Promocion;
import modelos.PromocionAXB;
import modelos.PromocionAbsoluta;
import modelos.PromocionInvalida;
import modelos.PromocionPorcentual;
import modelos.TipoDeAtraccion;
import persistencia.PromocionDAO;
import persistencia.comunes.ConnectionBBDD;
import persistencia.comunes.MissingDataException;

public class PromocionDAOImpl implements PromocionDAO {

	public List<Promocion> getAllPromo(List<Atraccion> atracciones) {
		try {
			String sql = "SELECT * FROM promociones";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			List<Promocion> promociones = new LinkedList<Promocion>();

			while (resultado.next()) {
				promociones.add(toPromocion(resultado, atracciones));

			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public static Promocion toPromocion(ResultSet resultado, List<Atraccion> atracciones) throws PromocionInvalida {
		try {
		String tipoPromo = (resultado.getString(3));
			if (tipoPromo.equals("Absoluta")) {
				return crearAbsoluta(resultado, atracciones);
			} else if (tipoPromo.equals("Porcentual")) {
				return crearPorcentual(resultado, atracciones);
			} else if (tipoPromo.equals("AXB")) {
				return crearAXB(resultado, atracciones);
			} else
				throw new PromocionInvalida("Tipo de promocion invalido");
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static LinkedList<Atraccion> atraccionesQueIncluye(String nombrePromo, List<Atraccion> atracciones) {
		try {
			String sql = "SELECT atracciones.nombre\r\n"
					+ "FROM atracciones\r\n"
					+ "JOIN atracciones_promociones on atracciones_promociones.atraccion_id=atracciones.id\r\n"
					+ "JOIN promociones on promociones.id = atracciones_promociones.promocion_id\r\n"
					+ "WHERE promociones.nombre ='"+ nombrePromo
					+ "'";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			LinkedList<Atraccion> atraccIncluidas = new LinkedList<Atraccion>();

			while (resultado.next()) {
				atraccIncluidas.add(obtenerAtraccionPorNombre(resultado.getString(1), atracciones));
			}
			return atraccIncluidas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static Promocion crearAbsoluta(ResultSet resultado, List<Atraccion> atracciones) {
		try {
			int id = resultado.getInt(1);
			String nombre = resultado.getString(2);
			Double costoPaquete = (double) resultado.getInt(4);
			TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(resultado.getString(5));
			LinkedList<Atraccion> atraccionesIncluidas = atraccionesQueIncluye(nombre, atracciones);
			return new PromocionAbsoluta(nombre, tipo, atraccionesIncluidas, costoPaquete, id);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static Promocion crearPorcentual(ResultSet resultado, List<Atraccion> atracciones) {
		try {
			int id = resultado.getInt(1);
			String nombre = resultado.getString(2);
			Double descuento = (double) resultado.getInt(4);
			TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(resultado.getString(5));
			LinkedList<Atraccion> atraccionesIncluidas = atraccionesQueIncluye(nombre, atracciones);
			return new PromocionPorcentual(nombre, tipo, atraccionesIncluidas, descuento, id);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static Promocion crearAXB(ResultSet resultado, List<Atraccion> atracciones) {
		try {
			int id = resultado.getInt(1);
			String nombre = resultado.getString(2);
			TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(resultado.getString(5));
			Atraccion atraccionBonificada = obtenerAtraccionPorNombre((resultado.getString(6)), atracciones);
			LinkedList<Atraccion> atraccionesIncluidas = atraccionesQueIncluye(nombre, atracciones);
			return new PromocionAXB(nombre, tipo, atraccionesIncluidas, atraccionBonificada, id);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static Atraccion obtenerAtraccionPorNombre(String nombre, List<Atraccion> atracciones) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombre)) {
				return atraccion;
			}
		}
		return null; 
	}

	
	@Override
	public void update(Promocion promocion) {
		try {
			String sql = "UPDATE atracciones SET cupo = ? WHERE nombre = ?";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			for (Atraccion atraccion : promocion.getAtracciones()) {
				statement.setInt(1, atraccion.getCupo());
				statement.setString(2, atraccion.getNombre());
				statement.executeUpdate();
			}
			

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}
	@Override
	public List<Promocion> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public Promocion findPromo(Integer id, List<Atraccion> atracciones) {
        try {
            String sql = "SELECT * FROM PROMOCIONES WHERE id = ?";
            Connection conn = ConnectionBBDD.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultados = statement.executeQuery();

            Promocion promocion = null;
            if (resultados.next()) {
                promocion = toPromocion(resultados, atracciones);
            }

            return promocion;
        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

	@Override
	public Promocion find(Integer id) {
		try {
			String sql = "SELECT * FROM PROMOCIONES WHERE id = ?";
			Connection conn = ConnectionBBDD.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Promocion promocion = null;
			if (resultados.next()) {
				promocion = toPromocion(resultados, null);
			}

			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}

