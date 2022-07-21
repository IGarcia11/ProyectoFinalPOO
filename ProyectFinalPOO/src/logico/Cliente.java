package logico;

public class Cliente {

	private String cedCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String direccion;
	private String telefono;
	private char sexo;
	private int cantPuntosAcumulados;

	public Cliente(String cedCliente, String nombreCliente, String apellidoCliente, String direccion, String telefono,
			char sexo, int cantPuntosAcumulados) {
		super();
		this.cedCliente = cedCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sexo = sexo;
		this.cantPuntosAcumulados = cantPuntosAcumulados;
	}

	public String getCedCliente() {
		return cedCliente;
	}

	public void setCedCliente(String cedCliente) {
		this.cedCliente = cedCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getCantPuntosAcumulados() {
		return cantPuntosAcumulados;
	}

	public void setCantPuntosAcumulados(int cantPuntosAcumulados) {
		this.cantPuntosAcumulados = cantPuntosAcumulados;
	}

}
