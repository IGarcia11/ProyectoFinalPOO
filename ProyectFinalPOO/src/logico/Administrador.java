package logico;

public class Administrador extends Empleado {

	private float pagoHorasExtras;
	private float horasExtras;
	
	public Administrador(String cedulaEmpleado, String nombreEmpleado, String apellidoEmpleado, String user,
			String password, int codeEmpleado, float sueldoBase, float pagoHorasExtras, float horasExtras) {
		super(cedulaEmpleado, nombreEmpleado, apellidoEmpleado, user, password, codeEmpleado, sueldoBase);
		this.pagoHorasExtras = pagoHorasExtras;
		this.horasExtras = horasExtras;
	}

	public float getPagoHorasExtras() {
		return pagoHorasExtras;
	}

	public void setPagoHorasExtras(float pagoHorasExtras) {
		this.pagoHorasExtras = pagoHorasExtras;
	}

	public float getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(float horasExtras) {
		this.horasExtras = horasExtras;
	}

	public float sueldoByTipoEmpleado() {
		return (float) (pagoHorasExtras * horasExtras);
	}
}
