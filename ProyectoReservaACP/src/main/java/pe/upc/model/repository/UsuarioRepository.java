package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pe.upc.model.entity.Usuario;

@Named
public class UsuarioRepository implements Serializable{
private static final long serialVersionUID = 5L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Usuario usuario) throws Exception {
		em.persist(usuario);
		return usuario.getIdUsuario();
	}
	
	
	public Long update(Usuario usuario) throws Exception {
		em.merge(usuario);
		return usuario.getIdUsuario();
	}
	
	
	public void delete(Usuario usuario) throws Exception {
		em.remove(usuario);
	}
	
	
	public List<Usuario> findAll() throws Exception{
		List<Usuario> usuarios=new ArrayList<>();
		
		TypedQuery<Usuario> query=em.createQuery("FROM Usuario u",Usuario.class);
		usuarios=query.getResultList();
		
		return usuarios;
	}
	
//esta opcion nos puede servir para luego darle beneficios segun las historias de usuario y cambiar la contraseña 	
	public Optional<Usuario> findById(Long id) throws Exception{
		Usuario usuarioFound;
		TypedQuery<Usuario> query=em.createQuery("FROM Usuario u WHERE u.id=?1",Usuario.class);
		query.setParameter(1, id);
		usuarioFound=query.getSingleResult();
		
		return Optional.of(usuarioFound);
	}

}
