package pe.upc.business;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import pe.upc.model.entity.Usuario;
import pe.upc.model.repository.UsuarioRepository;

@Named
public class UsuarioBusiness implements Serializable{
private static final long serialVersionUID = 5L;
	
	@Inject
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Long insert(Usuario usuario) throws Exception {
		return usuarioRepository.insert(usuario);
	}

	
	@Transactional
	public Long update(Usuario usuario) throws Exception{
		return usuarioRepository.update(usuario);
	}
	
	
	public List<Usuario> getAll() throws Exception {
		return usuarioRepository.findAll();
	}
		
	public Optional<Usuario> getUsuarioById(Long id) throws Exception{
		return usuarioRepository.findById(id);
	}
}
