package productosSupermercado.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import productosSupermercado.entidades.Producto;

public class ControladorProducto {
	public static List<Producto> findAllById(int id) {
		List<Producto> lista = new ArrayList<Producto>();

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from producto where idCategoria = " + id);

			while (rs.next()) {
				Producto p = new Producto();
				p.setId(rs.getInt("id"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setIdCategoria(rs.getInt("idCategoria"));
				p.setCodigo(rs.getString("codigo"));
				p.setPerecedero(rs.getBoolean("perecedero"));
				p.setFechaCaducidad(rs.getDate("fechaCaducidad"));
				p.setUnidadesStock(rs.getInt("unidadesStock"));
				lista.add(p);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return lista;
	}

	/**
	 * 
	 */

	public static int update(Producto p) {

		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement("update producto set descripcion = ?, codigo = ?, "
					+ "idCategoria = ?, perecedero = ?, fechaCaducidad = ?, unidadesStock = ? where id = ?");

			ps.setString(1, p.getDescripcion());
			ps.setString(2, p.getCodigo());
			ps.setInt(3, p.getIdCategoria());
			ps.setBoolean(4, p.getPerecedero());
			ps.setDate(5, new java.sql.Date(p.getFechaCaducidad().getTime()));
			ps.setInt(6, p.getUnidadesStock());
			ps.setInt(7, p.getId());

			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
