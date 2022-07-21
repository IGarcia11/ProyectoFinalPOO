package logico;

public class Plan {
	
	private String nombre;
	private String estado;
	private Servicio[] serviciosPlan;
	private int cantServicios;
	
	public Plan(String nombre, String estado) {
		super();
		this.nombre = nombre;
		this.estado = estado;
		this.serviciosPlan = new Servicio[2];
		this.cantServicios = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Servicio[] getServiciosPlan() {
		return serviciosPlan;
	}

	public int getCantServicios() {
		return cantServicios;
	}

	public float precioPlan() {
		float precioPlan = 0;
		float precio = 0;
		int cant = 0;
		for (int i = 0; i<cantServicios; i++) {
			precio+= serviciosPlan[i].costo();
			cant++;
		}
		if (cant==2) {
			precioPlan = (precio * 30)/100;
		}else if(cant==3) {
			precioPlan = (precio * 45)/100;
		}
		return precioPlan;
	}
	
	public void insertarServicio(Servicio se1) {
		serviciosPlan[cantServicios] = se1;
		cantServicios++;
	}
}
