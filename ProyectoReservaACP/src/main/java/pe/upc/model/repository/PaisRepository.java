package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Pais;

@Named
public class PaisRepository implements Serializable  {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public List<Pais> findAll() throws Exception {
		List<Pais> paises = new ArrayList<>();

		TypedQuery<Pais> query = em.createQuery("SELECT p FROM Pais p", Pais.class);
		paises = query.getResultList();
		return paises;
	}
}
