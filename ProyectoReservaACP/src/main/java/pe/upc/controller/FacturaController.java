package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import pe.upc.business.FacturaBusiness;
import pe.upc.model.entity.Factura;
import pe.upc.model.entity.Pedido;
import pe.upc.util.Message;

@Named
@SessionScoped
public class FacturaController implements Serializable {
	private static final long serialVersionUID = 6L;

	@Inject
	private FacturaBusiness facturaBusiness;


	private Factura factura;
	private List<Factura> facturas;
	private Factura facturaSelect;
	private String filterName;
	@PostConstruct
	public void init() {
		factura = new Factura();
		facturas = new ArrayList<Factura>();
		getAllFacturas();
	}

	public void getAllFacturas() {
		try {
			facturas = facturaBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de pedidos :" + e.getMessage());
		}
	}

	public String newFactura() {

		try {
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listfactura() {
		return "list.xhtml";
	}

	public String savePedido() {
		String view = "";
		try {

			if (factura.getIdFactura()!= null) {
				facturaBusiness.update(factura);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				facturaBusiness.insert(factura);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllFacturas();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Usuario :" + e.getStackTrace());
		}

		return view;
	}

	public String editPedido() {
		String view = "";
		try {
			if (this.facturaSelect != null) {
				this.factura = facturaSelect;

				view = "/factura/update";
			} else {
				Message.messageInfo("Debe seleccionar un factura");
			}
		} catch (Exception e) {
			Message.messageError("Error factura :" + e.getMessage());
		}

		return view;
	}

	public void selectFactura(SelectEvent e) {
		this.facturaSelect = (Factura) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.factura = new Factura();
	}

	public FacturaBusiness getFacturaBusiness() {
		return facturaBusiness;
	}

	public void setFacturaBusiness(FacturaBusiness facturaBusiness) {
		this.facturaBusiness = facturaBusiness;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura getFacturaSelect() {
		return facturaSelect;
	}

	public void setFacturaSelect(Factura facturaSelect) {
		this.facturaSelect = facturaSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	
	
}
