package logico;

import java.io.Serializable;
import java.time.LocalDate;

public class Venta implements Serializable{
	
	private String codeVenta;
	private LocalDate diaVenta;
	//private int codeFactura;
	Cliente client;
	Empleado employee;
	Plan plan;
	//private ArrayList<Plan> misPlanes;
	private static final long serialVersionUID = 1L;
	//private Calendar fechaPrueba; //UTILIZA ESTE ATRIBUTO PARA LA FECHA

	public Venta(String codeVenta, LocalDate diaVenta, Cliente client, Empleado employee, Plan plan) {
		super();
		this.codeVenta = codeVenta;
		this.diaVenta = diaVenta;//LocalDate.now();
		this.client = client;
		this.employee = employee;
		this.plan = plan;
		
	}

	public String getCodeVenta() {
		return codeVenta;
	}

	public void setCodeVenta(String codeVenta) {
		this.codeVenta = codeVenta;
		
	}

	/*public LocalDate getDiaVenta() {
		diaVenta = LocalDate.now();
		
		return diaVenta;
	}
	
	public void setDiaVenta(LocalDate diaVenta) {
		//String formatoFecha = "2022/07/26";
		//diaVenta = LocalDate.parse(formatoFecha);
		this.diaVenta = LocalDate.now(); //LocalDate.now();
	}*/

	public LocalDate getDiaVenta() {
		return diaVenta;
	}

	public void setDiaVenta(LocalDate diaVenta) {
		this.diaVenta = diaVenta;
	}

	/*public int getCodeFactura() {
		return codeFactura;
	}

	public void setCodeFactura(int codeFactura) {
		this.codeFactura = codeFactura;
	}*/

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

	/*public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}*/

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public float montoTotal() {
		float total = plan.precioPlan();
		/*for(int i = 0; i<misPlanes.size(); i++) {
			total+= misPlanes.get(i).precioPlan();
		}*/
		return total;
	}
	
	/*public void insertarPlan(Plan p1) {
		misPlanes.add(p1);
	}*/

	
	/*public Venta(int codeFactura) {
		super();
		this.codeFactura = codeFactura;
	}*/

	/*public Calendar getFechaPrueba() {
		return fechaPrueba;
	}

	public void setFechaPrueba(Calendar fechaPrueba) {
		this.fechaPrueba = fechaPrueba;
	}*/

}

