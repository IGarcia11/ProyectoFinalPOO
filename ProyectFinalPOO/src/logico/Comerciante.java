package logico;

public class Comerciante extends Empleado {
	
	private float comision;
	private float pagoComision;	 

	public Comerciante(String cedulaEmpleado, String nombreEmpleado, String apellidoEmpleado, String user,
			String password, int codeEmpleado, float sueldoBase, float comision, float pagoComision) {
		super(cedulaEmpleado, nombreEmpleado, apellidoEmpleado, user, password, codeEmpleado, sueldoBase);
		this.comision = comision;
		this.pagoComision = pagoComision;
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

	/*public float sueldoByTipoEmpleado() {//SE LE VA A ESTABLECER 1% DE LA VENTA REALIZADA POR EMPLEADO.
		return (float) (pagoHorasExtras * horasExtras);
	}*/
}
