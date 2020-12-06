package ec.edu.ups.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.modelo.RequerimientosCompra;
import ups.edu.ec.modelo.Usuario;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		RequerimientosCompraDAO rdao = DAOFactory.getFactory().getRequerimientosCompraDAO();
		List<RequerimientosCompra> list;
		
		Usuario us;
		
		us = usuarioDAO.read(1);
		System.out.println(us.getNombre());
		
		list = rdao.find_usuario(1);
		System.out.println(list);

	}

}
