package pe.upc.model.entity;


/*import java.util.Date;*/
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String nameProducto;
	private Date dayReabastecimiento;
	private int quantityStock;
	private double moneyPrecio;
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
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
	public double getMoneyPrecio() {
		return moneyPrecio;
	}
	public void setMoneyPrecio(double moneyPrecio) {
		this.moneyPrecio = moneyPrecio;
	}
	
	
}
