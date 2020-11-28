package ups.edu.ec.modelo;

import java.io.Serializable;

public class Producto implements Serializable {

	private int id;
	private String nombre;
	private String precio;
	private String descripcion;
	private int categoria_id;
	
	public Producto(int id , String nombre, String precio, String descripcion,int categoria_id) {
		this.id=id;
		this.nombre=nombre;
		this.precio=precio;
		this.descripcion=descripcion;
		this.categoria_id=categoria_id;
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

	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", categoria_id=" + categoria_id + "]";
	}

	
	
}
