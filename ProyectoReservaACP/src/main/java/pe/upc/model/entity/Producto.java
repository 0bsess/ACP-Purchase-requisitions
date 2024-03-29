package pe.upc.model.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	private String nameProducto;
	
	@Future
	private Date dayReabastecimiento;
	
	@Positive
	private int quantityStock;
	
	@Positive
	private double moneyPrecio;
	
	@Positive
	private int quantityReserva;
	
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNameProducto() {
		return nameProducto;
	}
	public void setNameProducto(String nameProducto) {
		this.nameProducto = nameProducto;
	}
	public Date getDayReabastecimiento() {
		return dayReabastecimiento;
	}
	public void setDayReabastecimiento(Date dayReabastecimiento) {
		this.dayReabastecimiento = dayReabastecimiento;
	}
	public int getQuantityStock() {
		return quantityStock;
	}
	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}
	public int getQuantityReserva() {
		return quantityReserva;
	}
	public void setQuantityReserva(int quantityReserva) {
		this.quantityReserva = quantityReserva;
	}
	
	public double getMoneyPrecio() {
		return moneyPrecio;
	}
	public void setMoneyPrecio(double moneyPrecio) {
		this.moneyPrecio = moneyPrecio;
	}
	
	
}
