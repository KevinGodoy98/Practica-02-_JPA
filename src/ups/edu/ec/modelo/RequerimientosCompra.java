package ups.edu.ec.modelo;

import java.io.Serializable;

public class RequerimientosCompra implements Serializable {

	private int id;
	private String descripcion;
	
	public RequerimientosCompra (int id ,String descripcion) {
	}

	public void RequerimientosCompra (int id ,String descripcion) {
		this.id=id;
		this.descripcion=descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
