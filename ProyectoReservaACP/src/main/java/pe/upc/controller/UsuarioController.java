package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import pe.upc.business.UsuarioBusiness;
import pe.upc.model.entity.Usuario;
import pe.upc.util.Message;

@Named
@SessionScoped
public class UsuarioController  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioBusiness usuarioBusiness;


	private Usuario usuario;
	private List<Usuario> usuarios;
	private Optional<Usuario> usuariosid;
	private Usuario usuarioSelect;

	private String filterName;
	private Long filterId;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
		usuarios = new ArrayList<Usuario>();
		getAllUsuarios();
	}

	public void getAllUsuarios() {
		try {
			usuarios = usuarioBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Usuarios :" + e.getMessage());
		}
	}

	public String newUsuario() {

		try {
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listUsuario() {
		return "list.xhtml";
	}

	public String saveUsuario() {
		String view = "";
		try {

			if (usuario.getIdUsuario()!= null) {
				usuarioBusiness.update(usuario);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				usuarioBusiness.insert(usuario);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllUsuarios();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Usuario :" + e.getStackTrace());
		}

		return view;
	}

	public String editUsuario() {
		String view = "";
		try {
			if (this.usuarioSelect != null) {
				this.usuario = usuarioSelect;

				view = "/usuario/update";
			} else {
				Message.messageInfo("Debe seleccionar un Usuario");
			}
		} catch (Exception e) {
			Message.messageError("Error Usuario :" + e.getMessage());
		}

		return view;
	}

	public void searchUsuarioById() {
		try {
			usuariosid = usuarioBusiness.getUsuarioById(this.filterId);
			resetForm();
			if (usuarios.isEmpty()) {
				Message.messageInfo("No se encontraron al usuario");

			}

		} catch (Exception e) {
			Message.messageError("Error Usuario Search :" + e.getMessage());
		}
	}

	public void selectUsuario(SelectEvent e) {
		this.usuarioSelect = (Usuario) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.usuario = new Usuario();
	}

	public UsuarioBusiness getUsuarioBusiness() {
		return usuarioBusiness;
	}

	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Optional<Usuario> getUsuariosid() {
		return usuariosid;
	}

	public void setUsuariosid(Optional<Usuario> usuariosid) {
		this.usuariosid = usuariosid;
	}

	public Usuario getUsuarioSelect() {
		return usuarioSelect;
	}

	public void setUsuarioSelect(Usuario usuarioSelect) {
		this.usuarioSelect = usuarioSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public Long getFilterId() {
		return filterId;
	}

	public void setFilterId(Long filterId) {
		this.filterId = filterId;
	}

	
}
