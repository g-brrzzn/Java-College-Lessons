package ContaCorrenteBanco;

public interface IcontaCorrente {
	public double consultarSaldo();
	public void depositar(double valor);
	public void retirar(double valor);
	public void transferir(double valor);
	public void imprimirExtrato();
}
