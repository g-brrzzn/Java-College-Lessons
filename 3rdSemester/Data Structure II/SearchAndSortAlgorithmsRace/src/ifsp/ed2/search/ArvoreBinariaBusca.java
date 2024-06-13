package ifsp.ed2.search;

import ifsp.ed2.model.Customer;

public class ArvoreBinariaBusca {

	protected No raiz;

	public ArvoreBinariaBusca() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean ehVazia() {
		return raiz == null;
	}

	public int pegaQuantidadeNos() {
		return pegaQuantidadeNosDoSubNo(raiz);
	}

	private int pegaQuantidadeNosDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaQuantidadeNosDoSubNo(noReferencia.getEsquerdo()) + 1 + pegaQuantidadeNosDoSubNo(noReferencia.getDireito());
		}
	}

	public No pegarNoArvorePorValor(int idBuscado) {
		No atual = raiz;
		while (atual != null) {
			if (idBuscado == atual.getCustomer().getId()) {
				return atual;
			} else if (idBuscado < atual.getCustomer().getId()) {
				atual = atual.getEsquerdo();
			} else {
				atual = atual.getDireito();
			}
		}
		return null;
	}

	public boolean contem(int idBuscado) {
		return (pegarNoArvorePorValor(idBuscado) != null);
	}

	public void adicionaNo(Customer customerAdicionado) {
		if (raiz == null) {
			raiz = new No(customerAdicionado, null, null);
		} else {
			No atual = raiz;
			while (true) {
				if (customerAdicionado.getId() < atual.getCustomer().getId()) {
					if (atual.getEsquerdo() == null) {
						atual.setEsquerdo(new No(customerAdicionado, null, null));
						return;
					}
					atual = atual.getEsquerdo();
				} else if (customerAdicionado.getId() > atual.getCustomer().getId()) {
					if (atual.getDireito() == null) {
						atual.setDireito(new No(customerAdicionado, null, null));
						return;
					}
					atual = atual.getDireito();
				} else {
					// Já existe um nó com o mesmo ID, atualizar o valor
					atual.setCustomer(customerAdicionado);
					return;
				}
			}
		}
	}
}
