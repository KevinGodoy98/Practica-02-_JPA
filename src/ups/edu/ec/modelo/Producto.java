package ups.edu.ec.modelo;

import java.io.Serializable;

public class Producto implements Serializable {

	private int id;
	private String nombre;
	private String precio;
	private String descripcion;
	
	public void Producto(int id , String nombre, String precio, String descripcion) {
		this.id=id;
		this.nombre=nombre;
		this.precio=precio;
		this.descripcion=descripcion;
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

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ "]";
	}
	
}
