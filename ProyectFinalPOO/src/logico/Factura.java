package logico;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Factura implements Serializable{

	private String codeFactura;
    Cliente micliente;
	private LocalDate fechaFactura;
	private ArrayList<Plan> planes;
	private int diaCorte;
	private static final long serialVersionUID = 1L;
	//Plan pn;
	
	public Factura(String codeFactura, Cliente micliente, LocalDate fechaFactura, int diaCorte) {
		super();
		this.codeFactura = codeFactura;
		this.micliente = micliente;
		this.setFechaFactura(fechaFactura);
		this.planes = new ArrayList<>();
		this.diaCorte = diaCorte;
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
	
	public LocalDate getFechaFactura() {
		return fechaFactura;
	}


	public void setFechaFactura(LocalDate fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	
	public ArrayList<Plan> getPlanes() {
		return planes;
	}

	public int getDiaCorte() {
		return diaCorte;
	}


	public float totalFactura() {
		float total = 0;
		for(int i = 0; i<planes.size(); i++) {
			total+= planes.get(i).precioPlan();
		}
		return total;
	}
	
	/*public void darFechaActual(Date fechaFactura) {
		LocalDate fechaActual = LocalDate.now();
	}*/
	
	
	public void insertarPlanesFactura(Plan p1) {
		planes.add(p1);
	}


	/*public void setPlanes(ArrayList<Plan> planes) {
		this.planes = planes;
	}*/
	
}

