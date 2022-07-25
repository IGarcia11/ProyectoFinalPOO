package logico;

import java.util.ArrayList;

public class Comerciante extends Empleado {
	
	private float porcentajeComision;
	//private float pagoComision;	 MULTIPLICAR COMISION*VENTAS
	private ArrayList<Venta> misVentas;
	
	public Comerciante(String codeEmpleado, String cedulaEmpleado, String nombreEmpleado, float sueldoBase, String direccion, String telefono, String sexo,
			float porcentajeComision) {
		super(codeEmpleado, cedulaEmpleado, nombreEmpleado, sueldoBase, direccion, telefono, sexo);
		this.porcentajeComision = porcentajeComision;
		this.misVentas = new ArrayList<>();
	}

	public float getPorcentajeComision() {
		return porcentajeComision;
	}

	public void setPorcentajeComision(float porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
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
