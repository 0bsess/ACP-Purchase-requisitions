package pe.upc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCiudad;
	private String nameCiudad;
	
	@ManyToOne
	@JoinColumn(name = "idPais", nullable = false)
	private Pais pais;

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNameCiudad() {
		return nameCiudad;
	}

	public void setNameCiudad(String nameCiudad) {
		this.nameCiudad = nameCiudad;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
