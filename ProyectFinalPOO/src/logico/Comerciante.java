package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Comerciante extends Empleado /*implements Serializable*/ {
	
	//private static final long serialVersionUID = 1L;
	private float porcentajeComision;
	//private float pagoComision;	 MULTIPLICAR COMISION*VENTAS
	private ArrayList<Venta> misVentas;
	private ArrayList<Factura> myFacturas;
	Altice alt;
	//private float sueldoBruto;
	
	public Comerciante(String codeEmpleado, String cedulaEmpleado, String nombreEmpleado, float sueldoBase, String direccion, String telefono, String sexo,
			String tipo, String userName, String pass, float porcentajeComision, float sueldoBruto) {	
		super(codeEmpleado, cedulaEmpleado, nombreEmpleado, sueldoBase, direccion, telefono, sexo, tipo, userName, pass, sueldoBruto);
		this.porcentajeComision = porcentajeComision;
		this.misVentas = new ArrayList<>();
		//this.sueldoBruto = sueldoBruto;
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
	/*public float getSueldoBruto() {
		return sueldoBruto;
	}

	public void setSueldoBruto(float sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}*/
	
	//@Override 
	
	

	/*public float sueldoByTipoEmpleado() {//SE LE VA A ESTABLECER 1% DE LA VENTA REALIZADA POR EMPLEADO.
		return (float) (porcentajeComision * horasExtras);
	}*/
}
