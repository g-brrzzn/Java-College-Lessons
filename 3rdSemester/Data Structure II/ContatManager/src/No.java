public class No {

	private Contato valor;
	private No direito;
	private No esquerdo;

	public No(Contato valor, No direito, No esquerdo) {
		this.valor = valor;
		this.direito = direito;
		this.esquerdo = esquerdo;
	}

	public Contato getValor() {
		return valor;
	}

	public void setValor(Contato valor) {
		this.valor = valor;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public boolean ehFolha() {
		return (direito == null && esquerdo == null);
	}


}
