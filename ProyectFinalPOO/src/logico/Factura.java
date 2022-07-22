package logico;

import java.sql.Date;
import java.util.ArrayList;

public class Factura {

	private String codeFactura;
	private Cliente micliente;
	private Date fechaFactura;
	private ArrayList<Plan> misPlanes;
	
	public Factura(String codeFactura, Cliente micliente, Date fechaFactura) {
		super();
		this.codeFactura = codeFactura;
		this.micliente = micliente;
		this.fechaFactura = fechaFactura;
		this.misPlanes = new ArrayList<>();
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

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	
	public float totalFactura() {
		float total = 0;
		for(int i = 0; i<misPlanes.size(); i++) {
			total+= misPlanes.get(i).precioPlan();
		}
		return total;
	}
	
	
	public void insertarPlanesFactura(Plan p1) {
		misPlanes.add(p1);
	}
	
}

