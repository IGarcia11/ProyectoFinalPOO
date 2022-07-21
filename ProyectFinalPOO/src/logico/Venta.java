package logico;

import java.sql.Date;

public class Venta {
	
	private String codeVenta;
	private Date diaVenta;
	private float montoTotal;
	private int codeFactura;
	Cliente client;
	Empleado employee;

	public Venta(String codeVenta, Date diaVenta, float montoTotal, int codeFactura, Cliente client, Empleado employee) {
		super();
		this.codeVenta = codeVenta;
		this.diaVenta = diaVenta;
		this.montoTotal = montoTotal;
		this.codeFactura = codeFactura;
		this.client = client;
		this.employee = employee;
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

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
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



}
