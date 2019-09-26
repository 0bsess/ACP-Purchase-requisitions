package pe.upc.business;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import pe.upc.model.entity.Producto;
import pe.upc.model.repository.ProductoRepository;

@Named
public class ProductoBusiness implements Serializable{
private static final long serialVersionUID = 4L;
	
	@Inject
	private ProductoRepository productoRepository;

	@Transactional
	public Long insert(Producto producto) throws Exception {
		return productoRepository.insert(producto);
	}

	
	@Transactional
	public Long update(Producto producto) throws Exception{
		return productoRepository.update(producto);
	}
	
	
	public List<Producto> getAll() throws Exception {
		return productoRepository.findAll();
	}
	
	public List<Producto> getProductosByName(String name) throws Exception{
		return productoRepository.findByName(name);
	}
	
	public List<Producto> validar(String nombre) throws Exception {
		return productoRepository.ListarProductoxNombre(nombre);
	}
}
