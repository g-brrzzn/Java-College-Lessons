package ContaCorrenteBanco;
public class BancoMain {
	public static void main() {
		ContaCorrente conta = new ContaCorrente();
		conta.depositar(1000);
		conta.consultarSaldo();
		conta.retirar(250);
		conta.consultarSaldo();
	}
}
