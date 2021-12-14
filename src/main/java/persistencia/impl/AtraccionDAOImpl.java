package persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelos.Atraccion;
import modelos.TipoDeAtraccion;
import persistencia.AtraccionDAO;
import persistencia.comunes.ConnectionBBDD;
import persistencia.comunes.MissingDataException;

public class AtraccionDAOImpl implements AtraccionDAO {

	@Override
	public List<Atraccion> getAll() {
		try {
			String sql = "SELECT * FROM ATRACCIONES";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();

			while (resultado.next()) {
				atracciones.add(toAtraccion(resultado));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet resultado) {
		try {
			return new Atraccion(resultado.getString(2), resultado.getInt(3), resultado.getInt(4),
					TipoDeAtraccion.valueOf(resultado.getString(5)), resultado.getInt(6), resultado.getInt(1));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public void update(Atraccion atraccion) {
		try {
			String sql = "UPDATE atracciones SET nombre= ?, costo= ?, duracion= ?, tipo_atraccion= ? ,cupo = ? WHERE nombre = ?";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, atraccion.getCosto());
			statement.setDouble(2, atraccion.getDuracion());
			statement.setString(3, atraccion.getTipo().toString());
			statement.setInt(4, atraccion.getCupo());
			statement.setInt(5, atraccion.getId());
			statement.executeUpdate();
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Atraccion find(Integer id) {
		try {
			String sql = "SELECT * FROM ATRACCIONES WHERE id = ?";
			Connection conn = ConnectionBBDD.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Atraccion atraccion = null;
			if (resultados.next()) {
				atraccion = toAtraccion(resultados);
			}

			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Atraccion atraccion) {
		try {
			String sql = "INSERT INTO ATRACCIONES (NOMBRE, COSTO, DURACION, TIPO_ATRACCION, CUPO) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionBBDD.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, atraccion.getNombre());
			statement.setDouble(i++, atraccion.getCosto());
			statement.setDouble(i++, atraccion.getDuracion());
			statement.setString(i++, atraccion.getTipo().toString());
			statement.setInt(i++, atraccion.getCupo());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "UPDATE ATRACCIONES SET BORRADO = ? WHERE ID = ?";
			Connection conn = ConnectionBBDD.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, 1);
			statement.setInt(2, id);
			statement.executeUpdate();

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
