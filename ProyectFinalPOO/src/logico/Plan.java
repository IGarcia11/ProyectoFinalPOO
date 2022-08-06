package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Plan implements Serializable{
	
	private String nombre;
	private String estado;
	private ArrayList<Servicio> serviciosPlan;
	private static final long serialVersionUID = 1L;
	
	public Plan(String nombre) {
		super();
		this.nombre = nombre;
		this.estado = "Activo";
		this.serviciosPlan = new ArrayList<>();
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


	public ArrayList<Servicio> getServiciosPlan() {
		return serviciosPlan;
	}

	public float precioPlan() {
		float precioPlan = 0;
		float precio = 0;
		int cant = 0;
		for (int i = 0; i<serviciosPlan.size(); i++) {
			precio+= serviciosPlan.get(i).costo();
			cant++;
		}
		if(cant==1) {
			precioPlan = precio;
		}
		if (cant==2) {
			precioPlan = (precio * 85)/100;
		}else if(cant==3) {
			precioPlan = (precio * 70)/100;
		}
		return precioPlan;
	}
	
	public void insertarServicio(Servicio se1) {
		serviciosPlan.add(se1);
	}
}
