package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Empresa implements Serializable{
	@Id
	private int id;
	private String nombre;
	private String ruc;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Empresa")
	private Set<Producto> productos = new java.util.HashSet<Producto>();
	private Set<Usuario> usuarios = new java.util.HashSet<Usuario>();
	private Set<RequerimientosCompra> requerimientos = new java.util.HashSet<RequerimientosCompra>();
	
	public Empresa() {
		
	}
	
	public Empresa(int id , String nombre, String ruc) {
        this.id= id;
        this.nombre=nombre;
        this.ruc=ruc;
        
	}
	
	public Set<RequerimientosCompra> getRequerimientos() {
		return requerimientos;
	}
	
	public void addRequerimientos(RequerimientosCompra requerimiento) {
		this.requerimientos.add(requerimiento);
    }

    public void removeRequerimientos(RequerimientosCompra requerimiento) {
    	this.requerimientos.remove(requerimiento);
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

    public Set<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void addUsuariox(Usuario usuario) {
		this.usuarios.add(usuario);
    }

    public void removeUsuarios(Usuario usuario) {
    	this.usuarios.remove(usuario);
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

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", ruc=" + ruc + "]";
	}
	
	
}
