package fila;

import ListaLigada.ListaLigada;

public class Fila  {
	
	private ListaLigada lista = new ListaLigada();
	
	public void adicionar(Object elemento) {
		lista.adicionarNoFinal(elemento);
	}
	
	public void remover() {
		lista.removerDoComeco();
	}
	
	public boolean ehVazia() {
		return lista.ehVazia();
	}
	
	public Object poll() {
		
		if (ehVazia()) {
			return null;
		}
		else {
			Object primeiro = lista.pegarPrimeiro();
			lista.removerDoComeco();
			return primeiro;
		}
	}
	
	public boolean contem(Object elemento) {
		return lista.contem(elemento);
	}
	
	public Object pegaPrimeiro() {
		return lista.pegarPrimeiro();
	}
	
	public Object pegaUltimo() {
		return lista.pegarUltima();
	}
	
	public int pegarTamanho() {
		return lista.pegarTotalElementos();
	}


}
