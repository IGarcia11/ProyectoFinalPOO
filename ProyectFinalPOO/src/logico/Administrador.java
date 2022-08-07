package logico;

public class Administrador extends Empleado {

	private int annosExperiencia;
	private float sueldoB;
	//private float horasExtras;
	
	
	public Administrador(String codeEmpleado, String cedulaEmpleado, String nombreEmpleado, float sueldoBase,String direccion, String telefono, String sexo,
			String tipo, String userName, String pass, float sueldoBruto, int annosExperiencia, float sueldoB) {
		super(codeEmpleado, cedulaEmpleado, nombreEmpleado, sueldoBase, direccion, telefono, sexo, tipo, userName, pass, sueldoBruto);
		this.annosExperiencia = annosExperiencia;	
		this.sueldoB = sueldoB;
	}


	public int getAnnosExperiencia() {
		return annosExperiencia;
	}


	public void setAnnosExperiencia(int annosExperiencia) {
		this.annosExperiencia = annosExperiencia;
	}	
	/*public void sueldoAdmin(float sueldo) {
		sueldo = annosExperiencia * 2500;
	}*/


	public float getSueldoB() {
		return sueldoB;
	}


	public void setSueldoB(float sueldoB) {
		this.sueldoB = sueldoB;
	}

	public float sueldoByAdmin() {
		return (float) (annosExperiencia * 2500) + sueldoB;
	}
}
