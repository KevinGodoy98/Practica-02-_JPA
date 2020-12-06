package ups.edu.ec.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
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

		conexionUno.update("INSERT Producto VALUES (" + producto.getId() + ", '" + producto.getNombre() + "', '"
				+ producto.getPrecio() + "', '" + producto.getDescripcion() +     "', " + producto.getCategoria_id() +", "+ producto.getEmpresa_id()+", '"+   producto.getEstado()   +  "' )");

	}

	@Override
	public Producto read(Integer id) {

		Producto producto = null;
		ResultSet rsProduct = conexionUno.query("SELECT * FROM Producto WHERE id=" + id);
		try {
			if (rsProduct != null && rsProduct.next()) {
				producto = new Producto(rsProduct.getInt("id"), rsProduct.getString("nombre"), rsProduct.getString("precio"), rsProduct.getString("descripcion"),rsProduct.getInt("categoria_id"),rsProduct.getInt("empresa_id"),rsProduct.getString("estado"));
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

		conexionUno.update("UPDATE Producto SET nombre = '" + producto.getNombre() + "', precio = '"
				+ producto.getPrecio() + "', descripcion = ' "
						+ producto.getDescripcion()+ " ', categoria_id = "
								+ producto.getCategoria_id()+ " WHERE id = " + producto.getId());

	}

	@Override
	public void delete(Producto producto) {
		conexionUno.update("UPDATE Producto SET estado ='E' WHERE id = " + producto.getId());
	}
	
	@Override
	public List<Producto> find_emp(int emp) {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rsProduct = conexionUno.query("SELECT * FROM Producto WHERE Empresa_id="+emp);
		try {
			while (rsProduct.next()) {
				list.add(new Producto(rsProduct.getInt("id"), rsProduct.getString("nombre"), rsProduct.getString("precio"), rsProduct.getString("descripcion"),rsProduct.getInt("categoria_id"),rsProduct.getInt("empresa_id"),rsProduct.getString("estado")));
				//System.out.println("se leyo ");
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductoDAO:find): " + e.getMessage());
		}

		return list;
	}
	
	@Override
	public List<Producto> find() {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rsProduct = conexionUno.query("SELECT * FROM Producto");
		try {
			while (rsProduct.next()) {
				list.add(new Producto(rsProduct.getInt("id"), rsProduct.getString("nombre"), rsProduct.getString("precio"), rsProduct.getString("descripcion"),rsProduct.getInt("categoria_id"),rsProduct.getInt("empresa_id"),rsProduct.getString("estado")));
				//System.out.println("se leyo ");
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