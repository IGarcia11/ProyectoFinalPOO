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
	public int velocidadB() {
		// TODO Auto-generated method stub
		return velocidadBajada;
	}

	@Override
	public int velocidadS() {
		// TODO Auto-generated method stub
		return velocidadSubida;
	}

	@Override
	public int minutos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int canalesLoc() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int canalesHD() {
		// TODO Auto-generated method stub
		return 0;
	}



}
