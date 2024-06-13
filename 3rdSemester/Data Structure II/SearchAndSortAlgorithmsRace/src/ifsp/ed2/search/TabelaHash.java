package ifsp.ed2.search;

import ifsp.ed2.model.Customer;

public class TabelaHash {

    private ArvoreBinariaBusca[] filas;
    private int capacidade;
    private int tamanho;

    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.filas = new ArvoreBinariaBusca[capacidade];
        this.tamanho = 0;
        for (int i = 0; i < capacidade; i++) {
            filas[i] = new ArvoreBinariaBusca();
        }
    }

    private int obterIndiceDofila(int chave) {
        return chave % capacidade;
    }

    public void inserir(int chave, Customer valor) {
        int indiceDofila = obterIndiceDofila(chave);
        ArvoreBinariaBusca fila = filas[indiceDofila];
        if (fila.contem(chave)) {
            No no = fila.pegarNoArvorePorValor(chave);
            no.setCustomer(valor);
        } else {
            fila.adicionaNo(valor);
            tamanho++;
        }
    }

    public boolean contemChave(int chave) {
        int indiceDofila = obterIndiceDofila(chave);
        ArvoreBinariaBusca fila = filas[indiceDofila];
        return fila.contem(chave);
    }

    public int pegarTamanho() {
        return tamanho;
    }
}
