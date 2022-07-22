package logico;

import java.sql.Date;
import java.util.ArrayList;

public class Venta {
	
	private String codeVenta;
	private Date diaVenta;
	private int codeFactura;
	Cliente client;
	Empleado employee;
	private ArrayList<Plan> misPlanes;

	public Venta(String codeVenta, Date diaVenta, int codeFactura, Cliente client, Empleado employee) {
		super();
		this.codeVenta = codeVenta;
		this.diaVenta = diaVenta;
		this.codeFactura = codeFactura;
		this.client = client;
		this.employee = employee;
		this.misPlanes = new ArrayList<>();
	}

	public String getCodeVenta() {
		return codeVenta;
	}

	public void setCodeVenta(String codeVenta) {
		this.codeVenta = codeVenta;
	}

	public Date getDiaVenta() {
		return diaVenta;
	}

	public void setDiaVenta(Date diaVenta) {
		this.diaVenta = diaVenta;
	}

	public int getCodeFactura() {
		return codeFactura;
	}

	public void setCodeFactura(int codeFactura) {
		this.codeFactura = codeFactura;
	}

	public Cliente getClient() {
		return client;
	}

	public void setClient(Cliente client) {
		this.client = client;
	}

	public Empleado getEmployee() {
		return employee;
	}

	public void setEmployee(Empleado employee) {
		this.employee = employee;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public float montoTotal() {
		float total = 0;
		for(int i = 0; i<misPlanes.size(); i++) {
			total+= misPlanes.get(i).precioPlan();
		}
		return total;
	}
	
	public void insertarPlan(Plan p1) {
		misPlanes.add(p1);
	}

}
