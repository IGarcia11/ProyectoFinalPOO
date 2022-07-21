package logico;

public class Empleado {

	protected String cedulaEmpleado;
	protected String nombreEmpleado;
	protected String apellidoEmpleado;
	protected String user;
	protected String password;
	protected int codeEmpleado;
	private float sueldoBase;
	
	public Empleado(String cedulaEmpleado, String nombreEmpleado, String apellidoEmpleado, String user,
			String password, int codeEmpleado, float sueldoBase) {
		super();
		this.cedulaEmpleado = cedulaEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.user = user;
		this.password = password;
		this.codeEmpleado = codeEmpleado;
		this.sueldoBase = sueldoBase;
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

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCodeEmpleado() {
		return codeEmpleado;
	}

	public void setCodeEmpleado(int codeEmpleado) {
		this.codeEmpleado = codeEmpleado;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	

}
