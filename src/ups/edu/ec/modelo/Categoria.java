package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Categoria implements Serializable {
	 @Id
	private int id;
	private String nombre;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Categoria")
	private Set<Producto> productos = new java.util.HashSet<Producto>();
	
	public Categoria() {
		
	}

	public Categoria(int id ,String nombre) {
		this.id=id;
		this.nombre=nombre;
		
	}
	
	public Set<Producto> getProductos() {
		return productos;
	}
	
	public void addProductos(Producto producto) {
		this.productos.add(producto);
    }

    public void removeProducto(Producto producto) {
    	this.productos.remove(producto);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
