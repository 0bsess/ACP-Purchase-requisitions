package pe.upc.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	@ManyToOne
	@JoinColumn(name = "idReserva", nullable = false)
	private Reserva reserva;
	
	@ManyToOne
	@JoinColumn(name = "idProducto", nullable = false)
	private Producto producto;
	
	@Column(name = "quantityPeso", nullable = false)
	private double quantityPeso;
	
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getQuantityPeso() {
		return quantityPeso;
	}

	public void setQuantityPeso(double quantityPeso) {
		this.quantityPeso = quantityPeso;
	}
	
}
