package logico;

public class Internet extends Servicio {
	
	private int velocidadSubida;
	private int velocidadBajada;

	public Internet(int velocidadSubida, int velocidadBajada) {
		super();
		this.setVelocidadSubida(velocidadSubida);
		this.setVelocidadBajada(velocidadBajada);
	}

	public int getVelocidadSubida() {
		return velocidadSubida;
	}

	public void setVelocidadSubida(int velocidadSubida) {
		this.velocidadSubida = velocidadSubida;
	}

	public int getVelocidadBajada() {
		return velocidadBajada;
	}

	public void setVelocidadBajada(int velocidadBajada) {
		this.velocidadBajada = velocidadBajada;
	}

	@Override
	public float costo() {
		float costo = ((velocidadSubida*175)+(velocidadBajada*130));
		return costo;
	}

	@Override
	public String capacidad() {
		String vB = Integer.toString(velocidadBajada);
		String vS = Integer.toString(velocidadSubida);
		String capacidad = vB+"Mbps / "+vS+"Mbps"; 
		return capacidad;
	}
}
