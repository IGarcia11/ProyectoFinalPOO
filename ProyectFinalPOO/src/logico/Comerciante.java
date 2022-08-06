package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Comerciante extends Empleado /*implements Serializable*/ {
	
	//private static final long serialVersionUID = 1L;
	private float porcentajeComision;
	//private float pagoComision;	 MULTIPLICAR COMISION*VENTAS
	private ArrayList<Venta> misVentas;
	Altice alt;
	
	public Comerciante(String codeEmpleado, String cedulaEmpleado, String nombreEmpleado, float sueldoBase, String direccion, String telefono, String sexo,
			String tipo, String userName, String pass, float porcentajeComision) {
		super(codeEmpleado, cedulaEmpleado, nombreEmpleado, sueldoBase, direccion, telefono, sexo, tipo, userName, pass);
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
	@Override 
	public float sueldoByTipoEmpleadoComerciante() {
		
		return (Float) null; //Altice.getInstance().cantVentasByEmpleado(cedulaEmpleado);
	}

	/*public float sueldoByTipoEmpleado() {//SE LE VA A ESTABLECER 1% DE LA VENTA REALIZADA POR EMPLEADO.
		return (float) (porcentajeComision * horasExtras);
	}*/
}
