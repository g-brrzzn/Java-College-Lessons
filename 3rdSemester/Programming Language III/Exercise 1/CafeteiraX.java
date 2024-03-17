
public class CafeteiraX extends Cafeteira{

	public CafeteiraX(boolean ligado, int voltagem) {
		super(ligado, voltagem);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ligar() {
		System.out.println("Ligando...");
		
	}

	@Override
	public void desligar() {
		System.out.println("Desligando...");
		
	}

	@Override
	public void fazerCafe() {
		if (this.isLigado()) System.out.println("Fazendo Café...");
		
	}

}

