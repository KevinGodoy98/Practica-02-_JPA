package ups.edu.ec.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class RequerimientosCompra implements Serializable {
	@Id
	private int id;
	private String estado;
	private int cantidad;
	
	
	@OneToMany
	@JoinColumn
	private Producto producto;
	private Empresa empresa;
	private Usuario usuario;
	
	public RequerimientosCompra() {
		
	}
	
	public RequerimientosCompra (int id ,Usuario usuario,Empresa empresa,String estado,Producto producto, int cantidad) {
		this.id=id;
		this.usuario=usuario;
		this.empresa=empresa;
		this.estado=estado;
		this.producto=producto;
		this.cantidad=cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
}
