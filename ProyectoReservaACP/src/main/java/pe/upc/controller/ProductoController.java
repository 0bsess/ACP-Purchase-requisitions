package pe.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.ProductoBusiness;
import pe.upc.model.entity.Producto;
import pe.upc.util.Message;

@Named
@SessionScoped
public class ProductoController implements Serializable{
	private static final long serialVersionUID = 4L;

	@Inject
	private ProductoBusiness productBusiness;

	private Producto product;
	private List<Producto> products;
	private Producto productSelect;

	private String filterName;

	@PostConstruct
	public void init() {
		product = new Producto();
		products = new ArrayList<Producto>();
		getAllProducts();
	}

	public void getAllProducts() {
		try {
			products = productBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Productos :" + e.getMessage());
		}
	}

	public String newProduct() {

		try {
			resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String listProduct() {
		return "list.xhtml";
	}
	
	public String saveProduct() {
	String view = "";
	try {

		if (product.getIdProducto() != null) {
			productBusiness.update(product);
			Message.messageInfo("Registro actualizado exitosamente");
		} else {
			if(productBusiness.validar(product.getNameProducto())==null)
			{
				productBusiness.insert(product);
			Message.messageInfo("Registro guardado exitosamente");
			}
			else {
				Message.messageInfo("El producto ya se encuentra registrado");
			}
		}
		this.getAllProducts();
		resetForm();
		view = "list";
	} catch (Exception e) {
		Message.messageError("Error Producto :" + e.getStackTrace());
	}

	return view;
}
	public String editProduct() {
		String view = "";
		try {
			if (this.productSelect != null) {
				this.product = productSelect;

				view = "/producto/update";
			} else {
				Message.messageInfo("Debe seleccionar un producto");
			}
		} catch (Exception e) {
			Message.messageError("Error Producto :" + e.getMessage());
		}

		return view;
	}

	public void searchProductoByName() {
		try {
			products = productBusiness.getProductosByName(this.filterName.trim());
			resetForm();
			if (products.isEmpty()) {
				Message.messageInfo("No se encontraron productos");
			}

		} catch (Exception e) {
			Message.messageError("Error Product Search :" + e.getMessage());
		}
	}

	public void selectProduct(SelectEvent e) {
		this.productSelect = (Producto) e.getObject();
	}

	public void resetForm() {
		this.filterName = "";
		this.product = new Producto();
	}

	public Producto getProduct() {
		return product;
	}

	public void setProduct(Producto product) {
		this.product = product;
	}

	public List<Producto> getProducts() {
		return products;
	}

	public void setProducts(List<Producto> products) {
		this.products = products;
	}

	public Producto getProductSelect() {
		return productSelect;
	}

	public void setProductSelect(Producto productSelect) {
		this.productSelect = productSelect;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
