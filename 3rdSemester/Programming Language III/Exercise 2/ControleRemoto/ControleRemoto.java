package ControleRemoto;

public class ControleRemoto implements IControleRemoto{
	
	private static int volume = 5;
	private static int canal = 10;
	private static boolean ligado = false;
	
	@Override
	public void MudarCanalCima() {
		if (ligado) {
			canal++;
			System.out.println("Mudando para o canal "+ canal);
		}
		
	}
	
	public void MudarCanalBaixo() {
		if (ligado) {
			if (volume > 0) canal--;
			System.out.println("Mudando para o canal "+ canal);
		}
	}

	@Override
	public void Aumentar() {
		if (ligado) {
			if (volume < 10) volume++;
			System.out.println("Aumentando volume para " + volume);
		}
	}

	@Override
	public void Reduzir() {
		if (ligado) {
			volume--;
			System.out.println("Reduzindo volume para " + volume);
		}
		
	}

	@Override
	public void Ligar() {
		ligado = true;
		System.out.println("Ligando a TV");
		
	}

	@Override
	public void Desligar() {
		ligado = false;
		System.out.println("Desligando a TV");
		
	}

}
