package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pe.upc.model.entity.Factura;
import pe.upc.model.entity.Reserva;

@Named
public class FacturaRepository implements Serializable {
private static final long serialVersionUID = 7L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public int insert(Factura factura) throws Exception {
		em.persist(factura);
		return factura.getIdFactura();
	}
	
	
	public int update(Factura factura) throws Exception {
		em.merge(factura);
		return factura.getIdFactura();
	}
	
	
	public void delete(Factura factura) throws Exception {
		em.remove(factura);
	}
	
	
	public List<Reserva> findAll() throws Exception{
		List<Reserva> reservas=new ArrayList<>();
		
		TypedQuery<Reserva> query=em.createQuery("FROM Reserva r",Reserva.class);
		reservas=query.getResultList();
		
		return reservas;
	}
}
