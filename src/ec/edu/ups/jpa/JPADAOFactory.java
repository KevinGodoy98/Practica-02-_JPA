package ec.edu.ups.jpa;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.jdbc.JDBCCategoriaDAO;
import ups.edu.ec.jdbc.JDBCEmpresaDAO;
import ups.edu.ec.jdbc.JDBCProductoDAO;
import ups.edu.ec.jdbc.JDBCRequerimientosCompraDAO;
import ups.edu.ec.jdbc.JDBCUsuarioDAO;

public class JPADAOFactory extends DAOFactory {

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
