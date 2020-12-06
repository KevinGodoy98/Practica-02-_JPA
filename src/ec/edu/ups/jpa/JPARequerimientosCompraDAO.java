package ec.edu.ups.jpa;

import java.util.List;

import ec.edu.ups.dao.RequerimientosCompraDAO;
import ups.edu.ec.modelo.RequerimientosCompra;

public class JPARequerimientosCompraDAO extends JPAGenericDAO<RequerimientosCompra, Integer> implements RequerimientosCompraDAO {

	public JPARequerimientosCompraDAO() {
		super(RequerimientosCompra.class);
	}

	@Override
	public void update_estado(RequerimientosCompra requerimientosCompra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RequerimientosCompra> find_empresa(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequerimientosCompra> find_usuario(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
