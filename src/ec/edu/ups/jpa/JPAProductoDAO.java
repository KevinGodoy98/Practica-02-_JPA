package ec.edu.ups.jpa;

import ups.edu.ec.modelo.Producto;

import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.ProductoDAO;

public class JPAProductoDAO extends JPAGenericDAO<Producto, Integer> implements ProductoDAO {
	
	public JPAProductoDAO() {
		super(Producto.class);
	}

	@Override
	public Set<Producto> listarProducto(int id_producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> find_emp(int emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
