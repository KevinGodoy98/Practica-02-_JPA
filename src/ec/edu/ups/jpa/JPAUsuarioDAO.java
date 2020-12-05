package ec.edu.ups.jpa;

import ups.edu.ec.modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.UsuarioDAO;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO {

	private EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	
	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario login(String mail, String pass) {
		
		Usuario user = null;
		String jpql = "SELECT u FROM Usuario u WHERE u.correo = "+mail+" and u.contrasena = "+pass;
		
		try {
			user = em.createQuery(jpql, Usuario.class).getSingleResult();
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBCUserDAO:login): " + e.getMessage());
		}
		
		return user;
	}
	
}
