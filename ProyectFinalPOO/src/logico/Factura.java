package logico;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Factura {

	private String codeFactura;
	private Cliente micliente;
	private Date fechaFactura;
	private ArrayList<Plan> planes;
	//Plan pn;
	
	public Factura(String codeFactura, Cliente micliente, Date fechaFactura) {
		super();
		this.codeFactura = codeFactura;
		this.micliente = micliente;
		this.fechaFactura = fechaFactura;
		this.planes = new ArrayList<>();
	}


	public String getCodeFactura() {
		return codeFactura;  	
	}

	public void setCodeFactura(String codeFactura) {
		this.codeFactura = codeFactura;
	}	

	public Cliente getMicliente() {
		return micliente;
	}

	public void setMicliente(Cliente micliente) {
		this.micliente = micliente;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	/*public ArrayList<Plan> getMisPlanes() {
		return planes;
	}
	
	public void setPlanes(ArrayList<Plan> planes) {
		this.planes = planes;
	}*/
	/*
	 * public void setMisquesos(ArrayList<Queso> misquesos) {
		this.misquesos = misquesos;
	}
	 */
	
	public float totalFactura() {
		float total = 0;
		for(int i = 0; i<planes.size(); i++) {
			total+= planes.get(i).precioPlan();
		}
		return total;
	}
	public void darFechaActual(Date fechaFactura) {
		LocalDate fechaActual = LocalDate.now();
	}
	
	
	public void insertarPlanesFactura(Plan p1) {
		planes.add(p1);
	}


	public ArrayList<Plan> getPlanes() {
		return planes;
	}


	public void setPlanes(ArrayList<Plan> planes) {
		this.planes = planes;
	}
	
}

