package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
	
	public Long insert(Reserva reserva) throws Exception {
		em.persist(reserva);
		return reserva.getIdReserva();
	}
	
	
	public Long update(Reserva reserva) throws Exception {
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
	
}
