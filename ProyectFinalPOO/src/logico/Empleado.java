package logico;

public class Empleado {

	protected String cedulaEmpleado;
	protected String nombreEmpleado;
	protected String codeEmpleado;
	private float sueldoBase;
	private String direccion;
	private String telefono;
	private String sexo;
	
	public Empleado(String codeEmpleado, String cedulaEmpleado, String nombreEmpleado, float sueldoBase, String direccion, String telefono, String sexo) {
		super();
		this.cedulaEmpleado = cedulaEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.codeEmpleado = codeEmpleado;
		this.sueldoBase = sueldoBase;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sexo = sexo; 
		
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
	
	

}
