package logico;

import java.io.Serializable;
import java.util.ArrayList;


public class Altice implements Serializable{

	//private ArrayList<Usuario> users;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Venta> misVentas;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Plan> misPlanes;
	public int generadorCodFactura = 1;
	public int generadorCodEmpleado = 0;
	public int generadorCodVenta = 1;
	private static Altice altice = null;
	Empleado worker;
	Administrador admin;
	private static final long serialVersionUID = 1L;
	//private static User loginUser;
	private static Empleado loginUser;
	private ArrayList<User> misUsers;
	//private static Altice altice;
	
	private Altice() {
		super();
		this.misClientes = new ArrayList<>();
		this.misVentas = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.misEmpleados = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
		this.misUsers = new ArrayList<>();

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
	public Empleado findEmpleadoByUser(String userName) {
		for (Empleado empleado : misEmpleados) {
			if (empleado.getUserName().equals(userName)) {
				return empleado;
			}
		}
		return null;
	}
	/*
	 * public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		for(Empleado emp : misEmpleados) {
			if(emp.getUserName().equals(text) && emp.getPass().equals(text2)){//getUserName().equals(text) && user.getPass().equals(text2)) {
				System.out.println("login correct");
				loginUser = emp;
				login = true;
			}
		}
		return login;
	}
	
	 */
	
	public float gananciaEstimada(String nombrePlan) {
		float totalGanancia = 0;
		for(Venta v : misVentas) {
			if(v.getPlan().getNombre().equals(nombrePlan)) {
				totalGanancia += v.montoTotal();
				System.out.println("Total Ganancia  -- "+totalGanancia);
			}			
		}
		return totalGanancia;
	}
	
	public int cantVentasByPlan(String nombrePlan) {
		int cant = 0;
		for(Venta sale : misVentas) {
			if(sale.getPlan().getNombre().equals(nombrePlan)) {
				cant++;
				System.out.println("Cant Ventas  -- "+cant);
			}
			
		}
		return cant;
	}
	
	/*public int cantVentasEmpleado(String nombreU)
	{
		
		int cantVentaComerciante = 0;
		if(confirmLogin(nombreU, nombreU) == true) {
			for(User user : misUsers) {
				loginUser = user;

			}
		}

		if(empleado != null)
		{
			for(int i = 0; i < misEmpleados.size(); i++)
			{
				if(misVentas.get(i).getEmployee().getNombreEmpleado().equalsIgnoreCase(nombreEmpleado))
				{
					cantVentaComerciante++;
				}
			}
		}	
		return cantVentaComerciante;
	}*/
	
	/*public int cantVentasByEmpleado(String nombreEmpleado)
	{
		Empleado empleado = null;
		Empleado emp = null;
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
	}*/
	
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
	
	public Plan buscarPlanByNombre(String nombre) {
		boolean encontrado = false;
		Plan aux = null;
		int i = 0;
		while(!encontrado && i<misPlanes.size()) {
			if(misPlanes.get(i).getNombre().equalsIgnoreCase(nombre)) {
				aux = misPlanes.get(i);
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

	public static Altice getAltice() {
		return altice;
	}

	public static void setAltice(Altice altice) {
		Altice.altice = altice;
	}

	public ArrayList<User> getMisUsers() {
		return misUsers;
	}

	public void setMisUsers(ArrayList<User> misUsers) {
		this.misUsers = misUsers;
	}
	public void regUser( User user) {
		misUsers.add(user);
	}

	public static Empleado getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(Empleado loginUser) {
		Altice.loginUser = loginUser;
	}
	
	public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		for(Empleado emp : misEmpleados) {
			if(emp.getUserName().equals(text) && emp.getPass().equals(text2)){//getUserName().equals(text) && user.getPass().equals(text2)) {
				System.out.println("login correct");
				loginUser = emp;
				login = true;
			}
		}
		return login;
	}
	
	/*public float cantVentasByEmpleado() {
		float ventas = 0;
		for(Empleado emp : misEmpleados) {
			if(emp.getUserName().equals(getLoginUser())){	//getLoginUser().equals(emp.getUserName())) {
				System.out.println("Son iguales");
				for(Factura fac : misFacturas) {
					ventas += fac.totalFactura();
					System.out.println(""+ventas);
					//emp.com.
				}
				//ventas += ;
			}
		}
		
		return ventas;
	}*/
	/*public float sueldoBrutoComerciante() {
		
		float sueldoBruto = 0;
		for(Empleado emp : misEmpleados) {		
			//Comerciante aux = new Comerciante();
			//((Administrador) emp).sueldoByAdmin();
			System.out.println(""+sueldoBruto);
		}
		return sueldoBruto;
	}*/

	public Factura buscarFacturaByCode(String codigo) {
		boolean encontrado = false;
		Factura aux = null;
		int i = 0;
		while(!encontrado && i<misFacturas.size()) {
			if(misFacturas.get(i).getCodeFactura().equalsIgnoreCase(codigo)) {
				aux = misFacturas.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}

	public void modificarCliente(Cliente auxCliente) {
		int aux = -1;
		aux = buscarIndexByCliente(auxCliente.getCedCliente());
		misClientes.remove(aux);
		misClientes.add(aux, auxCliente);
		
	}
	
	private int buscarIndexByCliente(String cedula) {
		boolean encontrado = false;
		int aux = -1;
		int i = 0;
		while(!encontrado && i<misClientes.size()) {
			if(misClientes.get(i).getCedCliente().equalsIgnoreCase(cedula)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	private int buscarIndexByEmpleado(String cedula) {
		boolean encontrado = false;
		int aux = -1;
		int i = 0;
		while(!encontrado && i<misEmpleados.size()) {
			if(misEmpleados.get(i).getCedulaEmpleado().equalsIgnoreCase(cedula)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		return aux;
	}

	public void modificarEmpleado(Empleado auxEmpleado) {
		int aux = -1;
		aux = buscarIndexByEmpleado(auxEmpleado.getCedulaEmpleado());
		misEmpleados.remove(aux);
		misEmpleados.add(aux, auxEmpleado);
		
	}

	public Empleado buscarEmpleadoByCod(String cod) {
		boolean encontrado = false;
		Empleado aux = null;
		int i = 0;
		while(!encontrado && i<misEmpleados.size()) {
			if(misEmpleados.get(i).getCodeEmpleado().equalsIgnoreCase(cod)) {
				aux = misEmpleados.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}

	/**
	 * @param misUsers
	 */

	
	/*public float totalFactura (Plan p) {
		float suma = 0;
		suma += p.precioPlan();
		/*for (Plan plan : getMisPlanes()) {
			suma += plan.precioPlan();
		}*/

		//return suma;//+=getMisPlanes().p;
	//}
	
	/*public float totalFactura() {
		float total = 0;
		for(int i = 0; i<getMisPlanes().size(); i++) {
			total+= getMisPlanes().get(i).precioPlan();
		}
		return total;
	}*/

	
}



