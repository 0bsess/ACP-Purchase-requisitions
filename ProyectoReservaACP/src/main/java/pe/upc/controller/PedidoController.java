package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import pe.upc.business.PedidoBusiness;
import pe.upc.model.entity.Pedido;
import pe.upc.util.Message;

@Named
@SessionScoped
public class PedidoController implements Serializable {
	private static final long serialVersionUID = 6L;

	@Inject
	private PedidoBusiness pedidoBusiness;


	private Pedido pedido;
	private List<Pedido> pedidos;
	private Pedido pedidoSelect;
	private String filterName;
	@PostConstruct
	public void init() {
		pedido = new Pedido();
		pedidos = new ArrayList<Pedido>();
		getAllPedidos();
	}

	public void getAllPedidos() {
		try {
			pedidos = pedidoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de pedidos :" + e.getMessage());
		}
	}

	public String newPedido() {

		try {
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listPedido() {
		return "list.xhtml";
	}

	public String savePedido() {
		String view = "";
		try {

			if (pedido.getIdPedido()!= null) {
				pedidoBusiness.update(pedido);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				pedidoBusiness.insert(pedido);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllPedidos();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Pedido :" + e.getStackTrace());
		}

		return view;
	}

	public String editPedido() {
		String view = "";
		try {
			if (this.pedidoSelect != null) {
				this.pedido = pedidoSelect;

				view = "/pedido/update";
			} else {
				Message.messageInfo("Debe seleccionar un Pedido");
			}
		} catch (Exception e) {
			Message.messageError("Error Pedido :" + e.getMessage());
		}

		return view;
	}

	public void selectPedido(SelectEvent e) {
		this.pedidoSelect = (Pedido) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.pedido = new Pedido();
	}

	public PedidoBusiness getPedidoBusiness() {
		return pedidoBusiness;
	}

	public void setPedidoBusiness(PedidoBusiness pedidoBusiness) {
		this.pedidoBusiness = pedidoBusiness;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido getPedidoSelect() {
		return pedidoSelect;
	}

	public void setPedidoSelect(Pedido pedidoSelect) {
		this.pedidoSelect = pedidoSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	
}
