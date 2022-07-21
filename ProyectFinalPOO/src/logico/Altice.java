package logico;

import java.util.ArrayList;

public class Altice {

	//private ArrayList<Usuario> users;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Venta> misVentas;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Empleado> misEmpleados;
	private static Altice altice = null;
	
	public Altice() {
		super();
		this.misClientes = new ArrayList<>();
		this.misVentas = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.misEmpleados = new ArrayList<>();
	}
	
	public static Altice getInstance() {
		if (altice == null) {
			altice= new Altice();
		}
		return altice;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}


	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}


	public ArrayList<Venta> getMisVentas() {
		return misVentas;
	}


	public void setMisVentas(ArrayList<Venta> misVentas) {
		this.misVentas = misVentas;
	}


	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}


	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}


	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}


	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}


	public Empleado findEmpleadoByNombre(String nombreEmpleado) {
		for (Empleado empleado : misEmpleados) {
			if (empleado.getNombreEmpleado().equals(nombreEmpleado)) {
				return empleado;
			}
		}
		return null;
	}
	
	
	public int cantVentasByEmpleado(String nombreEmpleado)
	{
		Empleado empleado = null;
		empleado = findEmpleadoByNombre(nombreEmpleado);
		int cantVentaComerciante = 0;
		if(empleado != null)
		{
			for(int i = 0; i < misEmpleados.size(); i++)
			{
				//misVentas.get(i).getEmployee().getNombreEmpleado().equalsIgnoreCase(nombreEmpleado)
				if(misVentas.get(i).getEmployee().getNombreEmpleado().equalsIgnoreCase(nombreEmpleado))
				{
					cantVentaComerciante++;
				}
			}
		}	
		return cantVentaComerciante;
	}
}
