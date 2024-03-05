package productosSupermercado.entidades;

public class Categoria {
	@Override
	public String toString() {
		return descripcion;
	}
	private int id;
	private String descripcion;
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categoria(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
