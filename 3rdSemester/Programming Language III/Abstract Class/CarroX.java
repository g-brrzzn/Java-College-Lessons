
public class CarroX extends Carro {

	public CarroX(boolean on, int gas) {
		super(on, gas);
		System.out.println("CarroX criado!");
	}

	@Override
	public void ligar() {
		System.out.println("Ligando o carro.");
		if (this.getGas() <= 0) System.out.println("Sem gasolina...");
		
	}

	@Override
	public void desligar() {
		System.out.println("Desligando o carro.");
		
	}

	@Override
	public void Acelerar() {
		if (!(this.getGas() <= 0)) System.out.println("Acelerando o carro.");
		
	}

	@Override
	public void Freiar() {
		System.out.println("Freiando o carro.");
		
	}

}
