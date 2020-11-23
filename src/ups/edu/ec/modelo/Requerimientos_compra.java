package ups.edu.ec.modelo;

import java.io.Serializable;

public class Requerimientos_compra implements Serializable {

	private String id;
	private String descripcion;
	
	public void Requerimientos_compra (String id ,String descripcion) {
		this.id=id;
		this.descripcion=descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Requerimientos_compra [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
