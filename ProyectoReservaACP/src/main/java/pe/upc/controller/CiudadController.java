package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.CiudadBusiness;
import pe.upc.business.PaisBusiness;
import pe.upc.model.entity.Ciudad;
import pe.upc.model.entity.Pais;
import pe.upc.util.Message;

@Named
@SessionScoped
public class CiudadController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CiudadBusiness ciudadBusiness;

	@Inject
	private PaisBusiness paisBusiness;

	private Ciudad ciudad;
	private List<Ciudad> ciudades;
	private Ciudad ciudadSelect;

	private Pais pais;
	private List<Pais> paises;

	@PostConstruct
	public void init() {
		ciudad = new Ciudad();
		ciudades = new ArrayList<Ciudad>();

		pais = new Pais();
		paises = new ArrayList<>();

		getAllCiudades();
	}

	public void getAllCiudades() {
		try {
			ciudades = ciudadBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Productos :" + e.getMessage());
		}
	}


	public String listCiudad() {
		return "list.xhtml";
	}

	public CiudadBusiness getCiudadBusiness() {
		return ciudadBusiness;
	}

	public void setCiudadBusiness(CiudadBusiness ciudadBusiness) {
		this.ciudadBusiness = ciudadBusiness;
	}

	public PaisBusiness getPaisBusiness() {
		return paisBusiness;
	}

	public void setPaisBusiness(PaisBusiness paisBusiness) {
		this.paisBusiness = paisBusiness;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public Ciudad getCiudadSelect() {
		return ciudadSelect;
	}

	public void setCiudadSelect(Ciudad ciudadSelect) {
		this.ciudadSelect = ciudadSelect;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	
}
