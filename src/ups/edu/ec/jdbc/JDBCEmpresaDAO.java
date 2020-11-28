package ups.edu.ec.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
import ec.edu.ups.dao.EmpresaDAO;
>>>>>>> main
import ups.edu.ec.modelo.Empresa;
import ec.edu.ups.dao.EmpresaDAO;


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
