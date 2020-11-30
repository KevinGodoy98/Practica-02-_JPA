package ups.edu.ec.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ups.edu.ec.modelo.Producto;
import ups.edu.ec.modelo.RequerimientosCompra;


/**
 * Clase JDBCShoppingBasketDAO.
 * 
 * La clase JDBCShoppingBasketDAO hereda los mÃ©️todos y atributos de la clase abstracta
 * padre JDBCGenericDAO, asÃ­ como tambiÃ©️n, implementa los mÃ©️todos de la
 * interface ShoppingBasketDAO.
 * 
 * Teniendo de esta manera una clase especÃ­fica que gestionara la persistencia a
 * la base de datos del modelo ShoppingBasket
 * 
 * @author Gabriel A. LeÃ³n Paredes 
 * Doctor en TecnologÃ­as de InformaciÃ³n
 * https://www.linkedin.com/in/gabrielleonp
 *
 * @see JDBCRequerimientosCompraDAO
 * @see ShoppingBasketDAO
 * @see ShoppingBasket
 * 
 * @version 1.0
 */
public class JDBCRequerimientosCompraDAO extends JDBCGenericDAO<RequerimientosCompra, Integer> implements RequerimientosCompraDAO {

	@Override
	public void createTable() {


	}

	@Override
	public void create(RequerimientosCompra requerimientosCompra) {
		conexionDos.update("Insert RequerimientosCompra (`Usuario_id`, `Empresa_id`, `estado`, `Producto_id`, `Cantidad`) VALUES ("
		+ requerimientosCompra.getUsuario_id() + ", " + requerimientosCompra.getEmpresa_id() + ", '"
		+ requerimientosCompra.getEstado() + "', " + requerimientosCompra.getProducto_id() + ", " + requerimientosCompra.getCantidad() +")");
	}

	@Override
	public RequerimientosCompra read(Integer id) {
		RequerimientosCompra requerimientosCompra  = null;
		ResultSet rs = conexionUno.query("SELECT * FROM RequerimientosCompra WHERE id=" + id);
		try {
			if (rs != null && rs.next()) {
				requerimientosCompra = new RequerimientosCompra( rs.getInt("usuario_id"), rs.getInt("empresa_id"),
						rs.getString("estado"), rs.getInt("producto_id"), rs.getInt("cantidad"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCRequerimientosCompraDAO:read): " + e.getMessage());
		}
		if (requerimientosCompra == null) {
			return null;
		}

		return requerimientosCompra;
	}

	@Override
	public void update(RequerimientosCompra requerimientosCompra) {
		conexionDos.update(
				"UPDATE empresa SET estado = '" + requerimientosCompra.getEstado());

	}

	@Override
	public void delete(RequerimientosCompra requerimientosCompra) {
		

	}

	@Override
	public List<RequerimientosCompra> find() {
		List<RequerimientosCompra> list = new ArrayList<RequerimientosCompra>();
		
		return list;
	}

}
