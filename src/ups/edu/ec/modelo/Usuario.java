package ups.edu.ec.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private int id;
	private int empresa_id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
	private String rol;
	

	public Usuario(int id, int empresa_id, String cedula,String nombre , String apellido ,String correo,String contrasena, String rol) {
	    this.id=id;
	    this.empresa_id = empresa_id;
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
	}
	
	public int getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(int empresa_id) {
		this.empresa_id = empresa_id;
	}

	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
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


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", correo=" + correo + ", contrasena=" + contrasena + "]";
	}


	
	
	
	
}
