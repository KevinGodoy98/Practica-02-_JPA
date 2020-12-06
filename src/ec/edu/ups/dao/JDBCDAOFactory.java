package ec.edu.ups.dao;

import ec.edu.ups.jpa.JPACategoriaDAO;
import ec.edu.ups.jpa.JPAEmpresaDAO;
import ec.edu.ups.jpa.JPAProductoDAO;
import ec.edu.ups.jpa.JPARequerimientosCompraDAO;
import ec.edu.ups.jpa.JPAUsuarioDAO;

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
		return new JPACategoriaDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

	@Override
	public EmpresaDAO getEmpresaDAO() {
		return new JPAEmpresaDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		return new JPAProductoDAO();
	}

	@Override
	public RequerimientosCompraDAO getRequerimientosCompraDAO() {
		return new JPARequerimientosCompraDAO();
	}


}
