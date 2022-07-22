package logico;

import java.util.ArrayList;

public class Altice {

	//private ArrayList<Usuario> users;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Venta> misVentas;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Plan> misPlanes;
	public static int generadorCodFactura = 1;
	public static int generadorCodEmpleado = 1;
	public static int generadorCodVenta = 1;
	private static Altice altice = null;
	
	private Altice() {
		super();
		this.misClientes = new ArrayList<>();
		this.misVentas = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.misEmpleados = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
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

	public ArrayList<Venta> getMisVentas() {
		return misVentas;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
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
	
	public Cliente buscarClienteByCedula(String cedula) {
		boolean encontrado = false;
		Cliente aux = null;
		int i = 0;
		while(!encontrado && i<misClientes.size()) {
			if(misClientes.get(i).getCedCliente().equalsIgnoreCase(cedula)) {
				aux = misClientes.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public void insertarCliente(Cliente c1) {
		misClientes.add(c1);
	}
	
	public void insertarEmpleado(Empleado e1) {
		misEmpleados.add(e1);
		generadorCodEmpleado++;
	}
	
	public void insertarFactura(Factura f1) {
		misFacturas.add(f1);
		generadorCodFactura++;
	}
	
	public void insertarVenta(Venta v1) {
		misVentas.add(v1);
		generadorCodVenta++;
	}
	
	public void insertarPlan(Plan p1) {
		misPlanes.add(p1);
	}

	
}



