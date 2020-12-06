package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Producto implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	private String precio;
	private String descripcion;
	private String estado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Producto")
	private Set<RequerimientosCompra> requerimientos = new java.util.HashSet<RequerimientosCompra>();
	@OneToMany
	@JoinColumn
	private Categoria categoria;
	private Empresa empresa;
	
	public Producto() {
		
	}
	public Producto(int id , String nombre, String precio, String descripcion,Categoria categoria, Empresa empresa, String estado) {
		this.id=id;
		this.nombre=nombre;
		this.precio=precio;
		this.descripcion=descripcion;
		this.categoria = categoria;
		this.empresa = empresa;
		this.estado=estado;
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
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
