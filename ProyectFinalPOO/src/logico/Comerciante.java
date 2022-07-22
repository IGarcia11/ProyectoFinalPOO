package logico;

import java.util.ArrayList;

public class Comerciante extends Empleado {
	
	private float comision;
	private float pagoComision;	 
	private ArrayList<Venta> misVentas;

	public Comerciante(String cedulaEmpleado, String nombreEmpleado, String apellidoEmpleado, String user,
			String password, int codeEmpleado, float sueldoBase, float comision, float pagoComision) {
		super(cedulaEmpleado, nombreEmpleado, apellidoEmpleado, user, password, codeEmpleado, sueldoBase);
		this.comision = comision;
		this.pagoComision = pagoComision;
		this.misVentas = new ArrayList<>();
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public float getPagoComision() {
		return pagoComision;
	}

	public void setPagoComision(float pagoComision) {
		this.pagoComision = pagoComision;
	}

	public ArrayList<Venta> getMisVentas() {
		return misVentas;
	}
	
	public void insertarVenta(Venta v1) {
		misVentas.add(v1);
	}

	/*public float sueldoByTipoEmpleado() {//SE LE VA A ESTABLECER 1% DE LA VENTA REALIZADA POR EMPLEADO.
		return (float) (pagoHorasExtras * horasExtras);
	}*/
}
