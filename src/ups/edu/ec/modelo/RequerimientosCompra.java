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
	private int usuario_id;
	private String estado;
	
	private int cantidad;
	
	
	@OneToMany
	@JoinColumn
	private Producto producto;
	private Empresa empresa;
	private Usuario usuario;
	
	public RequerimientosCompra() {
		
	}
	
	public RequerimientosCompra (int id ,int usuario_id,int empresa_id,String estado,int producto_id, int cantidad) {
		this.id=id;
		this.usuario_id=usuario_id;
		this.empresa_id=empresa_id;
		this.estado=estado;
		this.producto_id=producto_id;
		this.cantidad=cantidad;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + empresa_id;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + id;
		result = prime * result + producto_id;
		result = prime * result + usuario_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequerimientosCompra other = (RequerimientosCompra) obj;
		if (cantidad != other.cantidad)
			return false;
		if (empresa_id != other.empresa_id)
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id != other.id)
			return false;
		if (producto_id != other.producto_id)
			return false;
		if (usuario_id != other.usuario_id)
			return false;
		return true;
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
