package productosSupermercado.entidades;

import java.util.Date;

public class Producto {
	@Override
	public String toString() {
		return descripcion;
	}
	private int id, idCategoria, unidadesStock;
	private String descripcion, codigo;
	private Date fechaCaducidad;
	private Boolean perecedero;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Boolean getPerecedero() {
		return perecedero;
	}
	public void setPerecedero(Boolean perecedero) {
		this.perecedero = perecedero;
	}
	public int getUnidadesStock() {
		return unidadesStock;
	}
	public void setUnidadesStock(int unidadesStock) {
		this.unidadesStock = unidadesStock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public Producto(int id, int idCategoria, Boolean perecedero, int unidadesStock, String descripcion, String codigo,
			Date fechaCaducidad) {
		super();
		this.id = id;
		this.idCategoria = idCategoria;
		this.perecedero = perecedero;
		this.unidadesStock = unidadesStock;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.fechaCaducidad = fechaCaducidad;
	}
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
