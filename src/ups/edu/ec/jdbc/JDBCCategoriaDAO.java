package ups.edu.ec.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.CategoriaDAO;
import ups.edu.ec.modelo.Categoria;

/**
 * Clase JDBCCategoryDAO.
 * 
 * La clase JDBCCategoryDAO hereda los métodos y atributos de la clase abstracta
 * padre JDBCGenericDAO, así como también, implementa los métodos de la
 * interface CategoryDAO.
 * 
 * Teniendo de esta manera una clase específica que gestionara la persistencia a
 * la base de datos del modelo Category
 * 
 *
 * @see JDBCGenericDAO
 * @see CategoryDAO
 * @see Category
 * 
 * @version 1.0
 */
public class JDBCCategoriaDAO extends JDBCGenericDAO<Categoria, Integer> implements CategoriaDAO {

	@Override
	public void createTable() {
		
	}

	@Override
	public void create(Categoria categoria) {
		conexionUno.update("INSERT Categoria VALUES (" + categoria.getId() + ", " + categoria.getNombre());
		
	}

	@Override
	public Categoria read(Integer id) {
		Categoria categoria = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Categoria WHERE id=" + id);
		try {
			if (rs != null && rs.next()) {
				categoria = new Categoria(rs.getInt("id"), rs.getString("nombre"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:read): " + e.getMessage());
		}

		return categoria;
	}

	@Override
	public void update(Categoria categoria) {
		conexionUno.update("UPDATE Category SET name = '" + categoria.getNombre() 
				+  "' WHERE id = " + categoria.getId());

	}

	@Override
	public void delete(Categoria categoria) {
		 conexionUno.update("DELETE FROM Categoria WHERE id = " + categoria.getId());

	}

	@Override
	public List<Categoria> find() {
		List<Categoria> list = new ArrayList<Categoria>();
		ResultSet rs = conexionUno.query("SELECT * FROM Categoria");
		try {
			while (rs.next()) {
				list.add(new Categoria(rs.getInt("id"), rs.getString("nombre")));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:find): " + e.getMessage());
		}
		return list;
	}


}
