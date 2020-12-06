package ec.edu.ups.jpa;

import ups.edu.ec.modelo.Empresa;
import ec.edu.ups.dao.EmpresaDAO;

public class JPAEmpresaDAO extends JPAGenericDAO<Empresa, Integer> implements EmpresaDAO{

	public JPAEmpresaDAO() {
		super(Empresa.class);
	}
	
}
