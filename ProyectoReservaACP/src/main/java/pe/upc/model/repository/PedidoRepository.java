package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Pedido;
import pe.upc.model.entity.Producto;
@Named
public class PedidoRepository  implements Serializable{
private static final long serialVersionUID = 7L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Pedido pedido) throws Exception {
		em.persist(pedido);
		return pedido.getIdPedido();
	}
	
	
	public Long update(Pedido pedido) throws Exception {
		em.merge(pedido);
		return pedido.getIdPedido();
	}
	
	
	public void delete(Pedido pedido) throws Exception {
		em.remove(pedido);
	}
	
	
	public List<Pedido> findAll() throws Exception{
		List<Pedido> pedidos=new ArrayList<>();
		
		TypedQuery<Pedido> query=em.createQuery("FROM Pedido p",Pedido.class);
		pedidos=query.getResultList();
		
		return pedidos;
	}
	
	
	public Optional<Pedido> findById(Long id) throws Exception{
		Pedido productFound;
		
		TypedQuery<Pedido> query=em.createQuery("FROM Pedido p WHERE p.id=?1",Pedido.class);
		query.setParameter(1, id);
		productFound=query.getSingleResult();
		
		return Optional.of(productFound);
	}
	
	//para que busque un producto similar
	public List<Producto> findByName(String name) throws Exception{
		List<Producto> productos=new ArrayList<>();
		
		TypedQuery<Producto> query=em.createQuery("FROM Producto p WHERE p.nameProducto LIKE ?1",Producto.class);
		query.setParameter(1, "%"+name+"%");
		productos=query.getResultList();
		
		return productos;
	}
}
