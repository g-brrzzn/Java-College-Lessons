public class ArvoreBinariaBuscaNome {

	private No raiz;

	static final int CONTADOR_ESPACO = 5;

	public boolean ehMaior(Contato no1, Contato no2) {
		return (no1.getNome().compareTo(no2.getNome()) > 0);
	}
	public boolean ehMenor(Contato no1, Contato no2) {
		return (no1.getNome().compareTo(no2.getNome()) < 0);
	}
	public boolean ehIgual(Contato no1, Contato no2) {
		return (no1.getNome().compareTo(no2.getNome()) == 0);
	}

	public ArvoreBinariaBuscaNome() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz, ArvoreBinariaBuscaCodigo arvoreCodigo) {
		this.raiz = raiz;
		arvoreCodigo.setRaiz(raiz);
	}

	public boolean ehVazia() {
		return raiz == null;
	}

	public int pegaQuantidadeNos() {
		return pegaQuantidadeNosDoSubNo(raiz);
	}

	public int pegaQuantidadeNosDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaQuantidadeNosDoSubNo(noReferencia.getEsquerdo()) + 1
					+ pegaQuantidadeNosDoSubNo(noReferencia.getDireito());
		}
	}

	public int pegaAlturaDoNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaAlturaDoSubNo(noReferencia) - 1;
		}
	}

	private int pegaAlturaDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		}
		int alturaDireita = pegaAlturaDoSubNo(noReferencia.getDireito());
		int alturaEsquerda = pegaAlturaDoSubNo(noReferencia.getEsquerdo());

		return 1 + Math.max(alturaDireita, alturaEsquerda);
	}

	public int pegaAlturaDaArvore() {
		return pegaAlturaDoNo(raiz);
	}

	public int pegaProfundidadeDoNo(No noBuscado) {

		if (noBuscado == null) {
			return 0;
		} else {
			return pegaProfundidadeDoNoAteRaiz(raiz, noBuscado) - 1;
		}
	}

	private int pegaProfundidadeDoNoAteRaiz(No noReferencia, No noBuscado) {
		if (noReferencia == null) {
			return 0;
		} else {
			if (noBuscado.getValor() == noReferencia.getValor()) {
				return 1;
			}

			if (ehMenor(noBuscado.getValor(), noReferencia.getValor())) {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getEsquerdo(), noBuscado);
			} else {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getDireito(), noBuscado);
			}
		}
	}

	public No pegarNoArvorePorValor(Contato valorBuscado) {
		
		No atual = raiz;
		while (atual != null) {
			if (valorBuscado.getCodigo() == atual.getValor().getCodigo()) {
				return atual;
			} else if (ehMenor(valorBuscado, atual.getValor())) {
				atual = atual.getEsquerdo();
			} else {
				atual = atual.getDireito();
			}
		}
		return null;
	}

	public boolean contem(Contato valorBuscado) {
		return (pegarNoArvorePorValor(valorBuscado) != null);
	}


	public void adicionaNo(Contato valorNoAdicionado, ArvoreBinariaBuscaCodigo arvoreCodigo) {

		No NoAdicionado = new No(valorNoAdicionado, null, null);
		if (!arvoreCodigo.contem(valorNoAdicionado)) {
			if (raiz == null) {
				raiz = NoAdicionado; //
			} else {
				No atual = raiz;
				while (true) {
					if (ehMenor(valorNoAdicionado, atual.getValor())) {
						if (atual.getEsquerdo() == null) {
							arvoreCodigo.adicionaNo(valorNoAdicionado);
							atual.setEsquerdo(NoAdicionado); //
							return;
						}
						atual = atual.getEsquerdo();
					} else if (ehMaior(valorNoAdicionado, atual.getValor())) {
						if (atual.getDireito() == null) {
							arvoreCodigo.adicionaNo(valorNoAdicionado);
							atual.setDireito(NoAdicionado); //
							return;
						}
						atual = atual.getDireito();
					} else {
						System.out.println("Contato não adicionado, pois ele já existe na árvore.");
						return;
					}
				}
			}
		} else {
			System.out.println("Não é permitido adicionar códigos repetidos");
		}
	}

	public void removeNoPorValor(Contato valorARemover, ArvoreBinariaBuscaCodigo arvoreCodigo) {

		No pai = null;
		No atual = raiz;
		arvoreCodigo.removeNoPorValor(valorARemover);
		while (atual != null) {
			if (ehIgual(valorARemover, atual.getValor())) {
				if (atual.ehFolha()) {
					removerNoFolha(pai, atual);
				} else if (atual.getDireito() == null) {
					removerSoFilhoEsquerdo(pai, atual);
				} else if (atual.getEsquerdo() == null) {
					removerSoFilhoDireito(pai, atual);
				} else {
					No sucessor = buscarSucessor(atual);
					Contato valorSucessor = sucessor.getValor();
					removeNoPorValor(valorSucessor, arvoreCodigo);
					atual.setValor(valorSucessor);
				}
				return;
			} else if (ehMenor(valorARemover, atual.getValor())) {
				pai = atual;
				atual = atual.getEsquerdo();
			} else {
				pai = atual;
				atual = atual.getDireito();
			}
		}
	}

	private void removerSoFilhoDireito(No pai, No atual) {
		if (pai == null) {
			raiz = atual.getDireito();
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(atual.getDireito());
			} else {
				pai.setDireito(atual.getDireito());
			}
		}
	}

	private void removerSoFilhoEsquerdo(No pai, No atual) {
		if (pai == null) {
			raiz = atual.getEsquerdo();
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(atual.getEsquerdo());
			} else {
				pai.setDireito(atual.getEsquerdo());
			}
		}
	}

	private void removerNoFolha(No pai, No atual) {
		if (pai == null) {
			raiz = null;
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(null);
			} else {
				pai.setDireito(null);
			}
		}
	}

	private No buscarSucessor(No noAtual) {
		No sucessor = noAtual.getDireito();
		while (sucessor.getEsquerdo() != null) {
			sucessor = sucessor.getEsquerdo();
		}
		return sucessor;
	}

	public void imprimirPreOrder() {
		percorrerPreOrder(raiz);
	}

	private void percorrerPreOrder(No noReferencia) {
		if (noReferencia != null) {
			System.out.println(noReferencia.getValor());
			percorrerPreOrder(noReferencia.getEsquerdo());
			percorrerPreOrder(noReferencia.getDireito());
		}
	}

	public void imprimirInOrder() {
		percorrerInOrder(raiz);
	}

	private void percorrerInOrder(No noReferencia) {
		if (noReferencia != null) {
			percorrerInOrder(noReferencia.getEsquerdo());
			System.out.println(noReferencia.getValor().getNome());
			percorrerInOrder(noReferencia.getDireito());
		}
	}

	public void imprimirPosOrder() {
		percorrerPosOrder(raiz);
	}

	private void percorrerPosOrder(No noReferencia) {
		if (noReferencia != null) {
			percorrerPosOrder(noReferencia.getEsquerdo());
			percorrerPosOrder(noReferencia.getDireito());
			System.out.println(noReferencia.getValor());
		}
	}

	public void imprimir2DArvore() {
		print2DUtil(raiz, 0);
	}

	private void print2DUtil(No noReferencia, int space) {
		if (noReferencia == null) {
			return;
		}
		space += CONTADOR_ESPACO;
		print2DUtil(noReferencia.getDireito(), space);

		System.out.print("\n");
		for (int i = CONTADOR_ESPACO; i < space; i++)
			System.out.print(" ");
		System.out.print(noReferencia.getValor() + "\n");

		print2DUtil(noReferencia.getEsquerdo(), space);
	}

	public boolean pegaNoPorNome(String nome) {
		No atual = getRaiz();
		while (true) {
			if (nome.compareTo(atual.getValor().getNome()) < 0) {
				if (atual.getEsquerdo() == null) {
					System.out.println("Nome não existe na árvore.");
					return false;
				}
				atual = atual.getEsquerdo();
			} else if (nome.compareTo(atual.getValor().getNome()) > 0) {
				if (atual.getEsquerdo() == null) {
					System.out.println("Nome não existe na árvore.");
					return false;
				}
				atual = atual.getDireito();
			} else {
				System.out.println(atual.getValor().getNome() + " " + atual.getValor().getCodigo() + " " + atual.getValor().getTelefone() + " \n");
				return true;
			}
		}
	}

	public void removeNoPorNome(String nome, ArvoreBinariaBuscaCodigo arvoreCodigo) {
		No atual = getRaiz();
		while (true) {
			if (nome.compareTo(atual.getValor().getNome()) < 0) {
				if (atual.getEsquerdo() == null) {
					System.out.println("Nome não existe na árvore.");
					return;
				}
				atual = atual.getEsquerdo();
			} else if (nome.compareTo(atual.getValor().getNome()) > 0) {
				if (atual.getEsquerdo() == null) {
					System.out.println("Nome não existe na árvore.");
					return;
				}
				atual = atual.getDireito();
			} else {
				System.out.println("Contato removido: " + atual.getValor().getNome() + " " + atual.getValor().getCodigo() + " " + atual.getValor().getTelefone() + " \n");
				removeNoPorValor(atual.getValor(), arvoreCodigo);
				return;
			}
		}
	}

	public void imprimirAlfabetica() {
		percorrerInOrder(raiz);
	}

}
