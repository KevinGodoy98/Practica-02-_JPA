package ec.edu.ups.jpa;

import ec.edu.ups.dao.CategoriaDAO;
import ups.edu.ec.modelo.Categoria;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> implements CategoriaDAO{

	public JPACategoriaDAO() {
		super(Categoria.class);
	}
	
}
