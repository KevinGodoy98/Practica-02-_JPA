package ec.edu.ups.dao;

import java.util.List;
import java.util.Set;

import ups.edu.ec.modelo.Producto;

/**
 * Interface ProductDAO.
 * 
 * La interface ProductDAO ha sido creada como interface específica para la
 * persistencia de objetos de tipo Category en la base de datos. Dicha interface
 * hereda de la clase GenericDAO y será imlementada en una clase específica que
 * controlará la conexión a la base de datos de un sistema que permite
 * ejemplificar el uso del patrón de diseño DAO.
 * 
 * Además, en esta interface se pueden agregar método específicos para el manejo
 * del objeto Product, por ejemplo: buscarProductPorDescripction entre otras.
 * 
 * @author Gabriel A. León Paredes 
 * Doctor en Tecnologías de Información
 * https://www.linkedin.com/in/gabrielleonp
 * 
 * @see GenericDAO
 * @see Product
 * 
 * @version 1.0
 *
 */
public interface ProductoDAO extends GenericDAO<Producto, Integer> {

	public abstract Set<Producto>listarProducto(int id_producto);

	List<Producto> find_emp(int emp);
}
