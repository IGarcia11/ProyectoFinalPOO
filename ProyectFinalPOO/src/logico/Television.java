package logico;

public class Television extends Servicio {
	
	private int cantCanalesLocales;
	private int cantCanalesHD;

	public Television(int cantCanalesLocales, int cantCanalesHD) {
		super();
		this.cantCanalesLocales = cantCanalesLocales;
		this.cantCanalesHD = cantCanalesHD;
	}

	public int getCantCanalesLocales() {
		return cantCanalesLocales;
	}

	public void setCantCanalesLocales(int cantCanalesLocales) {
		this.cantCanalesLocales = cantCanalesLocales;
	}

	public int getCantCanalesHD() {
		return cantCanalesHD;
	}

	public void setCantCanalesHD(int cantCanalesHD) {
		this.cantCanalesHD = cantCanalesHD;
	}

	@Override
	public float costo() {
		float costo = (float) ((cantCanalesLocales*5.80)+(cantCanalesHD*7.35));
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
		return 0;
	}

	@Override
	public int canalesLoc() {
		// TODO Auto-generated method stub
		return cantCanalesLocales;
	}

	@Override
	public int canalesHD() {
		// TODO Auto-generated method stub
		return cantCanalesHD;
	}

}
