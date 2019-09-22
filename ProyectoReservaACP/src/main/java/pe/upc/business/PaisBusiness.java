package pe.upc.business;
import java.io.Serializable;
import java.util.List;


import javax.inject.Inject;
import javax.inject.Named;

import pe.upc.model.entity.Pais;

import pe.upc.model.repository.PaisRepository;

@Named
public class PaisBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PaisRepository paisRepository;

	
	public List<Pais> getAll() throws Exception {
		return paisRepository.findAll();
	}
}
