package ups.edu.ec.modelo;

import java.io.Serializable;

public class RequerimientosCompra implements Serializable {

	private int id;
	private int usuario_id;
	private int empresa_id;
	private String estado;
	private int producto_id;
	private int cantidad;
	
	public RequerimientosCompra (int usuario_id,int empresa_id,String estado,int producto_id, int cantidad) {
		this.usuario_id=usuario_id;
		this.empresa_id=empresa_id;
		this.estado=estado;
		this.producto_id=producto_id;
		this.cantidad=cantidad;
	}
	
	public RequerimientosCompra (int id ,int usuario_id,int empresa_id,String estado,int producto_id, int cantidad) {
		this.id=id;
		this.usuario_id=usuario_id;
		this.empresa_id=empresa_id;
		this.estado=estado;
		this.producto_id=producto_id;
		this.cantidad=cantidad;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(int empresa_id) {
		this.empresa_id = empresa_id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "RequerimientosCompra [id=" + id + ", usuario_id=" + usuario_id + ", empresa_id=" + empresa_id
				+ ", estado=" + estado + ", producto_id=" + producto_id + ", cantidad=" + cantidad + "]";
	}

	
	
}
