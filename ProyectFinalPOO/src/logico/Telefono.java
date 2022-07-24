package logico;

public class Telefono extends Servicio {
	
	private int minutos;

	public Telefono(int minutos) {
		super();
		this.minutos = minutos;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	@Override
	public float costo() {
		float costo = (float) (minutos*1.85);
		return costo;
	}

	@Override
	public String capacidad() {
		String min = Integer.toString(minutos)+" minutos";
		return min;
	}
}
