package ups.edu.ec.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
	

	public void Usuario(int id,String cedula,String nombre , String apellido ,String correo,String contrasena) {
	    this.id=id;
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
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
