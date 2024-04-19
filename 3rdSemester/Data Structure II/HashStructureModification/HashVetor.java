
public class HashVetor {

	private int tamanho;
	private TabelaHash tabelaHash;

	public HashVetor(int tamanho) {

		if (tamanho <= 0) {
			throw new IllegalArgumentException("Tamanho Inválido.");
		}
		this.tamanho = tamanho;
		tabelaHash = new TabelaHash(tamanho);
	}

	public boolean contem(Cliente cliente) {
		int codigoBuscado = cliente.getCodigo();
		if (buscarClientePorCodigo(codigoBuscado) != null) return true;
		else return false;
	}

	public double tamanhoMedioPesquisa() {
		int totalAcessos = 0;
		int totalElementos = 0;

		for (int i = 0; i < tamanho; i++) {
			Cliente cliente = tabelaHash.getElementos()[i];
			if (cliente != null && cliente.getCodigo() != 0) {
				totalElementos++;
				totalAcessos += quantidadeAcessos(cliente.getCodigo());
			}
			ListaLigada colisoes = tabelaHash.getColisoes()[i];
			totalAcessos += colisoes != null ? colisoes.pegarTotalElementos() : 0;
		}

		if (totalElementos == 0) {
			return 0;
		}

		return (double) totalAcessos / totalElementos;
	}

	private int quantidadeAcessos(int codigo) {
		int enderecoHash = calcularHash(codigo);
		int acessos = 1;
		Cliente cliente = tabelaHash.getElementos()[enderecoHash];
		while (cliente != null && cliente.getCodigo() != codigo) {
			acessos++;
			enderecoHash = (enderecoHash + 1) % tamanho;
			cliente = tabelaHash.getElementos()[enderecoHash];
		}
		return acessos;
	}




	public int inserir(Cliente novoCliente) {
		
		int enderecoHashAdicionado = calcularHash(novoCliente.getCodigo());
		
		if (tabelaHash.getElementos()[enderecoHashAdicionado] != null) {
			tabelaHash.getColisoes()[enderecoHashAdicionado].adicionarNoFinal(novoCliente);
		}
		else {
			tabelaHash.getElementos()[enderecoHashAdicionado] = novoCliente;
		}
		return enderecoHashAdicionado;
		
	}


	public boolean excluir(int codigo) {
		int enderecoHash = calcularHash(codigo);
		if (tabelaHash.getElementos()[enderecoHash] != null) {
			if (tabelaHash.getElementos()[enderecoHash].getCodigo() == codigo) {
				tabelaHash.getElementos()[enderecoHash].setCodigo(0);
				return true;
			} else {
				if (tabelaHash.getColisoes()[enderecoHash] != null) {
					for (int i = 0; i < tabelaHash.getColisoes()[enderecoHash].pegarTotalElementos(); i++) {
						Cliente cliente = (Cliente) tabelaHash.getColisoes()[enderecoHash].pegar(i);
						if (cliente.getCodigo() == codigo) {
							tabelaHash.getColisoes()[enderecoHash].removerNaPosicao(i);
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public Cliente buscarClientePorCodigo(int codigoBuscado) {

		int enderecoHashBuscado = calcularHash(codigoBuscado);

		if (tabelaHash.getElementos()[enderecoHashBuscado] != null) {
			if (tabelaHash.getElementos()[enderecoHashBuscado].getCodigo() == codigoBuscado) {
				return tabelaHash.getElementos()[enderecoHashBuscado];
			}
			else {
				int tamanhoListaColisao = tabelaHash.getColisoes()[enderecoHashBuscado].pegarTotalElementos();
				if (tamanhoListaColisao > 0) {
					for (int i=0; i<tamanhoListaColisao; i++) {
						Cliente clienteColisao = (Cliente) tabelaHash.getColisoes()[enderecoHashBuscado].pegar(i);
						if (clienteColisao.getCodigo() == codigoBuscado) {
							return clienteColisao;
						}
					}
				}
			}
		}
		return null;
	}

	public int calcularHash(int codigo) {
		
		String chaveConvertida = String.valueOf(codigo);
		int h = 0;
		for(int i=0; i < chaveConvertida.length(); i++) {
			h = 31 * h + chaveConvertida.charAt(i);
		}		
		return h % this.tamanho;
	}
	
	
	
	
	
	
	
	
	
	

}
