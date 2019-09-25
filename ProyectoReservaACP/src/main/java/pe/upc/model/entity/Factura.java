package pe.upc.model.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFactura;
	
	@OneToOne
	@JoinColumn(name = "idReserva", nullable = false)
	private Reserva reserva;
	
	private double moneyPrecioFinal;
	
	boolean flagPagoTarjeta;
	String numFactura;
	String numSerie;
	boolean flagCancelado;
	Date dayFactura;
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public double getMoneyPrecioFinal() {
		return moneyPrecioFinal;
	}
	public void setMoneyPrecioFinal(double moneyPrecioFinal) {
		this.moneyPrecioFinal = moneyPrecioFinal;
	}
	public boolean isFlagPagoTarjeta() {
		return flagPagoTarjeta;
	}
	public void setFlagPagoTarjeta(boolean flagPagoTarjeta) {
		this.flagPagoTarjeta = flagPagoTarjeta;
	}
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public boolean isFlagCancelado() {
		return flagCancelado;
	}
	public void setFlagCancelado(boolean flagCancelado) {
		this.flagCancelado = flagCancelado;
	}
	public Date getDayFactura() {
		return dayFactura;
	}
	public void setDayFactura(Date dayFactura) {
		this.dayFactura = dayFactura;
	}	
	
}
