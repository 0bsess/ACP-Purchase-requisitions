package pe.upc.model.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	
	private Date dayReserva;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idCiudad", nullable = false)
	private Ciudad ciudad;
	
//completado por el sistema o admin
	private Date dayLlegada;
	private boolean flagAnulado;
	private Date dayVencimiento;
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public Date getDayReserva() {
		return dayReserva;
	}
	public void setDayReserva(Date dayReserva) {
		this.dayReserva = dayReserva;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Date getDayLlegada() {
		return dayLlegada;
	}
	public void setDayLlegada(Date dayLlegada) {
		this.dayLlegada = dayLlegada;
	}
	public boolean isFlagAnulado() {
		return flagAnulado;
	}
	public void setFlagAnulado(boolean flagAnulado) {
		this.flagAnulado = flagAnulado;
	}
	public Date getDayVencimiento() {
		return dayVencimiento;
	}
	public void setDayVencimiento(Date dayVencimiento) {
		this.dayVencimiento = dayVencimiento;
	}
	
}
