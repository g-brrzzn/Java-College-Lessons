package ContaCorrenteBanco;

public class ContaCorrente implements IcontaCorrente {
	
	public ContaCorrente() {
		System.out.println("Conta Corrente criada");
	}
	
	private double saldo;
	
	@Override
	public double consultarSaldo() {
		return saldo;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;

	}

	@Override
	public void retirar(double valor) {
		saldo -= valor;
		
	}

	@Override
	public void transferir(double valor) {
		saldo -= valor;
		// transferencia...
		
	}

	@Override
	public void imprimirExtrato() {
		System.out.println(saldo);
		
	}
}


