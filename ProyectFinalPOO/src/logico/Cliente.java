package logico;

import java.util.ArrayList;

public class Cliente {

	private String cedCliente;
	private String nombreCliente;
	private String direccion;
	private String telefono;
	private int cantPuntosAcumulados;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Venta> misCompras;

	public Cliente(String cedCliente, String nombreCliente, String direccion, String telefono) {
		super();
		this.cedCliente = cedCliente;
		this.nombreCliente = nombreCliente;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cantPuntosAcumulados = 0;
		this.misFacturas = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
		this.misCompras = new ArrayList<>();
	}

	public String getCedCliente() {
		return cedCliente;
	}

	public void setCedCliente(String cedCliente) {
		this.cedCliente = cedCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCantPuntosAcumulados() {
		return cantPuntosAcumulados;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public ArrayList<Venta> getMisCompras() {
		return misCompras;
	}
	
	public void insertarFactura(Factura f1) {
		misFacturas.add(f1);
	}
	
	public void insertarVenta(Venta v1) {
		misCompras.add(v1);
	}
	
	public void insertarPlan(Plan p1) {
		misPlanes.add(p1);
	}

}
