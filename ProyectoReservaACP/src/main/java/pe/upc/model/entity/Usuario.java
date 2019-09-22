package pe.upc.model.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	private String nameUsuario;
	private String nameApPaterno;
	private String nameApMaterno;
	private String idDocumento;
	private String phone;
	private String email;
	private String password;
	private boolean flagAdmin;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNameUsuario() {
		return nameUsuario;
	}
	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}
	public String getNameApPaterno() {
		return nameApPaterno;
	}
	public void setNameApPaterno(String nameApPaterno) {
		this.nameApPaterno = nameApPaterno;
	}
	public String getNameApMaterno() {
		return nameApMaterno;
	}
	public void setNameApMaterno(String nameApMaterno) {
		this.nameApMaterno = nameApMaterno;
	}
	public String getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isFlagAdmin() {
		return flagAdmin;
	}
	public void setFlagAdmin(boolean flagAdmin) {
		this.flagAdmin = flagAdmin;
	}
	
	

}
