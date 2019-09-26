package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import pe.upc.business.ReservaBusiness;
import pe.upc.model.entity.Reserva;
import pe.upc.util.Message;

@Named
@SessionScoped
public class ReservaController implements Serializable {
	private static final long serialVersionUID = 5L;

	@Inject
	private ReservaBusiness reservaBusiness;


	private Reserva reserva;
	private List<Reserva> reservas;
	private Reserva reservaSelect;
	private String filterName;
	@PostConstruct
	public void init() {
		reserva = new Reserva();
		reservas = new ArrayList<Reserva>();
		getAllReserva();
	}

	public void getAllReserva() {
		try {
			reservas = reservaBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Reserva :" + e.getMessage());
		}
	}

	public String newReserva() {

		try {
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listReserva() {
		return "list.xhtml";
	}

	public String saveReserva() {
		String view = "";
		try {

			if (reserva.getIdReserva()!= null) {
				reservaBusiness.update(reserva);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				reservaBusiness.insert(reserva);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllReserva();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Usuario :" + e.getStackTrace());
		}

		return view;
	}

	public String editReserva() {
		String view = "";
		try {
			if (this.reservaSelect != null) {
				this.reserva = reservaSelect;

				view = "/reserva/update";
			} else {
				Message.messageInfo("Debe seleccionar un Usuario");
			}
		} catch (Exception e) {
			Message.messageError("Error Usuario :" + e.getMessage());
		}

		return view;
	}

	public void selectReserva(SelectEvent e) {
		this.reservaSelect = (Reserva) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.reserva = new Reserva();
	}

	public ReservaBusiness getReservaBusiness() {
		return reservaBusiness;
	}

	public void setReservaBusiness(ReservaBusiness reservaBusiness) {
		this.reservaBusiness = reservaBusiness;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva getReservaSelect() {
		return reservaSelect;
	}

	public void setReservaSelect(Reserva reservaSelect) {
		this.reservaSelect = reservaSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
