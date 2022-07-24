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
	public String capacidad() {
		String cL =Integer.toString(cantCanalesLocales);
		String cH =Integer.toString(cantCanalesHD);
		String capacidad= cL+" Loc./ "+cH+" HD";
		return capacidad;
	}

}
