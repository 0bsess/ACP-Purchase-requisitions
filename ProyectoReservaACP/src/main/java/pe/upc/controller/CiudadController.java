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
	private String filterName;
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

	public String newCiudad() {
		try {
			this.paises = paisBusiness.getAll();
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}
	
	public void resetForm() {
			this.filterName = "";
			this.ciudad = new Ciudad();
		}
	public String saveCiudad() {
		String view = "";
		try {

			if (ciudad.getIdCiudad() != 0) {
				ciudad.setPais(pais);
				ciudadBusiness.update(ciudad);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				ciudad.setPais(pais);
				ciudadBusiness.insert(ciudad);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllCiudades();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Ciudad :" + e.getStackTrace());
		}

		return view;
	}
	public String editCiudad() {
		String view = "";
		try {
			if (this.ciudadSelect != null) {
				this.ciudad = ciudadSelect;

				view = "/ciudad/update";
			} else {
				Message.messageInfo("Debe seleccionar una Ciudad");
			}
		} catch (Exception e) {
			Message.messageError("Error Ciudad :" + e.getMessage());
		}

		return view;
	}
	public void selectCiudad(SelectEvent e) {
		this.ciudadSelect = (Ciudad) e.getObject();
	}
	public void eliminar() {
		try {
			if (this.ciudadSelect != null) {
				this.ciudad = ciudadSelect;
				ciudadBusiness.delet(ciudad);}
			this.getAllCiudades();
			resetForm();
		} catch (Exception e) {
			e.getMessage();
		}
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

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	
}
