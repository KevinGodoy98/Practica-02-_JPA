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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((ruc == null) ? 0 : ruc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (ruc == null) {
			if (other.ruc != null)
				return false;
		} else if (!ruc.equals(other.ruc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", ruc=" + ruc + "]";
	}
	
	
}
