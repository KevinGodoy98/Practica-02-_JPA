package ec.edu.ups.dao;


/**
 * Clase JDBCGenericDAO.
 * 
 * 
 * Esta clase implementa los métodos abstractos de la clase DAOFatcory
 * gestionando de esta manera a través de esta clase el acceso a los DAOs que
 * persistiran la información en la base de datos.
 * 
 * @author Gabriel A. León Paredes 
 * Doctor en Tecnologías de Información
 * https://www.linkedin.com/in/gabrielleonp
 *
 * @see DAOFactory
 * @version 1.0
 * 
 */
public class JDBCDAOFactory extends DAOFactory {

	@Override
	public void createTables() {
		this.getCategoriaDAO().createTable();
		this.getUsuarioDAO().createTable();
		this.getRequerimientosCompraDAO().createTable();
		this.getEmpresaDAO().createTable();
		this.getProductoDAO().createTable();

	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new JDBCCategoriaDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JDBCUsuarioDAO();
	}

	@Override
	public EmpresaDAO getEmpresaDAO() {
		return new JDBCEmpresaDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		return new JDBCProductoDAO();
	}

	@Override
	public RequerimientosCompraDAO getRequerimientosCompraDAO() {
		return new JDBCRequerimientosCompraDAO();
	}


}
