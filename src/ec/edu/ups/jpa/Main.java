package ec.edu.ups.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.RequerimientosCompraDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ups.edu.ec.modelo.Producto;
import ups.edu.ec.modelo.RequerimientosCompra;
import ups.edu.ec.modelo.Usuario;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		RequerimientosCompraDAO RequerimientosCompraDao = DAOFactory.getFactory().getRequerimientosCompraDAO();
		RequerimientosCompra us;
		//RequerimientosCompra us1;
		//List<RequerimientosCompra> us;
	 // List<Producto> us1= ProductoDao.find_emp(2);
	   //System.out.println(us1.toString());
		//us= RequerimientosCompraDao.find_empresa(1);
		us= RequerimientosCompraDao.read(1);
		us.setEstado("R");
		RequerimientosCompraDao.update_estado(us);
		
		//us =RequerimientosCompraDao.find_usuario(1);
		System.out.println(us.getProducto().getNombre());
		
	//	System.out.println(us.getId()+""+us.getNombre()+""+us.getPrecio()+""+us.getDescripcion()+""+us.getCategoria()+""+us.getEmpresa()+""+us.getEstado());
		
		
		//us= ProductoDao.create(us.getId(),us.getNombre(),us.getPrecio(),us.getDescripcion(),us.getCategoria(),us.getEmpresa(),us.getEstado());
		
		//System.out.println(us.getCorreo());
	///	System.out.println(us.getContrasena());
		//System.out.println(UsuarioDao.login(us.getCorreo(),us.getContrasena()));
		
		
		
	}

	
	
}
