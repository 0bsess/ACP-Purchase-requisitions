package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Unidad;

@Named
public class UnidadRepository implements Serializable {
	private static final long serialVersionUID = 3L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public List<Unidad> findAll() throws Exception {
		List<Unidad> unidades = new ArrayList<>();

		TypedQuery<Unidad> query = em.createQuery("SELECT u FROM Unidad u", Unidad.class);
		unidades = query.getResultList();
		return unidades;
	}
}
