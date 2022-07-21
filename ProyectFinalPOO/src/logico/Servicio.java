package logico;

public abstract class Servicio {
	
	protected String nombre;
	
	public Servicio(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract float costo();
}
