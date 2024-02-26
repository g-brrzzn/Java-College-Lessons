public abstract class Cafeteira {
	private boolean ligado;
	private int voltagem;

	public abstract void ligar();

	public abstract void desligar();

	public abstract void fazerCafe();

	public Cafeteira(boolean ligado, int voltagem) {
		this.ligado = ligado;
		this.voltagem = voltagem;
	}

	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}

	public int getVoltagem() {
		return voltagem;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	public boolean isLigado() {
		return ligado;
	}
}




