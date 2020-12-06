package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;


@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String rol;
	private String correo;
	private String contrasena;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private Set<RequerimientosCompra> requerimientos = new java.util.HashSet<RequerimientosCompra>();
	
	@ManyToOne
	@JoinColumn
	private Empresa empresa;

	
	public Usuario() {
		
	}
	public Usuario(int id,Empresa empresa,String cedula,String nombre , String apellido ,String rol,String correo,String contrasena) {
	    this.id=id;
	    this.empresa=empresa;
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido = apellido;
		this.rol=rol;
		this.correo = correo;
		this.contrasena = contrasena;
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

	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void setRequerimientos(Set<RequerimientosCompra> requerimientos) {
		this.requerimientos = requerimientos;
	}
	
	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}
	
}
