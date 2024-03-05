package productosSupermercado.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import productosSupermercado.entidades.Categoria;

public class ControladorCategoria {
	public static List<Categoria> findAll() {
		List<Categoria> lista = new ArrayList<Categoria>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from categoria");
			
			while (rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				lista.add(c);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}
}
