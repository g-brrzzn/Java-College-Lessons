
public class TabelaHash {
	
	private Cliente[] elementos;
	private ListaLigada[] colisoes;
	
	public TabelaHash(int tamanho) {
		
		elementos = new Cliente[tamanho];
		colisoes = new ListaLigada[tamanho]; 
		inicializarListaLigada(tamanho);
	}

	private void inicializarListaLigada(int tamanho) {
		for (int i=0; i<tamanho; i++) {
			colisoes[i] = new ListaLigada();
		}
		
	}

	public Cliente[] getElementos() {
		return elementos;
	}

	public ListaLigada[] getColisoes() {
		return colisoes;
	}

}
