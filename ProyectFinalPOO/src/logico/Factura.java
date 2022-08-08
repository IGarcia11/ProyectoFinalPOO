package logico;

import java.io.Serializable;
import java.time.LocalDate;


public class Factura extends Thread implements Serializable{

	private String codeFactura;
    Cliente micliente;
	private LocalDate fechaFactura;
	Plan miPlan;
	//private ArrayList<Plan> planes;
	private int diaCorte;
	private String estado;
	private static final long serialVersionUID = 1L;
	//Plan pn;
	
	public Factura(String codeFactura, Cliente micliente, Plan miPlan, LocalDate fechaFactura, int diaCorte) {
		super();
		this.codeFactura = codeFactura;
		this.micliente = micliente;
		this.setFechaFactura(fechaFactura);
		this.miPlan = miPlan;
		//this.planes = new ArrayList<>();
		this.diaCorte = diaCorte;
		this.estado = "Pagada";
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
	
	/*public ArrayList<Plan> getPlanes() {
		return planes;
	}*/
	
	public Plan getMiPlan() {
		return miPlan;
	}

	public int getDiaCorte() {
		return diaCorte;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public float totalFactura() {
		float total = miPlan.precioPlan();
		/*for(int i = 0; i<planes.size(); i++) {
			total+= planes.get(i).precioPlan();
		}*/
		return total;
	}
	
	@Override
	public void run(){
		int i=0; 
		while(true) {
			esperar();
			i++;
			LocalDate fechaNueva = fechaFactura.plusMonths(i);
			Factura f1 = new Factura("F-"+Altice.getInstance().generadorCodFactura, this.micliente, this.miPlan, fechaNueva, diaCorte);
			f1.setEstado("Vencida");
			micliente.insertarFactura(f1);
			Altice.getInstance().insertarFactura(f1);
		}
	}

	private void esperar() {
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/*public void darFechaActual(Date fechaFactura) {
		LocalDate fechaActual = LocalDate.now();
	}*/
	
	
	/*public void insertarPlanesFactura(Plan p1) {
		planes.add(p1);
	}*/


	/*public void setPlanes(ArrayList<Plan> planes) {
		this.planes = planes;
	}*/
	
}

