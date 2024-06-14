public abstract class Carro {
	private boolean on;
	private int gas;

	public abstract void ligar();

	public abstract void desligar();

	public abstract void Acelerar();
	
	public abstract void Freiar();

	public Carro(boolean on, int gas) {
		this.on = on;
		this.gas = gas;
	}

	public void setGasolina(int voltagem) {
		this.gas = voltagem;
	}

	public int getGas() {
		return gas;
	}

	public void setOn(boolean ligado) {
		this.on = ligado;
	}

	public boolean isOn() {
		return on;
	}
}

