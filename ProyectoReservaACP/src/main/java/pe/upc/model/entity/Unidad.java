package pe.upc.model.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidad")
public class Unidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUnidad;
	
	private String nameUnidad;

	public int getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getNameUnidad() {
		return nameUnidad;
	}

	public void setNameUnidad(String nameUnidad) {
		this.nameUnidad = nameUnidad;
	}
}
