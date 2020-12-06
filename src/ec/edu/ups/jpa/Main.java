package ec.edu.ups.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.modelo.Usuario;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		Usuario us;
		
		us = usuarioDAO.read(1);
		System.out.println(us.getNombre());

	}

}
