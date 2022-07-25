package logico;

public class Administrador extends Empleado {

	private float pagoHorasExtras;
	//private float horasExtras;
	
	
	public Administrador(String codeEmpleado, String cedulaEmpleado, String nombreEmpleado, float sueldoBase,String direccion, String telefono, String sexo,
			float pagoHorasExtras) {
		super(codeEmpleado, cedulaEmpleado, nombreEmpleado, sueldoBase, direccion, telefono, sexo);
		this.pagoHorasExtras = pagoHorasExtras;		
	}

	public float getPagoHorasExtras() {
		return pagoHorasExtras;
	}

	public void setPagoHorasExtras(float pagoHorasExtras) {
		this.pagoHorasExtras = pagoHorasExtras;
	}

	/*public float sueldoByTipoEmpleado() {
		return (float) (pagoHorasExtras * horasExtras);
	}*/
}
