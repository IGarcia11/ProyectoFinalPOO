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
	public int velocidadB() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int velocidadS() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minutos() {
		// TODO Auto-generated method stub
		return minutos;
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
