package ups.edu.ec.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;

import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.modelo.Usuario;

/**
 * Clase JDBCUserDAO.
 * 
 * La clase JDBCUserDAO hereda los métodos y atributos de la clase abstracta
 * padre JDBCGenericDAO, así como también, implementa los métodos de la
 * interface UserDAO.
 * 
 * Teniendo de esta manera una clase específica que gestionara la persistencia a
 * la base de datos del modelo User
 * 
 * @author Gabriel A. León Paredes 
 * Doctor en Tecnologías de Información
 * https://www.linkedin.com/in/gabrielleonp
 *
 * @see JDBCUsuarioDAO
 * @see UserDAO
 * @see User
 * 
 * @version 1.0
 */
public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, Integer> implements UsuarioDAO {

	@Override
	public void createTable() {
		
	}

	@Override
	public void create(Usuario user) {

		/*conexionUno.update("INSERT User VALUES (" + user.getId() + ", " + user.getLevel() + ", '" + user.getName()
				+ "', '" + user.getPassword() + "')");
		UserDetail userDetail = user.getDetail();
		if (userDetail != null) {
			DAOFactory.getFactory().getUserDetailDAO().create(userDetail);
		}*/

	}

	@Override
	public Usuario read(Integer id) {

		Usuario user = null;
		ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE id=" + id);
		try {
			if (rs != null && rs.next()) {
				user = new Usuario(rs.getInt("id"), rs.getInt("Empresa_id"), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("contrasena"), rs.getString("rol"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " + e.getMessage());
		}
		
		return user;
	}

	@Override
	public void update(Usuario user) {

		

	}

	@Override
	public void delete(Usuario user) {

		

	}
	
	@Override
	public String login(String mail, String pass) {
		
		Usuario us = null;
		ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE correo='"+ mail+"' AND contrasena='"+pass+"'");
		try {
			if (rs != null && rs.next()) {
				return rs.getString("rol");
			} 
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " + e.getMessage());
		}
		
		return "N";
	}

	@Override
	public List<Usuario> find() {
		List<Usuario> list = new ArrayList<Usuario>();
		
		return list;
	}

}
