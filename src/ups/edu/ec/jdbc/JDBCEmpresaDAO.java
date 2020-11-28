package ups.edu.ec.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.UserDetailDAO;
import ec.edu.ups.modelo.User;
import ec.edu.ups.modelo.UserDetail;
import ups.edu.ec.modelo.Empresa;

/**
 * Clase JDBCUserDetailDAO.
 * 
 * La clase JDBCUserDetailDAO hereda los métodos y atributos de la clase abstracta
 * padre JDBCGenericDAO, así como también, implementa los métodos de la
 * interface UserDetailDAO.
 * 
 * Teniendo de esta manera una clase específica que gestionara la persistencia a
 * la base de datos del modelo UserDetail
 * 
 * @author Gabriel A. León Paredes 
 * Doctor en Tecnologías de Información
 * https://www.linkedin.com/in/gabrielleonp
 *
 * @see JDBCEmpresaDAO
 * @see UserDetailDAO
 * @see UserDetail
 * 
 * @version 1.0
 */
public class JDBCEmpresaDAO extends JDBCGenericDAO<Empresa, Integer> implements EmpresaDAO {

	@Override
	public void createTable() {
		
	}

	@Override
	public void create(Empresa empresa) {

		conexionDos.update("INSERT empresa VALUES (" 
		+ empresa.getId() + ", '" + empresa.getNombre() + "', "+ empresa.getRuc() + ")");
	}

	@Override
	public Empresa read(Integer id) {

		Empresa empresa = null;
		
		ResultSet rs = conexionUno.query("SELECT * FROM empresa WHERE id=" + id);
		try {
			if (rs != null && rs.next()) {
				empresa = new Empresa(rs.getInt("id"), rs.getString("nombre"), rs.getString("ruc"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCategoryDAO:read): " + e.getMessage());
		}
		
		return empresa;

	}

	@Override
	public void update(Empresa empresa) {

		conexionDos.update(
				"UPDATE empresa SET name = '" + empresa.getNombre() + ", ruc = '"+empresa.getRuc()+"' WHERE id = " + empresa.getId());
	}

	@Override
	public void delete(Empresa empresa) {

	}

	@Override
	public List<Empresa> find() {
		List<Empresa> list = new ArrayList<Empresa>();
		

		return list;
	}

}
