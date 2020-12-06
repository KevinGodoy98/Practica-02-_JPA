package ups.edu.ec.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class RequerimientosCompra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String estado;
	private int cantidad;
	
	
	@ManyToOne
	@JoinColumn
	private Producto producto;
	
	@ManyToOne
	@JoinColumn
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn
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
