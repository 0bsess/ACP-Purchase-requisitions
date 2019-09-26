package pe.upc.business;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
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
	
	@Transactional
	public Long insert(Ciudad ciudad) throws Exception {
		return ciudadRepository.insert(ciudad);
	}
	
	@Transactional
	public Long update(Ciudad ciudad) throws Exception{
		return ciudadRepository.update(ciudad);
	}
	@Transactional
	public Long delete(Ciudad ciudad) throws Exception{
		return ciudadRepository.delete(ciudad);
	}
	
	public List<Ciudad> validar(String nombre) throws Exception {
		return ciudadRepository.ListarCiudadxNombre(nombre);
	}
}

