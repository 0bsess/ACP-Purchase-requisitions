package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pe.upc.model.entity.Reserva;

@Named
public class ReservaRepository  implements Serializable {
private static final long serialVersionUID = 6L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public int insert(Reserva reserva) throws Exception {
		em.persist(reserva);
		return reserva.getIdReserva();
	}
	
	
	public int update(Reserva reserva) throws Exception {
		em.merge(reserva);
		return reserva.getIdReserva();
	}
	
	
	public void delete(Reserva reserva) throws Exception {
		em.remove(reserva);
	}
	
	
	public List<Reserva> findAll() throws Exception{
		List<Reserva> reservas=new ArrayList<>();
		
		TypedQuery<Reserva> query=em.createQuery("FROM Reserva r",Reserva.class);
		reservas=query.getResultList();
		
		return reservas;
	}
	
	
	public Optional<Reserva> findById(Long id) throws Exception{
		Reserva productFound;
		
		TypedQuery<Reserva> query=em.createQuery("FROM Reserva r WHERE r.id=?1",Reserva.class);
		query.setParameter(1, id);
		productFound=query.getSingleResult();
		
		return Optional.of(productFound);
	}
}
