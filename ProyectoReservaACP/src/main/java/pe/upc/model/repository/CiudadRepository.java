package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pe.upc.model.entity.Ciudad;
@Named
public class CiudadRepository implements Serializable{
	private static final long serialVersionUID = 2L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public List<Ciudad> findAll() throws Exception {
		List<Ciudad> ciudades = new ArrayList<>();

		TypedQuery<Ciudad> query = em.createQuery("SELECT c FROM Ciudad c", Ciudad.class);
		ciudades = query.getResultList();
		return ciudades;
	}

	public Long insert(Ciudad ciudad) throws Exception {
		em.persist(ciudad);
		return ciudad.getIdCiudad();
	}

	public Long update(Ciudad ciudad) throws Exception {
		em.merge(ciudad);
		return ciudad.getIdCiudad();
	}
	public Long delete(Ciudad ciudad) throws Exception {
		em.remove(ciudad);
		return ciudad.getIdCiudad();
	}
	public List<Ciudad> ListarCiudadxNombre(String nombre) throws Exception {
		List<Ciudad> ciudad = new ArrayList<>();

		TypedQuery<Ciudad> query = em.createQuery("FROM Ciudad p WHERE p.nombre LIKE ?1", Ciudad.class);
		query.setParameter(1, "%" + nombre + "%");
		ciudad = query.getResultList();

		if(ciudad.isEmpty())
			return null;
		else
			return ciudad;
	}
}
