package ups.edu.ec.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.ProductoDAO;
import ups.edu.ec.modelo.Producto;

/**
 * Clase JDBCProductDAO.
 * 
 * La clase JDBCProductDAO hereda los métodos y atributos de la clase abstracta
 * padre JDBCGenericDAO, así como también, implementa los métodos de la
 * interface ProductDAO.
 * 
 * Teniendo de esta manera una clase específica que gestionara la persistencia a
 * la base de datos del modelo Product
 * 
 * @author Gabriel A. León Paredes 
 * Doctor en Tecnologías de Información
 * https://www.linkedin.com/in/gabrielleonp
 *
 * @see JDBCGenericDAO
 * @see ProductDAO
 * @see Product
 * 
 * @version 1.0
 */
public class JDBCProductoDAO extends JDBCGenericDAO<Producto, Integer> implements ProductoDAO {

	@Override
	public void createTable() {

	}

	@Override
	public void create(Producto producto) {

<<<<<<< HEAD
		conexionUno.update("INSERT Producto VALUES (" + producto.getId() + ", " + producto.getNombre() + ", '"
				+ producto.getPrecio() + "', " + producto.getDescripcion() +     "', " + producto.getCategoria_id() +         " )");
=======
		conexionUno.update("INSERT producto VALUES (" + producto.getId() + ", '" + producto.getNombre() + "', '"
				+ producto.getPrecio() + "', '" + producto.getDescripcion() +     "', " + producto.getCategoria_id() +   ", "+   + producto.getEmpresa_id()   +" )");
>>>>>>> main

	}

	@Override
	public Producto read(Integer id) {

		Producto producto = null;
		ResultSet rsProduct = conexionUno.query("SELECT * FROM producto WHERE id=" + id);
		try {
			if (rsProduct != null && rsProduct.next()) {
				producto = new Producto(rsProduct.getInt("id"), rsProduct.getString("nombre"), rsProduct.getString("precio"), rsProduct.getString("descripcion"),rsProduct.getInt("categoria_id"),rsProduct.getInt("empresa_id"));
				/*ResultSet rsShoppingBasket = conexionDos
						.query("SELECT * FROM Shopping_Basket WHERE id=" + rsProduct.getInt("shopping_basket_id"));

				if (rsShoppingBasket != null && rsShoppingBasket.next()) {
					Calendar calendar = new GregorianCalendar();
					calendar.setTime(rsShoppingBasket.getDate("date"));
					ShoppingBasket shoppingBasket = new ShoppingBasket(rsShoppingBasket.getInt("id"), calendar);
					producto.setShoppingBasket(shoppingBasket);
				}*/

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductoDAO:read): " + e.getMessage());
		}
		/*if (producto == null) {
			return null;
		}*/
		return producto;
	}

	@Override
	public void update(Producto producto) {

		conexionUno.update("UPDATE producto SET nombre = " + producto.getNombre() + "nombre = '" + producto.getPrecio() + " description = "
				+ producto.getDescripcion()  + "categoria_id = '"+ producto.getCategoria_id()+"' WHERE id = " + producto.getId());

	}

	@Override
	public void delete(Producto producto) {

		conexionUno.update("DELETE FROM producto WHERE id = " + producto.getId());

	}

	@Override
	public List<Producto> find() {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rsProduct = conexionUno.query("SELECT * FROM Producto");
		try {
			while (rsProduct.next()) {
				list.add(new Producto(rsProduct.getInt("id"), rsProduct.getString("nombre"), rsProduct.getString("precio"), rsProduct.getString("descripcion"),rsProduct.getInt("categoria_id"), rsProduct.getInt("empresa_id")));
				
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductoDAO:find): " + e.getMessage());
		}

		return list;
	}

	@Override
	public Set<Producto> listarProducto(int id_producto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}