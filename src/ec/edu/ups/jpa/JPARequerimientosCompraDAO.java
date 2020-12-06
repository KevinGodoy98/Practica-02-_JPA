package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.RequerimientosCompraDAO;
import ups.edu.ec.modelo.Producto;
import ups.edu.ec.modelo.RequerimientosCompra;

public class JPARequerimientosCompraDAO extends JPAGenericDAO<RequerimientosCompra, Integer> implements RequerimientosCompraDAO {

	private EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	
	public JPARequerimientosCompraDAO() {
		super(RequerimientosCompra.class);
	}

	@Override
	public void update_estado(RequerimientosCompra requerimientosCompra) {
		
		em.getTransaction().begin();
		em.merge(requerimientosCompra);
		em.getTransaction().commit();
		
	}

	@Override
	public List<RequerimientosCompra> find_empresa(int id) {
		
		List<RequerimientosCompra> list = new ArrayList<RequerimientosCompra>();
		String jpql = "SELECT r FROM RequerimientosCompra r INNER JOIN r.empresa e WHERE e.id = "+id;
		list = (List<RequerimientosCompra>) em.createQuery(jpql, RequerimientosCompra.class).getResultList();
		
		return list;
	}

	@Override
	public List<RequerimientosCompra> find_usuario(int id) {
		
		List<RequerimientosCompra> list = new ArrayList<RequerimientosCompra>();
		String jpql = "SELECT r FROM RequerimientosCompra r INNER JOIN r.usuario u WHERE u.id = "+id;
		list = (List<RequerimientosCompra>) em.createQuery(jpql, RequerimientosCompra.class).getResultList();
		
		return list;
	}
	
}
