package pe.upc.business;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import pe.upc.model.entity.Ciudad;
import pe.upc.model.repository.CiudadRepository;

@Named
public class CiudadBusiness implements Serializable{
	private static final long serialVersionUID = 2L;
	
	@Inject
	private CiudadRepository ciudadRepository;

	
	public List<Ciudad> getAll() throws Exception {
		return ciudadRepository.findAll();
	}
}
