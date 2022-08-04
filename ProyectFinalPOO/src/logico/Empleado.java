package logico;

public class Empleado {

	protected String cedulaEmpleado;
	protected String nombreEmpleado;
	protected String codeEmpleado;
	private float sueldoBase;
	private String direccion;
	private String telefono;
	private String sexo;
	public static int generadorCodEmpleado = 1;
	Administrador adm;
	
	public Empleado(String codeEmpleado, String cedulaEmpleado, String nombreEmpleado, float sueldoBase, String direccion, String telefono, String sexo) {
		super();
		this.cedulaEmpleado = cedulaEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.codeEmpleado = codeEmpleado;
		this.sueldoBase = sueldoBase;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sexo = sexo; 
		Empleado.generadorCodEmpleado++;
		
	}

	public String getCedulaEmpleado() {
		return cedulaEmpleado;
	}

	public void setCedulaEmpleado(String cedulaEmpleado) {
		this.cedulaEmpleado = cedulaEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getCodeEmpleado() {
		return codeEmpleado;
	}

	public void setCodeEmpleado(String codeEmpleado) {
		this.codeEmpleado = codeEmpleado;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	//public abstract float sueldoByTipoEmpleado();
	
	/*public float sueldoTotalAdmin(){//float sueldoTotalAdmin() {
		Administrador admin;
		float sueldoBruto = 0;
		System.out.println("sueldo b en empleado "+getSueldoBase());
		sueldoBruto = sueldoBase + getAnnosExperiencia; // + admin.getAnnosExperiencia(); //+ admin.getAnnosExperiencia() ;
		//return sueldoBruto;
		return (float) sueldoBase + (2500);
	}*/

	public static int getGeneradorCodEmpleado() {
		return generadorCodEmpleado;
	}

	public static void setGeneradorCodEmpleado(int generadorCodEmpleado) {
		Empleado.generadorCodEmpleado = generadorCodEmpleado;
	}

	public float sueldoByTipoEmpleadoComerciante() {
		// TODO Auto-generated method stub
		return 0;
	}

}
