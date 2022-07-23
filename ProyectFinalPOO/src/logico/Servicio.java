package logico;

public abstract class Servicio {
	
	public Servicio() {
		super();
	
	}

	public abstract float costo();
	public abstract int velocidadB();
	public abstract int velocidadS();
	public abstract int minutos();
	public abstract int canalesLoc();
	public abstract int canalesHD();
}
