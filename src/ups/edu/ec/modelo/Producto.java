package ups.edu.ec.modelo;

import java.io.Serializable;

public class Producto implements Serializable {

	private int id;
	private String nombre;
	private String precio;
	private String descripcion;
	private int categoria_id;
	private int empresa_id;
	private String estado;
	
	public Producto(int id , String nombre, String precio, String descripcion,int categoria_id, int empresa_id, String estado) {
		this.id=id;
		this.nombre=nombre;
		this.precio=precio;
		this.descripcion=descripcion;
		this.categoria_id=categoria_id;
		this.empresa_id = empresa_id;
		this.estado=estado;
	}

	public int getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(int empresa_id) {
		this.empresa_id = empresa_id;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", categoria_id=" + categoria_id + ", empresa_id=" + empresa_id + ", estado=" + estado + "]";
	}

	
	
}
