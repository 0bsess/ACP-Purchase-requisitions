package pe.upc.business;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import pe.upc.model.entity.Factura;
import pe.upc.model.repository.FacturaRepository;

@Named
public class FacturaBusiness implements Serializable{
	private static final long serialVersionUID = 7L;

	@Inject
	private FacturaRepository facturaRepository;

	@Transactional
	public Long insert(Factura factura) throws Exception {
		return facturaRepository.insert(factura);
	}

	
	@Transactional
	public Long update(Factura factura) throws Exception{
		return facturaRepository.update(factura);
	}
	
	
	public List<Factura> getAll() throws Exception {
		return facturaRepository.findAll();
	}

}
