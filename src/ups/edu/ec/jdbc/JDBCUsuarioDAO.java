package ups.edu.ec.jdbc;
<<<<<<< HEAD
	
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	
	import ec.edu.ups.dao.DAOFactory;
	
	import ec.edu.ups.dao.UsuarioDAO;
	import ups.edu.ec.modelo.Empresa;
	import ups.edu.ec.modelo.Producto;
	import ups.edu.ec.modelo.RequerimientosCompra;
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
		private static String idB;
		private static String idLP;
	
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
			ResultSet rs = conexionUno.query("SELECT * FROM User WHERE id=" + id);
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
			conexionUno.update("UPDATE Usuario SET cedula = " + user.getCedula() + "nombre = '" + user.getNombre() +
					" apellido = " + user.getApellido()  + "rol = '"+ user.getRol()+"correo = " + user.getCorreo() +
					"contrasena =  "+ user.getContrasena() + "empresa = '"+ user.getEmpresa_id()+
					"' WHERE id =  " + user.getId());
			
	
		}
	
		@Override
		public void delete(Usuario user) {
			conexionUno.update("DELETE FROM Usuario WHERE id = " + user.getId());
			
	
		}
		
		@Override
	
		public Empresa buscarEmpresa() {
			// TODO Auto-generated method stub
			Empresa empresaObject = null;
			ResultSet rs = conexionUno.query("Select e.ID from empresa e, usuario u "
					+ "where e.ID = u.Empresa_ID "
					+ "AND u.ID = " + idB);
			try {
				if (rs != null && rs.next()) {
					idB = rs.getString("id");
					empresaObject = new Empresa(rs.getInt("id"), rs.getString("nombre"), rs.getString("ruc"));
				}	
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
=======

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

	}

	@Override
	public Usuario read(Integer id) {

		Usuario user = null;
		ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE id=" + id);
		try {
			if (rs != null && rs.next()) {
				user = new Usuario(rs.getInt("id"), rs.getInt("Empresa_id"), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("contrasena"), rs.getString("rol"));
>>>>>>> main
			}
			return empresaObject;
		}
	
		@Override
		public List<Usuario> find() {
			List<Usuario> list = new ArrayList<Usuario>();
			
			ResultSet rsUsuario = conexionUno.query("SELECT * FROM Usuario");
			try {
				while (rsUsuario.next()) {
					list.add(new Usuario(rsUsuario.getInt("id"), rsUsuario.getInt("empresa_id"), rsUsuario.getString("cedula"), rsUsuario.getString("nombre"),
							rsUsuario.getString("apellido"), rsUsuario.getString("rol"), rsUsuario.getString("correo"), rsUsuario.getString("contrasena")));
					System.out.println("se leyo Usuario");
				}
	
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCUsuarioDAO:find): " + e.getMessage());
			}
		
			return list;
		}
		public List<Producto> listarProductos() {
			// TODO Auto-generated method stub
			List<Producto> list = new ArrayList<Producto>();
		    ResultSet rs = conexionUno.query("SELECT * FROM Producto p, "
		    		+ "RequerimientosCompra rc, Usuario u, Empresa e "
		    		+ "WHERE  p.RequerimeintosCompra_ID = rc.ID "
		    		+ "AND rc.Usuario_ID = u.ID "
		    		+ "AND u.Empresa_ID = e.ID "
		    		+ "AND e.ID =" + idLP);
		    try {
				while (rs.next()) {
					System.out.println("Entro en el while");
					Producto producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getString("precio"),
							rs.getString("descripcion"), rs.getInt("categoria_id"));
					System.out.println("IDs DE PRODUCTO:" + rs.getInt("id") + ", NOMBRE DE PRODUCTO: " + rs.getString("nombre"));
					list.add(producto);
				}
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
			}
			return list;
		}
		
		public List<Producto> listarProductosNum2() {
			// TODO Auto-generated method stub
			List<Producto> list = new ArrayList<Producto>();
		    ResultSet rs = conexionUno.query("SELECT * FROM Producto p, "
		    		+ "RequerimientosCompra rc, Usuario u, Empresa e "
		    		+ "WHERE  p.RequerimeintosCompra_ID = rc.ID "
		    		+ "AND rc.Usuario_ID = u.ID "
		    		+ "AND u.Empresa_ID = e.ID "
		    		+ "AND e.ID =" + idLP);
		    try {
				while (rs.next()) {
					System.out.println("Entro en el while");
					Producto producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getString("precio"),
							rs.getString("descripcion"), rs.getInt("categoria_id"));
					System.out.println("IDs DE PRODUCTO:" + rs.getInt("id") + ", NOMBRE DE PRODUCTO: " + rs.getString("nombre"));
					list.add(producto);
				}
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
			}
			return list;
		}
		
<<<<<<< HEAD
		public List<RequerimientosCompra>listarRequerimientosCompra() {
			// TODO Auto-generated method stub
			List<RequerimientosCompra> list = new ArrayList<RequerimientosCompra>();
		    ResultSet rs = conexionUno.query("SELECT * FROM RequerimientosCompra rc, "
		    		+ "Producto p, Usuario u, Empresa e "
		    		+ "WHERE  rc.Usuario_id = u.id "
		    		+ "AND rc.id = p.Requerimientos_id"
		    		+ "AND e.id = u.Empresa_id "
		    		+ "AND e.id =" + idLP);
		    try {
				while (rs.next()) {
					System.out.println("Entro en el while");
					RequerimientosCompra reqCom = new RequerimientosCompra(rs.getInt("id"), rs.getInt("usuario_id"), rs.getInt("empresa_id"),
							rs.getString("estado"), rs.getInt("producto_id"), rs.getInt("cantidad"));
					System.out.println("IDs DE RequerimientosCompra:" + rs.getInt("id") + ", UsuarioID: " + rs.getInt("usuario_id"));
					list.add(reqCom);
				}
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
			}
			return list;
		}
=======

	}
	
	@Override
	public Usuario login(String mail, String pass) {
		
		Usuario us = null;
		ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE correo='"+ mail+"' AND contrasena='"+pass+"'");
		try {
			if (rs != null && rs.next()) {
				us = new Usuario(rs.getInt("id"), rs.getInt("Empresa_id"), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("rol"), rs.getString("correo"), rs.getString("contrasena"));
			} 
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " + e.getMessage());
		}
		
		return us;
	}

	@Override
	public List<Usuario> find() {
		List<Usuario> list = new ArrayList<Usuario>();
>>>>>>> main
		
		public List<Empresa> listarEmpresa(){
			List<Empresa> list = new ArrayList<Empresa>();
			
			ResultSet rs = conexionUno.query("SELECT * FROM RequerimientosCompra rc, "
		    		+ "Producto p, Usuario u, Empresa e "
		    		+ "WHERE  rc.Usuario_id = u.id "
		    		+ "AND rc.id = p.Requerimientos_id"
		    		+ "AND e.id = u.Empresa_id "
		    		+ "AND e.id =" + idLP);
			 try {
					while (rs.next()) {
						Empresa em = new Empresa(rs.getInt("id"), rs.getString("nombre"), rs.getString("ruc"));
						System.out.println("Categoria: " + rs.getString("e.nombre"));
						list.add(em);
					}
				} catch (SQLException e) {
					System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
				}
			return list;	
		}
	
	}
<<<<<<< HEAD
	
=======

}
>>>>>>> main
