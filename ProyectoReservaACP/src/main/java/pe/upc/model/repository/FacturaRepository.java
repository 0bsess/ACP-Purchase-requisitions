package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pe.upc.model.entity.Factura;
@Named
public class FacturaRepository implements Serializable {
private static final long serialVersionUID = 7L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Factura factura) throws Exception {
		em.persist(factura);
		return factura.getIdFactura();
	}
	
	
	public Long update(Factura factura) throws Exception {
		em.merge(factura);
		return factura.getIdFactura();
	}
	
	
	public void delete(Factura factura) throws Exception {
		em.remove(factura);
	}
	
	
	public List<Factura> findAll() throws Exception{
		List<Factura> facturas=new ArrayList<>();
		
		TypedQuery<Factura> query=em.createQuery("FROM Factura r",Factura.class);
		facturas=query.getResultList();
		
		return facturas;
	}
}
