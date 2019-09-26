package pe.upc.business;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import pe.upc.model.entity.Pedido;
import pe.upc.model.repository.PedidoRepository;

@Named
public class PedidoBusiness implements Serializable{
	private static final long serialVersionUID = 6L;
	
	@Inject
	private PedidoRepository pedidoRepository;

	@Transactional
	public Long insert(Pedido pedido) throws Exception {
		return pedidoRepository.insert(pedido);
	}

	
	@Transactional
	public Long update(Pedido pedido) throws Exception{
		return pedidoRepository.update(pedido);
	}
	
	
	public List<Pedido> getAll() throws Exception {
		return pedidoRepository.findAll();
	}
	
	public Optional<Pedido> getPedidoById(Long id) throws Exception{
		return pedidoRepository.findById(id);
	}
}
