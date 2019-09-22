package pe.upc.business;
import java.io.Serializable;
import java.util.List;


import javax.inject.Inject;
import javax.inject.Named;

import pe.upc.model.entity.Unidad;

import pe.upc.model.repository.UnidadRepository;

@Named
public class UnidadBusiness implements Serializable{
private static final long serialVersionUID = 3L;
	
	@Inject
	private UnidadRepository unidadRepository;

	
	public List<Unidad> getAll() throws Exception {
		return unidadRepository.findAll();
	}
}
