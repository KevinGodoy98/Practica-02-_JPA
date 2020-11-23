package ups.edu.ec.modelo;

import java.io.Serializable;

public class Empresa implements Serializable{

	private String id;
	private String nombre;
	private String ruc;
	
	public void String(String id , String nombre, String ruc) {
        this.id= id;
        this.nombre=nombre;
        this.ruc=ruc;
        
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", ruc=" + ruc + "]";
	}
	
	
}
